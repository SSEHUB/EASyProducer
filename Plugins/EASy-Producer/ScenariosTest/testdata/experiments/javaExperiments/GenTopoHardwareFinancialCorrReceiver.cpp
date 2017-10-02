#include <stdio.h>
#include <stdlib.h>
#include <strings.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <sys/wait.h>
#include <signal.h>
#include <string>
#include <iostream>
#include <google/protobuf/io/coded_stream.h>
#include <google/protobuf/generated_message_util.h>
#include <google/protobuf/message.h>
#include <google/protobuf/extension_set.h>
#include <google/protobuf/unknown_field_set.h>
#include <google/protobuf/io/zero_copy_stream_impl_lite.h>

#include "SerializeServerTemplateCpuCode.h"
#include "parameters.pb.h"
#include "FCorrelationFinancial.pb.h"
#include "stringlist.pb.h"
using namespace std;

void receiver(parm *arg)
{
    struct sockaddr_in server_addr;
    int receiver_socket;
    int true_var=1;
    struct sockaddr_in receiver_addr;
    socklen_t sin_size;

    if ((receiver_socket = socket(AF_INET, SOCK_STREAM, 0)) == -1)
    {
        perror("Socket");
        exit(1);
    }

    if (setsockopt(receiver_socket,SOL_SOCKET,SO_REUSEADDR,&true_var,sizeof(int)) == -1)
    {
        perror("Setsockopt");
        exit(1);
    }

    server_addr.sin_family = AF_INET;
    server_addr.sin_port = htons(2400);
    server_addr.sin_addr.s_addr = INADDR_ANY;
    bzero(&(server_addr.sin_zero),8);

    if (bind(receiver_socket, (struct sockaddr *)&server_addr, sizeof(server_addr)) == -1)
    {
        perror("Unable to bind");
        exit(1);
    }

    if (listen(receiver_socket, 5) == -1)
    {
        perror("Listen failed");
        exit(1);
    }

    printf("TCPServer Waiting for client on port 2400\n");

    sin_size = (socklen_t)sizeof(receiver_addr);
    int receiver_socket_connected = accept(receiver_socket, (struct sockaddr *)&receiver_addr,&sin_size);
    printf("Got a connection from (%s , %d)\n",inet_ntoa(receiver_addr.sin_addr),ntohs(receiver_addr.sin_port));
    printf("Connection with Bolt\n");

    eu::qualimaster::families::protobuf::SIFCorrelationFinancialpreprocessedStreamInput preprocessedStreamInput;
    eu::qualimaster::base::protos::SStringList stringList;
    eu::qualimaster::base::protos::SIntegerParameter IntegerParameter;

    google::protobuf::uint32 size;
    google::protobuf::io::CodedInputStream::Limit msgLimit;
    unsigned char buffer[MAXDATASIZE];
    unsigned char temp[10];
    int numbytes = 0;
    int internal_size = 0;
    int pointer = 0;
    int j, i;
    bzero(buffer,0);

    struct message_receiver_processor msg;
    while(1)
    {
        numbytes = 0;
        while(pointer < MESSAGE_HEADER)
        {
            numbytes = recv(receiver_socket_connected, &buffer[pointer], 1, 0);
            if(numbytes > 0)
                pointer = pointer + numbytes;
        }

        google::protobuf::io::CodedInputStream codedIn1(&arrayIn);

        codedIn1.ReadRaw(temp, 2); // Read the protocol Message type
        codedIn1.ReadVarint32(&size);
        if((size & 0x7f800000) > 0)
        {
            message_size = 4 + (size + 2); //size of size variable in the message + size Bytes + 2 Bytes protocol
        }
        else if((size & 0x7f8000) > 0)
        {
            message_size = 3 + (size + 2);
        }
        else if((size & 0x7f80) > 0)
        {
            message_size = 2 + (size + 2);
        }
        else
        {
            message_size = 1 + (size + 2);
        }
        //Read the remaining Bytes from the incoming message from TCP buffer
        while(pointer < message_size)
        {
            numbytes = recv(receiver_socket_connected, &buffer[pointer], 1, 0);
            if(numbytes > 0)
                pointer = pointer + numbytes;
        }
        //Deserialize the complete incoming message
        google::protobuf::io::CodedInputStream codedIn(buffer, message_size);

        // Omit the first two Bytes (Message ID)
        codedIn.Skip(2);

            if(temp[0] == 'd') { //Data
                if(temp[1] == 'a') { //1st Data Type
                    codedIn.ReadVarint32(&size);
                    msgLimit = codedIn.PushLimit(size);
                    preprocessedStreamInput.ParseFromCodedStream(&codedIn);
                    codedIn.PopLimit(msgLimit);
                    // Parse the message data
                    msg.type = 0;
                    msg.data = preprocessedStreamInput.randominteger();

                    //Push data into the lockfree structure
                    while(!arg->queue_receiver_processor->push(msg))
                    {
                        ;
                    }
                }
                if(temp[1] == 'b') { //2st Data Type
                    codedIn.ReadVarint32(&size);
                    msgLimit = codedIn.PushLimit(size);
                    stringList.ParseFromCodedStream(&codedIn);
                    codedIn.PopLimit(msgLimit);
                    // Parse the message data
                    msg.type = 0;
                    msg.data = stringList.randominteger();

                    //Push data into the lockfree structure
                    while(!arg->queue_receiver_processor->push(msg))
                    {
                        ;
                    }
                }
            }
            else if(temp[0] == 'p') { //Parameters
                if(temp[1] == 'a')  {//int Parameter
                    codedIn.ReadVarint32(&size);
                    msgLimit = codedIn.PushLimit(size);
                    IntegerParameter.ParseFromCodedStream(&codedIn);
                    codedIn.PopLimit(msgLimit);
                    if((size & 0x7f800000) > 0)
                    {
                        internal_size = internal_size + size + 4;
                    }
                    else if((size & 0x7f8000) > 0)
                    {
                        internal_size = internal_size + size + 3;
                    }
                    else if((size & 0x7f80) > 0)
                    {
                        internal_size = internal_size + size + 2;
                    }
                    else
                    {
                        internal_size = internal_size + size + 1;
                    }
                }
            }
            else if(temp[0] == 'c')
            {
                printf("Connection closed\n");
                return;
            }

    }
    close(receiver_socket_connected);
}

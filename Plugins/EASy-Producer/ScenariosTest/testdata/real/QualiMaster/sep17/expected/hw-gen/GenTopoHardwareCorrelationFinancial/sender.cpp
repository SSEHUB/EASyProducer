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
#include <netdb.h>
#include <netinet/in.h>
#include <string.h>
#include <google/protobuf/io/coded_stream.h>
#include <google/protobuf/generated_message_util.h>
#include <google/protobuf/message.h>
#include <google/protobuf/extension_set.h>
#include <google/protobuf/unknown_field_set.h>
#include <google/protobuf/io/zero_copy_stream_impl_lite.h>

#include "SerializeServerTemplateCpuCode.h"
#include "FCorrelationFinancial.pb.h"

void sender(parm *arg)
{
    struct sockaddr_in server_addr;
    int transmitter_socket;
    socklen_t sin_size;
    int true_var=1;
    struct sockaddr_in transmitter_addr;

    if ((transmitter_socket = socket(AF_INET, SOCK_STREAM, 0)) == -1)
    {
        perror("Socket");
        exit(1);
    }

    if (setsockopt(transmitter_socket,SOL_SOCKET,SO_REUSEADDR,&true_var,sizeof(int)) == -1)
    {
        perror("Setsockopt");
        exit(1);
    }

    server_addr.sin_family = AF_INET;
    server_addr.sin_port = htons(2401);
    server_addr.sin_addr.s_addr = INADDR_ANY;
    bzero(&(server_addr.sin_zero),8);

    if (bind(transmitter_socket, (struct sockaddr *)&server_addr, sizeof(server_addr)) == -1)
    {
        perror("Unable to bind");
        exit(1);
    }

    if (listen(transmitter_socket, 5) == -1)
    {
        perror("Listen failed");
        exit(1);
    }

    printf("TCPServer Waiting for client on port 2401\n");

    sin_size = sizeof(transmitter_addr);
    int transmitter_socket_connected = accept(transmitter_socket, (struct sockaddr *)&transmitter_addr,&sin_size);
    printf("Got a connection from (%s , %d)\n",inet_ntoa(transmitter_addr.sin_addr),ntohs(transmitter_addr.sin_port));
    printf("Connection with Spout\n");

    eu::qualimaster::families::protobuf::SIFCorrelationFinancialPairwiseFinancialOutput to;

    struct message_processor_sender msg;
    while(1)
    {
        while(!arg->queue_processor_sender->pop(msg))
        {
            ;
        }
        to.set_randominteger(msg.data);
        //already set up a message object called serverAck
        //make a buffer that can hold message + room for a 32bit delimiter
        int ackSize=to.ByteSize()+ google::protobuf::io::CodedOutputStream::VarintSize32(to.ByteSize());
        char* ackBuf=new char[ackSize];

        //write varint delimiter to buffer
        google::protobuf::io::ArrayOutputStream arrayOut(ackBuf, ackSize);
        google::protobuf::io::CodedOutputStream codedOut(&arrayOut);

        //write protobuf ack to buffer
        codedOut.WriteVarint32(to.ByteSize());
        to.SerializeToCodedStream(&codedOut);

        //send buffer to client
        send(transmitter_socket_connected, ackBuf, ackSize, 0);

        delete(ackBuf);
    }
}

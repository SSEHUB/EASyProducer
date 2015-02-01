package eu.qualiMaster.hardware.imp;

import org.apache.log4j.Logger;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import eu.qualiMaster.families.inf.IFDouble;
import eu.qualiMaster.hardware.inf.*;
import backtype.storm.utils.Utils;

/**
 * Define the family hardware connection class.
**/
public class HwDouble implements IFDouble, HardwareStub{

    final static Logger logger = Logger.getLogger(HwDouble.class);
    private static PrintWriter out = null;
    private static BufferedReader in = null;
    private static int size = 384; //Maxeler input size needs to be a multiple of 384 elements
    private static int count = 0;
    IIFDoubleInput[] bufferedInputData;
    IIFDoubleOutput[] bufferedOutputData;

    /**
    * Construction of family hardware connection.
    **/
    public HwDouble() {
        bufferedInputData = new IIFDoubleInput[size];
        bufferedOutputData = new IIFDoubleOutput[size];
    }

    /**
    * Connect with Hardware.
    **/
    @Override
    public void connect(String host) {
        String[] hostInfo = host.split(":");
        String IP = hostInfo[0];
        String port = hostInfo[1];
        try {
            Socket sock = new Socket(IP, Integer.parseInt(port));
            in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            out = new PrintWriter(sock.getOutputStream(), true);
        }
        catch (IOException ioe) {
            logger.error(ioe);
        }
    }

    /**
    * Disconnect with hardware.
    **/
    @Override
    public void disconnect() {
        if(in != null)
            try {
                in.close();
                out.close();
            } catch(IOException e) {
                e.printStackTrace();
            }
    }

    /**
    * Hardware algorithm.
    **/
    @Override
    public void calculate(IIFDoubleInput input, IIFDoubleOutput result) {
        //Send the size arg number.
        out.println(size);
        //Send data
        for(int i=0; i<bufferedInputData.length; i++) {
            Utils.sleep(1);
            out.println(bufferedInputData[i]);
        }
        logger.info("Maxeler call performed!");
        for(int i=0; i<bufferedOutputData.length; i++) {
            //bufferedOutputData[i] = in.readLine();
        }
        disconnect();
    }
}

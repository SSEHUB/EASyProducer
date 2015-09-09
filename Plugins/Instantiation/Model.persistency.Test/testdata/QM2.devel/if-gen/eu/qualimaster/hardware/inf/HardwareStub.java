package eu.qualimaster.hardware.inf;

/**
* A basic hardware connection interface.
**/
public interface HardwareStub {
    /**
    * Connect to the hardware.
    **/
    public void connect (String host);

    /**
    * Disconnect to the hardware.
    **/
    public void disconnect();
}

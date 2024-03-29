package iip.datatypes;

/**
 * Implementation of the application data type MyConnMachineIn.
 * Generated by: EASy-Producer.
 */
public class MyConnMachineIn {
 
    private String dataField;
    

    /**
     * Default constructor. Fields are pre-allocated with default Java values.
     */
    public MyConnMachineIn() {
    }

    /**
     * Copy constructor.
     * 
     * @param from the instance to copy the values from
     */
    public MyConnMachineIn(MyConnMachineIn from) {
        this.dataField = from.dataField;
    }

    /**
      * Returns the value of {@code dataField}.
      * 
      * @return the value
      */
     public String getDataField() {
         return dataField;
     }
    
    
    /**
      * Changes the value of {@code dataField}.
      * 
      * @param value the new value
      */
     public void setDataField(String value) {
         this.dataField = value;
     }
    

}

package iip.datatypes;
import de.iip_ecosphere.platform.transport.serialization.IipEnum;

/**
 * Enumeration MyTestEnum.
 * Generated by: EASy-Producer.
 */
public enum MyTestEnum implements IipEnum {
 
    /**
    * Defines the literal Lit1.
    */
    Lit1(25),
    
    /**
    * Defines the literal Lit2.
    */
    Lit2(100);
    
    
    

    private int modelOrdinal;

    private MyTestEnum(int modelOrdinal) {
        this.modelOrdinal = modelOrdinal;
    }
    
    @Override
    public int getModelOrdinal() {
        return modelOrdinal;
    }

}
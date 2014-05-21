package de.uni_hildesheim.sse.easy_producer.instantiator.velocity;

public class VelocityContextItem {
    
    private String variableName;
    private Object value;
    
    public VelocityContextItem(String variableName, Object value) {
        this.variableName = variableName;
        this.value = value;
    }
    
    String getName() {
        return variableName;
    }

    Object getValue() {
        return value;
    }
}

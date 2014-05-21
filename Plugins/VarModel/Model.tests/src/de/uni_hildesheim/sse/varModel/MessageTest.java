package de.uni_hildesheim.sse.varModel;

import org.junit.Assert;
import org.junit.Test;

import de.uni_hildesheim.sse.utils.messages.Message;
import de.uni_hildesheim.sse.utils.messages.Status;

/**
 * Test class for the message class.
 * @author deagleD
 *
 */
public class MessageTest {

    /**
     * Creating a message.
     */
    @Test
    public void test() {
        String str = "Test Message!";
        Message m = new Message(str, Status.WARNING);
        Message m1 = new Message(str, Status.ERROR);
        
        Assert.assertEquals(str, m.getDescription());
        Assert.assertEquals(Status.WARNING, m.getStatus());
        Assert.assertEquals(Status.ERROR, m1.getStatus());
    }
}

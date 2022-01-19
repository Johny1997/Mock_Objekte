package java;

import main.java.RFIDReader;
import org.testng.annotations.Test;

public class test {

    @Test
    public void testReader(){
        MockPort mockport = new MockPort();
        RFIDReader r = new RFIDReader( mockport );
        r.list(mockport);
        mockport.verify();
    }

}

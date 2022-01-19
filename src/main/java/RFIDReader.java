package main.java;

import java.io.PrintStream;
import java.util.ArrayList;

public class RFIDReader {
    private Port port;
    private boolean errorFlag;
    
    public RFIDReader( Port p ){
        errorFlag=false;
        port = p;
    }
    
    public void list(PrintStream out){
        String rfidTag;
        try{
            while ((rfidTag = port.read()) != null) {
                out.println( rfidTag );
            }
            out.println("additional output");
        }
        catch( ReadError ex ){
            errorFlag=true;
        }
        port.close();
    }
    public boolean isError(){
        return errorFlag;
    }
    public static void main( String args[]) throws CannotOpen{
        RFIDReader reader = new RFIDReader(new SerialPort("COM1", 9600));
        reader.list( System.out );
    }

	public String[] getTags() {
	    ArrayList<String> list = new ArrayList<String>();
	    
	    try{
	      String rfidTag;
	      while ((rfidTag=port.read() ) != null) {  
	        list.add( rfidTag );
	      }
	    }
	    catch( ReadError ex ){
	      errorFlag=true;
	    }
	    String receivedTags[] = new String[ list.size()];
	    list.toArray( receivedTags );
	    return receivedTags;
	}
}

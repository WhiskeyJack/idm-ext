package nl.inthere.sfs2x;

import com.smartfoxserver.v2.protocol.serialization.SerializableSFSType;

public class TestObject implements SerializableSFSType {

	
    public int intField;
    public String strField;
    public Boolean boolField;
    public double doubleField;
    
    public TestObject()
    {
    	// empty constructor
    }
  
	// necesary for client error error CS0535: `TestObject' does not implement 
	// interface member `Sfs2X.Protocol.Serialization.SerializableSFSType.GetJavaPackageName
	public String GetJavaPackageName ()

	{

		return "";

	} 


}

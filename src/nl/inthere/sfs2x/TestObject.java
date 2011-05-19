package nl.inthere.sfs2x;

import com.smartfoxserver.v2.protocol.serialization.SerializableSFSType;

public class TestObject implements SerializableSFSType {

    public int intField;
    public String strField;
    public Boolean boolField;
    public double doubleField;

  
    public String GetJavaPackageName ()
    {
       return "";
    }

}

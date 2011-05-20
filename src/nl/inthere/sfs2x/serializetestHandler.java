package nl.inthere.sfs2x;

import com.smartfoxserver.v2.entities.User;
import com.smartfoxserver.v2.entities.data.ISFSObject;
import com.smartfoxserver.v2.extensions.BaseClientRequestHandler;

public class serializetestHandler extends BaseClientRequestHandler {

	@Override
	public void handleClientRequest(User player, ISFSObject params) {
		
		TestObject testobj = (TestObject) params.getClass("TestObject");
	
		
	}

}

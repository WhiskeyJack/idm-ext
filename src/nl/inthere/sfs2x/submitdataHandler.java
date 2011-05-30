package nl.inthere.sfs2x;

import java.util.List;

import com.smartfoxserver.v2.entities.Room;
import com.smartfoxserver.v2.entities.User;
import com.smartfoxserver.v2.entities.data.ISFSObject;
import com.smartfoxserver.v2.entities.data.SFSObject;
import com.smartfoxserver.v2.extensions.BaseClientRequestHandler;

public class submitdataHandler extends BaseClientRequestHandler {

	@Override
	public void handleClientRequest(User player, ISFSObject params) {
		IdmExt parentEx = (IdmExt) getParentExtension();
		int roomId = params.getInt("roomId");
		int roundNr = params.getInt("roundNr");
		// String data = params.getUtfString("data");
		Room currentRoom = parentEx.getParentZone().getRoomById(roomId);
		
		// add data for this user to room variable
		
		
		//List<User> roomUsers = parentEx.getParentZone().getRoomById(roomId).getUserList();
		
		// ISFSObject rtn = new SFSObject();
		//rtn.putInt("roomId", roomId);
		// parentEx.send("startgame", rtn, roomUsers);
		
		trace("Received data for round " + roundNr + " from user " + player.toString());
		
		// if data received for maxusers, send back
		// List<User> roomUsers = currentRoom.getUserList();
		
		//trace("Send startgame signal for room " + roomId + " to users: " + roomUsers.toString());
		
		
//		Room session = parentEx.getParentRoom().toString()
		
/*		
		int n1 = params.getInt("n1");
		int n2 = params.getInt("n2");
		
		int totalval =  parentEx.getTotalVal();	
		
		parentEx.setTotalVal(totalval+n2);
		
		
		ISFSObject rtn = new SFSObject();
		// rtn.putInt("sum", n1+n2);
		rtn.putInt("sum", totalval + n2);

		trace("Adding " + totalval + " and " + n2 + ", result is " + (totalval + n2));

		
		
		parentEx.send("math", rtn, player);
		
		*/
	}
}
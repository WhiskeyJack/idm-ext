package nl.inthere.sfs2x;

import java.util.List;

import com.smartfoxserver.v2.entities.Room;
import com.smartfoxserver.v2.entities.User;
import com.smartfoxserver.v2.entities.data.ISFSObject;
import com.smartfoxserver.v2.entities.data.SFSObject;
import com.smartfoxserver.v2.extensions.BaseClientRequestHandler;

public class startgameHandler extends BaseClientRequestHandler {

	@Override
	public void handleClientRequest(User player, ISFSObject params) {
		IdmExt parentEx = (IdmExt) getParentExtension();
		int roomId = params.getInt("roomId");
		Room currentRoom = parentEx.getParentZone().getRoomById(roomId);
		List<User> roomUsers = currentRoom.getUserList();
		
		// create a room var to hold the round data
		// getApi().setRoomVariables(room.getOwner(), room, new ArrayList<RoomVariable>(){{add(weatherVariable);}}); 
		
		ISFSObject rtn = new SFSObject();
		rtn.putInt("roomId", roomId);
		parentEx.send("startgame", rtn, roomUsers);
		
		trace("Send startgame signal for room " + roomId + " to users: " + roomUsers.toString());
		
		
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
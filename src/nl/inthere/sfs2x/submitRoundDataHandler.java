package nl.inthere.sfs2x;

import java.util.ArrayList;
import java.util.List;

import com.smartfoxserver.v2.entities.Room;
import com.smartfoxserver.v2.entities.User;
import com.smartfoxserver.v2.entities.data.ISFSObject;
import com.smartfoxserver.v2.entities.data.SFSObject;
import com.smartfoxserver.v2.extensions.BaseClientRequestHandler;

public class submitRoundDataHandler extends BaseClientRequestHandler {
	
	@Override
	public void handleClientRequest(User player, ISFSObject params) {
		IdmExt parentEx = (IdmExt) getParentExtension();	
        trace("Submit rounddata handler called");

		SFSObject playerRoundData = (SFSObject)params.getSFSObject("roundData");
		
		 int playerId = player.getPlayerId();
		 Room playerRoom = player.getLastJoinedRoom(); 
		 int roomId = playerRoom.getId();
		 int currentRound = playerRoundData.getInt("round");
		 String role = playerRoundData.getUtfString("role");
		 int playerCount = playerRoom.getSize().getUserCount();
		  
		 
		 // add round data to playerdata list
		 for (PlayerData pd : parentEx.playerDataList )
		 {
			 // check for duplicate, if do not add
			 trace("Checking for duplicate");
			 if (pd.room == roomId && pd.playerId == playerId && pd.round == currentRound)		
				 continue;
			 
			 trace("Adding playerdata to list");
			 PlayerData newPd = new PlayerData();
			 newPd.room = roomId;
			 newPd.playerId = playerId;
			 newPd.round = currentRound;
			 newPd.player = player;
			 newPd.role = role;
			 newPd.playerRoundData = playerRoundData;
			 parentEx.playerDataList.add(newPd);
		 }
		 
		 // check if we have data for all players for this round by putting counting the list
		 List<PlayerData> playerDataRound = new ArrayList<PlayerData>();
		
		 
		 for (PlayerData pd : parentEx.playerDataList )
		 {
			 // continue if player data is not for current room or current rond
			 if (pd.room != roomId || pd.round != currentRound)	
				 continue;
			 
			 // add player data to list if user of player data is in current room
			 if (playerRoom.getUserList().contains(pd.player) )
			 {
				 playerDataRound.add(pd);
				 trace("Adding player data to temp list"); 
			 }
		 }
		 
		 // if list count equals users in room, then we got all data, send back
		 trace("Checking if we have data for all " + playerCount + " players in the room");
		 if (playerDataRound.size() == playerCount) 
		 {
			 trace("Got data from all " + playerCount +  " players in the room, sending result back");
			 
			 SFSObject roundData = new SFSObject();			 
			 for (PlayerData pd : playerDataRound )
				 roundData.putSFSObject(pd.role, pd.playerRoundData);
			 
			 parentEx.send("receiveRoundData", roundData , playerRoom.getUserList()   );
			 
		 }
		
	}

}

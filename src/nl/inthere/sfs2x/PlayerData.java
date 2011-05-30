package nl.inthere.sfs2x;

import com.smartfoxserver.v2.entities.User;
import com.smartfoxserver.v2.entities.data.SFSObject;

public class PlayerData {

	int room;
	int round;
	int playerId;
	User player;
	String role;
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public User getPlayer() {
		return player;
	}
	public void setPlayer(User player) {
		this.player = player;
	}
	SFSObject playerRoundData;
	
	public int getRoom() {
		return room;
	}
	public void setRoom(int room) {
		this.room = room;
	}
	public int getRound() {
		return round;
	}
	public void setRound(int round) {
		this.round = round;
	}
	public int getPlayerId() {
		return playerId;
	}
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}
	public SFSObject getPlayerRoundData() {
		return playerRoundData;
	}
	public void setPlayerRoundData(SFSObject playerRoundData) {
		this.playerRoundData = playerRoundData;
	}
	
	
	
}

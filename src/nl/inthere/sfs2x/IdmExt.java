package nl.inthere.sfs2x;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import com.smartfoxserver.v2.extensions.SFSExtension;

public class IdmExt extends SFSExtension {
	
	int totalVal;
	
	// error: nl.inthere.sfs2x.submitRoundDataHandler.handleClientRequest(submitRoundDataHandler.java:38)
	// http://stackoverflow.com/questions/5890220/why-does-this-code-throw-a-java-concurrentmodificationexception
	//List<PlayerData> playerDataList = new ArrayList<PlayerData>();
	List<PlayerData> playerDataList = new CopyOnWriteArrayList<PlayerData>();
	 
	
	@Override
	public void init() {
		
		trace("IdmExt extension initialized");
		
		this.addRequestHandler("math", MathHandler.class);
		
		this.addRequestHandler("startgame", startgameHandler.class);
		
		this.addRequestHandler("submitdata", submitdataHandler.class);
		
		this.addRequestHandler("submitRoundData", submitRoundDataHandler.class);
		
	}
	
	public int getTotalVal() {
		return this.totalVal;
	}
	
	public void setTotalVal(int val) {
		this.totalVal = val;
	}
	

}

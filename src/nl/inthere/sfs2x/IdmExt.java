package nl.inthere.sfs2x;

import java.util.ArrayList;
import java.util.List;
import com.smartfoxserver.v2.extensions.SFSExtension;

public class IdmExt extends SFSExtension {
	
	int totalVal;
	
	List<PlayerData> playerDataList = new ArrayList<PlayerData>();
	
	
	
	@Override
	public void init() {
		
		trace("IdmExt extension initialized");
		
		this.addRequestHandler("math", MathHandler.class);
		
		this.addRequestHandler("startgame", startgameHandler.class);
		
		this.addRequestHandler("submitdata", submitdataHandler.class);
		
		this.addRequestHandler("submitenv", submitEnvelopeHandler.class);
		
		this.addRequestHandler("submitRoundData", submitRoundDataHandler.class);
		
	}
	
	public int getTotalVal() {
		return this.totalVal;
	}
	
	public void setTotalVal(int val) {
		this.totalVal = val;
	}
	

}

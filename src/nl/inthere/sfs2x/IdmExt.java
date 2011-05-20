package nl.inthere.sfs2x;

import com.smartfoxserver.v2.extensions.SFSExtension;

public class IdmExt extends SFSExtension {
	
	int totalVal;
	
	@Override
	public void init() {
		
		trace("IdmExt extension initialized");
		
		this.addRequestHandler("math", MathHandler.class);
		
		this.addRequestHandler("serializetest", serializetestHandler.class);
		
		
		
		
		
		
	}
	
	public int getTotalVal() {
		return this.totalVal;
	}
	
	public void setTotalVal(int val) {
		this.totalVal = val;
	}
	

}

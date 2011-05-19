package nl.inthere.sfs2x;

import com.smartfoxserver.v2.entities.User;
import com.smartfoxserver.v2.entities.data.ISFSObject;
import com.smartfoxserver.v2.entities.data.SFSObject;
import com.smartfoxserver.v2.extensions.BaseClientRequestHandler;

public class MathHandler extends BaseClientRequestHandler {
	

	@Override
	public void handleClientRequest(User player, ISFSObject params) {
		IdmExt parentEx = (IdmExt) getParentExtension();
		
		int n1 = params.getInt("n1");
		int n2 = params.getInt("n2");
		
		int totalval =  parentEx.getTotalVal();
		
		parentEx.setTotalVal(totalval+n2);
		
		
		ISFSObject rtn = new SFSObject();
		// rtn.putInt("sum", n1+n2);
		rtn.putInt("sum", totalval + n2);

		trace("Adding " + totalval + " and " + n2 + ", result is " + (totalval + n2));

		
		
		parentEx.send("math", rtn, player);
		
	}

	
	
}

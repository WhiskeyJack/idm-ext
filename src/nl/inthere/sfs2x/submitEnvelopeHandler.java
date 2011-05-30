package nl.inthere.sfs2x;

import nl.inthere.sfs2x.serialization.ISEnvelope;

import com.smartfoxserver.v2.entities.User;
import com.smartfoxserver.v2.entities.data.ISFSObject;
import com.smartfoxserver.v2.extensions.BaseClientRequestHandler;

public class submitEnvelopeHandler extends BaseClientRequestHandler {
	
	@Override
	public void handleClientRequest(User player, ISFSObject params) {
		// IdmExt parentEx = (IdmExt) getParentExtension();	
        trace("Submit envelope handler called");
		ISEnvelope env = (ISEnvelope) params.getClass("envelope");
		trace ("Envelope " + env.getId() + " received");
	}
}

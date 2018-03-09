package local.example.zul;

import org.zkoss.zk.au.AuRequest;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Div;

import local.example.ui.event.ScanEvent;

public class Codereader extends Div {
	
	static {
		//automatically adds "toServer" to the client event if an "onScan" listener is declared on this component
		//https://www.zkoss.org/wiki/ZK%20Component%20Development%20Essentials/Handling%20Events/Declaring%20an%20Important%20Event
		addClientEvent(Codereader.class, ScanEvent.ON_SCAN, 0);
	}
	
	@Override
	public void service(AuRequest request, boolean everError) {
		final String cmd = request.getCommand();
		if (ScanEvent.ON_SCAN.equals(cmd)){
			Events.postEvent(ScanEvent.getScanEvent(request,this));
		}else{
			super.service(request, everError);
		}
	}
		
}

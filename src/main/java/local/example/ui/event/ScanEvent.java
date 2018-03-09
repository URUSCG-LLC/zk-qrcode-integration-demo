package local.example.ui.event;

import java.util.Map;

import org.zkoss.zk.au.AuRequest;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;

public class ScanEvent extends Event{

	public static final String ON_SCAN = "onScan";
	private String scanValue = "";
	
	public ScanEvent(Component target,String scanValue ,Object data) {
		super(ON_SCAN, target, data);
		this.scanValue = scanValue;
	}
	
	public String getScanValue(){
		return scanValue;
	}
	
	public static ScanEvent getScanEvent(AuRequest request, Component target) {
		final Map<String, Object> data = request.getData();
		final String scanContent = (String) data.get("scanContent");
		return scanContent != null ? new ScanEvent(target, scanContent, data) : null;
	}

}

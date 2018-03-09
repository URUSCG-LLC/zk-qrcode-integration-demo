package local.example.zk_integration_qr.mvvm;

import java.util.Date;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zul.ListModelList;

import local.example.zk_integration_qr.QrScanEntity;

public class QrIntegrationViewModel {

	private ListModelList<QrScanEntity> myScannedEntries;

	public ListModelList<QrScanEntity> getMyScannedEntries() {
		return myScannedEntries;
	}
	
	@Init
	public void init(){
		myScannedEntries = new ListModelList<>();
	}
	
	@Command
	public void handleScan(@BindingParam("scanValue") String scanValue ){
		myScannedEntries.add(new QrScanEntity(new Date(), scanValue, "my content"));
	}
	
}

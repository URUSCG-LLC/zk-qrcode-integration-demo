package local.example.zk_integration_qr.mvc;

import java.util.Date;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;

import local.example.ui.event.ScanEvent;
import local.example.zk_integration_qr.QrScanEntity;


public class QrIntegrationComposerCodeReader extends SelectorComposer<Component> {

	@Wire
	private Listbox scanResultsListbox;
	private ListModelList<QrScanEntity> myScannedEntries;
	
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		myScannedEntries = new ListModelList<QrScanEntity>();
		scanResultsListbox.setModel(myScannedEntries);
	}
	
	@Listen(ScanEvent.ON_SCAN + " = #myCodeReader")
	public void handleScan(ScanEvent event){
		myScannedEntries.add(new QrScanEntity(new Date(), event.getScanValue(), "my content"));
	}
	
}

package local.example.zk_integration_qr.mvc;

import java.util.Date;

import org.zkoss.json.JSONObject;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Div;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;

import local.example.ui.event.ScanEvent;
import local.example.zk_integration_qr.QrScanEntity;

public class QrIntegrationComposer extends SelectorComposer<Component> {

	@Wire
	private Div myScanner;
	@Wire
	private Listbox scanResultsListbox;
	private ListModelList<QrScanEntity> myScannedEntries;

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		myScannedEntries = new ListModelList<QrScanEntity>();
		scanResultsListbox.setModel(myScannedEntries);
		myScanner.addEventListener(ScanEvent.ON_SCAN, event -> {
			String value = (String) ((JSONObject) event.getData()).get("content");
			if (value != null) {
				myScannedEntries.add(new QrScanEntity(new Date(), value, "my content"));
			}
		});
	}

}

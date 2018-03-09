package local.example.zk_integration_qr;

import java.util.Date;

public class QrScanEntity {

	private Date scanDate;
	private String value;
	private String extraValue;
	
	public QrScanEntity(Date scanDate, String value, String extraValue) {
		super();
		this.scanDate = scanDate;
		this.value = value;
		this.extraValue = extraValue;
	}

	public Date getScanDate() {
		return scanDate;
	}
	public String getValue() {
		return value;
	}
	public String getExtraValue() {
		return extraValue;
	}
	
		
}

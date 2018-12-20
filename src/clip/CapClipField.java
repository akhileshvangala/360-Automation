package clip;

//import com.cisco.app.DataType;

public enum CapClipField {
	ENGAGEMENT_ID ("Engagement ID", "ENGAGEMENT_ID", DataType.VARCHAR2),
	TITLE ("Title", "TITLE_DESC", DataType.VARCHAR2),
	OWNER ("Owner", "ENG_OWNER", DataType.VARCHAR2),
	AGE ("Age", "AGE", DataType.NUMBER),
	STATUS ("Status", "STATUS", DataType.VARCHAR2),
	SERVICE_NAME ("Service Name", "SERVICE_NM", DataType.VARCHAR2),
	CUSTOMER ("Customer", "CUSTOMER_NM", DataType.VARCHAR2),
	BEMS_PRODUCT ("BEMS Product", "BEMS_PRODUCT", DataType.VARCHAR2),
	BEMS_GROUP ("BEMS Group", "BEMS_GROUP", DataType.VARCHAR2),
	PRODUCT_FAMILY ("Product Family", "PROD_FAMILY", DataType.VARCHAR2),
	OPEN_DATE ("Open Date", "OPEN_DT", DataType.DATE),
	PRIMARY_ASSIGNMENT ("Primary Assignment(s)", "PRIMARY_ASSIGNMENT", DataType.VARCHAR2),
	ISSUE_TYPE ("Issue Type", "ISSUE_TYPE", DataType.VARCHAR2),
	CAUSE ("Cause(s)", "CAUSE_DESC", DataType.VARCHAR2),
	CREATE_DATE ("Create Date", "CREATE_DT", DataType.DATE),
	BEMS_PROD_FAMILY ("BEMS Enterprise Product Family", "BEMS_PROD_FAMILY", DataType.VARCHAR2),
	CAP_MGR_ENGAGED ("CAP Manager(s) Engaged", "CAP_MGR_ENGAGED", DataType.VARCHAR2);
	
	public final String csvName;
	public final String dbName;
	public final DataType dataType;
 	
	CapClipField(String csvName, String dbName, DataType dataType) {
		this.csvName = csvName;
		this.dbName = dbName;
		this.dataType = dataType;
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
}

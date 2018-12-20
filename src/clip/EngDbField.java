package clip;


public enum EngDbField {
	
	AGE ("age", "AGE", DataType.NUMBER),
	BEMS_CASE ("bemsCase", "BEMS_CD", DataType.VARCHAR2),
	CAP_ID ("capID", "CAP_CASE_CD", DataType.VARCHAR2),
	CAP_INDEX ("index", "CAP_INDEX", DataType.NUMBER),
	CAP_ROLE ("capRole", "CAP_ROLE", DataType.VARCHAR2),
	CASE_UNIT ("caseUnit", "CASE_UNIT", DataType.NUMBER),
	CUSTOMER ("customer", "CUSTOMER_NM", DataType.VARCHAR2),
	DDTS ("ddts", "DDTS_CD", DataType.VARCHAR2),
	ETR ("ETR", "ETR", DataType.NUMBER),
	EXEC_SUMMARY ("execSummary", "EXEC_SUMMARY", DataType.VARCHAR2),
	F_PRIORITY ("fPriority", "F_PRIORITY", DataType.NUMBER),
	HEADLINE ("headline", "HEADLINE_DESC", DataType.VARCHAR2),
	HW_PROFILE ("hwProfile", "HW_PROFILE", DataType.VARCHAR2),
	MAX_PRIORITY ("maxPriority", "MAX_PRIORITY", DataType.VARCHAR2),
	OPEN_DATE ("openDate", "OPENED_DT", DataType.DATE),
	OWNER ("owner", "PRIMARY_OWNER", DataType.VARCHAR2),
	PLATORM ("platform", "PLAT_FAMILY", DataType.VARCHAR2),
	PRIORITY ("priority", "CASE_PRIORITY", DataType.VARCHAR2),
	PRIORITY_HISTORY ("priorityHistory", "PRIORITY_HISTORY", DataType.VARCHAR2),
	SERVICE_REQUEST ("serviceRequest", "SR_CD", DataType.VARCHAR2),
	STATUS ("status", "CASE_STATUS", DataType.VARCHAR2),
	SW_AREA ("swArea", "SW_AREA", DataType.VARCHAR2),
	TEMERATURE ("temperature", "CASE_TEMP", DataType.VARCHAR2),
	THEATER ("theater", "THEATER", DataType.VARCHAR2),
	UNIT ("unit", "UNIT", DataType.VARCHAR2),
	UPDATE_NOTE ("updateNote", "LAST_UPD_SUMMARY", DataType.VARCHAR2),
	UPDATE_NOTE_DATE ("updateNoteDate", "LAST_UPD_DT", DataType.DATE_OBJ),
	UPDATE_NOTE_USER ("updateNoteUser", "LAST_UPD_USER", DataType.VARCHAR2),
	VERSION_FOUND ("versionFound", "CASE_VERSION", DataType.VARCHAR2);
	
	public final String escalationName;
	public final String dbName;
	public final DataType dataType;
 	
	EngDbField(String escalationName, String dbName, DataType dataType) {
		this.escalationName = escalationName;
		this.dbName = dbName;
		this.dataType = dataType;
	}
}


package clip;

import java.util.ArrayList;



public enum ReleaseCqiField {
	VIEW_NAME ("ViewName", "VIEW_NAME", DataType.VARCHAR2, null),
	RG ("RG", "RG", DataType.INTEGER, "COUNT"),
	CFD ("CFD", "CFD", DataType.INTEGER, "COUNT"),
	URC ("URC", "URC", DataType.INTEGER, "COUNT"),
	RG_MTTR ("RG MTTR - Average Outstanding", "RG", DataType.NUMBER, "MTTR"),
	CFD_MTTR ("CFD MTTR - Average Outstanding", "CFD", DataType.NUMBER, "MTTR"),
	URC_MTTR ("URC MTTR", "URC", DataType.NUMBER, "MTTR");
	
	public final String cqiName;
	public final String dbName;
	public final DataType dataType;
	public final String cd;
 	
	ReleaseCqiField(String cqiName, String dbName, DataType dataType, String cd) {
		this.cqiName = cqiName;
		this.dbName = dbName;
		this.dataType = dataType;
		this.cd = cd;
	}
	
	public static final String[] getMetrics(String cd) {
		ArrayList<String> metrics = new ArrayList<>();
		for (ReleaseCqiField field : ReleaseCqiField.values()) {
			if (cd == null || cd.equalsIgnoreCase(field.cd)) metrics.add(field.cqiName);
		}
		
		int len = metrics.size();
		String[] result = new String[len];
		for (int i = 0; i < len; i ++) {
			result[i] = metrics.get(i);
		}
		return result;
	}
}

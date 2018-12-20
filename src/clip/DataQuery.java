package clip;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DataQuery {
	public final String queryCd;
	public final String chartCd;
	public final String pinNm;
	public final String subjAreaNm;
	public final String srcAppNm;
	public final String srcDataQry;
	public final String srcCsvPath;
	public final int execSeqNum;
	public final String qryParam;
	public final String targetTable;
	
	public DataQuery(ResultSet set) {
		String queryCd = null;
		String chartCd = null; 
		String pinNm = null; 
		String subjAreaNm = null; 
		String srcAppNm = null; 
		String srcDataQry = null; 
		String srcCsvPath = null;
		int execSeqNum = -1;
		String qryParam = null;
		String targetTable= null;
		
		try {
			queryCd = set.getString("QUERY_CD");
			chartCd = set.getString("CHART_CD"); 
			pinNm = set.getString("PIN_NM"); 
			subjAreaNm = set.getString("SUBJ_AREA_NM"); 
			srcAppNm = set.getString("SRC_APP_NM"); 
			srcDataQry = set.getString("SRC_DATA_QRY");
			srcCsvPath = set.getString("SRC_CSV_PATH");
			execSeqNum = set.getInt("EXEC_SEQ_NUM"); 
			qryParam = set.getString("QRY_PARAM");
			targetTable= set.getString("TARGET_TABLE");
		} catch (SQLException e) {
			e.printStackTrace();
			 
		} 
		
		this.queryCd = queryCd;
		this.chartCd = chartCd; 
		this.pinNm = pinNm; 
		this.subjAreaNm = subjAreaNm; 
		this.srcAppNm = srcAppNm; 
		this.srcDataQry = srcDataQry; 
		this.srcCsvPath = srcCsvPath;
		this.execSeqNum = execSeqNum; 
		this.qryParam = qryParam;
		this.targetTable = targetTable;
	}
}

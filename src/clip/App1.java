package clip;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class App1 {
	public static final String DATA_QUERY_TABLE_NAME = "OPSBI_360_SOURCE_DATA_QUERIES";
	
	public App1() {
		List<DataQuery> queries = fetchDataQueries();
		
// Akhilesh's Code
//		try {
//			new TacSR_Tableau().run();
//			new CAP_CQI_Outstanding_Table().openUrl();
//			new CDRR_CQI_ProductQualityMetrics().run();
//		} catch (ClassNotFoundException | InterruptedException | IOException | AWTException | SQLException e) {
//			e.printStackTrace();
//		}
		
		Util.clearTable("OPSBI_360_ESC_CLIP");
		Util.resetSequence("esc_rec_seq");
		
		ReleaseCqiManager.run();
		for (DataQuery query : queries) {
			Util.disposeConnection();
			//System.out.println("srcAppNm : " +query.srcAppNm );
			//System.out.println("chartCd : "+ query.chartCd);
			String srcAppNm = query.srcAppNm.trim();
			if (srcAppNm.equals("CLIP") && query.chartCd.equals("1.1")) 
				CapClipManager1.updateQuery(query);
		}
		
		Util.disposeConnection();
		System.out.println("Complete.");
	}
	
	public List<DataQuery> fetchDataQueries() {
		List<DataQuery> queries = new ArrayList<>();
		String query = "SELECT * FROM " + DATA_QUERY_TABLE_NAME;
		ResultSet set = Util.query(query);
		try {
			while (set.next()) {
				queries.add(new DataQuery(set));
			}
			set.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return queries;
	}
	
	public static void main(String[] args) {
		new App1();
	}
}

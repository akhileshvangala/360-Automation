package clip;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class App {
	public static final String DATA_QUERY_TABLE_NAME = "OPSBI_360_SOURCE_DATA_QUERIES";
	
	public App() {
		List<DataQuery> queries = fetchDataQueries();
		
// Akhilesh's Code
//		try {
//			new TacSR_Tableau().run();
//			new CAP_CQI_Outstanding_Table().openUrl();
//			new CDRR_CQI_ProductQualityMetrics().run();
//		} catch (ClassNotFoundException | InterruptedException | IOException | AWTException | SQLException e) {
//			e.printStackTrace();
//		}
		
		Util.clearTable(CapClipManager.TABLE_NAME);
		Util.clearTable(EngDbManager.TABLE_NAME);
		Util.clearTable(ReleaseCqiManager.TABLE_NAME);
		
		Util.resetSequence("OPSBI_360_CLIP_BEMSRRR_SEQ");
		Util.resetSequence("OPSBI_360_CAPENG_SEQ");
		Util.resetSequence("OPSBI_360_CQI_REL_SEQ");
		
		ReleaseCqiManager.run();
		for (DataQuery query : queries) {
			Util.disposeConnection();
			if (query.srcAppNm.equals("CLIP")) CapClipManager.updateQuery(query);
			else if (query.srcAppNm.equals("ENG_ESCALATION_DASHBOARD")) EngDbManager.updateQuery(query);
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
		new App();
	}
}

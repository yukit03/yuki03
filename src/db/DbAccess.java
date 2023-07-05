package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



public class DbAccess {

	String url = "jdbc:postgresql://localhost:5432/postgres" ;//DB の URL
	String user = "postgres" ; //DB のユーザー名
	String password = "postgrestest" ; //DB のパスワード

	public ArrayList <ArchiveData> dbGetArchiveData(){
		Connection con = null;
		Statement stmt = null; 
		ResultSet result = null;

		String sql = "select * from 成績表  " ;

		ArrayList <ArchiveData> a= new ArrayList<>();

		try {
			// PostgreSQL に接続
			con = DriverManager.getConnection ( url, user, password );
			stmt = con.createStatement();
			result = stmt.executeQuery ( sql );//返ってきた値を受け取る


			while ( result.next() ) {//次の行があれば繰り返す

				String col1=result.getString(1);
				String col2 =result.getString(2);
				int col3 =result.getInt(3);
				int col4=result.getInt(4);
			    int col5=result.getInt(5);
			    int col6=result.getInt(6);
			    int col7=result.getInt(7);
			    String col8=result.getString(8);
				a.add(new ArchiveData(col1,col2,col3,col4,col5,col6,col7,col8));
			}


		} catch ( SQLException e ) {
			e.printStackTrace() ;
		}finally{
			//クローズ処理
			try {
				if(result != null) result.close();
				if(stmt != null) stmt.close();
				if(con != null) con.close();
			}catch(Exception e) {
				e.printStackTrace();

			}


		}
		return a;
	}


}



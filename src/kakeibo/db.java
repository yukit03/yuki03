package kakeibo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class db {

	private Connection conn;
	String url;
	String user;
	String password;

	public db(){
		url = "jdbc:postgresql://localhost:5432/postgres";//DBのURL
		user = "postgres";//DBのユーザー名
		password = "postgrestest";//DBのパスワード
	}

	public void connect() {

		try {
			//Class.forName("org.postgres.Driver");
			conn = DriverManager.getConnection ( url, user, password ) ;

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}
	public void disConnect() {

		try {
			conn.setAutoCommit(true);
			conn.close();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	//家計簿テーブルを取得するdb操作
	public ArrayList <Kakeibo> dbGetKakeiboData(){

		String sql = "select * from 家計簿";

		ArrayList<Kakeibo>list = new ArrayList<>();

		try (Statement stmt = conn.createStatement();
				ResultSet result = stmt.executeQuery(sql);){


			while(result.next()) {//実行結果の取得
				Kakeibo goods = new Kakeibo();
				goods.setHiduke(result.getDate(1));//商品番号
				goods.setHimoku(result.getString(2));//商品名
				goods.setMemo(result.getString(3));//仕入先番号
				goods.setNyuukinn(result.getInt(4));//価格
				goods.setSyukkinn(result.getInt(5));//更新日

				list.add(goods);

			}

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return list;
	}


	//費目で検索して取得するdb操作
	public ArrayList<Kakeibo> getHimoku(String goodsname) {
		ArrayList<Kakeibo>list = new ArrayList<>();
		//Kakeibo goods = new Kakeibo();


		String sql = "select * from 家計簿 where 費目 = '"+goodsname+"'";
		try (Statement stmt = conn.createStatement();
				ResultSet result = stmt.executeQuery(sql);){


			while(result.next()) {//実行結果の取得

				Kakeibo goods = new Kakeibo();
				goods.setHiduke(result.getDate(1));//商品番号
				goods.setHimoku(result.getString(2));//商品名
				goods.setMemo(result.getString(3));//仕入先番号
				goods.setNyuukinn(result.getInt(4));//価格
				goods.setSyukkinn(result.getInt(5));//更新日
				
				list.add(goods);

			}

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		return list;
	}

	//費目で検索して削除するdb操作 	
	public int deleteHimoku(String goodsname) {

		int delete = 0;

		String sql ="delete from 家計簿 where 費目 = '"+goodsname+"'";
		try {

			Statement stmt = conn.createStatement();
			delete = stmt.executeUpdate(sql);


		} catch (SQLException e) {

			e.printStackTrace();
		}
		return delete;
	}

	public int insertKakeibo(Kakeibo goods) {

		int count = 0;
		String sql = "insert into 家計簿  values(?,?,?,?,?)";

		try (Connection con = DriverManager.getConnection ( url, user, password ) ;
				PreparedStatement pstmt = con.prepareStatement(sql); ) {

			//java.util.Dateのインスタンスに対してgetTime()してエポックからのミリ秒を取得し、
			//その値をjava.sql.Dateのコンストラクタに渡して、java.sql.Dateのインスタンスを作る必要がある
			pstmt.setDate(1, new Date(goods.getHiduke().getTime()));
			pstmt.setString(2, goods.getHimoku());
			pstmt.setString(3,goods.getMemo());
			pstmt.setInt(4,goods.getNyuukinn());
			pstmt.setInt(5, goods.getSyukkinn());

			count = pstmt.executeUpdate();//実行して件数取得

		} catch ( SQLException e ) {
			e.printStackTrace() ;
		}

		return count;
	}

	//費目を参照してアップデートするdb操作
	public int updateKakeibo(Kakeibo goods) {

		int count=0;
		String sql = "update 家計簿 set 日付 = ? ,費目 = ? ,メモ = ?, 入金額 = ?, 出金額 = ? where 費目 = ?";
		try (Connection con = DriverManager.getConnection ( url, user, password ) ;
				PreparedStatement pstmt = con.prepareStatement(sql); ) {

			pstmt.setDate(1, new Date(goods.getHiduke().getTime()));
			pstmt.setString(2, goods.getHimoku());
			pstmt.setString(3,goods.getMemo());
			pstmt.setInt(4,goods.getNyuukinn());
			pstmt.setInt(5, goods.getSyukkinn());
			pstmt.setString(6, goods.getHimoku());
			count = pstmt.executeUpdate();//実行して件数取得

		} catch ( SQLException e ) {
			e.printStackTrace() ;
		}

		return count;

	}

}
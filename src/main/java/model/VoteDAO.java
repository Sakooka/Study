package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VoteDAO {
	
	private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/animals";
	private final String DB_USER="sa";
	private final String DB_PASS="";
	
	//VOTE TABLEをリストに格納しreturnするメソッド
	public List<Animals> findAll(){
		List<Animals> animalsList = new ArrayList<>();
		
		//データベースへ接続
		try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){
		
			//SELECT文を用意
			String sql = "SELECT ID,NAME,VOTES FROM VOTE";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			//SELECTを実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();
			
			//結果表の内容をインスタンスに設定しArrayListインスタンスに格納
			while(rs.next()) {
				int id = rs.getInt("ID");
				String name = rs.getString("NAME");
				int votes = rs.getInt("VOTES");
				Animals animals = new Animals(id,name,votes);
				animalsList.add(animals);
			}
		
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return animalsList;
	}
	
	
	//投票された動物の票数を1増やすメソッド
	public void CountVote(String name) {
		try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){
			
			int voted;
			//SELECT文を用意
			String sql1 = "SELECT VOTES FROM VOTE WHERE NAME="+"\'"+name+"\'";
			PreparedStatement pStmt1 = conn.prepareStatement(sql1);
			
			//SELECTを実行し、結果表をからvotesを取得。+1
			ResultSet rs = pStmt1.executeQuery();
			rs.next();
			int votes = rs.getInt("VOTES");
			voted = votes+1;
			
			//UPDATE文でvotedを反映
			String sql2="UPDATE VOTE SET VOTES="+voted+" WHERE NAME="+"\'"+name+"\'";
			PreparedStatement pStmt2 = conn.prepareStatement(sql2);
			pStmt2.execute();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	//新たなAnimalを票数0でDBへ追加するメソッド
	public void AddAnimal(String name) {
		try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){
			//INSERT文を用意
			String sql = "INSERT INTO VOTE(NAME,VOTES) VALUES(\'"+name+"\',\'0\')";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	//登録済みのAnimalをDBから削除するメソッド
	public void DeleteAnimal(String name) {
		try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){
			//DELETE文を用意
			String sql = "DELETE FROM VOTE WHERE NAME="+"\'"+name+"\'";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
}

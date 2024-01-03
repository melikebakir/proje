package proje_gui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class T_baglanti {
	static Connection myConn;
	static Statement myStat;

	  static ResultSet yap() {
		  
		  ResultSet myRs = null;
		  try {
			  
			 myConn = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/kitap_listesi","root","Me21li52ke.");
			 myStat = (Statement)myConn.createStatement(); 
			 myRs= myStat.executeQuery("select * from kitap");
			 
		  }catch (Exception e) {
			  e.printStackTrace();
		  }
		  return myRs;
		 }
	
	  static void ekle(String sql_sorgu) {
		  
		  try {
			myStat.executeUpdate(sql_sorgu);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		    }
	  
	  static ResultSet sorgula(String sql_sorgu) {
		  ResultSet myRs = null;
		  
		  try {
			myRs= myStat.executeQuery(sql_sorgu);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		  return myRs;
	  }
}

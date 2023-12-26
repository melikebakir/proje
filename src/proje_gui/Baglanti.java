package proje_gui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Baglanti {
	

	public static void main(String[] args) {
		
   try {
	   Connection myConn=DriverManager.getConnection("jdbc:mysql://localhost:3306/kitap_listesi","root","Me21li52ke.");
	   Statement myStat= myConn.createStatement();
	   ResultSet myRs= myStat.executeQuery("select * from kullanıcılar");
   
	   while(myRs.next()) { //bütün kayıtları sırasıyla almamızı sağlayan bir komut
		   System.out.println(myRs.getString("kullanıcı adı")+ " "+ myRs.getString("şifre"));
	   }
   }catch (Exception e) {
	   e.printStackTrace(); //hatanın türünü algılayıp kendisinin yazması için
   }
   
	}
	

}

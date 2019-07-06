package testp2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


 /*
  * 
  * This file is part of CineApp.
  * 
  * CineApp is free software: you can redistribute it and/or modify
  * it under the terms of the GNU General Public License as published by
  * the Free Software Foundation, either version 3 of the License, or
  * (at your option) any later version.
  * 
  * CineApp is distributed in the hope that it will be useful,
  * but WITHOUT ANY WARRANTY; without even the implied warranty of
  * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
  * GNU General Public License for more details.
  * 
  * You should have received a copy of the GNU General Public License
  * along with CineApp.  If not, see <http://www.gnu.org/licenses/>.
  * 
  * */

public class Dolum {
	
	/*
	 * Koltukların dolu ve boşluğunu getirme parse etme
	 * Yeni koltuk güncelleme
	 * */
	
	private int did;
	private String dmetin;
	private int numaralar[];
	
	
//	Dolum(int did, String dmetin){
//		this.did=did;
//		this.dmetin=dmetin;
//	}
		

	 void koltuk_getir_sq(int did){
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:test3.db");
			c.setAutoCommit(false);
			System.out.println("\nOpened database successfully");

			stmt = c.createStatement();
			String sorgu="SELECT * FROM Doluluk Where did=" + did +";";  
			ResultSet rs = stmt.executeQuery(sorgu);
			
			 while (rs.next()) {
			 dmetin = rs.getString("DOLUM");
			 
			 String[] numaralars = dmetin.split(",");
			 
			 numaralar= new int[numaralars.length];
			 for(int i=0;i<numaralars.length;i++){
				 numaralar[i]=Integer.parseInt(numaralars[i]);
			 }	 
			 
//			 System.out.println("dolum = " + dmetin);
			 }
			 
			rs.close();
			stmt.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			// System.exit(0); 
		}
		System.out.println("Operation done successfully");
			
	}
	void koltuk_guncelle(String eklenecek,int did){
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:test3.db");
			c.setAutoCommit(false);
			System.out.println("\nOpened database successfully");

			stmt = c.createStatement();
			String sorgu="SELECT * FROM Doluluk Where did=" + did +";";  
			ResultSet rs = stmt.executeQuery(sorgu);
			
			 while (rs.next()) {
				 dmetin = rs.getString("DOLUM");
			}
			
			rs.close();
			
			dmetin+=eklenecek;
			
			sorgu= "UPDATE Doluluk SET DOLUM ="+"'"+ dmetin+"'"+ "WHERE DID ="+ did +";";
			
			stmt.executeUpdate(sorgu);
			
			
			
			stmt.close();
			c.commit();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			// System.exit(0);
		}
		System.out.println("Operation done successfully");
		
	}
	
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public String getDmetin() {
		return dmetin;
	}
	public void setDmetin(String dmetin) {
		this.dmetin = dmetin;
	}
	
	public int[] getNumaralar() {
		return numaralar;
	}

}

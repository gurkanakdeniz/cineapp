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

public class Sq { 
	
	/*
	 * Veritabanı sorgularının olduğu bölüm
	 * filmler ve salonlar çekiliyor
	 * */

	public Film[] fdizi;
	public FilmV2[] fdiziV2;
	public Salon[] sdizi;
	public Dolum[][] ddizi;
	

	
	Sq(String f) {
		if(f=="film"){
			filmleri_al();
		}else if(f=="salon"){
			salonlari_al();
		}else if(f=="v2"){
			filmleri_al_v2();
		}

	}
	static int boyut(){
		Connection c = null;
		Statement stmt = null;
		int count = 0;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:test3.db");
			c.setAutoCommit(false);
			System.out.println("Opened database successfully");

			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM Filmler Where VFL=1;");
//			rs.getSearchedResult(stmt);
			 while (rs.next()) {
				 //System.out.println();
				 count=Integer.parseInt(rs.getString(1));
			 }
			
			

			rs.close();
			stmt.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			// System.exit(0);
		}
		System.out.println("Operation done successfully");
	
		G1.N=count;
		return count;
	}
	void filmleri_al(){
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:test3.db");
			c.setAutoCommit(false);
			System.out.println("Opened database successfully");

			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Filmler Where VFL=1;");
			
			fdizi = new Film[G1.N];

			for (int i = 0; i < G1.N; i++) {
				if (rs.next()) {
					fdizi[i] = new Film(rs.getInt("fid"), rs.getString("name"), rs.getFloat("salary"),rs.getInt("sid"));
				}
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

	void salonlari_al(){
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:test3.db");
			c.setAutoCommit(false);
			System.out.println("Opened database successfully");

			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Salonlar WHERE SFL=1;");

			sdizi = new Salon[G1.N];
			
			for (int i = 0; i < G1.N; i++) {
				if (rs.next()) {
					sdizi[i] = new Salon(rs.getInt("sido"), rs.getInt("sid"), rs.getString("trh"), rs.getInt("did"));					
					
				}
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
	

	void filmleri_al_v2(){
		
		Connection c = null;
		Statement stmt = null;
		int count=0;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:test3.db");
			c.setAutoCommit(false);
			System.out.println("Opened database successfully");

			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT DISTINCT * FROM Filmler WHERE VFL=1 GROUP BY NAME");
			
			fdiziV2 = new FilmV2[G1.N];
			
			for (int i = 0; i < G1.N; i++) {
				if (rs.next()) {
					fdiziV2[i] = new FilmV2(rs.getInt("fid"), rs.getString("name"));
					count++;
				}
			}
		
			rs.close();
			stmt.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			// System.exit(0);
		}
		System.out.println("Operation done successfully");
		
		
//		System.out.println("v2count:"+count);
		G1.N2=count;
		
	}
	
	public Film[] getFdizi() {
		return fdizi;
	}

	public void setFdizi(Film[] fdizi) {
		this.fdizi = fdizi;
	}
	
	public Salon[] getSdizi() {
		return sdizi;
	}

	public void setSdizi(Salon[] sdizi) {
		this.sdizi = sdizi;
	}


}

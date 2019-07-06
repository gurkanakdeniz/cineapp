package testp2;

import java.sql.Connection;
import java.sql.DriverManager;
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

public class Kisi {
	
	/*
	 * Bilet alan kisiler
	 * */
	
	private int fid;
	private String name=null;
	private String bid;
	private double salary;
	
	Kisi(int fid,String bid,double salary,String name){
		this.fid=fid;
		this.bid=bid;
		this.salary=salary;
		
		this.name=name;
		//yukle();
	}
	void yukle(){
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:test3.db");
			c.setAutoCommit(false);
			System.out.println("\nOpened database successfully");

			stmt = c.createStatement();
			String sorgu="INSERT INTO Kisiler (ID,FID,NAME,BID,SALARY)"+ 
						 "VALUES (" + null + "," + fid + "," +"'"+ name +"'"+ "," +"'"+ bid+"'" + "," + salary + ");";
			
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
	
	
	
	
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBid() {
		return bid;
	}
	public void setBid(String bid) {
		this.bid = bid;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}


}

package giris;

//import java.awt.Color;
//import java.awt.Font;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JComboBox;
//import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
//import javax.swing.JTextArea;
import javax.swing.JTextField;
//import javax.swing.UIManager;

//import testp2.Kisi;

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

public class PersonelEkle {
	
private boolean ok=false;
private boolean ok2=false;

	  PersonelEkle() {

	  }  
	
	  PersonelEkle(Personel A){
		  
	        JTextField field1 = new JTextField();
	        JTextField field2 = new JTextField();
	        JPanel panel = new JPanel(new GridLayout(0, 1));
//	        panel.add(combo);
	        panel.add(new JLabel("İsim:"));
	        panel.add(field1);
	        panel.add(new JLabel("Şifre:"));
	        panel.add(field2);
	        int result = JOptionPane.showConfirmDialog(null, panel, "Personel Ekle",
	            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
	        if (result == JOptionPane.OK_OPTION) {
	        	System.out.println(field1.getText());
	        	
	        	if(!field1.getText().equals("")||!field2.getText().equals("")){
	        		A.setP_name(field1.getText());
		        	A.setP_pass(field2.getText());
		        	ok2=true;
	        	}else{
	        		 System.out.println("Kayıt Yapılmadı");
	        	}
	        	
	        } else {
	            System.out.println("Kayıt Yapılmadı");
	        }
	    
	}
	  
	void personelSil(Personel A){
		JComboBox combo = new JComboBox();
		JPanel panel = new JPanel(new GridLayout(0, 1));
		panel.add(new JLabel("Personel İsmi:"));
		panel.add(combo);
		
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:test3.db");
			c.setAutoCommit(false);
			System.out.println("Opened database successfully");

			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Personeller Where name<>'admin';");

			 while (rs.next()) {
			 //int id = rs.getInt("pid");
			 String name = rs.getString("name");
			 int a =rs.getInt("FL");
			 if(a!=0){
				 combo.addItem(name); 
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
		
		
		int result = JOptionPane.showConfirmDialog(null, panel, "Personel Sil",
	            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
	        if (result == JOptionPane.OK_OPTION) {
	        	
	        	String a=(String) combo.getSelectedItem();
	        	
	        	Connection c1 = null;
	    		Statement stmt1 = null;
	    		try {
	    			Class.forName("org.sqlite.JDBC");
	    			c1 = DriverManager.getConnection("jdbc:sqlite:test3.db");
	    			c1.setAutoCommit(false);
	    			System.out.println("\nOpened database successfully");

	    			stmt1 = c1.createStatement();
	    			
	    			String sorgu= "UPDATE Personeller SET FL ='0'"+"WHERE name ='"+ a +"';";
	    			
	    			stmt1.executeUpdate(sorgu);
	    			
	    			
	    			
	    			stmt1.close();
	    			c1.commit();
	    			c1.close();
	    		} catch (Exception e) {
	    			System.err.println(e.getClass().getName() + ": " + e.getMessage());
	    			// System.exit(0);
	    		}
	    		System.out.println("Operation done successfully");
	        	
	        	
	        	

	        } else {
	            System.out.println("Silinmedi");
	        }
		
	}

	
	void sifreDegistir(Personel A){

    	ok=true;
    	
    	
    	JComboBox combo = new JComboBox();
    	JTextField field2 = new JTextField();
    	
		JPanel panel = new JPanel(new GridLayout(0, 1));
		panel.add(new JLabel("Personel İsmi:"));
		panel.add(combo);
		panel.add(new JLabel("Yeni Şifre:"));
        panel.add(field2);
		
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:test3.db");
			c.setAutoCommit(false);
			System.out.println("Opened database successfully");

			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Personeller Where name<>'admin';");

			 while (rs.next()) {
			 //int id = rs.getInt("pid");
			 String name = rs.getString("name");
			 int a =rs.getInt("FL");
			 if(a!=0){
				 combo.addItem(name); 
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
		
		
		int result = JOptionPane.showConfirmDialog(null, panel, "Şifre Değiştir",
	            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
	        if (result == JOptionPane.OK_OPTION) {
	        	if(!field2.getText().equals("")){
	        		String a=(String) combo.getSelectedItem();
		        	String b=field2.getText().toString();
		        	Connection c1 = null;
		    		Statement stmt1 = null;
		    		try {
		    			Class.forName("org.sqlite.JDBC");
		    			c1 = DriverManager.getConnection("jdbc:sqlite:test3.db");
		    			c1.setAutoCommit(false);
		    			System.out.println("\nOpened database successfully");

		    			stmt1 = c1.createStatement();
		    			
		    			String sorgu= "UPDATE Personeller SET password ='"+b+"'"+"WHERE name ='"+ a +"';";
		    			
		    			stmt1.executeUpdate(sorgu);
		    			
		    			
		    			
		    			stmt1.close();
		    			c1.commit();
		    			c1.close();
		    		} catch (Exception e) {
		    			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		    			// System.exit(0);
		    		}
		    		System.out.println("Operation done successfully");
	        	}else{
	        		System.out.println("Degismedi");
	        	}
	        	

	        } else {
	            System.out.println("Degismedi");
	        }	
		
	}
	public boolean isOk() {
		return ok;
	}

	public void setOk(boolean ok) {
		this.ok = ok;
	}



	public boolean isOk2() {
		return ok2;
	}



	public void setOk2(boolean ok2) {
		this.ok2 = ok2;
	}

}

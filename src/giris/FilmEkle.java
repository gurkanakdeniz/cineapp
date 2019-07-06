package giris;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import testp2.Film;
import testp2.FilmV2;
import testp2.Salon;

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

public class FilmEkle {
	
	/*
	 * admin panelinden film ekle film sil
	 * 
	 * */
	static int N=0;
	static int N2=0;
	static int secili_fid=0;
	
	static Film fdizi[];
	static FilmV2 fdizi2[];
	
	static Salon sdizi[];
	
	FilmEkle(String secim){
		
		if(secim=="ekle"){
			filmEkle();
			
		}else if(secim=="sil"){
			boyut();
			filmAl2();
			filmAl();
			salonlar();
			
			filmSil();
		}else{
			System.out.println("hata");
		}
		
		
	}
	
	
	
	void boyut(){
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
			// System.exit(0); bir hata var
		}
		System.out.println("Operation done successfully");
		
		N=count;
	}
	
	void filmAl(){
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:test3.db");
			c.setAutoCommit(false);
			System.out.println("Opened database successfully");

			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Filmler Where VFL=1;");

			fdizi = new Film[N];

			for (int i = 0; i < N; i++) {
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
	
	void filmAl2(){
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
			
			fdizi2 = new FilmV2[N];
			for (int i = 0; i < N; i++) {
				if (rs.next()) {
					fdizi2[i] = new FilmV2(rs.getInt("fid"), rs.getString("name"));
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
		
		
		System.out.println("v2count:"+count);
		N2=count;
	}
	void salonlar(){
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:test3.db");
			c.setAutoCommit(false);
			System.out.println("Opened database successfully");

			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Salonlar WHERE SFL=1;");

			sdizi = new Salon[N];
			
			for (int i = 0; i < N; i++) {
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
	void filmSil(){
		
		JComboBox combo = new JComboBox();
		JComboBox combo1 = new JComboBox();
    	
		JPanel panel = new JPanel(new GridLayout(0, 1));
		panel.add(new JLabel("Film:"));
		panel.add(combo);
		panel.add(new JLabel("Tarih:"));
        panel.add(combo1);
		
        for (int i = 0; i <N2; i++) {
			String tmp="" + fdizi2[i].getIsim();
			System.out.println(tmp);
			combo.addItem(tmp);

		}
        
        combo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String ara=(String) combo.getSelectedItem();

				combo1.removeAllItems();
				for(int i=0;i<N;i++){
					
					String kontrol=fdizi[i].getIsim();					
					
					if(ara.equals(kontrol)){						
						String tmp=sdizi[i].getTarih();
						combo1.addItem(tmp);
						
					}
				}
				
				System.out.println("secilen metin:"+ara);
				
			}
		});
        combo1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (combo.getSelectedIndex() != -1) {
					
					String secim_tarih=(String) combo1.getSelectedItem();
					String ara=(String) combo.getSelectedItem();
					
					for(int i=0;i<N;i++){
						
						String kontrol=fdizi[i].getIsim();
			
						if(ara.equals(kontrol)&&sdizi[i].getTarih().equals(secim_tarih)){
							secili_fid=fdizi[i].getId();
							
						}
					}
				//	System.out.println("secili_fid"+secili_fid);
				 }  
			}
		});
        
        
		
		int result = JOptionPane.showConfirmDialog(null, panel, "Film Sil",
	            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
	        if (result == JOptionPane.OK_OPTION) {

	        	Connection c1 = null;
	    		Statement stmt1 = null;
	    		
	    		try {
	    			Class.forName("org.sqlite.JDBC");
	    			c1 = DriverManager.getConnection("jdbc:sqlite:test3.db");
	    			c1.setAutoCommit(false);
	    			System.out.println("\nOpened database successfully");

	    			stmt1 = c1.createStatement();
	    			
	    			String sorgu= "UPDATE Filmler SET VFL ='0'"+"WHERE FID ='"+ secili_fid +"';";
	    			
	    			stmt1.executeUpdate(sorgu);
	    			
	    			
	    			
	    			stmt1.close();
	    			c1.commit();
	    			c1.close();
	    		} catch (Exception e) {
	    			System.err.println(e.getClass().getName() + ": " + e.getMessage());
	    			// System.exit(0);
	    		}
	    		System.out.println("Operation done successfully");
	    		
	    		Connection c11 = null;
	    		Statement stmt11 = null;
	    		
	    		try {
	    			Class.forName("org.sqlite.JDBC");
	    			c11 = DriverManager.getConnection("jdbc:sqlite:test3.db");
	    			c11.setAutoCommit(false);
	    			System.out.println("\nOpened database successfully");

	    			stmt11 = c11.createStatement();
	    			
	    			String sorgu= "UPDATE Salonlar SET SFL ='0'"+"WHERE SIDO ='"+ secili_fid +"';";
	    			
	    			stmt11.executeUpdate(sorgu);
	    			
	    			stmt11.close();
	    			c11.commit();
	    			c11.close();
	    		} catch (Exception e) {
	    			System.err.println(e.getClass().getName() + ": " + e.getMessage());
	    			// System.exit(0);
	    		}

	        } else {
	            System.out.println("Degismedi");
	        }
    	
    	
    	
		
		
		
	}

	void filmEkle(){

		DateFormat tarihformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		JTextField field = new JTextField();
    	JTextField field2 = new JTextField();
    	JComboBox combo = new JComboBox();
    	JFormattedTextField tarih = new JFormattedTextField(tarihformat);
    	//"2017-01-02 18:00:00"
    	JButton ok=new JButton("Ekle");
    	tarih.setText("2017-03-02 00:00:00");
    	
		JPanel panel = new JPanel(new GridLayout(0, 1));
		combo.addItem("1");combo.addItem("2");combo.addItem("3");combo.addItem("4");
		combo.addItem("5");combo.addItem("6");combo.addItem("7");combo.addItem("8");
		
		panel.add(new JLabel("Film İsmi:"));
		panel.add(field);
		panel.add(new JLabel("Ücret:"));
        panel.add(field2);
        panel.add(new JLabel("Salon:"));
        panel.add(combo);
        panel.add(new JLabel("Tarih:"));
        panel.add(tarih);
        
        panel.add(new JLabel(" "));
        panel.add(ok);
        panel.add(new JLabel(" "));
        
        ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int flag=0;
				String isim="";
				String salon="";
				String tarihS="";
				String ucret="";
				
				
				while(flag==0){
	
					if(field.getText().equals("")){
						JOptionPane.showMessageDialog(
								null, "Film İsmi Yok", "İsim", JOptionPane.ERROR_MESSAGE);
						break;
					}else{
						flag=1;
						isim=field.getText();
					}
					if(field2.getText().equals("")){
						JOptionPane.showMessageDialog(
								null, "Ücret Yok", "Ücret", JOptionPane.ERROR_MESSAGE);
						break;
					}else{
						flag=1;
						ucret=field2.getText();
					}
					if(combo.getSelectedIndex()<0){
						JOptionPane.showMessageDialog(
								null, "Salon Yok", "Salon", JOptionPane.ERROR_MESSAGE);
						break;
					}else{
						flag=1;
						salon=(String) combo.getSelectedItem();
					}
					if(tarih.getText().equals("")){
						JOptionPane.showMessageDialog(
								null, "Tarih Yok", "Tarih", JOptionPane.ERROR_MESSAGE);
						break;
					}else{
						flag=1;
						tarihS=tarih.getText();
					}
			
					int sN=0;
					Connection c4 = null;
					Statement stmt4 = null;
					int count = 0;
					try {
						Class.forName("org.sqlite.JDBC");
						c4 = DriverManager.getConnection("jdbc:sqlite:test3.db");
						c4.setAutoCommit(false);
						System.out.println("Opened database successfully");

						stmt4 = c4.createStatement();
						ResultSet rs = stmt4.executeQuery("SELECT COUNT(*) FROM Salonlar");
//						rs.getSearchedResult(stmt);
						 while (rs.next()) {
							 sN=Integer.parseInt(rs.getString(1));
						 }
						
						

						rs.close();
						stmt4.close();
						c4.close();
					} catch (Exception ex) {
						System.err.println(ex.getClass().getName() + ": " + ex.getMessage());
						// System.exit(0);
					}
					System.out.println("Operation done successfully");
					sN++;
					 	Connection c3 = null;
					    Statement stmt3 = null;
					    try {
					      Class.forName("org.sqlite.JDBC");
					      c3 = DriverManager.getConnection("jdbc:sqlite:test3.db");
					      c3.setAutoCommit(false);
					      System.out.println("Opened database successfully");

					      stmt3 = c3.createStatement();
					      
					      String sql ="";
					      
					      sql="INSERT INTO Doluluk (DOLUM)VALUES ('00');";
					      stmt3.executeUpdate(sql);
					      
					      sql="INSERT INTO Salonlar (SIDO,SID,TRH,DID,SFL)VALUES ("+sN+","+salon+",'"+tarihS+"',"+sN+","+1+");";
					      stmt3.executeUpdate(sql);
					      
					      sql="INSERT INTO Filmler (FID,SID,NAME,SALARY,VFL)VALUES ("+sN+","+salon+",'"+isim+"',"+ucret+",1);";
					      stmt3.executeUpdate(sql);

					      stmt3.close();
					      c3.commit();
					      c3.close();
					    } catch ( Exception ex ) {
					      System.err.println( ex.getClass().getName() + ": " + ex.getMessage() );
					      System.exit(0);
					    }
					    System.out.println("Records created successfully");
	        		
					flag=1;
				}
				}
			});
        
        int result = JOptionPane.showConfirmDialog(null, panel, "Film Ekle",
	            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
	        if (result == JOptionPane.OK_OPTION) {
	        	

	        } else {
	         //   System.out.println("Degismedi");
	        }
        
        
		
	}

}

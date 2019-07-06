package giris;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import org.omg.PortableServer.ServantRetentionPolicyValue;

import testp2.Kisi;

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

public class BiletSq {
	JFrame frame;
	JTable table;
	JScrollPane scrollPane;
	
	ArrayList<Bilet> bdizi = new ArrayList<Bilet>();
	
	BiletSq(){

		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:test3.db");
			c.setAutoCommit(false);
			System.out.println("Opened database successfully");

			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Kisiler;");

			 while (rs.next()) {
				 bdizi.add(new Bilet(rs.getInt("fid"),rs.getString("name"),rs.getString("bid"),rs.getFloat("salary")));
			 }

			rs.close();
			stmt.close();
			c.close();
			
			
			Font font = new Font("SansSerif", Font.BOLD, 14);
			
			JTextArea veri= new JTextArea(25,35);
			veri.setEditable(false);
			veri.setFont(font);
			String tmp="|Film|\t|Personel|\t|Koltuklar|\t|Fiyat|\n\n";
			for(int i=0;i<bdizi.size();i++){
				tmp +=bdizi.get(i).getFid()+"\t"+bdizi.get(i).getName()+"\t "+bdizi.get(i).getBid()+"\t"+bdizi.get(i).getSalary()+"\n";
			}
			veri.setText(tmp);

			
			JPanel panel = new JPanel(new GridLayout(0, 1));
	        panel.setFont(font);
	        
	        panel.add(veri);  
	        
	        veri.setForeground(Color.DARK_GRAY);
      
	        
	        
	        JScrollPane scroll = new JScrollPane (veri, 
	        		   JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	        
	        panel.add(scroll);
	        
	        int result = JOptionPane.showConfirmDialog(null, panel, "Biletler",
	            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
	        if (result == JOptionPane.OK_OPTION) {
	        	//
	        } else {
	        	//
	        }
			
			
			
			
//			frame = new JFrame();
//		    //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//			String col[] = {"Film Id","Personel","Koltuklar", "Ücret"};
//
//		    DefaultTableModel tableModel = new DefaultTableModel(col, bdizi.size());
//		    
//		    table= new JTable(tableModel);
//
//
//		    scrollPane = new JScrollPane(table);
//		    frame.add(scrollPane, BorderLayout.CENTER);
//		    frame.setSize(300, 150);
//		    
//		    
//		    for (int i = 0; i < bdizi.size(); i++){
//		    	//String a=bdizi.get(i).getFid();
////		    	String b=bdizi.get(i).getName();
//		    	//String c=bdizi.get(i).getBid();
//		    	//String d=bdizi.get(i).getSalary();		
//		    	Object[] data = {"asd","b","asdas","sd"};
////
////		    	frame.add(data);
////		    	System.out.println(data[1]);
//		    	frame.
//		    	System.out.println(bdizi.get(i).getFid()+bdizi.get(i).getName()+bdizi.get(i).getBid()+bdizi.get(i).getSalary());
//			    
//		    }
//			
//			frame.setVisible(true);
/*
 *     JFrame f = new JFrame("JTable Sample");
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Object rows[][] = { { "A", "Name 1", "38.94" },
                        { "B", "Name 2", "7.70" }, 
                        { "C", "Name 3", "112.65" } };
    
    
    Object columns[] = { "Symbol", "Name", "Price" };
    JTable table = new JTable(rows, columns);
    JScrollPane scrollPane = new JScrollPane(table);
    f.add(scrollPane, BorderLayout.CENTER);
    f.setSize(300, 200);
    f.setVisible(true);
 * 
 * 
 * */			
			
			
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			// System.exit(0); bir hata var
		}
		System.out.println("Operation done successfully");
	}
	

}

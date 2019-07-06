package giris;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import testp2.Gg;

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

public class G0 extends JFrame  {
	
	/*
	 * giriş bölümü
	 * 
	 * */
	
	//version numarası
	String visim="V08.13";
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField passwordField;
	static private JComboBox comboBox;
	static Admin adminpanel;
	String kullanici="";
	
	//hash için 
//	private static int workload = 12;
	
	public G0(){
		G0Panel();
		
		kullanicilarSq();
		
		//admin seçili gelmesin
		comboBox.setSelectedIndex(1);
		
	}
	
	
	void G0Panel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		setTitle("Giriş");
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				passwordField.setText("");
			}
		});
		
		comboBox.setBounds(133, 73, 203, 29);
		contentPane.add(comboBox);
		
		passwordField = new JPasswordField();
		
		passwordField.setBounds(133, 128, 203, 29);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("Giriş");
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String a=(String) comboBox.getSelectedItem();
				String ps = new String(passwordField.getPassword());
				
				if(sifreSorgu(a,ps)){
					if(a.equals("admin")){
						passwordField.setText("");
						Gg.frame0.setVisible(false);
						Gg.frame0.dispose();
						 adminpanel=new Admin();
						 adminpanel.setVisible(true);
						 G0.this.validate();
					}else{
						Gg.frame0.setVisible(false);
						Gg.frame0.dispose();
						kullanici=a;
						Gg.frame1(kullanici);
					}
					
				}else{
					JOptionPane.showMessageDialog(
					        null, "Şifre Yanlış", "Hatalı Giriş", JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyChar()==KeyEvent.VK_ENTER)
					btnNewButton.doClick();
			}
		});
		
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setBounds(180, 170, 117, 25);
		contentPane.add(btnNewButton);
		
		JTextPane txtpnKullanc = new JTextPane();
		txtpnKullanc.setFont(UIManager.getFont("InternalFrame.titleFont"));
		txtpnKullanc.setForeground(Color.RED);
		txtpnKullanc.setBackground(Color.DARK_GRAY);
		txtpnKullanc.setText("KULLANICI:");
		txtpnKullanc.setEditable(false);
		txtpnKullanc.setBounds(31, 73, 84, 21);
		contentPane.add(txtpnKullanc);
		
		JTextPane txtpnifre = new JTextPane();
		txtpnifre.setText("ŞİFRE:");
		txtpnifre.setForeground(Color.RED);
		txtpnifre.setFont(UIManager.getFont("InternalFrame.titleFont"));
		txtpnifre.setEditable(false);
		txtpnifre.setBackground(Color.DARK_GRAY);
		txtpnifre.setBounds(31, 128, 84, 21);
		contentPane.add(txtpnifre);
		
		JTextPane txtpnSinema = new JTextPane();
		txtpnSinema.setForeground(new Color(102, 0, 51));
		txtpnSinema.setFont(new Font("DejaVu Sans Mono", Font.BOLD, 22));
		txtpnSinema.setText("           CineApp ");
		//txtpnSinema.setAlignmentX();
		txtpnSinema.setEditable(false);
		txtpnSinema.setBackground(Color.DARK_GRAY);
		txtpnSinema.setBounds(31, 12, 396, 49);
		contentPane.add(txtpnSinema);
		
		JTextPane txtpnV = new JTextPane();
		txtpnV.setFont(new Font("Liberation Sans", Font.PLAIN, 12));
		txtpnV.setForeground(new Color(0, 128, 0));
		txtpnV.setText(visim);
		txtpnV.setBackground(Color.DARK_GRAY);
		txtpnV.setEditable(false);
		txtpnV.setBounds(354, 239, 84, 21);
		contentPane.add(txtpnV);
	}
	
	void kullanicilarSq(){
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:test3.db");
			c.setAutoCommit(false);
			System.out.println("Opened database successfully");

			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Personeller Where fl=1;");

			 while (rs.next()) {
			 //int id = rs.getInt("pid");
			 String name = rs.getString("name");
			 
			 comboBox.addItem(name);
			 
			 }

			rs.close();
			stmt.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			// System.exit(0); bir hata var
		}
		System.out.println("Operation done successfully");
	}
	
	String sifreSetHash(String sifre){
		String hashSifre="";
//		
//		String salt = BCrypt.gensalt(workload);
//		String hashed_password = BCrypt.hashpw(password_plaintext, salt);
//		
//		
		
		return hashSifre;
	}
	String sifreCozHash(String hs){
		String cozumSifre="";
		
		return cozumSifre;
	}
	
	boolean sifreSorgu(String ad, String ps){
		boolean flag=false;
		
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:test3.db");
			c.setAutoCommit(false);
			System.out.println("Opened database successfully");

			stmt = c.createStatement();
			String sorgu="SELECT * FROM Personeller Where name='"+ad+"';";
			ResultSet rs = stmt.executeQuery(sorgu);
			 
			 while (rs.next()) {
				 String ps1=rs.getString("password");
				 if(ps.equals(ps1)){
					 flag=true;
				 }else{
					 flag=false;
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
		
		
		
		return flag;
	}

}

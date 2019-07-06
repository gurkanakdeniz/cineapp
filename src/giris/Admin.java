package giris;

import java.awt.Color;
import java.awt.Font;
//import java.awt.GridBagConstraints;
//import java.awt.GridBagLayout;
//import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
//import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
//import javax.swing.JOptionPane;
import javax.swing.JPanel;
//import javax.swing.JPasswordField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
//import javax.swing.UIManager;
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

public class Admin extends JFrame  {
	
	/**
	 * Admin paneli
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	Admin(){
		
		AdminFrame();
		//UIManager.put("Panel.foreground", Color.RED);
		String uyariMesajı="Veritabanı hakkında bilginiz yoksa veya\ndikkatli olmazsanız bu alanda işlem yapmanız\nhatalara neden olabilir.\n";
		JOptionPane.showMessageDialog(null, uyariMesajı, "Uyarı",
		        JOptionPane.WARNING_MESSAGE);
	}
	
	
	void AdminFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		setTitle("Admin Paneli");
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnFilmEkle = new JButton("Film Ekle");
		btnFilmEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				   //
					FilmEkle test= new FilmEkle("ekle");
				}
			});
		btnFilmEkle.setForeground(Color.WHITE);
		btnFilmEkle.setFont(new Font("Liberation Mono", Font.BOLD, 12));
		btnFilmEkle.setBackground(new Color(128, 0, 0));
		
		
		JButton btnPersonelEkle = new JButton("Personel Ekle");
		btnPersonelEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Personel ekle= new Personel();
				PersonelEkle ek= new PersonelEkle(ekle);
				if(ek.isOk2()){
					ekle.yukle();
				}
				
				
			}
		});
		btnPersonelEkle.setForeground(Color.WHITE);
		btnPersonelEkle.setFont(new Font("Liberation Mono", Font.BOLD, 12));
		btnPersonelEkle.setBackground(new Color(128, 0, 0));
		
		JButton btnFilmSil = new JButton("Film Sil");
		btnFilmSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			   //
				//@SuppressWarnings("unused")
				FilmEkle test= new FilmEkle("sil");
				
			}
		});
		btnFilmSil.setForeground(Color.WHITE);
		btnFilmSil.setFont(new Font("Liberation Mono", Font.BOLD, 12));
		btnFilmSil.setBackground(new Color(128, 0, 0));
		
		JButton btnifreDeitir = new JButton("Şifre Değiştir");
		btnifreDeitir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Personel sifredegisecek=new Personel();
				PersonelEkle sfdeg=new PersonelEkle();
				sfdeg.sifreDegistir(sifredegisecek);
//				if(sfdeg.isOk()){
//					sifredegisecek.sifreGuncelle();
//				}
			}
		});
		btnifreDeitir.setForeground(Color.WHITE);
		btnifreDeitir.setFont(new Font("Liberation Mono", Font.BOLD, 12));
		btnifreDeitir.setBackground(new Color(128, 0, 0));
		
		JButton btnGiriiEkran = new JButton("Giriş Ekranı");
		btnGiriiEkran.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				G0.adminpanel.setVisible(false);
				G0.adminpanel.dispose();
				Gg.frame0.setVisible(true);
			}
		});
		
		btnGiriiEkran.setForeground(Color.WHITE);
		btnGiriiEkran.setFont(new Font("Liberation Mono", Font.BOLD, 12));
		btnGiriiEkran.setBackground(new Color(0, 128, 0));
		
		JButton btnk = new JButton("Çıkış");
		btnk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		btnk.setForeground(Color.WHITE);
		btnk.setFont(new Font("Liberation Mono", Font.BOLD, 12));
		btnk.setBackground(new Color(210, 105, 30));
		
		JTextPane txtpnAdminPaneli = new JTextPane();
		txtpnAdminPaneli.setForeground(new Color(128, 0, 0));
		txtpnAdminPaneli.setFont(new Font("Lucida Sans", Font.PLAIN, 21));
		txtpnAdminPaneli.setBackground(new Color(0, 0, 0));
		txtpnAdminPaneli.setEditable(false);
		txtpnAdminPaneli.setText("            ADMİN PANELİ");
		
		JButton btnpersnlsil = new JButton("Personel Sil");
		btnpersnlsil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Personel sil=new Personel();
				PersonelEkle sl=new PersonelEkle();
				sl.personelSil(sil);
				
			}
		});
		
		btnpersnlsil.setForeground(Color.WHITE);
		btnpersnlsil.setFont(new Font("Liberation Mono", Font.BOLD, 12));
		btnpersnlsil.setBackground(new Color(128, 0, 0));
		
		JButton btnbiletler = new JButton("Biletlere Bak");
		btnbiletler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				   BiletSq sorgu=new BiletSq();
				}
			});
		
		btnbiletler.setForeground(Color.WHITE);
		btnbiletler.setFont(new Font("Liberation Mono", Font.BOLD, 12));
		btnbiletler.setBackground(new Color(128, 0, 0));
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(60)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(txtpnAdminPaneli, GroupLayout.PREFERRED_SIZE, 306, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnpersnlsil, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
									.addComponent(btnFilmEkle, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(btnGiriiEkran)
										.addGap(7))
									.addComponent(btnFilmSil, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
							.addGap(65)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnbiletler, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
								.addComponent(btnifreDeitir, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
								.addComponent(btnk, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
								.addComponent(btnPersonelEkle, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))))
					.addContainerGap(50, GroupLayout.PREFERRED_SIZE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtpnAdminPaneli, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnFilmEkle)
						.addComponent(btnPersonelEkle))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnFilmSil)
						.addComponent(btnifreDeitir))
					.addGap(5)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnpersnlsil, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnbiletler, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addGap(63)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnGiriiEkran)
						.addComponent(btnk))
					.addContainerGap(22, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	
}

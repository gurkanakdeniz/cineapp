package testp2;

//import java.awt.BorderLayout;
//import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.metal.MetalToggleButtonUI;
//import com.jgoodies.forms.layout.FormLayout;
//import com.jgoodies.forms.layout.ColumnSpec;
//import com.jgoodies.forms.layout.RowSpec;
//import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JButton;
//import net.miginfocom.swing.MigLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.awt.event.ItemEvent;
//import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextPane;
import javax.swing.JToggleButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;

import java.awt.Color;
import java.awt.Font;


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

public class G1 extends JFrame {

	/**
	 * Film seçim ekranı için kullanılan ekran
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static int N=0;
	//group by için kullanılan
	public static int N2=0;
	
	protected static JPanel contentPane; 
	protected static JPanel panel; //koltuklar
	protected static JPanel panel_1; //seans ve film
	protected static JPanel panel_2; //gonder admin
	protected static JPanel panel_3; // perde
	
	protected static JLabel perde;
	
	
	protected static JTextPane textPane; //perde
	
	protected static JToggleButton list2Button[][];  //koltuklar
	
	protected static JComboBox comboBox;
	protected static JComboBox comboBox_1;  //köşeli parantez string ekleme yeri uyarı bak
	protected static JComboBox comboBox_2;
	
	protected static Sq ss;
	protected static Sq sf;
	
	protected static Sq sfV2;
	
	//secili filmler sürekli güncel tutup her yerden erişmek için
	private String film_data=null;
	private double film_salary_data=0;
	private int secili_fid=0;
	
	protected static Dolum dl;
	public String personelAd="";

	
	public G1(String user) {
		//System.out.println(user);
		this.personelAd=user;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		setTitle("Film Seçim Ekranı");
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{112, 117, 0};
		gbl_contentPane.rowHeights = new int[]{25, 25, 25, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 0.0, 1.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		koltuklar();
		
		panel1();
		
		panel2();
		
		panel3();
		
		//baslangicta koltuklar yüklensin diye
		comboBox.setSelectedIndex(0);
		
		comboBox_1.setSelectedIndex(0);
		
		
	}
	
	void koltuklar(){
		list2Button = new JToggleButton[6][4];
		for(int i=0;i<6;i++){
			for(int j=0;j<4;j++){
				list2Button[i][j] = new JToggleButton(""+(i)+(j));
				list2Button[i][j].setBackground(Color.ORANGE);
				list2Button[i][j].setBounds(10, 10, 100, 100);
				list2Button[i][j].addActionListener(new ActionListener() {
					
					
					@Override
					public void actionPerformed(ActionEvent e) {
						for (int i = 0; i < 6; i++) {
							for (int j = 0; j < 4; j++) {
								
								list2Button[i][j].setUI(new MetalToggleButtonUI() {
								    @Override
								    protected Color getSelectColor() {
								        return Color.RED;
								    }
								});
							}
						}
						
					}
				});
				
			}
		}
		
		panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridwidth = 2;
		gbc_panel.gridheight = 4;
		gbc_panel.fill = GridBagConstraints.VERTICAL;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 2;
		contentPane.add(panel, gbc_panel);
		
		GroupLayout gl_panel = new GroupLayout(panel);
		
		
		gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup()
						.addGap(30)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(list2Button[0][0], GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(list2Button[0][1], GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(list2Button[0][2], GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(list2Button[0][3], GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(list2Button[1][0], GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(list2Button[1][1], GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(list2Button[1][2], GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(list2Button[1][3], GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(list2Button[2][0], GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(list2Button[2][1], GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(list2Button[2][2], GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(list2Button[2][3], GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(list2Button[3][0], GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(list2Button[3][1], GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(list2Button[3][2], GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(list2Button[3][3], GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(list2Button[4][0], GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(list2Button[4][1], GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(list2Button[4][2], GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(list2Button[4][3], GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(list2Button[5][0], GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(list2Button[5][1], GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(list2Button[5][2], GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(list2Button[5][3], GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))))
			);
			gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup()
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addComponent(list2Button[0][0])
							.addComponent(list2Button[0][1])
							.addComponent(list2Button[0][2])
							.addComponent(list2Button[0][3]))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addComponent(list2Button[1][0])
							.addComponent(list2Button[1][1])
							.addComponent(list2Button[1][2])
							.addComponent(list2Button[1][3]))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addComponent(list2Button[2][0])
							.addComponent(list2Button[2][1])
							.addComponent(list2Button[2][2])
							.addComponent(list2Button[2][3]))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addComponent(list2Button[3][0])
							.addComponent(list2Button[3][1])
							.addComponent(list2Button[3][2])
							.addComponent(list2Button[3][3]))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addComponent(list2Button[4][0])
							.addComponent(list2Button[4][1])
							.addComponent(list2Button[4][2])
							.addComponent(list2Button[4][3]))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addComponent(list2Button[5][0])
							.addComponent(list2Button[5][1])
							.addComponent(list2Button[5][2])
							.addComponent(list2Button[5][3])))
			);
			panel.setLayout(gl_panel);
		
		
	}
	
	void panel1(){
		panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridheight = 2;
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		contentPane.add(panel_1, gbc_panel_1);
		
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		comboBox = new JComboBox();

		Sq.boyut();
//		System.out.println("N:"+N);
				
		dl=new Dolum();

		//bunların fonksiyona çekilmesi gerekiyor
		sf= new Sq("film");
		
		ss = new Sq("salon");
				
		sfV2 = new Sq("v2");
		
		for (int i = 0; i <N2; i++) {
			String tmp="" + sfV2.fdiziV2[i].getIsim();
//			System.out.println(tmp);
			comboBox.addItem(tmp);

		}
		
		
		comboBox_1 = new JComboBox();

		comboBox.addActionListener(new ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent e) {
				
				for(int i=0;i<6;i++){
					for(int j=0;j<4;j++){
						list2Button[i][j].setBackground(Color.ORANGE);
				        list2Button[i][j].setSelected(false);
				        list2Button[i][j].setEnabled(true);
					}
			    }
				
		
				String ara=(String) comboBox.getSelectedItem();

				comboBox_1.removeAllItems();
				for(int i=0;i<N;i++){
					
					String kontrol=sf.fdizi[i].getIsim();					
					
					if(ara.equals(kontrol)){		
						String tmp=ss.sdizi[i].getTarih();
						comboBox_1.addItem(tmp);
					}
				}
				
//				System.out.println("secilen metin:"+ara);
				
			}
		});
		
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 0;
		panel_1.add(comboBox, gbc_comboBox);
		
		
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				for(int i=0;i<6;i++){
					for(int j=0;j<4;j++){
						list2Button[i][j].setBackground(Color.ORANGE);
				        list2Button[i][j].setSelected(false);
				        list2Button[i][j].setEnabled(true);
					}
			    }
				
				if (comboBox.getSelectedIndex() != -1) {   			 
					String secim_tarih=(String) comboBox_1.getSelectedItem();
					 	
//					System.out.println("secilen tarih:"+secim_tarih);
					
					//System.out.println("secilen salon id:"+koltuk_icin_si);
										
					String ara=(String) comboBox.getSelectedItem();
					
					for(int i=0;i<N;i++){
						
						String kontrol=sf.fdizi[i].getIsim();
						//System.out.println("kontrol:"+kontrol);
						//System.out.println("kontrol id: "+);
//						System.out.println("\n"+kontrol+i+"\n");
//						System.out.println(ss.sdizi[sf.fdizi[i].getId()-1].getD_id());
						if(ara.equals(kontrol)&&ss.sdizi[i].getTarih().equals(secim_tarih)){
							
//							System.out.println("did: "+ss.sdizi[i].getD_id());
//							System.out.println("salon: "+ss.sdizi[i].getS_id());
							
							dl.koltuk_getir_sq(ss.sdizi[i].getD_id());
														
							film_data = "Film :" 
						            + sf.fdizi[i].getIsim()
						            +"\nÜcret: " + sf.fdizi[i].getUcret()
						            +"\nSalon: " + sf.fdizi[i].getSalon_id()
						            +"\nTarih: "+ ss.sdizi[i].getTarih();
							
							film_salary_data=sf.fdizi[i].getUcret();
							
							secili_fid=i;		
						}
					}
					
			    		int num[]=dl.getNumaralar();
			    		//System.out.println(num.length);
			    		for(int i=0;i<num.length;i++){	    			
			    			list2Button[num[i]/10][num[i]%10].setBackground(Color.BLACK);
			    			list2Button[num[i]/10][num[i]%10].setEnabled(false);
			    		}
					 
//	               for(int i=0;i<N;i++){ 
//	            	   /*if((comboBox_1.getSelectedIndex()+1)==sf.fdizi[i].getSalon_id()){
//	            		  comboBox.setSelectedIndex(i);
//	            	   }*/
//	               }
				 }  
			}
		});

		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 1;
		gbc_comboBox_1.gridy = 1;
		panel_1.add(comboBox_1, gbc_comboBox_1);
		
		comboBox_2 = new JComboBox();
		
		comboBox_2.addItem("Koltuklar: ");
		comboBox_2.addItem("İndirim Kodu");

		comboBox_2.setEnabled(false);
		
		GridBagConstraints gbc_comboBox_2 = new GridBagConstraints();
		gbc_comboBox_2.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_2.gridx = 1;
		gbc_comboBox_2.gridy = 2;
		panel_1.add(comboBox_2, gbc_comboBox_2);
		
		
	}
	
	void panel2(){
		
		panel_2 = new JPanel();
		panel_2.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.gridheight = 2;
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 1;
		gbc_panel_2.gridy = 0;
		contentPane.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		
		///gonder admin butonları 
		JButton btnNewButton_4 = new JButton("   Göster     ");
		btnNewButton_4.setBackground(new Color(210, 105, 30));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {              
				JOptionPane.showMessageDialog(null, film_data, "Film Bilgisi", JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_4.gridx = 4;
		gbc_btnNewButton_4.gridy = 0;
		panel_2.add(btnNewButton_4, gbc_btnNewButton_4);
		
		JButton btnNewButton_21 = new JButton("   Kayıt Al    ");
		btnNewButton_21.setBackground(new Color(0, 128, 0));
		btnNewButton_21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				int flag=0;
				String secili_koltuk=null;
				String koltuk_data="";
				for(int i=0;i<6;i++){
					for(int j=0;j<4;j++){
						if(list2Button[i][j].isSelected()){
							secili_koltuk=String.valueOf(i);
							secili_koltuk+=String.valueOf(j);
							secili_koltuk+=",";
							//System.out.println(" "+i+" "+j);
							//System.out.print(secili_koltuk);
							koltuk_data+=secili_koltuk;
							flag++;
						}
					}
			    }
				
				if(flag==0){
					System.out.println("secim bulunamadi ");
					JOptionPane.showMessageDialog(
					        null, "Seçili Koltuk Bulunamadı", "Koltuk Seçimi", JOptionPane.ERROR_MESSAGE);
				}else{
									
				//sondaki virgülü temizlemek için
				koltuk_data=koltuk_data.substring(0,koltuk_data.length()-1);
				
//				System.out.println("\ntum2:" + koltuk_data+"\nsayi:"+flag);
				
				String data_goster=film_data+"\nKoltuk: " + koltuk_data+"\nToplam Ücret: "+film_salary_data*flag+"\nKasiyer: "+personelAd;
				
				Kayit kayit_yapilan =new Kayit(data_goster,sf.fdizi[secili_fid].getId(),
						koltuk_data,film_salary_data*flag,personelAd);
				
				if(kayit_yapilan.isOk()){
					//System.out.println("ilgili salon güncellendi");
					String eklenecek_koltuk=","+koltuk_data;
//					System.out.println(ss.sdizi[secili_fid].getD_id());
					dl.koltuk_guncelle(eklenecek_koltuk,ss.sdizi[secili_fid].getD_id());
					comboBox_1.setSelectedIndex(comboBox_1.getSelectedIndex());
				}
					
				
				}


			}
		});
		
		GridBagConstraints gbc_btnNewButton_21 = new GridBagConstraints();
		gbc_btnNewButton_21.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_21.gridx = 4;
		gbc_btnNewButton_21.gridy = 1;
		panel_2.add(btnNewButton_21, gbc_btnNewButton_21);
		 
		JButton btnNewButton_22 = new JButton("      Çıkış      ");
		btnNewButton_22.setBackground(new Color(128, 0, 0));
		btnNewButton_22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Gg.frame1.dispose();
				Gg.frame0();
				//System.exit(2);				
			}
		});
		
		GridBagConstraints gbc_btnNewButton_22 = new GridBagConstraints();
		gbc_btnNewButton_22.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_22.gridx = 4;
		gbc_btnNewButton_22.gridy = 2;
		panel_2.add(btnNewButton_22, gbc_btnNewButton_22);
		
	}
	
	void panel3(){
		panel_3 = new JPanel();
		panel_3.setBackground(Color.GRAY);
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.gridwidth = 2;
		gbc_panel_3.insets = new Insets(0, 0, 0, 5);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 6;
		contentPane.add(panel_3, gbc_panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_3.rowHeights = new int[]{0, 0};
		gbl_panel_3.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		Font font = new Font("SansSerif", Font.BOLD, 18);
		
		perde = new JLabel("PERDE");
		perde.setForeground(UIManager.getColor("OptionPane.errorDialog.border.background"));
		//perde.setBackground(getIconImage());
		perde.setFont(font);
		
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 8;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		panel_3.add(perde, gbc_lblNewLabel);
		
		
		/*
		textPane = new JTextPane();
		textPane.setBackground(Color.RED);
		textPane.setForeground(Color.RED);
		GridBagConstraints gbc_textPane = new GridBagConstraints();
		gbc_textPane.gridwidth = 8;
		gbc_textPane.fill = GridBagConstraints.BOTH;
		gbc_textPane.gridx = 1;
		gbc_textPane.gridy = 0;
		panel_3.add(textPane, gbc_textPane);
		*/
		
	}
	
	
}

package testp2;

import java.awt.Color;
import java.awt.Font;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;


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

public class Kayit {
	
	/*
	 * Koltuk seçiminden sonra kayit alma
	 * Bilet bölümü
	 * */
	
	private boolean ok=false;
	
	Kayit(String film_bilgi,int fid,String bid,double salary,String personelAd){
				
		Font font = new Font("SansSerif", Font.BOLD, 14);
		
		
		JTextArea veri= new JTextArea(film_bilgi+"\n\n\n");
		veri.setEditable(false);
		veri.setFont(font);
		
		JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.setFont(font);
        
        JLabel bilgi=new JLabel("Bilgi:");
        bilgi.setFont(font);
        
        panel.add(bilgi);
        panel.add(veri);  
        
//        panel.setBackground(Color.DARK_GRAY);
//        veri.setBackground(Color.DARK_GRAY);
        veri.setForeground(Color.DARK_GRAY);
        bilgi.setForeground(Color.red);        
//        bilgi.setBackground(Color.DARK_GRAY);
        
//        UIManager.put("OptionPane.background", Color.DARK_GRAY);
//        UIManager.put("Panel.background", Color.DARK_GRAY);
        
        int result = JOptionPane.showConfirmDialog(null, panel, "Bilet",
            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
        	Kisi ekle= new Kisi(fid,bid,salary,personelAd);
        	ekle.yukle();
        	
        	setOk(true);
        	
        	System.out.println("Kayıt Yapıldı");
        } else {
        	setOk(false);
            System.out.println("Kayıt Yapılmadı");
        }
	}

	public boolean isOk() {
		return ok;
	}

	public void setOk(boolean ok) {
		this.ok = ok;
	}
	

}

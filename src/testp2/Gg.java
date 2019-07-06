package testp2;

import java.awt.EventQueue;

//import java.sql.*;
//
//import javax.swing.JOptionPane;

import giris.G0;


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

public class Gg {
	//public static int a=1;
	public static G0 frame0;
	static G1 frame1;
	
	public static void main(String[] args) {

		//giris ekranı	
		frame0();
		
	}
	
	static void frame0(){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame0 = new G0();
					frame0.setResizable(false);
					frame0.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});		
	}
	
	public static void frame1(String user){
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
				if(!user.equals("")){

					frame1 = new G1(user);
					frame1.setVisible(true);
					
				}
		
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
	}

}

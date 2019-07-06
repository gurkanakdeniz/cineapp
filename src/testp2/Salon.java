package testp2;


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

public class Salon {
	
	/*
	 * Salon bilgileri
	 * */
	
	private int s_id;
	private int s_ido;
	
	
	private String tarih;  //'2007-01-01 10:00:00'
	private int d_id;
	
	public Salon(int s_ido, int s_id, String tarih,int d_id){
		this.setS_ido(s_ido);
		this.s_id=s_id;
		this.tarih=tarih;
		this.d_id=d_id;
	}
	
	
	public int getS_id() {
		return this.s_id;
	}
	public void setS_id(int s_id) {
		this.s_id = s_id;
	}
	
	public String getTarih() {		
		return this.tarih;
	}
	public void setTarih(String tarih) {
		this.tarih = tarih;
	}


	public int getD_id() {
		return d_id;
	}


	public void setD_id(int d_id) {
		this.d_id = d_id;
	}


	public int getS_ido() {
		return s_ido;
	}


	public void setS_ido(int s_ido) {
		this.s_ido = s_ido;
	}
	
	

}

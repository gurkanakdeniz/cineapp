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

public class Film {
	
	/*
	 * Film bilgileri
	 * 
	 * */
	
	private int id;
	private String isim=null;
	private float ucret;
	private int salon_id;
	
	
	public Film(int id, String isim, float ucret,int salon_id){
		this.id=id;
		this.isim=isim;
		this.ucret=ucret;
		this.salon_id=salon_id;
	}
	
	
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIsim() {
		return this.isim;
	}
	public void setIsim(String isim) {
		this.isim = isim;
	}
	public double getUcret() {
		return this.ucret;
	}
	public void setUcret(float ucret) {
		this.ucret = ucret;
	}


	public int getSalon_id() {
		return this.salon_id;
	}


	public void setSalon_id(int salon_id) {
		this.salon_id = salon_id;
	}
	
	
	

}

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

public class FilmV2 {
	
	/*
	 * Group by için kullanılan film bilgileri
	 * 
	 * */
	
	private int id;
	private String isim=null;

	
	public FilmV2(int id, String isim){
		this.id=id;
		this.isim=isim;
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

}

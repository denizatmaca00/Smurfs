
package prolab2_1;

import javax.swing.ImageIcon;

public abstract class Oyuncu extends Karakter {

	public int skor;
	
	Oyuncu(String oyuncuIsim, int oyuncuID, String oyuncuTip, Lokasyon oyuncuLokasyon, int skor, ImageIcon img) {
		super(oyuncuIsim, oyuncuID, oyuncuTip, oyuncuLokasyon,img);
		this.skor = skor;
	}

	public abstract void PuaniGoster();

	// GETTER SETTER
	public int getSkor() {
		return skor;
	}

	public void setSkor(int skor) {
		this.skor = skor;
	}

}
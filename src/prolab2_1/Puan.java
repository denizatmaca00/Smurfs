package prolab2_1;

import javax.swing.ImageIcon;

public class Puan extends Oyuncu {
	Puan(String oyuncuIsim, int oyuncuID, String oyuncuTip, Lokasyon oyuncuLokasyon, int skor, ImageIcon img) {
		super(oyuncuIsim, oyuncuID, oyuncuTip, oyuncuLokasyon, skor, img);
	}

	@Override
	public void PuaniGoster() {
	}
}
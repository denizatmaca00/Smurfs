package prolab2_1;

import javax.swing.ImageIcon;

public class GozlukluSirin extends Oyuncu {
	int gozlukluMantarPuan = 50;
	int gozlukluAltinPuan = 5;

	GozlukluSirin(String oyuncuIsim, int oyuncuID, String oyuncuTip, Lokasyon oyuncuLokasyon, int skor, ImageIcon img) {
		super(oyuncuIsim, oyuncuID, oyuncuTip, oyuncuLokasyon, skor, img);
	}

	@Override
	public void PuaniGoster() {
		for (int i = 0; i < Obje.mantarlar.size(); i++) {
			if (Oyun.sirin.getLokasyon().getX() == Obje.mantarlar.get(i).getLokasyon().getX()
					&& Oyun.sirin.getLokasyon().getY() == Obje.mantarlar.get(i).getLokasyon().getY()
					&& i == Obje.mantarlar.size() - 1) {
				Oyun.sirin.setSkor(Oyun.sirin.getSkor() + gozlukluMantarPuan);
				Obje.mantarlar.remove(i);
			}
		}
		for (int i = 0; i < Obje.altinlar.size(); i++) {
			if (Oyun.sirin.getLokasyon().getX() == Obje.altinlar.get(i).getLokasyon().getX()
					&& Oyun.sirin.getLokasyon().getY() == Obje.altinlar.get(i).getLokasyon().getY()) {
				Oyun.sirin.setSkor(Oyun.sirin.getSkor() + gozlukluAltinPuan);
				Obje.altinlar.remove(i);
			}
		}
	}

	public int getGozlukluMantarPuan() {
		return gozlukluMantarPuan;
	}

	public void setGozlukluMantarPuan(int gozlukluMantarPuan) {
		this.gozlukluMantarPuan = gozlukluMantarPuan;
	}

	public int getGozlukluAltinPuan() {
		return gozlukluAltinPuan;
	}

	public void setGozlukluAltinPuan(int gozlukluAltinPuan) {
		this.gozlukluAltinPuan = gozlukluAltinPuan;
	}

}
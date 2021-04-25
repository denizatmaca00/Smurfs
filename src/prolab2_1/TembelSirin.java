package prolab2_1;

import javax.swing.ImageIcon;

public class TembelSirin extends Oyuncu {
	int tembelMantarPuan = 50;
	int tembelAltinPuan = 5;
	
	TembelSirin(String oyuncuIsim, int oyuncuID, String oyuncuTip, Lokasyon oyuncuLokasyon, int skor, ImageIcon img) {
		super(oyuncuIsim, oyuncuID, oyuncuTip, oyuncuLokasyon, skor, img);
	}
	
	@Override
	public void PuaniGoster() {
		for (int i=0; i<Obje.mantarlar.size(); i++) {
				if (Oyun.sirin.getLokasyon().getX() == Obje.mantarlar.get(i).getLokasyon().getX()
						&& Oyun.sirin.getLokasyon().getY() == Obje.mantarlar.get(i).getLokasyon().getY()
						&& i == Obje.mantarlar.size() - 1) {
					Oyun.sirin.setSkor(Oyun.sirin.getSkor() + tembelMantarPuan);
					 Obje.mantarlar.remove(i);
				}
			}
			for (int i=0; i<Obje.altinlar.size(); i++) {
				if (Oyun.sirin.getLokasyon().getX() == Obje.altinlar.get(i).getLokasyon().getX()
						&& Oyun.sirin.getLokasyon().getY() == Obje.altinlar.get(i).getLokasyon().getY()) {
					Oyun.sirin.setSkor(Oyun.sirin.getSkor() + tembelAltinPuan);
					Obje.altinlar.remove(i);
				}
			}
		}
	
	public int getTembelMantarPuan() {
		return tembelMantarPuan;
	}

	public void setTembelMantarPuan(int tembelMantarPuan) {
		this.tembelMantarPuan = tembelMantarPuan;
	}

	public int getTembelAltinPuan() {
		return tembelAltinPuan;
	}

	public void setTembelAltinPuan(int tembelAltinPuan) {
		this.tembelAltinPuan = tembelAltinPuan;
	}

}

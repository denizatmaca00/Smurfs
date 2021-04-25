package prolab2_1;

import javax.swing.ImageIcon;

public class Karakter {
	private String isim;
	private int ID;
	private String tip;
	private Lokasyon lokasyon;
	private ImageIcon img;

	Karakter(String isim, int ID, String tip, Lokasyon lokasyon, ImageIcon img) {
		this.setIsim(isim);
		this.ID = ID;
		this.setTip(tip);
		this.setLokasyon(lokasyon);
		this.img = img;
	}

	// GETTER SETTER
	public String getIsim() {
		return isim;
	}

	public ImageIcon getImg() {
		return img;
	}

	public void setImg(ImageIcon img) {
		this.img = img;
	}

	public void setIsim(String isim) {
		this.isim = isim;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public Lokasyon getLokasyon() {
		return lokasyon;
	}

	public void setLokasyon(Lokasyon lokasyon) {
		this.lokasyon = lokasyon;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

}
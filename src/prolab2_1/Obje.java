package prolab2_1;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;

public class Obje {
	Lokasyon lokasyon;
	ImageIcon img;
	int altin = 5, mantar = 1;

	Obje(Lokasyon lokasyon, ImageIcon img) {
		this.lokasyon = lokasyon;
		this.img = img;
	}

	Obje() {
	}

	public static ArrayList<Obje> altinlar = new ArrayList<>();
	public static ArrayList<Obje> mantarlar = new ArrayList<>();

	public static void objeleriOlusturma() {
		Obje obje = new Obje();
		Random random = new Random();
		Lokasyon[] objeKonum = new Lokasyon[obje.getAltin() + obje.getMantar()];
		int objeX, objeY;

		for (int i = 0; i < obje.getAltin() + obje.getMantar(); i++) {
			do {
				objeX = random.nextInt(13);
				objeY = random.nextInt(11);
				objeKonum[i] = new Lokasyon(objeX, objeY);
			} while (Oyun.harita[objeY][objeX] == 0 || (objeX == Oyun.sirin.getLokasyon().getX() && objeY == Oyun.sirin.getLokasyon().getY()) || (objeX == 12 && objeY == 7));
		}

		Timer timer = new Timer();
		TimerTask altin = new TimerTask() {
			@Override
			public void run() {
				for (int a = 0; a < obje.getAltin(); a++) {
					altinlar.add(new Obje(objeKonum[a], new ImageIcon("bitcoin.png")));
					Labirent.kutu[altinlar.get(a).lokasyon.getY()][altinlar.get(a).lokasyon.getX()]
							.setIcon(altinlar.get(a).img);
				}
			}
		};

		TimerTask mantar = new TimerTask() {
			@Override
			public void run() {
				mantarlar.add(new Obje(objeKonum[objeKonum.length - 1], new ImageIcon("mantar.png")));
				Labirent.kutu[mantarlar.get(mantarlar.size() - 1).lokasyon
						.getY()][mantarlar.get(mantarlar.size() - 1).lokasyon.getX()]
								.setIcon(mantarlar.get(mantarlar.size() - 1).img);
			}
		};

		TimerTask altinSilme = new TimerTask() {
			@Override
			public void run() {
				for (int a = 0; a < obje.getAltin(); a++) {
					if (!altinlar.isEmpty()) {
						Labirent.kutu[altinlar.get(0).lokasyon.getY()][altinlar.get(0).lokasyon.getX()].setIcon(null);
						altinlar.remove(0);
					}
				}
			}
		};

		TimerTask mantarSilme = new TimerTask() {
			@Override
			public void run() {
				if (!mantarlar.isEmpty()) {
					Labirent.kutu[mantarlar.get(mantarlar.size() - 1).lokasyon
							.getY()][mantarlar.get(mantarlar.size() - 1).lokasyon.getX()].setIcon(null);
					mantarlar.remove(mantarlar.size() - 1);
				}
			}
		};

		timer.schedule(altin, 4000,14000);
		timer.schedule(mantar, 8000,23000);
		timer.schedule(altinSilme, 11000,13000);
		timer.schedule(mantarSilme, 16000,32000);

	}

	public int getAltin() {
		return altin;
	}

	public void setAltin(int altin) {
		this.altin = altin;
	}

	public int getMantar() {
		return mantar;
	}

	public void setMantar(int mantar) {
		this.mantar = mantar;
	}

	public Lokasyon getLokasyon() {
		return lokasyon;
	}

	public void setLokasyon(Lokasyon lokasyon) {
		this.lokasyon = lokasyon;
	}

	public ImageIcon getImg() {
		return img;
	}

	public void setImg(ImageIcon img) {
		this.img = img;
	}

}
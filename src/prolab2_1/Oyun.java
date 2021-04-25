package prolab2_1;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class Oyun {
	public static boolean kazandiMi;
	public static ArrayList<Dusman> dusman;
	public static Oyuncu sirin;
	public static int[][] harita = new int[11][13];
	public static Kutu[] kutular;
	static int gargamelKapiX, gargamelKapiY, azmanKapiX, azmanKapiY;

	public static void main(String[] args) {
		dusman = new ArrayList<>();
		SecimEkrani.secimArayuz();
		dosyadanOkuma();
	}

	public static void kutuOlusturma() {
		Kutu n05 = new Kutu("0,5");
		Kutu n11 = new Kutu("1,1");
		Kutu n12 = new Kutu("1,2");
		Kutu n13 = new Kutu("1,3");
		Kutu n14 = new Kutu("1,4");
		Kutu n15 = new Kutu("1,5");
		Kutu n16 = new Kutu("1,6");
		Kutu n17 = new Kutu("1,7");
		Kutu n18 = new Kutu("1,8");
		Kutu n19 = new Kutu("1,9");
		Kutu n21 = new Kutu("2,1");
		Kutu n23 = new Kutu("2,3");
		Kutu n29 = new Kutu("2,9");
		Kutu n30 = new Kutu("3,0");
		Kutu n31 = new Kutu("3,1");
		Kutu n32 = new Kutu("3,2");
		Kutu n33 = new Kutu("3,3");
		Kutu n34 = new Kutu("3,4");
		Kutu n35 = new Kutu("3,5");
		Kutu n37 = new Kutu("3,7");
		Kutu n38 = new Kutu("3,8");
		Kutu n39 = new Kutu("3,9");
		Kutu n41 = new Kutu("3,1");
		Kutu n42 = new Kutu("4,2");
		Kutu n43 = new Kutu("4,3");
		Kutu n45 = new Kutu("4,5");
		Kutu n46 = new Kutu("4,6");
		Kutu n47 = new Kutu("4,7");
		Kutu n49 = new Kutu("4,9");
		Kutu n52 = new Kutu("5,2");
		Kutu n55 = new Kutu("5,5");
		Kutu n56 = new Kutu("5,6");
		Kutu n57 = new Kutu("5,7");
		Kutu n59 = new Kutu("5,9");
		Kutu n61 = new Kutu("6,1");
		Kutu n62 = new Kutu("6,2");
		Kutu n63 = new Kutu("6,3");
		Kutu n64 = new Kutu("6,4");
		Kutu n65 = new Kutu("6,5");
		Kutu n66 = new Kutu("6,6");
		Kutu n67 = new Kutu("6,7");
		Kutu n69 = new Kutu("6,9");
		Kutu n71 = new Kutu("7,1");
		Kutu n72 = new Kutu("7,2");
		Kutu n77 = new Kutu("7,7");
		Kutu n79 = new Kutu("7,9");
		Kutu n81 = new Kutu("8,1");
		Kutu n82 = new Kutu("8,2");
		Kutu n83 = new Kutu("8,3");
		Kutu n84 = new Kutu("8,4");
		Kutu n85 = new Kutu("8,5");
		Kutu n86 = new Kutu("8,6");
		Kutu n87 = new Kutu("8,7");
		Kutu n89 = new Kutu("8,9");
		Kutu n91 = new Kutu("9,1");
		Kutu n93 = new Kutu("9,3");
		Kutu n96 = new Kutu("9,6");
		Kutu n97 = new Kutu("9,7");
		Kutu n98 = new Kutu("9,8");
		Kutu n99 = new Kutu("9,9");
		Kutu n100 = new Kutu("10,0");
		Kutu n101 = new Kutu("10,1");
		Kutu n105 = new Kutu("10,5");
		Kutu n106 = new Kutu("10,6");
		Kutu n107 = new Kutu("10,7");
		Kutu n108 = new Kutu("10,8");
		Kutu n109 = new Kutu("10,9");
		Kutu n111 = new Kutu("11,1");
		Kutu n112 = new Kutu("11,2");
		Kutu n113 = new Kutu("11,3");
		Kutu n114 = new Kutu("11,4");
		Kutu n115 = new Kutu("11,5");
		Kutu n116 = new Kutu("11,6");
		Kutu n117 = new Kutu("11,7");
		Kutu n118 = new Kutu("11,8");
		Kutu n119 = new Kutu("11,9");
		Kutu n127 = new Kutu("12,7");
		Kutu n310 = new Kutu("3,10");

		kutular = new Kutu[] { n05, n11, n12, n13, n14, n15, n16, n17, n18, n19, n21, n23, n29, n30, n31, n32, n33, n34,
				n35, n37, n38, n39, n41, n42, n43, n45, n46, n47, n49, n52, n55, n56, n57, n59, n61, n62, n63, n64, n65,
				n66, n67, n69, n71, n72, n77, n79, n81, n82, n83, n84, n85, n86, n87, n89, n91, n93, n96, n97, n98, n99,
				n100, n101, n105, n106, n107, n108, n109, n111, n112, n113, n114, n115, n116, n117, n118, n119, n127,
				n310 };

		for (Kutu kutu : kutular) {
			kutu.nodeKoordinat(kutu);
		}

		for (int i = 0; i < kutular.length; i++) {
			if ((kutular[i].x) + 1 <= 12) {
				if (Oyun.harita[kutular[i].y][(kutular[i].x) + 1] != 0) {
					for (int j = 0; j < kutular.length; j++) {
						if (kutular[j].x == ((kutular[i].x) + 1) && kutular[j].y == kutular[i].y) {
							kutular[i].komsuEkle(new Graf(1, kutular[i], kutular[j]));
						}
					}
				}
			}

			if ((kutular[i].x) - 1 >= 0) {
				if (Oyun.harita[kutular[i].y][(kutular[i].x) - 1] != 0) {
					for (int j = 0; j < kutular.length; j++) {
						if (kutular[j].x == ((kutular[i].x) - 1) && kutular[j].y == kutular[i].y) {
							kutular[i].komsuEkle(new Graf(1, kutular[i], kutular[j]));
						}
					}
				}
			}

			if ((kutular[i].y) + 1 <= 10) {
				if (Oyun.harita[(kutular[i].y) + 1][kutular[i].x] != 0) {
					for (int j = 0; j < kutular.length; j++) {
						if (kutular[j].x == kutular[i].x && kutular[j].y == ((kutular[i].y) + 1)) {
							kutular[i].komsuEkle(new Graf(1, kutular[i], kutular[j]));
						}
					}
				}
			}

			if ((kutular[i].y) - 1 >= 0) {
				if (Oyun.harita[(kutular[i].y) - 1][kutular[i].x] != 0) {
					for (int j = 0; j < kutular.length; j++) {
						if (kutular[j].x == kutular[i].x && kutular[j].y == ((kutular[i].y) - 1)) {
							kutular[i].komsuEkle(new Graf(1, kutular[i], kutular[j]));
						}
					}
				}
			}

		}
	}

	public static void dosyadanOkuma() {
		File dosya = new File("Harita.txt");
		BufferedReader reader = null;
		int i = 0, j;
		try {
			String line;
			reader = new BufferedReader(new FileReader(dosya));
			while ((line = reader.readLine()) != null) {
				if (line.startsWith("Karakter")) {
					String[] virgulleAyrilmis = line.split(",");
					String[] kotuTutucu = virgulleAyrilmis[0].split(":");
					String[] kapiTutucu = virgulleAyrilmis[1].split(":");
					kotuKarakterYaratma(kotuTutucu[1], kapiTutucu[1]);
				} else {
					String[] haritaTutucu = line.split("\t");
					for (j = 0; j < 13; j++) {
						harita[i][j] = Integer.parseInt(haritaTutucu[j]);
					}
					i++;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null)
					reader.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	public static void kotuKarakterYaratma(String kotuTutucu, String kapiTutucu) {
		Lokasyon kapi = kapiBulma(kapiTutucu);
		switch (kotuTutucu) {
		case "Gargamel":
			Dusman gargamel = new Dusman("Gargamel", 1, "insan", kapi, new ImageIcon("gargamelLabirent.png"));
			gargamelKapiX = gargamel.getLokasyon().getX();
			gargamelKapiY = gargamel.getLokasyon().getY();
			dusman.add(gargamel);
			break;
		case "Azman":
			Dusman azman = new Dusman("Azman", 2, "kedi", kapi, new ImageIcon("azmanLabirent.png"));
			azmanKapiX = azman.getLokasyon().getX();
			azmanKapiY = azman.getLokasyon().getY();
			dusman.add(azman);
			break;
		}
	}

	public static Lokasyon kapiBulma(String kapiTutucu) {
		Lokasyon kapiKonum = null;
		switch (kapiTutucu) {
		case "A":
			kapiKonum = new Lokasyon(3, 0);
			break;
		case "B":
			kapiKonum = new Lokasyon(10, 0);
			break;
		case "C":
			kapiKonum = new Lokasyon(0, 5);
			break;
		case "D":
			kapiKonum = new Lokasyon(3, 10);
			break;
		}
		return kapiKonum;
	}

	public static void sagaGit() {
		int sirinX = sirin.getLokasyon().getX();
		int sirinY = sirin.getLokasyon().getY();

		if (sirinX + 1 < 13) {
			if (harita[sirinY][sirinX + 1] == 1) {
				sirin.getLokasyon().setX(sirinX + 1);
				Labirent.kutu[sirin.getLokasyon().getY()][sirin.getLokasyon().getX()].setIcon(sirin.getImg());
				Labirent.kutu[sirin.getLokasyon().getY()][sirin.getLokasyon().getX() - 1].setIcon(null);
				System.out.println("Saga gidildi");
			} else {
				System.out.println("Saga Gidilemez");
			}
		} else {
			System.out.println("Haritanin disina cikamazsiniz!");
		}

		sirin.PuaniGoster();
		kutuOlusturma();

		for (int j = 0; j < dusman.size(); j++) {
			EnKisaYol enkisayol = new EnKisaYol();
			for (int i = 0; i < kutular.length; i++) {
				if (kutular[i].x == dusman.get(j).getLokasyon().getX()
						&& kutular[i].y == dusman.get(j).getLokasyon().getY()) {
					enkisayol.dijkstra(kutular[i]);
				}
			}
			for (int i = 0; i < kutular.length; i++) {
				if (kutular[i].x == Oyun.sirin.getLokasyon().getX()
						&& kutular[i].y == Oyun.sirin.getLokasyon().getY()) {
					enkisayol.enKisaYol(kutular[i]);
					System.out.print("Dusmandan sirine olan en kisa yol: ");
					for (int k = 0; k < EnKisaYol.yol.size(); k++) {
						if (k == EnKisaYol.yol.size() - 1)
							System.out.print(EnKisaYol.yol.get(k));
						else
							System.out.print(EnKisaYol.yol.get(k) + " - ");
					}
					System.out.println();
				}
			}
		}

		if (sirinY == 7 && sirinX + 1 == 12)
			kazandiMi = true;

	}

	public static void solaGit() {
		int sirinX = sirin.getLokasyon().getX();
		int sirinY = sirin.getLokasyon().getY();

		if (sirinX - 1 >= 0) {
			if (harita[sirinY][sirinX - 1] == 1) {
				sirin.getLokasyon().setX(sirinX - 1);
				Labirent.kutu[sirin.getLokasyon().getY()][sirin.getLokasyon().getX()].setIcon(sirin.getImg());
				Labirent.kutu[sirin.getLokasyon().getY()][sirin.getLokasyon().getX() + 1].setIcon(null);
				System.out.println("Sola gidildi");
			} else {
				System.out.println("Sola Gidilemez");
			}
		} else {
			System.out.println("Haritanin disina cikamazsiniz!");
		}

		sirin.PuaniGoster();
		kutuOlusturma();

		for (int j = 0; j < dusman.size(); j++) {
			EnKisaYol enkisayol = new EnKisaYol();
			for (int i = 0; i < kutular.length; i++) {
				if (kutular[i].x == dusman.get(j).getLokasyon().getX()
						&& kutular[i].y == dusman.get(j).getLokasyon().getY()) {
					enkisayol.dijkstra(kutular[i]);
				}
			}
			for (int i = 0; i < kutular.length; i++) {
				if (kutular[i].x == Oyun.sirin.getLokasyon().getX()
						&& kutular[i].y == Oyun.sirin.getLokasyon().getY()) {
					enkisayol.enKisaYol(kutular[i]);
					System.out.print("Dusmandan sirine olan en kisa yol: ");
					for (int k = 0; k < EnKisaYol.yol.size(); k++) {
						if (k == EnKisaYol.yol.size() - 1)
							System.out.print(EnKisaYol.yol.get(k));
						else
							System.out.print(EnKisaYol.yol.get(k) + " - ");
					}
					System.out.println();
				}
			}
		}

		if (sirinY == 7 && sirinX - 1 == 12) {
			kazandiMi = true;
		}
	}

	public static void asagiGit() {
		int sirinX = sirin.getLokasyon().getX();
		int sirinY = sirin.getLokasyon().getY();

		if (sirinY + 1 < 11) {
			if (harita[(sirinY + 1)][sirinX] == 1) {
				sirin.getLokasyon().setY(sirinY + 1);
				Labirent.kutu[sirin.getLokasyon().getY()][sirin.getLokasyon().getX()].setIcon(sirin.getImg());
				Labirent.kutu[sirin.getLokasyon().getY() - 1][sirin.getLokasyon().getX()].setIcon(null);
				System.out.println("Asagi gidildi");
			} else {
				System.out.println("Asagi Gidilemez");
			}
		} else {
			System.out.println("Haritanin disina cikamazsiniz!");
		}

		sirin.PuaniGoster();
		kutuOlusturma();

		for (int j = 0; j < dusman.size(); j++) {
			EnKisaYol enkisayol = new EnKisaYol();
			for (int i = 0; i < kutular.length; i++) {
				if (kutular[i].x == dusman.get(j).getLokasyon().getX()
						&& kutular[i].y == dusman.get(j).getLokasyon().getY()) {
					enkisayol.dijkstra(kutular[i]);
				}
			}
			for (int i = 0; i < kutular.length; i++) {
				if (kutular[i].x == Oyun.sirin.getLokasyon().getX()
						&& kutular[i].y == Oyun.sirin.getLokasyon().getY()) {
					enkisayol.enKisaYol(kutular[i]);
					System.out.print("Dusmandan sirine olan en kisa yol: ");
					for (int k = 0; k < EnKisaYol.yol.size(); k++) {
						if (k == EnKisaYol.yol.size() - 1)
							System.out.print(EnKisaYol.yol.get(k));
						else
							System.out.print(EnKisaYol.yol.get(k) + " - ");
					}
					System.out.println();
				}
			}
		}

		if (sirinY + 1 == 7 && sirinX == 12) {
			kazandiMi = true;
		}
	}

	public static void yukariGit() {
		int sirinX = sirin.getLokasyon().getX();
		int sirinY = sirin.getLokasyon().getY();

		if (sirinY - 1 >= 0) {
			if (harita[(sirinY - 1)][sirinX] == 1) {
				sirin.getLokasyon().setY(sirinY - 1);
				Labirent.kutu[sirin.getLokasyon().getY()][sirin.getLokasyon().getX()].setIcon(sirin.getImg());
				Labirent.kutu[sirin.getLokasyon().getY() + 1][sirin.getLokasyon().getX()].setIcon(null);
				System.out.println("Yukari gidildi");
			} else {
				System.out.println("Yukari Gidilemez");
			}
		} else {
			System.out.println("Haritanin disina cikamazsiniz!");
		}

		sirin.PuaniGoster();
		kutuOlusturma();

		for (int j = 0; j < dusman.size(); j++) {
			EnKisaYol enkisayol = new EnKisaYol();
			for (int i = 0; i < kutular.length; i++) {
				if (kutular[i].x == dusman.get(j).getLokasyon().getX()
						&& kutular[i].y == dusman.get(j).getLokasyon().getY()) {
					enkisayol.dijkstra(kutular[i]);
				}
			}
			for (int i = 0; i < kutular.length; i++) {
				if (kutular[i].x == Oyun.sirin.getLokasyon().getX()
						&& kutular[i].y == Oyun.sirin.getLokasyon().getY()) {
					enkisayol.enKisaYol(kutular[i]);
					System.out.print("Dusmandan sirine olan en kisa yol: ");
					for (int k = 0; k < EnKisaYol.yol.size(); k++) {
						if (k == EnKisaYol.yol.size() - 1)
							System.out.print(EnKisaYol.yol.get(k));
						else
							System.out.print(EnKisaYol.yol.get(k) + " - ");
					}
					System.out.println();
				}
			}
		}
		if (sirinY - 1 == 7 && sirinX == 12) {
			kazandiMi = true;
		}
	}

	public static void dusmaniOynat() {
		// for (int j = 0; j < dusman.size(); j++) {
		int j = 0;
		int tutX = dusman.get(j).getLokasyon().getX();
		int tutY = dusman.get(j).getLokasyon().getY();
		if (dusman.get(j).getID() == 1) {
			for (int i = 0; i < 2; i++) {
				if (!EnKisaYol.yol.isEmpty()) {
					dusman.get(j).getLokasyon().setX(EnKisaYol.yol.get(i + 1).x);
					dusman.get(j).getLokasyon().setY(EnKisaYol.yol.get(i + 1).y);
				}
				if (dusman.get(j).getLokasyon().getX() == sirin.getLokasyon().getX()
						&& dusman.get(j).getLokasyon().getY() == sirin.getLokasyon().getY()) {
					sirin.setSkor(sirin.getSkor() - 15);
					dusman.get(j).getLokasyon().setX(gargamelKapiX);
					dusman.get(j).getLokasyon().setY(gargamelKapiY);
					Labirent.kutu[gargamelKapiY][gargamelKapiX].setIcon(dusman.get(j).getImg());
				}
			}
			Labirent.kutu[dusman.get(j).getLokasyon().getY()][dusman.get(j).getLokasyon().getX()]
					.setIcon(dusman.get(j).getImg());
			Labirent.kutu[tutY][tutX].setIcon(null);

			for (int a = 0; a < 11; a++) {
				for (int b = 0; b < 13; b++) {
					if (harita[a][b] == 1)
						Labirent.kutu[a][b].setBackground(new Color(51, 255, 153));
				}
			}
			for (int i = 2; i < EnKisaYol.yol.size(); i++) {
				Labirent.kutu[EnKisaYol.yol.get(i).y][EnKisaYol.yol.get(i).x].setBackground(new Color(255, 255, 153));
			}

		} else if (dusman.get(j).getID() == 2) {
			if (!EnKisaYol.yol.isEmpty()) {
				dusman.get(j).getLokasyon().setX(EnKisaYol.yol.get(1).x);
				dusman.get(j).getLokasyon().setY(EnKisaYol.yol.get(1).y);
			}
			if (dusman.get(j).getLokasyon().getX() == sirin.getLokasyon().getX()
					&& dusman.get(j).getLokasyon().getY() == sirin.getLokasyon().getY()) {
				sirin.setSkor(sirin.getSkor() - 5);
				dusman.get(j).getLokasyon().setX(azmanKapiX);
				dusman.get(j).getLokasyon().setY(azmanKapiY);
				Labirent.kutu[azmanKapiY][azmanKapiX].setIcon(dusman.get(j).getImg());
			}

			Labirent.kutu[dusman.get(j).getLokasyon().getY()][dusman.get(j).getLokasyon().getX()]
					.setIcon(dusman.get(j).getImg());
			Labirent.kutu[tutY][tutX].setIcon(null);

			for (int a = 0; a < 11; a++) {
				for (int b = 0; b < 13; b++) {
					if (harita[a][b] == 1)
						Labirent.kutu[a][b].setBackground(new Color(51, 255, 153));
				}
			}
			for (int i = 2; i < EnKisaYol.yol.size(); i++) {
				Labirent.kutu[EnKisaYol.yol.get(i).y][EnKisaYol.yol.get(i).x].setBackground(new Color(255, 255, 153));
			}
		}

		// }

	}

}
package prolab2_1;
import java.util.ArrayList;
import java.util.List;

public class Kutu implements Comparable<Kutu> {
	int x,y;
    public List<Graf> grafYapisi;
	public double uzaklik = Double.MAX_VALUE;
    public Kutu oncekiKutu;
	public boolean kullanildiMi;
	public String isim;

    public Kutu(String isim) {
        this.isim = isim;
        this.grafYapisi = new ArrayList<>();
    }
    
    public void nodeKoordinat(Kutu kutu) {
   	 String[] koordinat = kutu.isim.split(",");
   	 kutu.x = Integer.parseInt(koordinat[0]);
   	 kutu.y = Integer.parseInt(koordinat[1]);
    }


    public List<Graf> getGrafYapisi() {
		return grafYapisi;
	}

	public void setGrafYapisi(List<Graf> grafYapisi) {
		this.grafYapisi = grafYapisi;
	}
	
    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public int getX() {
    	return x;
    }

    public void setX(int x) {
    	this.x = x;
    }

    public int getY() {
    	return y;
    }

    public void setY(int y) {
    	this.y = y;
    }

    public void komsuEkle(Graf graf) {
        this.grafYapisi.add(graf);
    }

    public double getUzaklik() {
		return uzaklik;
	}

	public void setUzaklik(double uzaklik) {
		this.uzaklik = uzaklik;
	}

	public Kutu getOncekiKutu() {
		return oncekiKutu;
	}

	public void setOncekiKutu(Kutu oncekiKutu) {
		this.oncekiKutu = oncekiKutu;
	}

    public boolean isKullanildiMi() {
		return kullanildiMi;
	}

	public void setKullanildiMi(boolean kullanildiMi) {
		this.kullanildiMi = kullanildiMi;
	}

    @Override
    public String toString() {
        return this.isim;
    }

    @Override
    public int compareTo(Kutu kutuX) {
        return Double.compare(this.uzaklik, kutuX.getUzaklik());
    }


}
package prolab2_1;

public class Graf {
	public double maliyet;
    public Kutu baslangicNoktasi;
    public Kutu bitisNoktasi;

    public Graf(int maliyet, Kutu baslangicNoktasi, Kutu bitisNoktasi) {
        this.maliyet = maliyet;
        this.baslangicNoktasi = baslangicNoktasi;
        this.bitisNoktasi = bitisNoktasi;
    }

    public double getMaliyet() {
		return maliyet;
	}

	public void setMaliyet(double maliyet) {
		this.maliyet = maliyet;
	}

	public Kutu getBaslangicNoktasi() {
		return baslangicNoktasi;
	}

	public void setBaslangicNoktasi(Kutu baslangicNoktasi) {
		this.baslangicNoktasi = baslangicNoktasi;
	}

	public Kutu getBitisNoktasi() {
		return bitisNoktasi;
	}

	public void setBitisNoktasi(Kutu bitisNoktasi) {
		this.bitisNoktasi = bitisNoktasi;
	}
}
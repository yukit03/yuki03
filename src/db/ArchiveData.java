package db;


public class ArchiveData {//データをnewしていれる箱つくる
	
	private String gakusekibanngou;
	private String gakuseimei;
	private int hougaku;
	private int keizaigaku;
	private int tetugaku;
	private int jyoiuhouriron;
	private int gaikokugo;
	private String sougouseiseki;
	
	
	public ArchiveData(String gakusekibanngou, String gakuseimei, int hougaku, int keizaigaku, int tetugaku,
			int jyoiuhouriron, int gaikokugo, String sougouseiseki) {
		super();
		this.gakusekibanngou = gakusekibanngou;
		this.gakuseimei = gakuseimei;
		this.hougaku = hougaku;
		this.keizaigaku = keizaigaku;
		this.tetugaku = tetugaku;
		this.jyoiuhouriron = jyoiuhouriron;
		this.gaikokugo = gaikokugo;
		this.sougouseiseki = sougouseiseki;
	}


	public String getGakusekibanngou() {
		return gakusekibanngou;
	}


	public void setGakusekibanngou(String gakusekibanngou) {
		this.gakusekibanngou = gakusekibanngou;
	}


	public String getGakuseimei() {
		return gakuseimei;
	}


	public void setGakuseimei(String gakuseimei) {
		this.gakuseimei = gakuseimei;
	}


	public int getHougaku() {
		return hougaku;
	}


	public void setHougaku(int hougaku) {
		this.hougaku = hougaku;
	}


	public int getKeizaigaku() {
		return keizaigaku;
	}


	public void setKeizaigaku(int keizaigaku) {
		this.keizaigaku = keizaigaku;
	}


	public int getTetugaku() {
		return tetugaku;
	}


	public void setTetugaku(int tetugaku) {
		this.tetugaku = tetugaku;
	}


	public int getJyoiuhouriron() {
		return jyoiuhouriron;
	}


	public void setJyoiuhouriron(int jyoiuhouriron) {
		this.jyoiuhouriron = jyoiuhouriron;
	}


	public int getGaikokugo() {
		return gaikokugo;
	}


	public void setGaikokugo(int gaikokugo) {
		this.gaikokugo = gaikokugo;
	}


	public String getSougouseiseki() {
		return sougouseiseki;
	}


	public void setSougouseiseki(String sougouseiseki) {
		this.sougouseiseki = sougouseiseki;
	}
	
	

}

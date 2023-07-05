package kakeibo;

import java.util.Date;

public class Kakeibo {
	
	private Date hiduke;
	private String himoku;
	private String memo;
	private int nyuukinn;
	private int syukkinn;
		
	
	public Kakeibo(Date hiduke, String himoku, String memo, int nyuukinn, int syukkinn) {
		super();
		this.hiduke = hiduke;
		this.himoku = himoku;
		this.memo = memo;
		this.nyuukinn = nyuukinn;
		this.syukkinn = syukkinn;
	}
	
	public Kakeibo() {
		
	}
	
	
	
	public Date getHiduke() {
		return hiduke;
	}
	public void setHiduke(Date hiduke) {
		this.hiduke = hiduke;
	}
	public String getHimoku() {
		return himoku;
	}
	public void setHimoku(String himoku) {
		this.himoku = himoku;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public int getNyuukinn() {
		return nyuukinn;
	}
	public void setNyuukinn(int nyuukinn) {
		this.nyuukinn = nyuukinn;
	}
	public int getSyukkinn() {
		return syukkinn;
	}
	public void setSyukkinn(int syukkinn) {
		this.syukkinn = syukkinn;
	}
	
	

}

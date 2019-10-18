package blackJack;

public class Player {
	
	private String name;
	private int balance;
	private double winRate;
	
	public Player(String name, int balance, double winRate){
		this.name = name;
		this.balance = balance;
		this.winRate = winRate;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public double getWinRate() {
		return winRate;
	}
	public void setWinRate(double winRate) {
		this.winRate = winRate;
	}

	
}

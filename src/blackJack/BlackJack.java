package blackJack;

import java.util.Scanner;
import java.util.ArrayList;

public class BlackJack {
	
	private Player player;
	private int CPUcardSum = (int)Math.random()*7+15;
	private ArrayList<Integer> playCards = new ArrayList<>();
	
	public BlackJack(Player player){
		this.player = player;
	}
	
	public Player getPlayer() {
		return this.player;
	}
	
	public void gameInit() {
		int quitFlag = 0;
		System.out.println("    /$$   /$$$$$$$ /$$                  /$$         /$$$$$                  /$$         /$$   \n" + 
				"  /$$$$$$| $$__  $| $$                 | $$        |__  $$                 | $$       /$$$$$$ \n" + 
				" /$$__  $| $$  \\ $| $$ /$$$$$$  /$$$$$$| $$   /$$     | $$ /$$$$$$  /$$$$$$| $$   /$$/$$__  $$\n" + 
				"| $$  \\__| $$$$$$$| $$|____  $$/$$_____| $$  /$$/     | $$|____  $$/$$_____| $$  /$$| $$  \\__/\n" + 
				"|  $$$$$$| $$__  $| $$ /$$$$$$| $$     | $$$$$$/ /$$  | $$ /$$$$$$| $$     | $$$$$$/|  $$$$$$ \n" + 
				" \\____  $| $$  \\ $| $$/$$__  $| $$     | $$_  $$| $$  | $$/$$__  $| $$     | $$_  $$ \\____  $$\n" + 
				" /$$  \\ $| $$$$$$$| $|  $$$$$$|  $$$$$$| $$ \\  $|  $$$$$$|  $$$$$$|  $$$$$$| $$ \\  $$/$$  \\ $$\n" + 
				"|  $$$$$$|_______/|__/\\_______/\\_______|__/  \\__/\\______/ \\_______/\\_______|__/  \\__|  $$$$$$/\n" + 
				" \\_  $$_/                                                                            \\_  $$_/ \n" + 
				"   \\__/                                                                                \\__/   \n" + 
				"                                                                                             ");
		System.out.println("Welcom ! "+player.getName());
		System.out.println("Your Balance: "+player.getBalance());
		
		while(quitFlag == 0) {
			quitFlag = this.gameStart();
		}
		System.out.println("Bye");
	}
	
	
	public int gameStart() {
				
		int playing = 1;

				
		while(playing==1) {
			System.out.print("Place your bet: ");
			Scanner myObj = new Scanner(System.in);
			
			int betValue = myObj.nextInt();
			
			
			if(betValue<0) {
				System.out.println("You Quited the game");
				myObj.close();
				return 1;
			}else if(betValue>player.getBalance()){
				System.out.println("You don't have enough money");
				continue;
			}else {
				System.out.print("your bet: " + betValue);
				this.getPlayer().setBalance(this.getPlayer().getBalance()-betValue);
				System.out.print("your balance: " + this.getPlayer().getBalance());
			}
		}

	}
	
	public void dealCard() {
		
	}
	
}

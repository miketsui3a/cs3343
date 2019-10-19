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
		System.out.print("Want to win some cash??? (Y/N)");
		
		Scanner inGame = new Scanner(System.in);
		
		String isPlay = inGame.nextLine();
		if(isPlay.compareTo("Y")!=0	) {
			System.out.println("Bye");
			inGame.close();
			return; 
		}
		
		
		while(quitFlag == 0) {
			quitFlag = this.gameStart();
		}
		System.out.println("Bye");
		inGame.close();
	}
	
	
	public int gameStart() {
				
		int playing = 1;
		Deck playerDeck = new Deck();
		Deck cpuDeck = new Deck();
		playerDeck.dealCard();
		playerDeck.dealCard();
		cpuDeck.dealCard();
		cpuDeck.dealCard();
		int roundCnt = 0;
		int betValue = 0;
		int betAccumunate = 0;
		
		while(playing==1) {
			
			if(roundCnt==0) {
				System.out.print("Place your Bet: ");
				Scanner betScanner = new Scanner(System.in);
				betValue = betScanner.nextInt();
				if(betValue>this.getPlayer().getBalance()) {
					System.out.println("You don't have enough money.");
					continue;
				}
				betAccumunate += betValue; 
				this.getPlayer().setBalance(this.getPlayer().getBalance()-betValue);
				cpuDeck.printCpuCard();
				playerDeck.printCard();
				System.out.println("Total bet Value: "+betAccumunate);
				roundCnt++;
			}else {
				if (playerDeck.calCardSum()>21) {
					playerDeck.printCard();
					System.out.println("Busted !!!");
					playing=0;
				}else{
					if(roundCnt!=1) {
						cpuDeck.printCpuCard();
						playerDeck.printCard();
						System.out.println("Total bet Value: "+betAccumunate);
					}
					roundCnt++;
					
					
					System.out.print("What do you want to do? Bet, Hit, Stop: ");
					Scanner actionScanner = new Scanner(System.in);
					String action = actionScanner.nextLine();
					switch(action) {
						case "B": {
							System.out.print("Place your Bet: ");
							Scanner betScanner = new Scanner(System.in);
							betValue = betScanner.nextInt();
							if(betValue>this.getPlayer().getBalance()) {
								System.out.println("You don't have enough money.");
								continue;
							}
							this.getPlayer().setBalance(this.getPlayer().getBalance()-betValue);
							betAccumunate += betValue; 
							roundCnt++;
							break;
						}
						case "H": {
							playerDeck.dealCard();
							break;
						}
						case "S": {
							while(cpuDeck.calCardSum()<17) {
								cpuDeck.dealCard();
							}
							cpuDeck.printAllCpuCard();
							playerDeck.printCard();
							if (cpuDeck.calCardSum()<22 && cpuDeck.calCardSum()>playerDeck.calCardSum()) {
								System.out.println("You Losed !");
								System.out.println("Your balance: "+this.getPlayer().getBalance());
								return 1;
							}else if(cpuDeck.calCardSum()>21) {
								System.out.println("Cpu busted! You win !");
								this.getPlayer().setBalance(this.getPlayer().getBalance()+betAccumunate*2);
								System.out.println("Your balance: "+this.getPlayer().getBalance());
								return 1;
							}else if(cpuDeck.calCardSum()==playerDeck.calCardSum()) {
								System.out.println("Draw!");
								return 1;
							}
							break;
						}
						default: System.out.println("Something wrong...");return 1;
					}
				}
			}
		}
		return 1;
	}
}

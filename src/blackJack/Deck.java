package blackJack;

import java.util.ArrayList;

public class Deck {
	
	private ArrayList<String> cards = new ArrayList<>();
	
	public ArrayList<String> getCards(){
		return this.cards;
	}
	
	public void dealCard() {
		switch ((int)(Math.random()*13)) {
			case 0 : cards.add("A"); break;
			case 1 : cards.add("2");break;
			case 2 : cards.add("3");break;
			case 3 : cards.add("4");break;
			case 4 : cards.add("5");break;
			case 5 : cards.add("6");break;
			case 6 : cards.add("7");break;
			case 7 : cards.add("8");break;
			case 8 : cards.add("9");break;
			case 9 : cards.add("10");break;
			case 10 : cards.add("J");break;
			case 11 : cards.add("Q");break;
			case 12 : cards.add("K");break;
			default : System.out.println("dealCard random wrong");			
		}
	}
	
	public void printCard() {
		System.out.print("Your Deck: ");
		for (int i = 0;i<this.getCards().size();i++) {
			System.out.print(this.getCards().get(i)+' ');
		}
		System.out.println(' ');
	}
	
	public void printCpuCard() {
		System.out.print("Cpu's Deck: ? ");
		for (int i = 1;i<this.getCards().size();i++) {
			System.out.print(this.getCards().get(i)+' ');
		}
		System.out.println(' ');
	}
	
	public void printAllCpuCard() {
		System.out.print("CPU's Deck: ");
		for (int i = 0;i<this.getCards().size();i++) {
			System.out.print(this.getCards().get(i)+' ');
		}
		System.out.println(' ');
	}
	
	public int calCardSum() {
		int sum = 0;
		int noOfA = 0;
		for (int i = 0;i<cards.size();i++) {
			if(cards.get(i)!="A" && cards.get(i)!="J" && cards.get(i)!="Q" && cards.get(i)!="K") {
 				sum +=Integer.parseInt(cards.get(i));
			}else if(cards.get(i)=="J"||cards.get(i)=="Q"||cards.get(i)=="K") {
				sum += 10;
			}else if (cards.get(i)=="A"){
				noOfA++;
			}
		}
		
		for(int i = 0;i<noOfA;i++) {
			if(sum>10) {
				sum++;
			}else {
				sum+=11;
			}
		}
		return sum;
	}
	
}

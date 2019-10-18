package blackJack;

import java.util.ArrayList;

public class Deck {
	
	private ArrayList<String> cards = new ArrayList<>();
	
	public void dealCard() {
		switch ((int)(Math.random()*13)) {
			case 0 : cards.add("A");
			case 1 : cards.add("2");
			case 2 : cards.add("3");
			case 3 : cards.add("4");
			case 4 : cards.add("5");
			case 5 : cards.add("6");
			case 6 : cards.add("7");
			case 7 : cards.add("8");
			case 8 : cards.add("9");
			case 9 : cards.add("10");
			case 10 : cards.add("J");
			case 11 : cards.add("Q");
			case 12 : cards.add("K");
			default : System.out.println("dealCard random wrong");			
		}
	}
	
	public int calCardSum() {
		int sum = 0;
		for (int i = 0;i<cards.size();i++) {
			if(cards.get(i)!="A" && cards.get(i)!="J" && cards.get(i)!="Q" && cards.get(i)!="K") {
				sum +=Integer.parseInt(cards.get(i));
			}else if(cards.get(i)=="J"||cards.get(i)=="Q"||cards.get(i)=="K") {
				sum += 10;
			}else{
				
			}
		}
		return sum;
	}
	
}

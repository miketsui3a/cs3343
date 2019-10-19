package blackJackTest;

import blackJack.BlackJack;
import blackJack.Player;

import static org.junit.Assert.assertEquals;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BlackJackTest {
	@Test
	public void test() {
		BlackJack bj = new BlackJack(new Player("M",10,0));
		bj.gameInit();
	}
}

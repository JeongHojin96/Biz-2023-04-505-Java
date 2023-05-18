package blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class test {
	
	
	public static void main(String[] args) {
		
		
		List<String> deck = new ArrayList<>();

		String[] suits = { "♠", "♥", "♦", "♣" };
		String[] ranks = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };

		for (String suit : suits) {
			for (String rank : ranks) {
				deck.add(suit + rank);
			}
		}
		System.out.println(deck);
		System.out.println(deck.toString());
	}
}


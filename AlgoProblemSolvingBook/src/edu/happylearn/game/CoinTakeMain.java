package edu.happylearn.game;

import java.util.Scanner;

/**
 * The winning strategy for choosing coin game.
 * 
 * @author hu.xu
 *
 */
public class CoinTakeMain {
	int totalNum = 40;
	
	public static void main(String[] args) {
		CoinTakeMain m = new CoinTakeMain();
		m.solve();
	}

	private void solve() {
		// A choose First.
		totalNum -= 4;
		System.out.println("A selected 4, now the total number: "+ totalNum);
		
		Scanner scan = new Scanner(System.in);
		while(totalNum >= 6){
			// B's turn.
			int numOfB = scan.nextInt();
			
			// check the value.
			if(!isValidValue(numOfB)){
				System.out.println("Please select number between 1 and 5");
				continue;
			}
			System.out.println("B selected "+ numOfB);
			totalNum -= numOfB;
			System.out.println("After B selected, current coin number: "+ totalNum);
			
			
			// Check game ending conditon. 
			if(totalNum <= 5){
				System.out.println("A selected "+totalNum +", A win!!!");
				break;
			}
			
			// A's turn.
			int numOfA = 6 - numOfB;
			totalNum -= numOfA;
			System.out.println("> A selected "+ numOfA);
			System.out.println("After A selected, current coin number: "+ totalNum);
		}
		scan.close();
	}

	/**
	 * Check whether the chosen number of coin meets the rule.
	 * @param numOfCoins
	 * @return
	 */
	private boolean isValidValue(int numOfCoins) {
		if(numOfCoins < 1 || numOfCoins > 5){
			return false;
		}
		return true;
	}

}

package edu.happylearn.game.array;

import java.util.Scanner;

/**
 * 문제 설명: 
 * 당신은 아래와 같은 조작을 할 수 있다. 
 * 배열에서 앞으로 한칸 (i+1), 뒤로 한칸(i-1), 그리고 주어진 leap만큼 앞으로 이동(i+leap).
 * 이 게임에서 이기는 방법은 두가지이다. 
 * 1. 배열의 제일 마지막 원소에 도착하였을 경우. ex) i== n-1인 경우.
 * 2. 현재 index가 이미 배열의 길이를 초과하였을 경우. ex) i>=n
 * 
 * 입력이 주어졌을 때, 당신이 게임에서 이기는 여부를 판단하라.
 * 
 * @author hu.xu
 *
 */
public class OneDArrayGame {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int q = scan.nextInt();
		for(int i=0; i<q; i++){
			int n = scan.nextInt();
			int leap = scan.nextInt();
			
			int[] game = new int[n];
			for(int k=0; k<game.length; k++){
				game[k] = scan.nextInt();
			}
			
			System.out.println((canWin(leap, game) ? "YES" : "NO"));
		}
		scan.close();
		
	}

	private static boolean canWin(int leap, int[] game) {
		return isSolvable(0, leap, game);
	}
	
	private static boolean isSolvable(int currentIndex, int leap, int[] game){
		if(currentIndex < 0 || game[currentIndex] == 1){
			return false;
		}
		
		if(currentIndex >= (game.length-1) || (currentIndex + leap) >= game.length){
			return true;
		}
		
		game[currentIndex] = 1;
		
		return (isSolvable(currentIndex+leap, leap, game) 
				|| isSolvable(currentIndex+1, leap, game) 
				|| isSolvable(currentIndex-1, leap, game));
	}

}

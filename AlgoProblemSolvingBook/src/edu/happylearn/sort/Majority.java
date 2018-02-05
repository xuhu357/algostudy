package edu.happylearn.sort;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/**
 * 과반수 원소 출력하기
 * @author hu.xu
 *
 */
public class Majority {
	Map<Integer, Integer> countMap;
	
	public Majority() {
		countMap = new HashMap<Integer, Integer>();
	}
	
	public static void main(String[] args) {
		Majority m = new Majority();
		m.solve();
	}

	private void solve() {
		boolean findAnswer = false;
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		
		for(int i=0; i<N; i++){
			int tempNum = scan.nextInt();
			if(countMap.containsKey(tempNum)){
				int temp =countMap.get(tempNum);
				countMap.put(tempNum, temp+1);
				if(2*(temp+1) > N){
					System.out.println("Majority is "+tempNum);
					findAnswer = true;
					break;
				}
			}else{
				countMap.put(tempNum, 1);
			}
		}
		scan.close();
		if(!findAnswer){
			System.out.println("No majority element");
		}
	}

}

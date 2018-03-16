package edu.happylearn.hackerrank.nestedlogic;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int aDay = scan.nextInt();
		int aMon = scan.nextInt();
		int aYear = scan.nextInt();
		
		int eDay = scan.nextInt();
		int eMon = scan.nextInt();
		int eYear = scan.nextInt();
		scan.close();
		
		int resultFine = 0;
		
		if(aYear > eYear){
			resultFine = 10000;
		}else if(aYear == eYear){
			if(aMon > eMon){
				resultFine = 500 * (aMon - eMon);
			}else if(aMon == eMon){
				if(aDay > eDay){
					resultFine = 15 * (aDay - eDay);
				}
			}
		}
		
		System.out.println(resultFine);
		
		
		
		
	}

}

package edu.happylearn.hackerrank.testcasemaking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		ArrayList<String> nameList = new ArrayList<String>();
		Scanner scan = new Scanner(System.in);
		int testcase = scan.nextInt();
		for(int i=0; i<testcase; i++){
			String tempname = scan.next();
			String tempemail = scan.next();
			
			if(tempemail.endsWith("@gmail.com")){
				nameList.add(tempname);
			}
			
		}
		scan.close();
		
		Collections.sort(nameList);
		for (String name : nameList) {
			System.out.println(name);
		}
		
	}

}

package edu.happpylearn.subset;

import java.util.Scanner;

/**
 * 부분집합 나열하는 문제 
 * @author hu.xu
 *
 */
public class SubSetMain {

	int set[];
	
	public static void main(String[] args) {
		SubSetMain m = new SubSetMain();
		m.solve();
	}

	private void solve() {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		set = new int[N];
		scan.close();
		
		subSet(set, 0, N, 0);
		
	}

	private void subSet(int[] set, int setSize, int length, int idx) {
		if(idx == length){
			printData(set, setSize);
			return;
		}
		
		set[setSize] = idx;
		subSet(set, setSize+1, length, idx+1); // case idx is included in set
		subSet(set, setSize, length, idx+1);	// case idx is not included in set.
	}

	private void printData(int[] set2, int setSize) {
		for(int i=0; i<setSize; i++){
			System.out.print(set2[i] + " ");
		}
		System.out.println();
	}

	


}

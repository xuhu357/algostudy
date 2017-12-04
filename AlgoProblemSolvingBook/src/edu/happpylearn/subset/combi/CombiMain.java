package edu.happpylearn.subset.combi;

import java.util.Scanner;

/**
 * n과 k를 입력받아 값이 1인 비트가 k개인 길이가 n인 이진수를 출력하는 프로그램.
 * @author hu.xu
 */
public class CombiMain {
	
	int set[];
	int data[];
	int N;
	int M;
	
	public static void main(String[] args) {
		CombiMain m = new CombiMain();
		m.solve();
	}

	private void solve() {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		M = scan.nextInt();
		scan.close();
		
		set = new int[N];
		data = new int[N];
		
		combi(set, 0, N, M, 0);
	}

	private void combi(int set[], int setSize, int n, int m, int index){
		if(m == 0){
			printData(set, setSize, n);
		}else if(index == n){
			return;
		}else{
			set[setSize] = index;
			combi(set, setSize+1, n, m-1, index+1); // when selected
			combi(set, setSize, n, m, index+1);		// when not selected.
		}
	}

	private void printData(int[] set, int setSize, int length) {
		for(int i=0; i<length; i++){
			data[i] = 1;
		}
		
		for(int i=0; i<setSize; i++){
			data[set[i]] = 0;
		}
		
		for(int i=0; i<length; i++){
			System.out.print(data[i] + " ");
		}
		System.out.println();
	}

}

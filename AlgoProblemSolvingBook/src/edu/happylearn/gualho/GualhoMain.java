package edu.happylearn.gualho;

import java.util.Scanner;

/**
 * 올바른 괄호쌍 출력하기, 
 * ver1: 배열로 index를 저장
 * @author hu.xu
 *
 */
public class GualhoMain {
	int N;
	int toOpen;
	int toClose;
	int set[];
	int LEFT = 1;
	int RIGHT =2;
	
	public static void main(String[] args) {
		GualhoMain m = new GualhoMain();
		m.solve();
	}

	private void solve() {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		toOpen = toClose = N;
		scan.close();
		int setLength = 2 * N;
		set = new int[setLength];
		getSolution(set, 0, setLength, N, N, 0);
		
	}
	
	// after select, should be toOpen <= toClose
	private void getSolution(int set[], int setSize, int n, int toOpen, int toClose, int index){
		if(toOpen > toClose){
			return;
		}
		
		if(toOpen == 0 && toClose == 0){
			printData(set, setSize, n);
		}else if(index == n){
			return;
		}else{
			// when open selected.
			set[setSize] = index;
			getSolution(set, setSize+1, n, toOpen-1, toClose, index+1);
			
			// when open is not selected.
			getSolution(set, setSize, n, toOpen, toClose-1, index+1);
			
		}
		
	}

	private void printData(int[] set, int setSize, int n) {
		int arr[] = new int[n];
		
		for(int i=0; i<setSize; i++){
			arr[set[i]] = 1;
		}
		
		for(int i=0; i<n; i++){
			if(arr[i] == 1){
				System.out.print("(");
			}else{
				System.out.print(")");
			}
		}
		System.out.println();
		
	}

}

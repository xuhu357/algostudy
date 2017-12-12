package edu.happylearn.permutation;

import java.util.Scanner;

/**
 * n개의 숫자에서 k개를 중복가능한 순열 나열하기, 배열 버전 
 * @author hu.xu
 *
 */

public class RepeatPermutationMain {
	int n;
	int k;
	int arr[];
	
	public static void main(String[] args) {
		RepeatPermutationMain m = new RepeatPermutationMain();
		m.solve();
	}

	private void solve() {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		k = scan.nextInt();
		arr = new int[n];
		scan.close();
		
		repeatablePermutation(arr, n, k, 0);
	}

	private void repeatablePermutation(int[] arr, int n, int k, int len) {
		if(len == k){
			printData(arr, len);
			return;
		}
		for(int i=0; i<n; i++){
			arr[len] = i;
			repeatablePermutation(arr, n, k, len+1);
		}
	}

	private void printData(int[] arr, int len) {
		for(int i=0; i<len; i++){
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

}

package edu.happylearn.sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Implementation of Insertion Sort, ver 1.
 * 
 * @author hu.xu
 *
 */
public class InsertionSort {
	int arr[];
	
	public static void main(String[] args) {
		InsertionSort m = new InsertionSort();
		m.solve();
	}

	private void solve() {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		arr = new int[N];
		System.out.print("Before Sort: ");
		for(int last=0; last<N; last++){
			int tmpNum = scan.nextInt();
			System.out.print(tmpNum + ", ");
			insertionSort(arr, last, tmpNum);
		}
		System.out.println("\nAfter Insertion Sort: "+ Arrays.toString(arr));
		scan.close();
	}

	private void insertionSort(int[] arr, int last, int tmpNum) {
		int temp = arr[last] = tmpNum;
		int i;
		for(i=last; i>0 && arr[i-1] > temp; i--){
			arr[i] = arr[i-1];
		}
		
		arr[i] = temp;
	}

}

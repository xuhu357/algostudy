package edu.happylearn.sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * QuickSort algorithm
 * @author hu.xu
 *
 */
public class QuickSort {
	int arr[];
	
	public static void main(String[] args) {
		QuickSort m = new QuickSort();
		m.solve();
	}

	private void solve() {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		arr = new int[N];
		for(int i=0; i<N; i++){
			arr[i] = scan.nextInt();
		}
		scan.close();
		
		quickSort(arr, 0, N);
		System.out.println(Arrays.toString(arr));
	}

	private void quickSort(int[] arr, int start, int end) {
		if(start > end){
			return;
		}
		
		int p = partition(arr, start, end);
		quickSort(arr, start, p-1);
		quickSort(arr, p+1, end);
	}

	private int partition(int[] arr, int start, int end) {
		
		if(start == end){
			return start;
		}
		
		int base = arr[start];
		int p = start;
		for(int i=start+1; i<end; i++){
			if(arr[i] < base){
				p++;
				int temp = arr[p];
				arr[p] = arr[i];
				arr[i] = temp;
			}
		}
		
		arr[start] = arr[p];
		arr[p] = base;
		return p;
	}

}

package edu.happylearn.maxsubarray;
import java.util.Scanner;
/**
 * input data are as follows:
 16
 13 –3 –25 20 –3 –16 –23 18 20 –7 12 –5 –22 15 –4 7
 * @author hu.xu
 *
 */
public class MaximumSubArrayMain {
	
	int arr[];
	
	
	public static void main(String[] args) {
		MaximumSubArrayMain m = new MaximumSubArrayMain();
		m.solve();
	}

	private void solve() {
		// input data
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		arr = new int[N];
		for(int i=0; i<N; i++){
			arr[i] = scan.nextInt();
		}
		scan.close();
		
		int result = getMaximumSubArray(arr, 0, N-1);
		System.out.println("Maximum SubArray Sum is: "+result);
		
	}

	private int getMaximumSubArray(int[] arr, int low, int high) {
		// base case
		if(low == high){
			return arr[low];
		}
		
		int mid = (low + high)/2;
		int resLeft = getMaximumSubArray(arr, low, mid);
		int resRight = getMaximumSubArray(arr, mid+1, high);
		int resCross = getMaximumCrossArray(arr, low, mid, high);
		
		if(resLeft >= resRight && resLeft >= resCross){
			return resLeft;
		}else if(resRight >= resLeft && resRight >= resCross){
			return resRight;
		}else{
			return resCross;
		}
	}

	private int getMaximumCrossArray(int[] arr, int low, int mid, int high) {
		int sumLeft = Integer.MIN_VALUE;
//		int idxLeft = mid;
//		int idxRight = mid+1;
		
		int sum = 0;
		for(int i=mid; i>=low; i--){
			sum += arr[i];
			if(sum > sumLeft){
				sumLeft = sum;
//				idxLeft = i;
			}
		}
		
		int sumRight = Integer.MIN_VALUE;
		sum = 0;
		for(int i=mid+1; i<=high; i++){
			sum += arr[i];
			if(sum > sumRight){
				sumRight = sum;
//				idxRight = i;
			}
		}
		
		return max(sumLeft, sumRight, sumLeft+sumRight);
	}

	private int max(int a, int b, int c) {
		if(a>=b && a>=c){
			return a;
		}else if(b>=a && b>=c){
			return b;
		}else{
			return c;
		}
	}

}

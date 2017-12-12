package edu.happylearn.subset.choose;

import java.util.Scanner;

/**
 * 중복 가능한 조합 출력하기
 * @author hu.xu
 *
 */
public class ChooseMain {
	int set[];
	
	public static void main(String[] args) {
		ChooseMain m = new ChooseMain();
		m.solve();
	}

	private void solve() {
		// Get the input from standard input.
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		scan.close();
		
		set = new int[n];
		
		chooseAndPrintNum(set, 0, n, m, 0); // c(n,m) = c(n-1,m-1) + c(n-1, m)
		
	}
	
	public void chooseAndPrintNum(int set[], int setSize, int n, int m, int index){
		if(m == 0){ 			// no need to choose any more.
			printData(set, setSize);
		}else if(index == n){	// already hover all the element
			return;
		}else{					// set still not full
			chooseAndPrintNum(set, setSize, n, m, index+1);	// when element not selected.
			
			/** 중복가능 조합 ? index : index+1 */
			set[setSize] = index;
			chooseAndPrintNum(set, setSize+1, n, m-1, index); // when element selected.
			
		}
		
	}

	private void printData(int[] set, int setSize) {
		for(int i=0; i<setSize; i++){
			System.out.print(set[i] + " ");
		}
		System.out.println();
	}

}

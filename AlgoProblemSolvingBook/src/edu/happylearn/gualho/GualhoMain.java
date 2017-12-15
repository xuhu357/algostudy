package edu.happylearn.gualho;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

/**
 * 올바른 괄호쌍 출력하기, 
 * ver2: Stack을 이용한 버전
 * @author hu.xu
 *
 */
public class GualhoMain {
	int N;
	int toOpen;
	int toClose;
	Stack<Integer> stack;
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
		stack = new Stack<>();
		getSolution(stack, 0, setLength, N, N, 0);
		
	}
	
	// after select, should be toOpen <= toClose
	private void getSolution(Stack<Integer> stack, int setSize, int n, int toOpen, int toClose, int index){
		if(toOpen > toClose){
			return;
		}
		
		if(toOpen == 0 && toClose == 0){
			printData(stack, setSize, n);
		}else if(index == n){
			return;
		}else{
			// when open selected.
			stack.push(index);
			getSolution(stack, setSize+1, n, toOpen-1, toClose, index+1);
			
			// when open is not selected.
			stack.pop();
			getSolution(stack, setSize, n, toOpen, toClose-1, index+1);
		}
	}

	private void printData(Stack<Integer> stack, int setSize, int n) {
		int arr[] = new int[n];
		
		Iterator<Integer> iter = stack.iterator();
		while(iter.hasNext()){
			arr[iter.next()] = 1;
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

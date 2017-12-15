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
	Stack<String> stack;
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
		getSolution(stack, setLength, N, N, 0);
		
	}
	
	// after select, should be toOpen <= toClose
	private void getSolution(Stack<String> stack, int n, int toOpen, int toClose, int index){
		if(toOpen > toClose){
			return;
		}
		
		if(toOpen == 0 && toClose == 0){
			printData(stack);
		}else if(index == n){
			return;
		}else{
			// when open selected.
			stack.push("(");
			getSolution(stack, n, toOpen-1, toClose, index+1);
			stack.pop();
			
			// when open is not selected.
			stack.push(")");
			getSolution(stack, n, toOpen, toClose-1, index+1);
			stack.pop();
		}
	}

	private void printData(Stack<String> stack) {
		Iterator<String> iter = stack.iterator();
		while(iter.hasNext()){
			System.out.print(iter.next());
		}
		
		System.out.println();
		
	}

}

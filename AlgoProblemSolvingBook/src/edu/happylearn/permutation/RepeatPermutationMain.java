package edu.happylearn.permutation;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

/**
 * n개의 문자열을 입력받고 그 중에서 k개를 중복 불가 순열 나열하기, Stack 버전
 * @author hu.xu
 *
 */

public class RepeatPermutationMain {
	int n;
	int k;
	Stack<Integer> numStack;
	String strArr[];
	
	public static void main(String[] args) {
		RepeatPermutationMain m = new RepeatPermutationMain();
		m.solve();
	}

	private void solve() {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		k = scan.nextInt();
		numStack = new Stack<>();
		strArr = new String[n];
		for(int i=0; i<n; i++){
			strArr[i] = scan.next();
		}
		scan.close();
		
		repeatablePermutation(numStack, n, k, 0);
	}

	private void repeatablePermutation(Stack<Integer> numStack, int n, int k, int len) {
		if(len == k){
			printData(numStack, len);
			return;
		}
		for(int index=0; index<n; index++){
			if(numStack.contains(index)){
				continue;
			}
			numStack.push(index);
			repeatablePermutation(numStack, n, k, len+1);
			numStack.pop();
		}
	}

	private void printData(Stack<Integer> numStack, int len) {
		Iterator<Integer> iter = numStack.iterator();
		while(iter.hasNext()){
			System.out.print(strArr[iter.next()]+" ");
		}
		System.out.println();
	}

}

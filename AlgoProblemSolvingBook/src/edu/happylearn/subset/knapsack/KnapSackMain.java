package edu.happylearn.subset.knapsack;

import java.util.Scanner;

/**
 * KnapSack 문제풀기
 * @author hu.xu
 */
public class KnapSackMain {
	
	int weight[];	// real weight
	int value[];	// real value
	int maxWeight;
	int set[]; // set for saving element index
	
	int maxValue;
	int maxSet[];
	int maxSetSize;
	
	public static void main(String[] args) {
		KnapSackMain m = new KnapSackMain();
		m.solve();
	}

	private void solve() {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		maxWeight = scan.nextInt();
		
		weight = new int[N];
		value = new int[N];
		set = new int[N];
		maxSet = new int[N];
		
		for(int i=0; i<N; i++){
			value[i] = scan.nextInt();
		}
		
		for(int i=0; i<N; i++){
			weight[i] = scan.nextInt();
		}
		scan.close();
		
		subsetKnapSack(set, 0, N, 0);
		
		System.out.println("Max Value: " + maxValue);
		printData(maxSet, maxSetSize);
	}
	
	private void printData(int[] set2, int setSize) {
		for(int i=0; i<setSize; i++){
			System.out.print(set2[i] + " ");
		}
		System.out.println();
	}

	private void subsetKnapSack(int set[], int setSize, int length, int index){
		if(index == length){
			evaluateKnapSack(set, setSize);
			return;
		}
		
		set[setSize] = index;
		
		subsetKnapSack(set, setSize+1, length, index+1);
		subsetKnapSack(set, setSize, length, index+1);
	}

	private void evaluateKnapSack(int[] set, int setSize) {
		int currWeight = 0;
		int currValue = 0;
		
		for(int i=0; i<setSize; i++){
			currWeight += weight[set[i]];
			currValue += value[set[i]];
		}
		
		if(currWeight > maxWeight){
			return;
		}
		
		if(currValue > maxValue){
			maxValue = currValue;
			maxSetSize = setSize;
			
			for(int i=0; i<setSize; i++){
				maxSet[i] = set[i];
			}
		}
		
	}

}

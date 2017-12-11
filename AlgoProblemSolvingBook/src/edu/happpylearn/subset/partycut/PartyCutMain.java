package edu.happpylearn.subset.partycut;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 문제: 연회장 나누기
 * 설명: 친한 친구들끼리 앉는 문제. 그룹간에 연결선을 cut라고 하고, cut가 제일 적은 것을 찾는 문제
 * @author hu.xu
 *
 */
public class PartyCutMain {
	int N;
	int friends[][];
	int set[];
	int minSet[];
	int minCut = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		PartyCutMain m = new PartyCutMain();
		m.solve();
	}

	private void solve() {
		// Get input and make friends
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		friends = new int[N][N];
		set = new int[N];
		minSet = new int[N];
		for(int i=0; i<N; i++){
			int num = scan.nextInt();
			for(int j=0; j<num; j++){
				int f = scan.nextInt();
				friends[i][f] = 1;
			}
		}
		scan.close();
		
		// find min cut
		findMinCut(set, 0, N, N/2, 0);
		
//		 print the final result mincut and min set
		System.out.println("Min Cut: "+minCut);
		for(int i=0; i<N; i++){
			System.out.print(minSet[i] + " ");
		}
		System.out.println();
		
	}

	private void findMinCut(int[] set, int setSize, int n, int m, int index) {
		if(m == 0){
			evaluateCut(set, setSize, n);
		}else if(index == n){
			return;
		}else{
			// Point!!! when no element was selected
			findMinCut(set, setSize, n, m, index+1);		
			
			// Point!!! when index was selected. so put index to set[setSize]
			set[setSize] = index;
			findMinCut(set, setSize+1, n, m-1, index+1);
		}  
	}

	private void evaluateCut(int[] set, int setSize, int n) {
		//other group member
		ArrayList<Integer> group1 = new ArrayList<Integer>();
		for(int i=0; i<setSize; i++){
			group1.add(set[i]);
		}
		
		ArrayList<Integer> group2 = new ArrayList<Integer>();
		for(int i=0; i<n; i++){
			if(!group1.contains(i)){
				group2.add(i);
			}
		}
		
		int cut = 0;
		for(int i=0; i<group1.size(); i++){
			for(int j=0; j<group2.size(); j++){
				int src = group1.get(i);
				int dest = group2.get(j);
				if(friends[src][dest] == 1 || friends[dest][src] == 1){
					cut++;
				}
			}
		}
		
		for(int i=0; i<setSize; i++){
			System.out.print(set[i]+ " ");
		}
		System.out.println("cut: " + cut);
		
		if(cut < minCut){
			minCut = cut;
			
			for(int i=0; i<n; i++){
				minSet[i] = 0;
			}
			
			for(int i= 0; i<setSize; i++){
				minSet[set[i]] = 1;
			}
		}
	}

}

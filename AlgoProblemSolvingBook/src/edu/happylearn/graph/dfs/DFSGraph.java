package edu.happylearn.graph.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class DFSGraph {
	Map<Integer, List<Integer>> adjMap;
	private int nodeNum;
	private int edgeNum;
	private boolean[] visited;
	
	public DFSGraph() {
		adjMap = new HashMap<>();
	}
	
	public void solve(){
		Scanner scan = new Scanner(System.in);
		nodeNum = scan.nextInt();
		edgeNum = scan.nextInt();
		
		for(int i=0; i<edgeNum; i++){
			int src = scan.nextInt();
			int dest = scan.nextInt();
			addEdge(src, dest);
		}
		
		scan.close();
		
		visited = new boolean[nodeNum];
		
		dfs(2);
	}

	private void dfs(int here) {
		System.out.print(here+" ");
		visited[here] = true;
		List<Integer> adjNodes = adjMap.get(here);
		for (Integer nextNode : adjNodes) {
			if(visited[nextNode] == false){
				dfs(nextNode);
			}
		}
		
	}

	private void addEdge(int src, int dest) {
		List<Integer> adjNodeList = adjMap.get(src);
		if(adjNodeList == null){
			adjNodeList = new ArrayList<>();
		}
		adjNodeList.add(dest);
		adjMap.put(src, adjNodeList);
	}
	
	public static void main(String[] args) {
		DFSGraph m = new DFSGraph();
		m.solve();
	}
	
}

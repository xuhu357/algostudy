package edu.happylearn.graph.bfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class BFSGraph {
	
	private int nodeNum;
	private int edgeNum;
	private Map<Integer, List<Integer>> adjMap;
	private boolean visited[];
	private Queue<Integer> queue;
	
	public BFSGraph() {
		adjMap = new HashMap<>();
		queue = new LinkedList<>();
	}
	
	private void addEdge(int src, int dest){
		List<Integer> adjNodeList = adjMap.get(src);
		if(adjNodeList == null){
			adjNodeList = new ArrayList<>();
		}
		adjNodeList.add(dest);
		adjMap.put(src, adjNodeList);
	}
	
	private void solve(){
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
		
		bfs(2);
		
	}
	
	private void bfs(int start){
		
		// put here into queue
		queue.offer(start);
		System.out.print("Start: "+start+ " ");
		
		while(!queue.isEmpty()){
			int currNode = queue.poll();
			visited[currNode] = true;
			
			List<Integer> adjNodes = adjMap.get(currNode);
			for (Integer adjNode : adjNodes) {
				if(!queue.contains(adjNode) && !visited[adjNode]){
					queue.offer(adjNode);		// offer it into queue
					visited[adjNode] = true; 	// mark as visited
					System.out.print(adjNode+" ");
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		BFSGraph m = new BFSGraph();
		m.solve();
	}
	

}

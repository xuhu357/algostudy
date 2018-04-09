package edu.happylearn.shortestpath;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Graph {
	
	Set<Node> graphNodes;
	PriorityQueue<NodeInfo> priQueue;
	Map<String, Integer> mapMinPath;
	
	
	public Graph() {
		this.graphNodes = new HashSet<>();
		priQueue = new PriorityQueue<>();
		mapMinPath = new HashMap<>();
	}
	
	public void addNodeToGraph(Node node){
		this.graphNodes.add(node);
	}

	public void calcShortestPath(Node startNode) {
		priQueue.add(new NodeInfo(startNode, 0)); // add start node to priority queue
		checkAndUpdateShortestPathInfo(startNode, 0);
		
		while(priQueue.size() > 0){
			NodeInfo temp = priQueue.poll();
			
			Node currentNode = temp.node;
			int cost = temp.cost;
			
			for(Map.Entry<Node, Integer> neighbor : currentNode.getDestintionNodes().entrySet()){
				Node thereNode = neighbor.getKey();
				int thereCost = neighbor.getValue();
				
				if(mapMinPath.get(thereNode.getName())!= null){
					if((cost + thereCost) > mapMinPath.get(thereNode.getName())){
						continue;
					}
				}
				
				priQueue.offer(new NodeInfo(thereNode, cost+thereCost));
				checkAndUpdateShortestPathInfo(thereNode, cost+thereCost);
			}
		}
	}
	
	public void printResult(){
		System.out.println("=== Print Result ===");
		for (Map.Entry<String, Integer> node : mapMinPath.entrySet()) {
			System.out.println("Node: "+ node.getKey()+", ShortestPath: "+node.getValue());
		}
	}
	

	private void checkAndUpdateShortestPathInfo(Node currentNode, int currentCost) {
		if(mapMinPath.get(currentNode.getName()) == null){
			mapMinPath.put(currentNode.getName(), currentCost);
		}else{
			int savedCost = mapMinPath.get(currentNode.getName());
			if(savedCost > currentCost){
				mapMinPath.put(currentNode.getName(), currentCost);
			} 
		}
	}

}

package edu.happylearn.shortestpath;

import java.util.HashMap;
import java.util.Map;

public class Node {
	
	private String name;
	private Map<Node, Integer> destintionNodes; // key: destination node, value: weight
	boolean visited;
	
	public Node(String name) {
		this.name = name;
		this.destintionNodes = new HashMap<Node, Integer>();
		this.visited = false;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<Node, Integer> getDestintionNodes() {
		return destintionNodes;
	}

	public void setDestintionNodes(Map<Node, Integer> destintionNodes) {
		this.destintionNodes = destintionNodes;
	}

	public void addDestination(Node nodeB, int weight) {
		this.destintionNodes.put(nodeB, weight);
	}

}

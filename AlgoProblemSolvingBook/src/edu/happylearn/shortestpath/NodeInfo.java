package edu.happylearn.shortestpath;

public class NodeInfo implements Comparable<NodeInfo>{
	
	Node node;
	int cost;
	
	public NodeInfo(Node node, int cost) {
		this.node = node;
		this.cost = cost;
	}

	@Override
	public int compareTo(NodeInfo other) {
		return this.cost - other.cost;
	}

}

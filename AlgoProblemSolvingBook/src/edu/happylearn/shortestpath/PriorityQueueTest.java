package edu.happylearn.shortestpath;

import java.util.PriorityQueue;

public class PriorityQueueTest {
	
	public static void main(String[] args) {
		PriorityQueue<NodeInfo> queue = new PriorityQueue<>();
		queue.offer(new NodeInfo(new Node("bbb"), 10));
		queue.offer(new NodeInfo(new Node("ccc"), 1));
		queue.offer(new NodeInfo(new Node("ddd"), 5));
		
		while(queue.size() > 0){
			NodeInfo temp = queue.poll();
			
			System.out.println(temp.node.getName()+", weight: "+temp.cost);
		}
	}

}

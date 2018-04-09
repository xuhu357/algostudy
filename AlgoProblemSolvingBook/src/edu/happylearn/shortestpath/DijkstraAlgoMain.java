package edu.happylearn.shortestpath;

public class DijkstraAlgoMain {
	
	public static void main(String[] args) {
		Node nodeA = new Node("a");
		Node nodeB = new Node("b");
		Node nodeC = new Node("c");
		Node nodeD = new Node("d"); 
		Node nodeE = new Node("e");
		Node nodeF = new Node("f");
		Node nodeG = new Node("g");
		 
		nodeA.addDestination(nodeB, 5);
		nodeA.addDestination(nodeC, 1);
		 
		nodeB.addDestination(nodeA, 5);
		nodeB.addDestination(nodeD, 1);
		nodeB.addDestination(nodeG, 3);
		nodeB.addDestination(nodeF, 3);
		 
		nodeC.addDestination(nodeA, 1);
		nodeC.addDestination(nodeD, 2);
		
		 
		nodeD.addDestination(nodeC, 2);
		nodeD.addDestination(nodeB, 1);
		nodeD.addDestination(nodeE, 5);
		nodeD.addDestination(nodeF, 3);
		 
		nodeE.addDestination(nodeD, 5);
		
		nodeF.addDestination(nodeB, 3);
		nodeF.addDestination(nodeG, 2);
		nodeF.addDestination(nodeD, 3);
		
		nodeG.addDestination(nodeB, 3);
		nodeG.addDestination(nodeF, 2);
		
		Graph graph = new Graph();
		graph.addNodeToGraph(nodeA);
		graph.addNodeToGraph(nodeB);
		graph.addNodeToGraph(nodeC);
		graph.addNodeToGraph(nodeD);
		graph.addNodeToGraph(nodeE);
		graph.addNodeToGraph(nodeF);
		graph.addNodeToGraph(nodeG);
		
		graph.calcShortestPath(nodeA);
		graph.printResult();
	}

}

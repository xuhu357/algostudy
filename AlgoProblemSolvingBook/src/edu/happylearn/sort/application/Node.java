package edu.happylearn.sort.application;

public class Node {
	int index;
	char ch;
	
	public Node(int index, char ch) {
		this.index = index;
		this.ch = ch;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		boolean sameSame = false;

        if (obj != null && obj instanceof Node)
        {
            sameSame = this.ch == ((Node) obj).ch;
        }

        return sameSame;
	}

}

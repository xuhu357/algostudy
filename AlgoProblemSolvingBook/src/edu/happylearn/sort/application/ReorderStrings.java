package edu.happylearn.sort.application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

/**
 * s1: "operate"
 * s2: "progam"
 * Task: reorder string s1 using the order of s2
 * The result should be: proaeet
 * @author xuhu
 *
 */
public class ReorderStrings {
	
	public static void main(String[] args) {
		String s1 = "operate";
		String s2 = "progam";
		
		String result = getReorderedString(s1, s2);
		System.out.println(result);
	}

	private static String getReorderedString(String s1, String s2) {
		StringBuilder sb1 = new StringBuilder(s1);
		StringBuilder sb2 = new StringBuilder(s2);
		
		
		ArrayList<Node> nodeList = new ArrayList<Node>();
		ArrayList<Node> otherList = new ArrayList<Node>();
		HashMap<Character, Integer> dict = new HashMap<>();
		for(int i=0; i<sb2.length(); i++){
			dict.put(sb2.charAt(i), i);
		}
		
		int pivot = sb2.length()+1;
		
		for(int i=0; i<sb1.length(); i++){
			if(dict.get(sb1.charAt(i)) == null){
				Node temp = new Node(pivot, sb1.charAt(i));
				otherList.add(temp);
				pivot++;
			}else{
				nodeList.add(new Node(dict.get(sb1.charAt(i)), sb1.charAt(i)));
			}
		}
		
		Collections.sort(nodeList, new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				return o1.index - o2.index;
			}
			
		});
		
		Collections.sort(otherList, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o1.ch - o2.ch;
			}
			
		});
		
		nodeList.addAll(otherList);
		String result="";
		for(int i=0; i<nodeList.size(); i++){
			result += nodeList.get(i).ch+"";
		}
		
		return result;
	}
	
	

}

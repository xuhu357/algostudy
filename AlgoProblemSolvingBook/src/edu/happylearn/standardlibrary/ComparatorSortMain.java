package edu.happylearn.standardlibrary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ComparatorSortMain {
	
	public static void main(String[] args) {
		ArrayList<Student> stuList = new ArrayList<>();
		stuList.add(new Student("bbb", 10));
		stuList.add(new Student("aaa", 30));
		stuList.add(new Student("ccc", 20));
		
		System.out.println(stuList.toString());
		
		Collections.sort(stuList, new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				return o2.name.compareTo(o1.name);
			}
		});
		
		System.out.print(stuList.toString());
	}

}

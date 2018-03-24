package edu.happylearn.standardlibrary;

import java.util.ArrayList;
import java.util.Collections;

public class ComparableInnerMain {
	
	class StudentInner implements Comparable<StudentInner>{
		String name;
		int age;
		
		public StudentInner(String name, int age){
			this.name = name;
			this.age = age;
		}

		@Override
		public int compareTo(StudentInner o) {
			return (age - o.age);
		}
		
		@Override
		public String toString() {
			return "("+name+", "+age+")";
		}
	}

	public static void main(String[] args) {
		/* For normal case, student class is outside this class.
		ArrayList<Student1> stuList = new ArrayList<Student1>();
		stuList.add(new Student1("suhho", 32));
		stuList.add(new Student1("kimjin", 35));
		stuList.add(new Student1("kimsujin", 30));
		
		Collections.sort(stuList);
		System.out.println(stuList.toString());
		*/
		
		/* For inner class in the nested in this class. */
		ComparableInnerMain m = new ComparableInnerMain();
		ArrayList<StudentInner> arrList = new ArrayList<>();
		arrList.add(m.new StudentInner("a", 10));
		arrList.add(m.new StudentInner("b", 5));
		arrList.add(m.new StudentInner("c", 8));
		
		System.out.println("Before Sorting: "+ arrList.toString());
		
		Collections.sort(arrList);
		System.out.println(arrList.toString());
		// after reverse
		Collections.reverse(arrList);
		System.out.println("After Reverse: " + arrList.toString());
	}

}

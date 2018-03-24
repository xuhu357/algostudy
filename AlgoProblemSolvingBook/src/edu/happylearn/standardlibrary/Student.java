package edu.happylearn.standardlibrary;

public class Student implements Comparable<Student>{
	String name;
	int age;
	
	public Student(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "["+name+", "+age+"]";
	}

	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		return name.compareTo(o.name);
	}
	
	

}

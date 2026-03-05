package com.daw;


public class Main {

	public static void main(String[] args) {
		
		Lista l1 = new Lista(6);
		Lista l2 = new Lista(4);
		
		l1.add(1);
		l1.add(2);
		l1.add(3);
		
		l2.add(45);
		l2.add(50);
		
		 l1.add(l2);
		 
		 System.out.println(l1);
		 System.out.println(l2);
		 l2.add(l1);
		 
		 System.out.println(l2);
		 
		 System.out.println(l2.indexOf(50));
		 
		 // l2.remove(3);
		 l2.add(55);
		 l2.addFirst(10);
		 System.out.println(l2);
		 l2.add(3, 60);
		 System.out.println(l2);
		 System.out.println(l2.get(4));
		 

	}

}

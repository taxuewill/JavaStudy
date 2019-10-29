package com.will.java;

public class MainTest {
	
	public static void main(String[] args) {
		System.out.println("Hello,Java!");
		Thread t = new Thread(()->{
			System.out.println("I'm a new thread");
		});
	}

}

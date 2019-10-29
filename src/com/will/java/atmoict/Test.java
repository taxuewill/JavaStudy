package com.will.java.atmoict;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

class BarWorker implements Runnable{
	
	private static AtomicBoolean exists = new AtomicBoolean(false);
	
	private String name;
	
	public BarWorker(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		if(exists.compareAndSet(false, true)) {
			System.out.println(name+"enter");
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}else {
			System.out.println(name+" give up");
		}
		
		
	}
	
}

public class Test {
	public static void main(String[] args) {
		BarWorker bar1 = new BarWorker("bar1");
		BarWorker bar2 = new BarWorker("bar2");
		new Thread(bar1).start();
		new Thread(bar2).start();
	}
}

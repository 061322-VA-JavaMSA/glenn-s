package com.revature.memory;

public class GarbageDriver {
	
	public int id;
	
	public GarbageDriver(int id) {
		this.id = id;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// if you print out it 
		for(int i = 0; i < 1000; i++ ) {
			new GarbageDriver(i);
			
			//gc() method runs the garbage collector.
			System.gc();
		}
	}
    
	// this is called before the garbage collection for a particular object.
	@Override
	protected void finalize() {
		System.out.println("id: " + id + " has been garbage collected");
	}
	
}

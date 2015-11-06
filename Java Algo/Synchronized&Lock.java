public class MyClass extends Thread {
	private String name;
	private MyObject myObj;

	public MyClass(MyObject obj, String n) {
		name = n;
		myObj = obj;
	}

	public void run() {
		myObj.foo(name);
	}
}

public class MyObject {
	public synchronized void foo(String name) {
		try {
			System.out.println("Thread " + name + ".foo(): starting");
			Thread.sleep(3000);
			System.out.println("Thread " + name + ".foo(): ending");
		} catch(InterruptedException exc) {
			System.out.println("Thread " + name + ": interrupted.");
		}
	}
}

/* Difference references - both threads can call MyObject foo() */
MyObject obj1 = new MyObject();
MyObject obj2 = new MyObject();
MyClass thread1 = new MyClass(Obj1, "1");
MyClass thread2 = new MyClass(Obj2, "2");
thread1.start();
thread2.start();

/* Same reference to obj. Only one will be allowed to call foo, and the other will be forced to wait. */
MyObject obj = new MyObject();
MyClass thread1 = new MyClass(obj, "1");
MyClass thread2 = new MyClass(obj, "2");
thread1.start();
thread2.start();

/* Static methods synchronize on the class /oc/c.The two threads above could not simulta- neously execute synchronized static methods on the same class, even if one is calling fooandtheother iscallingbar. */
public class MyClass extends Thread {
	...
	public void run() {
		if(name.equals("1")) MyObject.foo(name);
		else if(name.equals("2")) MyObject.bar(name);
	}
}

public class MyObject {
	public static synchronized void foo() {}
	public static synchronized void bar() {}
}
Thread1.foo(): starting
Thread1.foo(): ending
Thread2.bar(): starting
Thread2.bar(): ending

/*Synchronized Blocks: This operates very similarly to synchronizing a method.*/
public void foo(Stirng name) {
	synchronized(this) {
		...
	}
}

/** . A lock (or monitor) is used to synchro- nize access to a sharedresource by associating the resource with the lock. A thread gets access to a shared resource by first acquiring the lock associated with the resource.At any given time, at most one thread can hold the lockand, therefore, only one thread can access the shared resource.
* A common use case for locks is when a resource is accessed from multiple places, but should be only accessed by one thread at a time.
* Using a lock will help protect a shared resource from being modified in unexpected ways.
*/
public class LockedATM {
	private Lock lock;
	private int balance = 100;

	public lockATM() {
		lock = new ReentrantLock();
	}

	public int withDraw(int value) {
		lock.lock();
		int temp = balance;
		try {
			Thread.sleep(100);
			temp = temp - value;
			Thread.sleep(100);
			balance = temp;
		} catch(InterruptedException e) {}
		lock.unlock();
		return temp;
	}

	public int deposit(int value) {
		lock.lock();
		int temp = balance;
		try {
			Thread.sleep(100);
			temp = temp + value;
			Thread.sleep(100);
			balance = temp;
		} catch(InterruptedException e) {}
		lock.unlock();
		return temp;
	}
}

/*
A deadlock isa situation where a thread iswaiting for an object lock that another thread holds, and this second thread is waiting for an object lock that the first thread holds (or anequivalent situationwith severalthreads).Sinceeachthread iswaitingfor the other thread to relinquish a lock, they both remain waiting forever. The threads are said to be deadlocked.

deadlock to occur, you must have all four of the following conditions meet:
1. Mutual Exclusion: Only one processcan access a resourceat a given time. (Or, more accurately, there is limited access to a resource. A deadlock could also occur if a resourcehaslimited quantity.)
2. Hold and Wait:Processes already holding a resource can request additional resources, without relinquishing their current resources.
3. Wo Preemption: One process cannot forcibly remove another process'resource.
4. Circular Wait: Two or more processes form a circular chain where each process is
waiting on another resource in the chain.

Most deadlock prevention algorithms focus on avoiding condition #4: circular wait.
*/


























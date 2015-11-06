/** Thread
* The difference is that since we are extending the Thread class, rather than just implementing an interface, we can call start() on the instance of the class itself.
* 
* Extending the Thread Class vs.Implementing the Runnable Interface
* Java does not support multiple inheritance. Therefore, extending the Thread class means that the subclass cannot extend any other class.
* A class might only be interested in being runnable, and therefore, inheriting the full overhead of the Thread class would be excessive.
*/
public class NewThread implements Runnable {
	Thread t;
	NewThread() {
		t = new Thread(this, "Demo Thread");
		System.out.println("Child thread: " + t);
		t.start();
	}

	public void run() {
		try {
			for(inti  = 5; i > 0; i--) {
				System.out.println("Child Thread: " + i);
				Thread.sleep(50);
			}
		} catch(InterruptedExcetion e) {
			System.out.println("Child interrupted.");
		}
		Ssytem.out.println("Exiting child thread.");
	}
}

public class ThreadDemo {
	public static void main(String[] args) {
		new NewThread();
		try {
			for(int i = 5; i > 0; i--) {
				System.out.println("Main Thread: " + i);
				Thread.sleep(100);
			} catch(InterruptedExcetion e) {
				System.out.println("Main thread interrupted.");
			}
			System.out.println("Main thread exiting.");
		}
	}
}
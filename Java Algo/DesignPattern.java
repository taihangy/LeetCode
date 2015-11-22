/**Suppose you have a logger class that is used to log error and warning messages. How can you implement this class while using the Singleton design pattern?

The Singleton design pattern – when applied to a given class – basically limits the class itself to having just one instance created.

So, if we want to implement the Singleton design pattern with a logger class, it means that there can be at most one instance of the logger class. How can we accomplish this? First, let’s rephrase that question into something more specific to the problem at hand – how can we control the initialization of a class? Well, through the constructor of course.

A private constructor is key to the Singleton

More specifically, if we make the constructor private, this means that no one outside of the class can create an instance of the class. So, the one and only instance of the class will be created within the logger class itself, and not outside of the logger class.

Now, here is what the Java code for our Logging class would look like:
*/

// Implements a simple logging class using a singleton.
public class Logging {

	// this creates the actual Singleton instance
	private static final Logging singletonInstance = new Logging();

	/* Private constructor prevents others from
	   instantiating this class: */
	private Logging(){}

	// this method returns the singleton instance
	public static Logging getSingleton() 
	{ 
	  return singletonInstance; 
	}

	/* This will print a message to the screen:
	   sample call: Logging.getSingleton().log("testing message");
	*/

	public void log( String message )
	{
	  System.out.println( System.currentTimeMillis() 
	  + ": " + message );
	}
}

/**
* Suppose you have an application that uses the Singleton Design pattern for one of it’s classes. But, the problem is that the singleton is expensive to create, because a resource intensive database access is necessary to create the singleton. What can you do to possibly add some efficiency to the process of creating a singleton?
* This technique is known as lazy loading
*
* So, we want to repeat that the key thing to understand here is that the method has been changed to check if an instance already exists. If it does exist, it just returns that instance. If it doesn’t exist, then it just creates a new instance and returns that one. The whole point of this is to save resources by instantiating the Singleton only when it’s actually needed. This technique is commonly known as lazy loading, or deferred initialization, because of the fact that the singleton instance is created only once it’s needed – hence it’s “lazy” or “deferred”.
*/

/*Create the singleton instance only if it's
  null, which means no one else has created it
  already
*/
public static Logging getSingleton() {
   if( singletonInstance  == null ){
       singletonInstance  = new Logging();
   }
	 return singletonInstance;
}
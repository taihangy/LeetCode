public abstract class Employee {
	public static int ID_NUM = 1;
	public static final int CHIEF = 1;
	public static final int SERVER = 2;
	protected String name;
	protected final int ID;
	protected int position;
	protected float salary;
	protected int age;
	protected Status status;
	private enum Status {BUSY, FREE}

	public abstract void work(Table t);
	public abstract int getPosition();

	public Employee(String name, float salary, int age) {
		this.name = name;
		this.ID = ID_NUM++;
		this.salary = salary;
		this.age = age;
	}

	public String getName(){return name;}
	public String getID(){return ID;}
	public String getSalary(){return salary;}
	public String getAge(){return age;}
	public Status getStatus() {return status;}

	public void setName(String name) {this.name = name;}
	public void setSalary(float salary) {this.salary = salary;}
	public void setAge(int age) {this.age = age;}
}
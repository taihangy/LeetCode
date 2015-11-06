public class Chief extends Employee {
	private int position = CHIEF;
	// private ArrayList<Order> orders;
	
	public Chief(Stirng name, float salay, int age) {
		super(name, salay, age);
		status = FREE;
	}

	@Override
	public void work(Table t) {
		System.out.println("Cooking dishes...");
		status = BUSY;
		cooking(t.getOrder());
		System.out.println("All job is done");
		status = FREE;
	}

	@Override
	public int getPosition() {
		return position;
	}
}
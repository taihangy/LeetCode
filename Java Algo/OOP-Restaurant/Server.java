public class Server extends Employee {
	private int position = SERVER;

	public Server(Stirng name, float salay, int age) {
		super(name, salay, age);
		status = FREE;
	}

	@Override
	public void work(Table t) {
		status = BUSY;
		serveDish();
		status = FREE;
	}

	@Override
	public int getPosition() {
		return position;
	}

	public Order takeOrder() {
		
	}
}
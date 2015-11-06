public class Restaurant {
	private static Restaurant _instance;
	private Host host;
	private ArrayList<Employee> chief;
	private ArrayList<Employee> server;
	private ArrayList<Table> tables;
	private LinkedList<Order> orders;
	private ArrayList<Dish> dishes;
	private Queue<Party> waitList;

	private  Restaurant() {
		host = new Host(name);
		chief = new ArrayList<Employee>();
		server = new ArrayList<Employee>();
		tables = new ArrayList<Table>();
		for(int i = 0; i < 5; i++)
			tables.add(new Table());
		orders = LinkedList<Order>();
		waitList = new LinkedList<Party>();
	}

	public Restaurant getInstance() {
		if(_instance == null) {
			_instance = new Restaurant();
		} 
		return _instance;
	}

	public int checkTable(Party p) {
		if(waitList.length() == 0) {
			for(Table t : tables) {
				if(!t.hasParty()) {
					t.setParty(true);
					return t.number;
				}
			}
			return -1;
		}
		waitList.offer(p);
	}

	public void takeOrder(Table t) {
		Order o = t.order();
		orders.offer(o);
	}

	public float bill(Table t) {
		return t.getBill();
	}

	public boolean serveDish(Table t) {
		if(t.getOrder().status == PREPARING) return false;
		for(Server s : server) {
			if(s.status == FREE) {
				s.work(t);
			}
		}
	}

}
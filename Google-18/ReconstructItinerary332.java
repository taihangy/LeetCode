public class Solution {
    public List<String> findItinerary(String[][] tickets) {
        List<String> res = new LinkedList<String>();
        if (tickets == null || tickets.length == 0 || tickets[0].length == 0) return res;
        HashMap<String, Queue<String>> map = new HashMap<String, Queue<String>>();
        for (String[] ticket : tickets) {
            String from = ticket[0];
            String to = ticket[1];
            Queue<String> q = new PriorityQueue<String>(10, (a, b)->(a.compareTo(b)));
            if (map.containsKey(from)) {
                q = map.get(from);
            }
            q.offer(to);
            map.put(from, q);
        }
        findItinerary(res, map, "JFK");
        return res;
    }
    
    private void findItinerary(List<String> res, HashMap<String, Queue<String>> map, String city) {
    	while (map.containsKey(city) && !map.get(city).isEmpty()) {
    	    findItinerary(res, map, map.get(city).poll());
    	}
    	res.add(0, city);
    }
}
public class LRUCache {
    private final int capacity;
    private int curCount;
    private Node head;
    private Node tail;
    private Map<Object, Node> map;
    
    private static class Node {
        private Node prev;
        private Node next;
        private int key;
        private int value;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        curCount = 0;
        map = new HashMap<Object, Node>();
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node node = map.get(key);
        move(node);
        return node.value;
    }
    
    private void move(Node node) {
        if(node == null || node == head) return;
        if(head == null || tail == null) {
            head = node;
            tail = node;
            return;
        }
        if(node.prev != null) node.prev.next = node.next;
        if(node.next != null) node.next.prev = node.prev;
        if(node == tail) tail = tail.prev;
        node.next = head;
        node.prev = null;
        head.prev = node;
        head = node;
    }
    
    public void set(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            node.value = value;
        } else {
            node = new Node(key, value);
            if (curCount < capacity) {
                curCount++;
            } 
            else if(tail != null) {
                map.remove(tail.key);
                removeTail();
            }
        }
        move(node);
        map.put(key, node);
    }
    
    private void removeTail() {
        if (tail == null) return;
        if(tail.prev != null) {
            tail.prev.next = null;
        } else {
            head = null;
        }
        tail = tail.prev;
    }
}
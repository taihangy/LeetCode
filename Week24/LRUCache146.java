public class LRUCache {
    
    private int capacity;
    private int count;
    private DNode head;
    private DNode tail;
    private HashMap<Integer, DNode> cache;
    
    class DNode {
        int key;
        int value;
        DNode next;
        DNode prev;
    }
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        count = 0;
        cache = new HashMap<Integer, DNode>();
        head = new DNode();
        tail = new DNode();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        DNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }
    
    public void set(int key, int value) {
        DNode node = cache.get(key);
        if (node == null) {
            node = new DNode();
            node.key = key;
            node.value = value;
            count++;
            addToHead(node);
            if (count > capacity) {
                DNode last = popLast();
                cache.remove(last.key);
                count--;
            }
        }
        else {
            node.value = value;
            moveToHead(node);
        }
        cache.put(key, node);
    }
    
    private void addToHead(DNode node) {
        node.next = head.next;
        head.next.prev = node;
        
        node.prev = head;
        head.next = node;
    }
    
    private DNode popLast() {
        DNode res = tail.prev;
        remove(res);
        return res;
    }
    
    private void remove(DNode node) {
        DNode prev = node.prev;
        DNode next = node.next;
        node.next = null;
        node.prev = null;
        
        prev.next = next;
        next.prev = prev;
    }
    
    private void moveToHead(DNode node) {
        remove(node);
        addToHead(node);
    }
}
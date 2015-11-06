public class LRUCache {
    private final int capacity;
    private int curCapacity;
    private HashMap<Object, CacheNode> map;
    private CacheNode head;
    private CacheNode tail;
    
    private class CacheNode {
        CacheNode prev;
        CacheNode next;
        int key;
        int value;
        public CacheNode(int k, int v) {
            key = k;
            value = v;
        }
    }
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        curCapacity = 0;
        map = new HashMap<Object, CacheNode>(capacity);
    }
    
    public int get(int key) {
        CacheNode node = map.get(key);
        if(node == null) return -1;
        else {
            move(node);
            return node.value;
        }
    }
    
    public void set(int key, int value) {
        CacheNode node = map.get(key);
        if(node != null) {
            node.value = value;
            move(node);
            map.put(key, node);
        } else {
            node = new CacheNode(key, value);
            if(curCapacity < capacity) {
                curCapacity++;
            }
            else if(tail != null) {
                map.remove(tail.key);
                removeTail();
            }
            move(node);
            map.put(key, node);
        }
        
    }
    
    //Remove the least recent use node from cache list
    private void removeTail() {
        if(tail != null) {
            if(tail.prev != null) {
                tail.prev.next = null;
            } else {
                head = null;
            }
            tail = tail.prev;
        }
    }
    
    //Move node to front
    private void move(CacheNode node) {
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
}
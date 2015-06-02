public class LRUCache {
    private final int capacity;
    private int curCapacity;
    private HashMap<Object,CacheNode> map;
    private CacheNode head;
    private CacheNode tail;
    
    private class CacheNode{
        CacheNode prev;
        CacheNode next;
        int key;
        int value;
        public CacheNode(int key,int value){
            this.key=key;
            this.value=value;
        }
    }
    
    public LRUCache(int capacity) {
        this.capacity=capacity;
        curCapacity=0;
        map=new HashMap<Object,CacheNode>(capacity);
    }
    
    public int get(int key) {
        CacheNode node=map.get(key);
        if(node!=null){
            move(node);
            return node.value;
        }else{
            return -1;
        }
    }
    
    private void move(CacheNode node){
        if(node==head) return;
        if(node.prev!=null) node.prev.next=node.next;
        if(node.next!=null) node.next.prev=node.prev;
        if(tail==node) tail=node.prev;
        if(head!=null) {
            node.next=head;
            head.prev=node;
        }
        head=node;
        node.prev=null;
        if(tail==null) tail=head;
    }
    
    public void set(int key, int value) {
        CacheNode node=map.get(key);
        if(node!=null){
            node.value=value;
            move(node);
            map.put(key,node);
        }else{
            node=new CacheNode(key,value);
            if(curCapacity<capacity){
                curCapacity++;
            }else{
                if(tail!=null){
                    map.remove(tail.key);
                }
                removeTail();
            }
            move(node);
            map.put(key,node);
        }
    }
    private void removeTail(){
        if(tail!=null){
            if(tail.prev!=null){
                tail.prev.next=null;
            }else{
                head=null;
            }
            tail=tail.prev;
        }
    }
}
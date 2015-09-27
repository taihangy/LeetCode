/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    //dfs recursion
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return null;
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = 
                            new  HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
        map.put(node, copy);
        dfs(node, map);
        return copy;
    }
    
    private void dfs(UndirectedGraphNode node, HashMap<UndirectedGraphNode, UndirectedGraphNode> map) {
        for(UndirectedGraphNode cur : node.neighbors) {
            UndirectedGraphNode copy = new UndirectedGraphNode(cur.label);
            if(!map.containsKey(cur)) {
                map.put(cur, copy);
                dfs(cur, map);
            }
            map.get(node).neighbors.add(map.get(cur));
        }
    }

    // dfs iterative, using stack
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return null;
        LinkedList<UndirectedGraphNode> stack = new LinkedList<UndirectedGraphNode>();
        HashMap<UndirectedGraphNode,UndirectedGraphNode> map=new HashMap<UndirectedGraphNode,UndirectedGraphNode>();
        UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
        map.put(node, copy);
        stack.push(node);
        while(!stack.isEmpty()) {
            UndirectedGraphNode cur = stack.pop();
            for(UndirectedGraphNode near : cur.neighbors) {
                if(!map.containsKey(near)) {
                    copy = new UndirectedGraphNode(near.label);
                    map.put(near, copy);
                    stack.offer(near);
                }
                map.get(cur).neighbors.add(map.get(near));
            }
        }
        return map.get(node);
    }

    //bfs iterative, using queue
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return null;
        LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        HashMap<UndirectedGraphNode,UndirectedGraphNode> map=new HashMap<UndirectedGraphNode,UndirectedGraphNode>();
        UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
        map.put(node, copy);
        queue.offer(node);
        while(!queue.isEmpty()) {
            UndirectedGraphNode cur = queue.poll();
            for(UndirectedGraphNode near : cur.neighbors) {
                if(!map.containsKey(near)) {
                    copy = new UndirectedGraphNode(near.label);
                    map.put(near, copy);
                    queue.offer(near);
                }
                map.get(cur).neighbors.add(map.get(near));
            }
        }
        return map.get(node);
    }
}
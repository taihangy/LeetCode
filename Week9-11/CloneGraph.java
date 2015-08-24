/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */

public class Solution {
    //dfs recursive
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node==null) return null;
        HashMap<UndirectedGraphNode,UndirectedGraphNode> map=new HashMap<UndirectedGraphNode,UndirectedGraphNode>();
        UndirectedGraphNode copy=new UndirectedGraphNode(node.label);
        map.put(node,copy);
        dfs(node,map);
        return copy;
    }
    private void dfs(UndirectedGraphNode node,HashMap<UndirectedGraphNode,UndirectedGraphNode> map){
        
        for(int i=0;i<node.neighbors.size();i++){
            UndirectedGraphNode cur=node.neighbors.get(i);
            if(!map.containsKey(cur)){
                UndirectedGraphNode copy=new UndirectedGraphNode(cur.label);
                map.put(cur,copy);
                dfs(cur,map);
            }
            map.get(node).neighbors.add(map.get(cur));
        }
    }

    //bfs iterated version
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node==null) return null;
        HashMap<UndirectedGraphNode,UndirectedGraphNode> map=new HashMap<UndirectedGraphNode,UndirectedGraphNode>();
        LinkedList<UndirectedGraphNode> queue=new LinkedList<UndirectedGraphNode>();
        UndirectedGraphNode copy=new UndirectedGraphNode(node.label);
        map.put(node,copy);
        queue.offer(node);
        while(!queue.isEmpty()){
            UndirectedGraphNode cur=queue.poll();
            for(int i=0;i<cur.neighbors.size();i++){
                if(!map.containsKey(cur.neighbors.get(i))){
                    copy=new UndirectedGraphNode(cur.neighbors.get(i).label);
                    map.put(cur.neighbors.get(i),copy);
                    queue.offer(cur.neighbors.get(i));
                }
                map.get(cur).neighbors.add(map.get(cur.neighbors.get(i)));
            }
        }
        return map.get(node);
    }

    //dfs iterated version
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node==null) return null;
        HashMap<UndirectedGraphNode,UndirectedGraphNode> map=new HashMap<UndirectedGraphNode,UndirectedGraphNode>();
        LinkedList<UndirectedGraphNode> stack=new LinkedList<UndirectedGraphNode>();
        UndirectedGraphNode copy=new UndirectedGraphNode(node.label);
        map.put(node,copy);
        stack.push(node);
        while(!stack.isEmpty()){
            UndirectedGraphNode cur=stack.pop();
            for(int i=0;i<cur.neighbors.size();i++){
                if(!map.containsKey(cur.neighbors.get(i))){
                    copy=new UndirectedGraphNode(cur.neighbors.get(i).label);
                    map.put(cur.neighbors.get(i),copy);
                    stack.push(cur.neighbors.get(i));
                }
                map.get(cur).neighbors.add(map.get(cur.neighbors.get(i)));
            }
        }
        return map.get(node);
    }
}
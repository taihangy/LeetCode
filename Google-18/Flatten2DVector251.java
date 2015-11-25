public class Vector2D {
    private List<Integer> vec1d;
    private int index;

    public Vector2D(List<List<Integer>> vec2d) {
        index = 0;
        vec1d = new ArrayList<Integer>();
        for(List<Integer> list : vec2d) {
            vec1d.addAll(list);
        }
    }

    public int next() {
        if(!hasNext()) return 0;
        return vec1d.get(index++);
    }

    public boolean hasNext() {
        return index != vec1d.size();
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */

public class Vector2D {
    private Iterator<List<Integer>> lists;
    private Iterator<Integer> list;

    public Vector2D(List<List<Integer>> vec2d) {
        lists = vec2d.iterator();
    }

    public int next() {
        if(!hasNext()) return 0;
        return list.next();
    }

    public boolean hasNext() {
        while((list == null || !list.hasNext()) && lists.hasNext()) {
            list = lists.next().iterator();
        }
        return list != null && list.hasNext();
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */
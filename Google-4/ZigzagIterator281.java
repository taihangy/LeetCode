public class ZigzagIterator {
    private List<Integer> list;
    private int index;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        index = 0;
        list = new ArrayList<Integer>();
        int i = 0, j = 0;
        while(i < v1.size() || j < v2.size()) {
            if(i >= v1.size()) list.add(v2.get(j++));
            else if(j >= v2.size()) list.add(v1.get(i++));
            else {
                list.add(v1.get(i++));
                list.add(v2.get(j++));
            }
        }
    }

    public int next() {
        return list.get(index++);
    }

    public boolean hasNext() {
        return index != list.size();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */

//Follow up
public class CyclicIterator {
    private List<Integer> list;
    private int index;

    public CyclicIterator(List<List<Integer>> v) {
        index = 0;
        list = new ArrayList<Integer>();
        int i = 0;
        while(i < maxLength(v)) {
            for(int j = 0; j < v.size(); j++) {
                List<Integer> vi = v.get(j);
                if(i < vi.size()) {
                    list.add(vi.get(i));
                }
            }
            i++;
        }
    }

    private int maxLength(List<List<Integer>> v) {
        int max = Integer.MIN_VALUE;
        for(List<Integer> list : v) {
            max = Math.max(max, list.size());
        }
        return max;
    }

    public int next() {
        return list.get(index++);
    }

    public boolean hasNext() {
        return index != list.size();
    }
}


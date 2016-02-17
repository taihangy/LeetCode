public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList<int[]>();
        if (buildings == null || buildings.length == 0 || buildings[0].length == 0) return res;
        PriorityQueue<Integer> heightPQ = new PriorityQueue<Integer>(10, (a, b)->(b - a));
        List<int[]> walls = ArrayList<int[]>();
        for (int[] building : buildings) {
            walls.add(new int[]{building[0], building[2]});
            walls.add(new int[]{building[1], -building[2]});
        }
        Collections.sort(walls, (a, b) -> (a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]));
        int cur = 0, pre = 0;
        for (int[] wall : walls) {
            if (wall[1] > 0) {
                heightPQ.add(wall[1]);
                cur = heightPQ.peek();
            }
            else {
                heightPQ.remove(-wall[1]);
                cur = heighttPQ.isEmpty() ? 0 : heighttPQ.peek();
            }
            if (cur != pre) {
                res.add(wall[0], cur);
                pre = cur;
            }
        }
        return res;
    }
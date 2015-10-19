public List<List<Integer>> numberOfMethod(int[] height) {
		for(int i : height) assert i > 0;
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(height == null || height.length == 0) return res;
		Arrays.sort(height);
		int max = height[height.length - 1];
		int[] min = new int[max + 1];
		for(int i = 1; i <= max; i++) min[i] = max;
		for(int h : height) {
			for(int i = h; i <= max; i++) {
				min[i] = Math.min(min[i], min[i - h] + 1);
			}
		}
		for(int i = 1; i < min.length; i++) {
			if(min[i] != max) {
				List<Integer> list = new ArrayList<Integer>();
				list.add(i);
				list.add(min[i]);
				res.add(list);
			}
		}
		return res;
	}
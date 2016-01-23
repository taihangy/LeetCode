public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0 || prerequisites == null || prerequisites.length == 0) return true;
        int[][] mat = new int[numCourses][numCourses];
        int[] indegree = new int[numCourses];
        
        for (int i = 0; i < prerequisites.length; i++) {
            int pre = prerequisites[i][1];
            int cur = prerequisites[i][0];
            if (mat[pre][cur] == 0) {
                indegree[cur]++;
            }
            mat[pre][cur] = 1;
        }
        
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }
        int count = numCourses;
        while (!queue.isEmpty()) {
            int pre = queue.poll();
            count--;
            for (int i = 0; i < numCourses; i++) {
                if (mat[pre][i] != 0) {
                    indegree[i] -= 1;
                    if (indegree[i] == 0) {
                        queue.offer(i);
                    }
                }
            }
        }
        return count == 0;
    }
}
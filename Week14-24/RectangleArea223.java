public class Solution {
    // complex solution, not easy to maintain
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area1 = (G - E) * (H - F);
        int area2 = (C - A) * (D - B);
        int res = area1 + area2;
        if(isOverLap(A, B, C, D, E, F, G, H)) {
            int width = (C - A + G -E) - Math.abs(Math.max(G, C) - Math.min(A, E));
            int height = (D - B + H - F) - Math.abs(Math.max(D, H) - Math.min(B, F));
            int over = width * height;
            res = res - over;
        }
        return res;
    }
    private boolean isOverLap(int A, int B, int C, int D, int E, int F, int G, int H) {
        if(H <= B || F >= D || E >= C || G <= A) return false;
        return true;
    }

    // clever and compact way, observe that right and up, if not overlapped, left == right, up == bottom
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int left = Math.max(A, E), right = Math.max(Math.min(C, G),left);
        int bottom = Math.max(B, F), up = Math.max(Math.min(D, H), bottom);
        return (C - A) * (D - B) + (G - E) * (H - F) - (up - bottom) * (right - left);
    }
}
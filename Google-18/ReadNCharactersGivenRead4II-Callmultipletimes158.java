/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    private char[] buff = new char[4];
    private int buffPtr = 0;
    private int buffCnt = 0;
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        if(n < 0) return 0;
        int index = 0;
        while(index < n) {
            if(buffPtr == 0) {
                buffCnt = read4(buff);
            }
            if(buffCnt == 0) break;
            while(index < n && buffPtr < buffCnt) {
                buf[index++] = buff[buffPtr++];
            }
            if(buffPtr >= buffCnt) buffPtr = 0;
        }
        return index;
    }
}
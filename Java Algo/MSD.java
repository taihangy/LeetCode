
/** Performance
* ■ For random inputs, MSD string sort
examines just enough characters to distinguish among the keys, and the running time is sublinear in the number of characters in the data (it examines a small fraction of the input characters).
■ For nonrandom inputs, MSD string sort still could be sublinear but might need to examine more characters than in the random case, depending on the data. In particular, it has to examine all the characters in equla keys, so the running time is nearly linear in the number of characters in the data when significant num- bers of equal keys are present.
■ In the worst case, MSD string sort examines all the characters in the keys, so the running time is linear in the number of characters in the data (like LSD string sort). A worst-case input is one with all strings equal.
* To sort N random strings from an R-character alphabet, MSD string sort examines about N log R N characters, on average.
* MSD string sort uses between 8N 􏰄+ 3R and ~7wN 􏰄+ 3WR array ac- cesses to sort N strings taken from an R-character alphabet, where w is the average string length.
* MSD string sort uses between 8N 􏰄 3R and ~7wN 􏰄 3WR array ac- cesses to sort N strings taken from an R-character alphabet, where w is the average string length.
*/
public class MSD {
	private static int R =256; //radix
	private static final int M = 15; //Cutoff for small subarrays
	private static String[] aux;

	private static int charAt(String s, int d) {
		if(d < s.length())
			return s.charAt(d);
		else return -1;
	}

	public static void sort(String[] a) {
		int N = a.length;
		aux = new String[N];
		sort(a, 0, N - 1, 0);
	}

	private static void sort(String[] a, int lo, int hi, int d){
		if(hi <= lo + M) {
			Insertion.sort(a, lo, hi, d);
			return;
		}
		int[] count = new int[R + 2]; //position 1 is for charAt(s) = -1, shorter string is before longer one
		for(int i = lo; i <= hi; i++) {
			count[charAt(a[i], d) + 2]++;
		}

		for(int r = 0; r < R + 1; r++) {
			count[r + 1] += count[r];
		}

		for(int i = lo; i <=hi; i++) {
			aux[count[charAt(a[i], d) + 1]++] = a[i];
		}

		for(int i = lo; i <= hi; i++) {
			a[i] = aux[i - lo];
		}

		for(int r = 0; r < R; r++)
			sort(a, lo + count[r], lo + count[r + 1] - 1, d + 1);
	}
}

/**
* 3-way string quicksort adapts well to handling equal keys, keys with long common prefixes,
* To sort an array of N random strings, 3-way string quicksort uses ~ 2N ln N character compares, on the average. like quick sort
* general-purpose, strings with long prefix matches
* between N and Nw Running time
*/ 
public class Quick3string {
	private static int charAt(String s, int d) {
		if(d < s.length())
			return s.charAt(d);
		else
			return -1;
	}

	public static void sort(String[] a) {
		sort(a, 0, a.length - 1, 0);
	} 

	private static void sort(String[] a, int lo, int hi, int d) {
		if(hi <= lo) return;
		int lt = lo, gt = hi;
		int v = charAt(a[lo], d);
		int i = lo + 1;
		while(i <= gt) {
			int t = charAt(a[i], d);
			if(t < v) exch(a, lt++, i++);
			else if(t > v) exch(a, gt--, i);
			else i++;
		}
		sort(a, lo, lt - 1, d);
		if(v >= 0) sort(a, lt, gt, d + 1);
		sort(a, gt + 1, hi, d);
	}

	private void exch(String[] a, int i, int j) {
		String t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

}
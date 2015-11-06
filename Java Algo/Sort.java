private static boolean less(Cpmarable v, Cpmparable w) {
	return v.compareTo(w) < 0;
}

private static void exch(Comparable[] a, int i, int j) {
	Comparable t = a[i]; 
	a[i] = a[j];
	a[j] = t;
}

private static boolean isSorted(Comparable[] a) {
	for(int i = 1; i < a.length; i++)
		if(less(a[i], a[i - 1])) return false;
	return true;
}

/** Selection Sort
* Selection sort uses 􏰯N^2/2 compares and N exchanges to sort an array of length N.
*/
public calss Selection {
	public static void sort(Comparable[] a) {
		int N = a.length;
		for(int i = 0; i < N; i++) {
			int min = i;
			for(int j = i + 1; j < N; j++) {
				if(less(a[j], a[min])) min = j;
			}
			exch(a, i, min);
		}
	}
}
/** Insertion Sort
* Insertion sort uses 􏰯N^2/4 compares and 􏰯N^2/4 exchanges to sort a randomly ordered array of length N with distinct keys, on the average. The worst case is 􏰯N^2/2 compares and 􏰯N^2/2 exchanges and the best case is N 􏰅- 1 compares and 0 exchanges.
*/
public calss Insertion {
	public static void sort(Comparable[] a) {
		int N = a.length;
		for(int i = 1; i < N; i++) {
			for(int j = i; j > 0 && less(a[j], a[j - 1]); j++) {
				exch(a, j, j - 1);
			}
		}
	}

	//Improve version, which we can minimize exchanges
	public static void sort(Comparable[] a) {
		int N = a.length;
		for(int i = 1; i < N; i++) {
			Comparable t = a[i];
			int j;
			for(j = i; j > 0 && less(a[j], a[j - 1]); j++) {
				a[j] = a[j - 1];
			}
			a[j] = t;
		}
	}


	//Comparator for different keys
	public static void sort(Object[] a, Comparator c) {
		int N = a.length;
		for(int i = 1; i < N; i++) 
			for(int j = i; j > 0 && less(c, a[j], a[j-1]); j--)
				exch(a, j, j - 1);
	}

	private static boolean less(Comparator c, Object v, Object w) {
		return c.compare(v, w) < 0;
	}
}

/** Shellsort
* Improvement of insertion sort, make it partially sorted by large step between element
*/
public class ShellSort {
	public static void sort(Cpmparable[] a) {
		int N = a.length;
		int h = 1;
		while(h < N / 3) h = 3 * h + 1;
		while(h >= 1) {
			for(int i = h; i < N; i++) {
				for(int j = i; j >= 0 && less(a[j], a[j - 1]); j -= h) {
					exch(a, j, j - h);
				}
				h = h / 3;
			}
		}
	}
}

/** Top down mergesort & Bottom up mergesort
* Top-down mergesort uses between 1⁄2 N lg N and N lg N compares to sort any array of length N.
* Top-down mergesort uses at most 6N lg N array accesses to sort an array of length N.
* Bottom-up mergesort uses between 1⁄2 N lg N and N lg N compares and at most 6N lg N array accesses to sort an array of length N.
* No compare-based sorting algorithm can guarantee to sort N items with fewer than lg(N !) ~ N lg N compares.
*/
public class MergeSort {
	private static Comparable[] aux;

	//Top down
	public static void sort(Comparable[] a) {
		aux = new Comparable[a.length];
		sort(a, 0, a.length - 1);
	}

	private static void sort(Comparable[] a, int lo, int hi) {
		if(hi <= lo) return;
		int mid = (lo + hi) / 2;
		sort(a, lo, mid);
		sort(a, mid + 1, hi);
		merge(a, lo, mid, hi);
	}

	public static void merge(Comparable[] a, int lo, int mid, int hi) {
		int i = lo, j = mid + 1;
		for(int k = lo; k <= hi; k++) 
			aux[k] = a[k];
		for(int k = lo; k <= hi; k++) {
			if(i > mid) a[k] = aux[j++];
			else if(j > hi) a[k] = aux[i++];
			else if(less[aux[i], aux[j]]) a[k] = aux[i++];
			else a[k] = aux[j++];
		}
	}

	//Bottom up
	public static void sort(Comparable[] a) {
		int N = a.length;
		aux = new Comparable[N];
		for(int sz = 1; sz < N; sz *= 2) {
			for(int lo = 0; lo < N - sz; lo += sz + sz) {
				merge(a, lo, lo + sz - 1, Math.min(lo + sz * 2 - 1, N - 1))
			}
		}
	}
}

/** Quick sort
* Quicksort uses ~ 2N ln N compares (and one-sixth that many ex- changes) on the average to sort an array of length N with distinct keys.
* Quicksort uses ~ N^2/2 compares in the worst case, but random shuffling protects against this case. Array is already sorted like 1 2 3 4 5
* Improvement: 
1. cutoff to insertion sort if(lo + M >= hi) {Insertion.sort(a, lo, hi); return;}
2. Median-of-three partioning: median of three sample as pivot
3. Large number of duplicate keys in the input array-Three way quick sort
* Quicksort is the fastest general-purpose sort.
* Generally, the reason that quicksort is fastest is that it has only a few instructions in its inner loop (and it does well with cache memories because it most often references data sequentially) so that its running time is ~c N lg N with the value of c smaller than the corresponding constants for other linearithmic sorts. With 3-way partitioning, quicksort becomes linear for certain key distributions likely to arise in practice, where other sorts are linearithmic.
*/
public class QuickSort {
	public static void sort(Comparable[] a) {
		shuffle(a);
		sort(a, 0, a.length - 1);
	}

	private static void shuffle(Comparable[] a) {
		Random r = new Random();
		for(int i = a.length - 1; i >= 0; i--) {
			int index = r.nextInt(i + 1);
			Comparable t = a[index];
			a[index] = a[i];
			a[i] = t;
		}
	}

	private static void sort(Comparable[] a, int lo, int hi) {
		if(hi <= lo) return;
		int j = partition(a, lo, hi);
		sort(a, lo, j - 1);
		sort(a, j + 1, hi);
	}

	private static int partition(Comparable[] a, int lo, int hi) {
		int i = lo, j = hi + 1;
		Comparable v = a[lo];
		while(true) {
			while(less(a[++i], v)) if(i == hi) break;
			while(less(v, a[--j])) if(j == lo) break;
			if(i >= j) break;
			exch(a, i, j);
		}
		exch(a, lo, j);
		return j; //with a[lo..j-1] <= a[j] <= a[j+1..hi]
	}
}

//Time between N and N log N 
//large numbers of equal keys
//Space log N
public class Quick3way {
	private static void sort(Comparable[] a, int lo, int hi) {
		if(hi <= lo) return;
		int lt = lo, i = lo + 1, gt = hi;
		Comparable v = a[lo];
		while(i <= gt) {
			int cmp = a[i].compareTo(v);
			if(cmp < 0) exch(a, lt++, i++);
			else if(cmp > 0) exch(a, gt--, i);
			else i++;
		}
		sort(a, lo, lt - 1);
		sort(a, gt + 1, hi);
	}
}

//Time O(n)
public class SelectTopK {
	//Return the kth smallest element in a.
	public static Comparable select(Comparable[] a, int k) {
		shuffle(a);
		int lo = 0; hi = a.length - 1;
		while(hi > lo) {
			int j = partition(a, lo, hi);
			if(k == j) return a[k];
			else if(j < k) lo = j + 1;
			else if(j > k) hi = j - 1;
		}
		return a[k];
	}

	private int partition(Comparable[] a, int lo, int hi) {
		int i = lo, j = hi + 1;
		Comparable v = a[lo];
		while(i < j) {
			while(less(a[++i], v])) if(i == hi) break;
			while(less([v, a[--j])) if(j == lo) break; 
			if(i >= j) break;
			exch(a, i, j);
		}
		exch(a, lo, j);
		return j;
	}

	private void shuffle(Comparable[] a) {
		int N = a.length;
		Random r = new Random();
		for(int i = N - 1; i > 0; i--) {
			int j = r.nextInt(i + 1);
			exch(a, i, j);
		}
	}
}























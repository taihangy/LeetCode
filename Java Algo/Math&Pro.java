public class Math {

	public static int gcd(int a, int b) {
		if(b == 0) return a;
		return gcd(b, a % b);
	}

	public static int lcm(int a, int b) {
		for(int m = 1;;m++) {
			int N = 2;
			if(m % a != 0) continue;
			else N--;
			if(m % b != 0) continue;
			else N--;
			if(N == 0) return m;
		}
	}

	public static int lcm(int... a) {
		for(int m = 1;;m++) {
			int N = a.length;
			for(int elem : a) {
				if(m % elem != 0) break;
				if(--N == 0) return m;
			}
		}
	}

	public static int gcd(int... a) {
		if(a.length == 0) return 0;
		int res = a[0];
		for(int i = 1; i < a.length; i++)
			res = gcd(res, a[i]);
		return res;
	}

	//Count the prime numbers that is less than n
	public static int countPrimes(int n) {
		if(n <= 2) return 0;
		boolean[] marked = new boolean[n];
		int count = 0; //count the numbers that are not prime, which can be divisible by a prime number
		for(int i = 2; i * i < n; i++) {
			if(marked[i]) continue;
			for(int dup = i * i; dup < n; dup += i) {
				if(!marked[dup]) {
					marked[dup] = true;
					count++;
				}
			}
		}
		return n - count - 2; //1 and itself
	}

	public static void main(String[] args) {
		System.out.println(Math.lcm(2, 3));
	}
}
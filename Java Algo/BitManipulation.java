public class BitMunipulation {
	public boolean getBit(int num, int i) {
		int mask = 1 << i;
		return (num & mask) != 0; 
	}

	public int setBit(int num, int i) {
		int mask = 1 << i;
		return num | mask;
	}

	public int clearBit(int num, int i) {
		int mask = ~(1 << i);
		return num & mask;
	}

	/** To clear the bits from the most significant bit through i*/
	public int clearBitsMSBthroughI(int num, int i) {
		int mask = (1 << i) - 1; // (~0 << (32 - i)) >>> (32 - i)
		return num & mask;
	}

	public int clearBitsIthrough0(int num, int i) {
		int mask = ~((1 << i) - 1);// ~0 << i
		return num & mask;
	}

	public int update(int num, int i, int v) {
		clearBit(num, i);
		return setBit(num, v);
	}

	/* Find the first ont from left of the Integer. i.e. 100, return 4 */
	public int findFirstOneFromRight(int num) {
		return num & -num;
	}
}
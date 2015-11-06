/**
* The number of array accesses when searching in a trie or inserting a key into a trie is at most 1 plus the length of the key.
* The average number of nodes examined for search miss in a trie built from N random keys over an alphabet of size R is ~log R N .
* The number of links in a trie is between RN and RNw, where w is the average key length.
*/
public class TrieST<Value> {
	private final int R = 256; //extended ACSII
	private TrieNode root;

	private static class TrieNode {
		private Object val;
		private TrieNode[] next = new TrieNode[R];
	}

	public void insert(String key, Value val) {
		if(key == null || key.length() == 0) return null;
		root = insert(root, key, val, 0);
	}

	private TrieNode insert(TrieNode x, String key, Value val, int index) {
		if(x == null) x = new TrieNode();
		if(index == key.length()) {
			x.val = val;
			return x;
		}
		char c = key.charAt(index);
		x.next[c] = insert(x.next[c], key, val, index + 1);
		return x;
	}

	public Value search(String key) {
		if(key == null || key.length() == 0) return null;
		Node x = search(root, key, 0);
		if(x == null) return null;
		return x.val;
	}

	private TrieNode search(TrieNode x, String key, int index) {
		if(x == null) return null;
		if(index == key.length()) return x;
		char c = key.charAt(index);
		return search(x.next[c], key, index + 1)；
	}

	public Iterable<String> keys() {
		return keysWithPrefix("");
	}

	public Iterable<String> keysWithPrefix(String pre) {
		if(pre == null) return null;
		LinkedList<String> q = new LinkedList<String>();
		collect(search(root, pre, 0), q, pre);
		return q;
	}

	private void collect(TrieNode x, LinkedList<String> q, String pre) {
		if(x == null) return;
		if(x.val != null) q.offer(pre);
		for(char c = 0; c < R; c++) {
			collect(x.next[i], q, pre + c);
		}
	}

	public Iterable<String> keysThatMatch(String pat) {
		if(pat == null || pat.length() == 0) return null;
		LinkedList<String> q = new LinkedList<String>();
		collect(q, pat, "", root);
		return q;
	}

	private void collect(LinkedList<String> q, String pat, String pre, TrieNode x) {
		int index = pre.length();
		if(x == null) return;
		if(index == pat.length() && x.val != null) q.offer(pre);
		if(index == pat.length()) return;
		char next = pat.charAt(index);
		for(char c = 0; c < R; c++) {
			if(next == c || next == '.') {
				collect(q, pat, pre + c, x.next[c]);
			}
		}
	}

	public String longestPrefixOf(String s) {
		int length = search(root, s, 0, 0);
		return s.substring(0, length);
	}

	private int search(TrieNode x, String s, int index, int length) {
		if(x == null) return length;
		if(x.val != null) length = index;
		if(index == s.length()) return length;
		char c = s.charAt(index);
		return search(x.next[c], s, index + 1, length);
	}

	public void delete(String key) {
		root = delete(root, key, 0);
	}

	private TrieNode delete(TrieNode x, String key, int index) {
		if(x == null) return null;
		if(index == key.length()) x.val  = null;
		else {
			char c = key.charAt(index);
			x.next[c] = delete(x.next[c], key, index + 1)
		}
	}

	public int size() {
		return size(root);
	}

	private int size(TrieNode x) {
		if(x == null) return 0;
		int count = 0;
		if(x.val != null) count++;
		for(int i = 0; i < R; i++)
			count += size(x.next[i]);
		return count;
	}
}
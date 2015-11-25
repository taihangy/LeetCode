public class ValidWordAbbr {
    private Map<String, String> map;

    public ValidWordAbbr(String[] dictionary) {
        map = new HashMap<String, String>();
        for(String word : dictionary) {
            String abbr = abbreviate(word);
            map.put(abbr, map.containsKey(abbr)? "" : word);
        }
    }
    
    private String abbreviate(String word) {
        assert word != null;
        if(word.length() <= 2) return word;
        int length = word.length() - 2;
        return "" + word.charAt(0) + length + word.charAt(word.length() - 1); 
    }

    public boolean isUnique(String word) {
        String abbr = abbreviate(word);
        return !map.containsKey(abbr) || map.get(abbr).equals(word);
    }
}


// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");
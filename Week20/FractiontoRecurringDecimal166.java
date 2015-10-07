public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        // check NaN, Positive Infinity and Negtive Infinity
        if(denominator == 0 && numerator == 0) return "NaN";
        else if(denominator == 0 && numerator > 0) return "Positive Infinity";
        else if(denominator == 0 && numerator < 0) return "Negtive Infinity";
        
        StringBuilder res = new StringBuilder();
        boolean isNeg = numerator ^ denominator < 0;
        int n = Math.abs((long)numerator);
        int d = Math.abs((long)denominator);
        res.append(n / d);
        //If n is divisible by d, return
        if(n % d == 0) return isNeg?"-" + res.toString() : res.toString();
        res.append('.');
        n = n % d;
        Map<Long, Integer> map = new HashMap<>();
        int index = res.indexOf(".") + 1; //Find the right place to insert '('
        while(true) {
            if(n < d) n *= 10;
            if(map.containsKey(n)) {
                res.insert(map.get(n), '(').append(')');
                break;
            }
            else map.put(n, index++);
            long num = n / d;
            n = n % d;
            res.append(num);
            if(n == 0) break;
        }
        return isNeg?"-" + res.toString() : res.toString();
    }
}
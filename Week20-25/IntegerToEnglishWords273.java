public class Solution {
    private static String[] number = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
                                            "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static String[] ty = {"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    public String numberToWords(int num) {
        if(num == 0) return "Zero";
        StringBuilder res = new StringBuilder();
        int count = 1;
        while(num > 0) {
            String s = chunk(num % 1000, count);
            res.insert(0, s);
            num /= 1000;
            count++;
        }
        return res.toString().trim();
    }
    
    private String chunk(int num, int count) {
        assert num < 1000;
        StringBuilder res = new StringBuilder();
        if(num == 0) return "";
        int digit = num % 100;
        if(digit != 0) {
            String s = null;
            if(digit < 20) {
                s = number[digit];
            }
            else {
                s = ty[digit / 10 - 2];
                if(digit % 10 != 0) s += " " + number[digit % 10];
            }
            res.insert(0, s + " ");
        }
        num /= 100;
        if(num != 0) res.insert(0, number[num] + " Hundred ");
        switch(count) {
            case 2: res.append("Thousand "); break;
            case 3: res.append("Million "); break;
            case 4: res.append("Billion "); break;
        }
        return res.toString();
    }
}
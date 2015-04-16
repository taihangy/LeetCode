public class FractiontoRecurringDecimal{
	public String fractionToDecimal(int numerator, int denominator) {
        if(denominator==0) return null;
        if(numerator==0) return "0";
        long n=numerator;
        long d=denominator;
        StringBuilder sb=new StringBuilder();
        if((n<0)^(d<0)) sb.append("-");
        n=Math.abs(n);
        d=Math.abs(d);
        long in=n/d;
        sb.append(in);
        if(n%d!=0) sb.append(".");
        HashMap<Long,Integer> map=new HashMap<Long,Integer>();
        long i;
        for(i=n%d;i!=0;i=i%d){
            if(map.get(i)!=null) break;
            map.put(i,sb.length());
            i=i*10;
            sb.append(i/d);
        }
        if(i==0) return sb.toString();
        sb.insert(map.get(i),"(");
        sb.append(")");
        return sb.toString();
    }
}
public class Solution {
    public static double findNthRootOfM(int n, long m) {
    	double power = (double)1 / (double)n;
        return Math.pow(m, power);
    }
}

package test;




import java.math.BigInteger;

//阶乘递归练习
public class RecursionTest {
    public static void main(String[] args) {
        BigInteger times = times(100);
        System.out.println(times);
    }

    public static BigInteger times(int n){
        if (n==0){
            return BigInteger.valueOf(1);
        }else {
            return BigInteger.valueOf(n).multiply(times(n-1));
        }
    }
}

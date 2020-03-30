package day04.string;

public class BF {

    public int bf(String source, String target) {
        if (source == null || source.length() == 0 || target == null || target.length() == 0) {
            return -1;
        }
        char[] sourceArr = source.toCharArray();
        char[] targetArr = target.toCharArray();


        int i = 0;
        int j = 0;

        while (i < source.length() && j < target.length()) {
            if (sourceArr[i] == targetArr[j]) {
                if (j==target.length()-1){
                    return i-j+1;
                }

                i++;
                j++;

            }else {
                i++;
                j=0;

            }
        }
        return -1;
    }


    public static void main(String[] args) {
        BF bf = new BF();
        String a = "abadfdcdsacsdd";
        String b = "sa";
        int bf1 = bf.bf(a, b);
        System.out.println(bf1);
    }
}

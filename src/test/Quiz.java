package test;

import java.util.HashSet;
import java.util.Set;

public class Quiz {
    public static void main(String[] args) {

        for (int a = 0; a < 10; a++) {
            for (int b = 0; b < 10; b++) {
                for (int c = 0; c < 10; c++) {
                    for (int d = 2; d < 10; d++) {
                        for (int e = 0; e < 10; e++) {
                            for (int f = 0; f < 10; f++) {
                                    for (int g = 0; g < 10; g++) {
                                        for (int h = 0; h < 10; h++) {
                                            for (int j = 0; j < 10; j++) {
                                                for (int k = 0; k < 10; k++) {
                                                    Set<Integer> set = new HashSet<>();
                                                    set.add(a);
                                                    set.add(b);
                                                    set.add(c);
                                                    set.add(d);
                                                    set.add(e);
                                                    set.add(f);
                                                    set.add(g);
                                                    set.add(h);
                                                    set.add(j);
                                                    set.add(k);
                                                    if(set.size()<=10){
                                                        continue;
                                                    }
                                                    if ((a * 1000 + b * 100 + c * 10 + d) / d == (e * 1000 + e * 100 * e * 10 + f)) {
                                                        if ((e * 1000 + e * 100 * e * 10 + f) + (g * 1000 + g * 100 + d * 10 + k) == (j * 1000 + j * 100 + f * 10 + h)){


                                                                                System.out.println("A:" + a);
                                                                                System.out.println("B:" + b);
                                                                                System.out.println("C:" + c);
                                                                                System.out.println("D:" + d);
                                                                                System.out.println("E:" + e);
                                                                                System.out.println("F:" + f);
                                                                                System.out.println("G:" + g);
                                                                                System.out.println("H:" + h);
                                                                                System.out.println("J:" + j);
                                                                                System.out.println("K:" + k);


                                                                            }

                                            }}
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }


    }

    public void test() {

        for (int a = 0; a < 10; a++) {
            for (int b = 0; b < 10; b++) {
                for (int c = 0; c < 10; c++) {
                    for (int d = 1; d < 10; d++) {
                        for (int e = 0; e < 10; e++) {
                            for (int f = 0; f < 10; f++) {
                                if ((a * 1000 + b * 100 + c * 10 + d) / d == (e * 1000 + e * 100 * e * 10 + f)) {
                                    for (int g = 0; g < 10; g++) {
                                        for (int h = 0; h < 10; h++) {
                                            for (int j = 0; j < 10; j++) {
                                                for (int k = 0; k < 10; k++) {
                                                    if (d + (d * 100 + k * 10 + j) == (d * 100 + k * 10 + b)) {
                                                        if ((a * 1000 + b * 100 + c * 10 + d) - (g * 1000 + h * 100 + j * 10 + f) == (j * 1000 + k * 100 + d * 10 + a)) {
                                                            if ((g * 1000 + h * 100 + j * 10 + f) - (d * 100 + k * 10 + j) == (g * 1000 + g * 100 + d * 10 + k)) {
                                                                if ((j * 1000 + k * 100 + d * 10 + a) + (d * 100 + k * 10 + b) == (j * 1000 + j * 100 + f * 10 + h)) {
                                                                    if ((e * 1000 + e * 100 * e * 10 + f) + (g * 1000 + g * 100 + d * 10 + k) == (j * 1000 + j * 100 + f * 10 + h)) {
                                                                        if ((j * 10 + k) / (k * 10 + h) == g) {
                                                                           /* Set<Integer> set = new HashSet<>();
                                                                            set.add(a);
                                                                            set.add(b);
                                                                            set.add(c);
                                                                            set.add(d);
                                                                            set.add(e);
                                                                            set.add(f);
                                                                            set.add(g);
                                                                            set.add(h);
                                                                            set.add(j);
                                                                            set.add(k);
                                                                            if (set.size() == 10) {*/
                                                                            System.out.println("A:" + a);
                                                                            System.out.println("B:" + b);
                                                                            System.out.println("C:" + c);
                                                                            System.out.println("D:" + d);
                                                                            System.out.println("E:" + e);
                                                                            System.out.println("F:" + f);
                                                                            System.out.println("G:" + g);
                                                                            System.out.println("H:" + h);
                                                                            System.out.println("J:" + j);
                                                                            System.out.println("K:" + k);

                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

package io.github.evenX86.java.base;

/**
 * Created with design-pattern-training
 *
 * @author xuyifei
 * @date 2019-11-28 8:07 AM
 */
public class CpuCacheTest {
    private static final int INFINATE = 1024 * 10;

    public static void main(String[] args) {
        int[][] arr = new int[INFINATE][INFINATE];
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < INFINATE; i++) {
            for (int j = 0;j<INFINATE; j++) {
                arr[j][i] = 0;
            }
        }
        System.out.println(System.currentTimeMillis() - startTime + " ms");
        long startTime2 = System.currentTimeMillis();

        for (int i = 0; i < INFINATE; i ++) {
            for (int j=0;j<INFINATE ;j++) {
                arr[i][j] = 0;
            }
        }
        System.out.println(System.currentTimeMillis() - startTime2 + " ms");

    }
}

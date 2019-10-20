package io.github.evenX86.algo;

/**
 * Created with design-pattern-training
 *
 * @author xuyifei
 * @date 2019-09-17 10:22 PM
 */
public class MergeSort {
    public void merge(int[]A,int p, int r) {
        if (p >= r) {
            return;
        }
        int q = (p+r)/2;
        merge(A, p, q);
        merge(A, q+1, r);
        merge_1(A,p,q,r);
    }

    private void merge_1(int[] a, int p, int q, int r) {
        int i=p,j=q+1,k=0;
        int[] tmp = new int[r-p+1];
        while (i<=q && j<=r) {
            if (a[i] <= a[j]) {
                tmp[k++] = a[i++];
            } else {
                tmp[k++] = a[j++];
            }
        }
        int start = i;
        int end = q;
        if (j<=r) {
            start = j;
            end = r;
        }
        while (start<=end) {
            tmp[k++] = a[start++];
        }
        for (int ord = 0 ; ord <= r-p ; ord ++) {
            a[p+ord] = tmp[ord];
        }
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] A = new int[]{1,2,6,4,5};
        mergeSort.merge(A,0, 4);
        for (int val : A) {
            System.out.println(val);
        }

    }
}

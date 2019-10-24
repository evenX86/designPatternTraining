package io.github.evenX86.algo.sort;

import io.github.evenX86.algo.MergeSort;

/**
 * Created with design-pattern-training
 *
 * @author xuyifei
 * @date 2019-03-21 5:37 PM
 */
public class QuickSort implements BaseSort{
    @Override
    public int[] sort(int[] arr, int n) {
        sort(arr, 0 , n-1);
        return arr;
    }

    public void sort(int[] arr, int p, int r) {
        if (p>=r) { return ; }
        int q = partition(arr, p ,r);
        sort(arr, p ,q-1);
        sort(arr, q+1, r);
    }

    private int partition(int[] arr, int p, int r) {
        int pivot = arr[r];
        int i = p;

        for (int j = p ; j<r; j++) {
            if (arr[j] < pivot) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i ++;
            }
        }
        int tmp = arr[i];
        arr[i] = pivot;
        arr[r] = tmp;
        return i;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] A = new int[]{3,8,11,9,7,1,2,5};
        quickSort.sort(A, 8);
        for (int val : A) {
            System.out.println(val);
        }

    }
}

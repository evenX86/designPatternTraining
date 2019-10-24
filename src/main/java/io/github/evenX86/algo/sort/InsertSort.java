package io.github.evenX86.algo.sort;

/**
 * Created with design-pattern-training
 * <p>
 * 插入排序也包含两种操作，一种是元素的比较，一种是元素的移动。当我们需要将一个数据 a 插入到已排序区间时，
 * 需要拿 a 与已排序区间的元素依次比较大小，找到合适的插入位置。找到插入点之后，我们还需要将插入点之后的元素顺序往后移动一位，
 * 这样才能腾出位置给元素 a 插入。
 *
 * @author xuyifei
 * @date 2019-10-23 9:19 PM
 */
public class InsertSort implements BaseSort {

    @Override
    public int[] sort(int[] arr, int n) {
        if (n <= 1) {
            return arr;
        }

        //4,5,7,1,6,2
        //1,4,5,7,6,2
        for (int i = 1; i < n; ++i) {
            int val = arr[i];
            int j = i - 1;
            for (; j >= 0; --j) {
                if (arr[j] < val) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = val;
        }
        return arr;
    }

    public static void main(String[] args) {
        InsertSort insertSort = new InsertSort();
        int[] arr = new int[]{4, 3, 2, 5, 3};
        for (int i : insertSort.sort(arr, 5)) {
            System.out.println(i);
        }
    }
}

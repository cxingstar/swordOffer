package groundtrue.chapters12.sort;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class quickSort {
    public void quickSort(int[] num, int left, int right) {
        if(left >= right)                //如果left等于right，即数组只有一个元素，直接返回
            return;
        int key = num[left];             //设置最左边的元素为基准值
        int i = left;
        int j = right;
        while(i < j){
            while(num[j] >= key && i < j)  //j向左移，直到遇到比key小的值
                j--;
            while(num[i] <= key && i < j)  //i向右移，直到遇到比key大的值
                i++;
            if(i < j){                     //i和j指向的元素交换
                int tmp=num[i];
                num[i]=num[j];
                num[j]=tmp;
            }
        }
        num[left]=num[i];
        num[i]=key;
        quickSort(num,left,i-1);
        quickSort(num,i+1,right);
    }



    public static void main(String[] args) {
        quickSort method = new quickSort();
        int[] nums = new int[]{1,12,231,34,123,34,45};
        method.quickSort(nums,0,nums.length -1);
        System.out.println(Arrays.toString(nums));
    }
}

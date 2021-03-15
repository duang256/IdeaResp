package sort;

import java.util.Arrays;


public class quickSort {
    public static void main(String[] args) {
        int arr[]={72,6,57,88,60,42,83,73,48,85};
        System.out.println(Arrays.toString(arr));
        sort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr, int low, int high) {
        if(low<high){//当low==high时，排序结束
            int index=partition(arr,low,high);  //不停的递归进行多次分区
            sort(arr,index+1,high);
            sort(arr,low,index-1);
        }

    }

    private static int partition(int[] arr, int low, int high) {
        int i=low;
        int j=high;
        int x=arr[low];
        while(i<j){
            while(i<j&&arr[j]>x){
                j--;
            }
            if(i<j){
                arr[i]=arr[j];
                i++;
            }
            while(i<j&&arr[i]<=x){
                i++;
            }
            if(i<j){
                arr[j]=arr[i];
                j--;
            }

        }
        arr[i]=x;
        return i;
    }


}

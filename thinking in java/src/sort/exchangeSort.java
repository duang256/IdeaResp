package sort;

import java.util.Arrays;

public class exchangeSort {
    public static void main(String[] args) {
        //冒泡排序
        int arr[]={7,5,6,8,9,1,4,3,2,0};
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int t;
                    t=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=t;
                }
            }

        }
        System.out.println(Arrays.toString(arr));
    }
}

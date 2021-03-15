package sort;

import java.util.Arrays;

public class selectSort {
    public static void main(String[] args) {
        //选择排序
        int arr[]={7,5,6,8,9,1,4,3,2,0};
        for(int i=0;i<arr.length-1;i++){
            for(int j=i;j<arr.length;j++){
                if(arr[i]>arr[j]){
                    int t;
                    t=arr[i];
                    arr[i]=arr[j];
                    arr[j]=t;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}

package sort;

import java.util.Arrays;

public class insetSort {
    public static void main(String[] args) {
        int arr[]={7,5,6,8,9,1,4,3,2,0};

        //直接插入排序是从第二项开始排序，假设这里是递增排序，第二项与第一项比较
        //如果，第一项大于第二项，什么也不做，不进入循环，否则第一项就往后移动一位，第二项补前面去
        //同理当前项前面如果有小于的，就将他们中间的全部后移，然后插入
        for(int i=1;i<arr.length;i++){
            int temp=arr[i];
            int j=i;
            while(j>0&&arr[j-1]>temp){
                arr[j]=arr[j-1];
                j--;
            }
            arr[j]=temp;
        }
        System.out.println(Arrays.toString(arr));



    }
}

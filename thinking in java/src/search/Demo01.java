package search;

public class Demo01 {
    public static void main(String[] args) {
        int []scores=new int[]{12,24,35,46,57,68,79,80,99,100};
        int score=100;
        int index=-1;

        index=searching(score,scores);


        if(index==-1){
            System.out.println("该数不存在");
        }else{
            System.out.println("该数索引为："+index);
        }


    }

    public static  int searching(int score,int []scores){
        int low=0;
        int high=scores.length-1;
        return searching(score,scores,low,high);

    }
    public static  int searching(int score,int []scores,int low,int high){
        int mid=(low+high)/2;
        if(scores[mid]==score){
            return mid;
        }else if(low>high){
            return -1;
        }else if(scores[mid]>score){
            return searching(score,scores,low,mid-1);
        }else if(scores[mid]<score){
            return searching(score,scores,mid+1,high);
        }
        return -1;
    }
}

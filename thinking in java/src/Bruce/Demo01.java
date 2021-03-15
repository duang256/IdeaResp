package Bruce;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class Demo01 {
    public static void main(String[] args) {

    }
    public void fun(int a[],int n,int k){
        int i;
        if(k==n-1){
            for(i=0;i<n;i++){
                System.out.println(a[i]);
            }
        }
        else {
            for(i=k;i<n;i++){
                a[i]=a[i]+i*i;
                fun(a,n,k+1);
            }
        }
    }
}

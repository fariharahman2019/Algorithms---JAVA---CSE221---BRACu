import java.util.*;
import java.io.*;

public class Task02 {
    public static void main(String args[]){
        try{
            String str;
            FileReader fr = new FileReader("C:\\Users\\Fariha Rahman\\Desktop\\BRAC\\5th Semester\\CSE221\\Assignment2_221\\Task02.txt");
            BufferedReader obj = new BufferedReader(fr);
            str = obj.readLine();
            int n = Integer.parseInt(str); // number of nodes
            int graph[][] = new int[n][n];
            String b[] = new String[n];
            str = obj.readLine();
            int m=Integer.parseInt(str); // number of connecting routes
            for(int i=0;i<m;i++){
                str = obj.readLine();
                StringTokenizer st = new StringTokenizer(str,",");
                int token1 = Integer.parseInt(st.nextToken());
                int token2 = Integer.parseInt(st.nextToken());
                int token3 = Integer.parseInt(st.nextToken());
                graph [token1][token2] = token3; 
            }
            str = obj.readLine();
            int s=Integer.parseInt(str); //source
            str = obj.readLine();
            int d=Integer.parseInt(str); //destination
            
            str = obj.readLine();
            StringTokenizer y = new StringTokenizer(str,",");
            int y1 = Integer.parseInt(y.nextToken());
            int y2 = Integer.parseInt(y.nextToken());
            int y3 = Integer.parseInt(y.nextToken());
            int y4 = Integer.parseInt(y.nextToken());
            
            for(int i=0;i<n;i++){
                if(i==y1||i==y2||i==y3||i==y4){
                    b[i]="Yellow";
                }
            }
            String nodeLocation[]={"Mouchak","Panthapath","Rampura","Shahbagh","Dhanmondi","Lalmatia","Badda","Hatirjheel","Nilkhet","TSC","Dhaka University","BUET"};
            Dijkstra dj=new Dijkstra(n,graph,b);
            dj.djkPath(s,d);
            int k=d;
            int count=0;
            while (dj.parent[k]!=0){
                count++;
                k=dj.parent[k];
            }
            String [] arr=new String [count+2];
            arr[0]=nodeLocation[d];
            arr[arr.length-1]=nodeLocation[s];
            k=d;
            for(int i=1;i<arr.length-1;i++){
                k=dj.parent[k];
                arr[i]=nodeLocation[k];
            }
            for(int i=arr.length-1;i>0;i--){
                System.out.print(arr[i]+ "->");
            }
            System.out.println(arr[0]);
            System.out.println("Path Cost : "+dj.distance[d]);
            
        }
        catch(IOException e){
            System.out.println("File not found");
        }
    }
}

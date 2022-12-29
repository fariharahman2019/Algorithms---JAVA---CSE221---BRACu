import java.util.*;
import java.io.*;

public class Task01 {
    public static void main(String[] args) {
      
      try{
            String str;
            FileReader fr = new FileReader("C:\\Users\\Fariha Rahman\\Desktop\\BRAC\\5th Semester\\CSE221\\Assignment2_221\\Task01.txt");
            BufferedReader obj = new BufferedReader(fr);
            str = obj.readLine();
            StringTokenizer st = new StringTokenizer(str," ");
            int n = Integer.parseInt(st.nextToken()); //number of countries
            int m = Integer.parseInt(st.nextToken()); // number of flights
            int x = Integer.parseInt(st.nextToken()); // number of continental hotels location
            int q = Integer.parseInt(st.nextToken()); // number of missions
            int graph[][] = new int[n][n];

            for(int i=0;i<m;i++){
                str = obj.readLine();
                StringTokenizer s = new StringTokenizer(str," ");
                int token1 = Integer.parseInt(s.nextToken());
                int token2 = Integer.parseInt(s.nextToken());
                int token3 = Integer.parseInt(s.nextToken());
                graph [token1-1][token2-1] = token3; 
            }
            
            int [] path=new int[q];
            for(int i=0;i<q;i++){
                Dijkstra d= new Dijkstra(n,graph);
                str = obj.readLine();
                StringTokenizer y = new StringTokenizer(str," ");
                int s = Integer.parseInt(y.nextToken()); //source
                int t = Integer.parseInt(y.nextToken()); //destination
                path[i]= d.dijkstra(s-1, x-1)+ d.dijkstra(x-1, t-1);
            }
            
            for(int i=0; i<q;i++){
                if(path[i]== 9999999)
                    System.out.println("Be seeing ya, John");
                else
                    System.out.println("Case "+(i+1)+" : "+path[i]);
            }
        }
        catch(IOException e){
            System.out.println("File not found");
        }
    }
}

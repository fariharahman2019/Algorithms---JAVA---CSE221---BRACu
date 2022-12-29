/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab04;

/**
 *
 * @author mahad
 */
import java.util.*;
import java.io.*;

public class Task02 {
    public static void main(String[] args) {
        try{
            FileReader fr = new FileReader("C:\\Users\\mahad\\Desktop\\input_2.txt");
            BufferedReader obj = new BufferedReader(fr);
            String str = obj.readLine();
            int maxWeight = Integer.parseInt(str);
            str = obj.readLine();
            int itemCount = Integer.parseInt(str);
            String club[] = new String[itemCount];
            int weight[] = new int[itemCount+1];
            double benefit[] = new double[itemCount+1];
            //String trophy[] = new String[itemCount];
            
            double v[][] = new double[itemCount + 1][maxWeight + 1];
            String b[][]=new String[itemCount+1][maxWeight+1];

            for (int i = 0; i < itemCount; i++) {
                str = obj.readLine();
                StringTokenizer st = new StringTokenizer(str," ");
                club[i] = st.nextToken();
                weight[i+1] = Integer.parseInt(st.nextToken());
                benefit[i+1] = Double.parseDouble(st.nextToken());
                //trophy[i] = st.nextToken();
            }
            for(int i=0;i<=itemCount;i++){
                v[i][0]=0;
            }
            for(int w=0;w<=maxWeight;w++){
                v[0][w]=0;
            }
            for(int i=1;i<=itemCount;i++){
                for(int w=1;w<=maxWeight;w++){
                    if(weight[i]<=w){
                        if(benefit[i]+v[i-1][w-weight[i]]>v[i-1][w]){
                            v[i][w]=benefit[i]+v[i-1][w-weight[i]];
                            b[i][w]="DIAGONAL";
                        }
                        else{
                            v[i][w]=v[i-1][w];
                            b[i][w]="UPWARD";
                        }
                    }
                    else{
                        v[i][w]=v[i-1][w];
                        b[i][w]="UPWARD";
                    }
                }
            }
            int i=itemCount;
            int w=maxWeight;
            Stack<Integer> s = new Stack<Integer>();
            while(b[i][w] !=null){
                if(b[i][w].equals("DIAGONAL")){
                    
                    s.push(i);
                    w -= weight[i];
                    i--;
                }
                else if(b[i][w].equals("UPWARD")){
                    i--;
                }
            }
            int temp;
            System.out.println("Name of clubs whose trophies were sold:");
            while(!s.isEmpty()){
                temp=s.pop();
                System.out.print(club[temp-1]+"->");
            }
            System.out.println();
            System.out.println("Maximum money he earned: "+v[itemCount][maxWeight]+" million");
        }
        catch(IOException e){
            System.out.println("File not found");
        }
    }
}

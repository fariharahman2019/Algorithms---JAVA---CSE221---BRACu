/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab03;

/**
 *
 * @author mahad
 */
import java.util.*;
import java.io.*;

public class Task01 {
    public static void main(String args[]){
        try{
            FileReader fr = new FileReader("C:\\Users\\mahad\\Desktop\\Task01.txt");
            BufferedReader obj = new BufferedReader(fr);
            String x = obj.readLine();
            String y = obj.readLine();
            int m=x.length();
            int n=y.length(); 
            int c[][]=new int[m+1][n+1];
            String b[][]=new String[m+1][n+1];
            for(int i=1;i<m;i++){
                c[i][0]=0;
            }
            for(int j=0;j<n;j++){
                c[0][j]=0;
            }
            for(int i=1;i<=m;i++){
                for(int j=1;j<=n;j++){
                    if(x.charAt(i-1) == y.charAt(j-1)){
                        c[i][j]=c[i-1][j-1]+1;
                        b[i][j]="DIAGONAL";
                    }
                    else if(c[i-1][j] > c[i][j-1]){
                        c[i][j]=c[i-1][j];
                        b[i][j]="UP";
                    }
                    else{  
                        c[i][j]=c[i][j-1];
                        b[i][j]="LEFT";
                    }  
                }
            }
            
            Stack<Character> s = new Stack<Character>();
            int i=m;
            int j=n;
            while(b[i][j]!= null){
                if(b[i][j].equals("DIAGONAL")){
                    s.push(x.charAt(i-1));
                    i--;
                    j--;
                }
                else if(b[i][j].equals("LEFT")){
                    j--;
                }
                else if(b[i][j].equals("UP")){
                    i--;
                }
            }
            double lcs = c[m][n];
            double tls = x.length();
            double a = (lcs/tls)*100;
            int accuracy = (int)a;
            if(accuracy >= 50){
                System.out.println(accuracy+"% Passed");
            }
            
            while(!s.isEmpty()){
                System.out.print(s.pop());
            }
            System.out.println();
        }
        catch(IOException e){
            System.out.println("File not found");
        }
    }
}

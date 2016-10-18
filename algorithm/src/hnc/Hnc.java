package hnc;

import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class Hnc {
	   public static void main(String[] args) throws IOException {
		      
		      Hnc h = new Hnc();
		      int result=0;
		      //src/hnc/
		   //System.out.println("헤헤:"+args[0]);
		      //"src/hnc/input.txt"
		   //   System.out.println(args[1]);
		      String path = System.getProperty("user.dir");
		      System.out.println(path);
		      
		      Scanner sc = new Scanner(System.in);
		      while(sc.hasNext()){
		         int testCase = sc.nextInt();
		         for(int i=0;i<testCase;i++){
		          result = h.getN(Math.abs(sc.nextInt()));
		           
		         }
		         System.out.println(result);
		      }
		      sc.close();
		   }
		   
		   public int getN(int x){
		      
		   int sum=1;
		   int cnt=1;
		   while(true){
		      if(x<=sum){
		         break;
		      }
		      cnt++;
		       sum = sum + cnt;
		   }
		   
		   if((sum-x)%2==0 || x==sum){ //짝수인경우
		          return cnt;
		   }else{
		        return cnt+2;
		   }
		   
		   }

}

package exampleNHN;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Num4 {
	 public static void main(String[] args) {
	        ArrayList<Integer> numberList = new ArrayList<Integer>();

	        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
	            String input = br.readLine();
	            String[] numStrList = input.split(" ");
	            for (String numStr : numStrList) {
	                numberList.add(Integer.parseInt(numStr));
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
//	        int[] suOrder = getBigNum(numberList);
	        String result = "";
	        
	        int[] rankList = new int[numberList.size()];
	        for(int i=0; i<numberList.size(); i++){
	        	int p=0;
	        	int q=0;
	        	int num=numberList.get(i);
	        	int rank=0;
	        	if(num>=10){
	        		p=num/10;
	        	}else
	        		p=num;
	        	
	        	
	        	for(int j=0; j<numberList.size(); j++){
	        		if(i==j) continue;
	        		int num2 = numberList.get(j);
	        		if(num2>=10){
	        			q=num2/10;
	        		}else
	        			q=num2;
	        		
	        		if(p<q){
	        			rank++;
	        		}else if(p==q){
	        			if(num2<10){
	        				rank++;
	        			}else if(num2>=10 && num%10<num2%10){
	        				rank++;
	        			}else if(num>=10 && num2>=10  && num%10<num2%10){
	        				rank++;
	        			}else if(num2%10==num%10){
	        				rank++;
	        			}
	        		}
	        	}
	        	rankList[rank]=numberList.get(i);
	        }
	        
	        for(int a : rankList)
	        result = result+ a;
	        
	        System.out.println(result);
	 }
	 
	 public static int[] getBigNum(ArrayList<Integer> numList){
		 int k=0;
		 int l=0;
		 int q=0;
		 int[] intArray = new int[numList.size()];
		 for(int i=0; i<numList.size(); i++){
			 int a = numList.get(i);
			 if(a>=10){
				 k=a/10;
			 }else{
				 k=a;
			 }
			 for(int j=0; j<numList.size() && i!=j ; j++){
				 int b = numList.get(j);
				 if(b>=10){
					 l=b/10;
				 }else{
					 l=b;
				 }
				 if(k<l){
					 intArray[i]=numList.get(j);
				 }else if(k==l){
					 if(b<10){
						 intArray[i]=numList.get(j);
					 }else if(a%10<b%10)
						 intArray[i]=numList.get(j);
					 else
						 intArray[i]=numList.get(i);
				 }
			 }
		 }
		 for(int a:intArray){
			 System.out.println(a);
		 }
		 return intArray;
	 }

}

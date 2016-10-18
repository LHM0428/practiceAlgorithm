package exampleNHN;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num3 {
	public static void main(String[] args) {
        int number = 0;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String line = br.readLine();
            number = Integer.parseInt(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int value=0;
        int newNum=0;
        for(int i=0; i<3; i++){
            newNum = getChangeNum(number);
            value = number+newNum;
            if(value==getChangeNum(value))
            	break;
            else{
            	if(i==2){
            		value=-1;
            	}
            }
            number = value;
        }
        System.out.println(value);
    }
	
	public static int getChangeNum(int number){
		int num3=0;
		int num2=0;
		int num1=0;
		int result=0;
		if(number>=100){
			num3=number/100;
			number=number%100;
			num2=number/10;
			number=number%10;
			num1=number;
			result=num1*100+num2*10+num3;
		}else if(number < 100 && number>=10){
			num2=number/10;
			number=number%10;
			num1=number;
			result = num1*10+num2;
		}else if(number <10){
			num1=number;
			result = number;
		}
		
		return result;
	}
}

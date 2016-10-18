package exampleNHN;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Num2 {

    public static void main(String[] args) {
        String[] words = null;
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String line = br.readLine();
            words = line.split(" ");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        ArrayList<String> firstFilter = new ArrayList<>();
        for (String word : words) {
        	
            for(int i=0; i<word.length()-1; i++){
            	if(word.charAt(i)=='a' || word.charAt(i)=='e' || word.charAt(i)=='e' || word.charAt(i)=='o'||
            			word.charAt(i)=='u'){
            		if(word.charAt(i+1)=='a' || word.charAt(i+1)=='e' || word.charAt(i+1)=='e' || word.charAt(i+1)=='o'||
                			word.charAt(i+1)=='u'){
            			firstFilter.add(word);
            			break;
            		}
            	}
            }
        }
        
        ArrayList<String> result = new ArrayList<>();
        for (String word : words){
        	/*if(word.length()<3)
        		continue;*/
        	
            for(int i=0; i<word.length()-2; i++){
            	if(word.charAt(i)!='a' && word.charAt(i)!='e' && word.charAt(i)!='e' && word.charAt(i)!='o'&&
            			word.charAt(i)!='u'){
            		if(word.charAt(i+1)!='a' && word.charAt(i+1)!='e' && word.charAt(i+1)!='e' && word.charAt(i+1)!='o'
                		&&	word.charAt(i+1)!='u'){
            			if(word.charAt(i+2)!='a' && word.charAt(i+2)!='e' && word.charAt(i+2)!='e' && word.charAt(i+2)!='o'&&
                    			word.charAt(i+2)!='u'){
            				result.add(word);
            				break;
                		}
            		}
            	}
            }
        }
        System.out.println(firstFilter.size());
        System.out.println(result.size());
    }
}

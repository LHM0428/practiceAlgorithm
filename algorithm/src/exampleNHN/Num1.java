package exampleNHN;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Num1 {
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

		ArrayList<Integer[]> numList = new ArrayList<Integer[]>();
		int numTemp;
		int addrNum = 0;
		int c = 0;
		for (int i = 0; i < numberList.size() - 1; i++) { // 6 20 34 8 38 40 À»
			int check = 0;
			for (int j = i + 1; j < numberList.size(); j++) {
				numTemp = Math.abs(numberList.get(i) - numberList.get(j));
				if (j == 1)
					c = numTemp;

				if (c >= numTemp) {
					c = numTemp;
					addrNum = j;
				}
			}
			for (int p = 0; p < numList.size(); p++) {
				if (numList.get(p)[0] == numberList.get(addrNum))
					check = 1;
				if (numList.get(p)[1] == numberList.get(addrNum))
					check = 1;
			}
			if (check != 1) {
				Integer[] numArray = new Integer[3];
				numArray[0] = numberList.get(i);
				numArray[1] = numberList.get(addrNum);
				numArray[2] = c;
				numList.add(numArray);
			}
		}

		addrNum = 0;
		for (int k = 0; k < numList.size(); k++) {
			Integer[] numArray2 = numList.get(k);
			numTemp = numArray2[0] + numArray2[1];
			if (k == 0) {
				c = numTemp;
			}
			if (c > numTemp) {
				addrNum = k;
			}
		}
		Integer[] numArray3 = numList.get(addrNum);
		System.out.println(numArray3[0] + " " + numArray3[1]);
	}
}

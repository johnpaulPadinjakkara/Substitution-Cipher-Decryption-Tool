package Model;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author: Bharathi, Johnpaul 
 * @Student_Number: 201595964, 201599234
 * @email: mailto:bs6523@mun.ca, jjpadinjakka@mun.ca
 */


public class Encryption {
	public static String key;
	public static String alphabets;


	public Encryption() {
		// TODO Auto-generated constructor stub
	}
	
	public static String encrypt (String plainText){
		plainText = plainText.toUpperCase();
		int i;
		int j;
		int n;
		int repetationCheck;
		ArrayList<Integer> randomMapping = new ArrayList<Integer>();
		ArrayList<Character> alphabetsEng = new ArrayList<Character>();
		ArrayList<Character> keyEng = new ArrayList<Character>();
		for(i=0; i< 26;i++) {
			alphabetsEng.add((char)(65 + i));
		}

		while (randomMapping.size() < 26) {
			Random rand = new Random();
			for ( i = 1; i <= 26; i++) {

				repetationCheck = 0;
				 n = rand.nextInt(26) + 1;

				for ( j = 0; j < randomMapping.size(); j++) {
					if (n == randomMapping.get(j)) {
						repetationCheck++;
					}
				}
				if (repetationCheck == 0) {
					randomMapping.add(n);
				} else {
					i--;
				}
			}
			
		}
		
		
		for(i= 0; i < 26; i++) {
				keyEng.add(alphabetsEng.get(randomMapping.get(i)-1));
			}
			
		
		System.out.println("Alphabets  : " + alphabetsEng);
		System.out.println("Key        : " + keyEng);
		
		Encryption.alphabets = alphabetsEng.toString();
		Encryption.key = keyEng.toString();
		
		ArrayList<Character> cipherText = new ArrayList<Character>();
		
		for(i = 0; i < plainText.length(); i++ ) {
			
		//	System.out.println(plainText.charAt(i));
			if(!(Encryption.key.contains(plainText.charAt(i) + ""))) {
				
				cipherText.add(plainText.charAt(i));
				
			}else {
			int locOfKey = Encryption.alphabets.indexOf(plainText.charAt(i));
			cipherText.add(key.charAt(locOfKey));
			}
			
			
		}
		String temp = "";
		for(char c : cipherText) {
			temp += c;
		System.out.println(c);
		}
		return temp;
		
	}

}


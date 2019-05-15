/**
 * 
 */
package Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/*@Fitness.java*/
/**
 * @author: Bharathi, Johnpaul
 * @Student_Number: 201595964, 201599234
 * @email: mailto:bs6523@mun.ca, jjpadinjakka@mun.ca
 */
public class Fitness {
	public static final ArrayList<String> OEC_Words = new ArrayList<String>(
			Arrays.asList("THE", "BE", "TO", "OF", "AND", "A", "IN", "THAT", "HAVE", "I", "DO", "BUT", "BY"));

	/**
	 * 
	 */
	public Fitness() {
		// TODO Auto-generated constructor stub
	}

	public static String Decryption(ArrayList<Character> key, String EncryptedText) {

		ArrayList<Character> alphabetsEng = new ArrayList<Character>();
		String Replaced = "";

		String keyString = key.toString();

		// have to change to const
		for (int i = 0; i < 26; i++) {
			alphabetsEng.add((char) (65 + i));
		}

		String alphabetsString = alphabetsEng.toString();

		// System.out.println(alphabetsEng);
		// System.out.println(key);

		for (int i = 0; i < EncryptedText.length(); i++) {

			if (keyString.contains(EncryptedText.charAt(i) + "")) {
				int locOfKey = keyString.indexOf(EncryptedText.charAt(i));
				Replaced += alphabetsString.charAt(locOfKey);
			} else {
				Replaced += EncryptedText.charAt(i);
			}
		}

		return Replaced;
	}

	public static double fitness(ArrayList<Character> key, String EncryptedText,
			HashMap<String, Integer> TrainingNgrams, int N_Gram) {

		Double Fitness = 0.0;
		String Decrypted_Text = Decryption(key, EncryptedText);
		HashMap<String, Integer> DecrypedTextNgrams = Model.Ngrams.Ngram(Decrypted_Text, N_Gram);

		Integer x = 0;

		for (HashMap.Entry<String, Integer> entry : DecrypedTextNgrams.entrySet()) {
			// model.addRow(new Object[]{entry.getKey(), entry.getValue()});

			if (TrainingNgrams.containsKey(entry.getKey())) {
				x = TrainingNgrams.get(entry.getKey());
				Fitness += Math.log(x) / Math.log(2) * entry.getValue();
			} else {

			}
		}

		for (int i = 0; i < OEC_Words.size(); i++) {
			if (Decrypted_Text.contains(" " + OEC_Words.get(i) + " ")) {
				Fitness = Fitness + 0.6;
			}
		}

		return Fitness;

	}
}

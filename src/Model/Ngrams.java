/**
 * 
 */
package Model;

import java.util.HashMap;

/*@Ngrams.java*/
/**
 * @author: Bharathi, Johnpaul
 * @Student_Number: 201595964, 201599234
 * @email: mailto:bs6523@mun.ca, jjpadinjakka@mun.ca
 */
public class Ngrams {

	/**
	 * 
	 */
	public Ngrams() {
		// TODO Auto-generated constructor stub
	}

	public static HashMap<String, Integer> findOccurences(String str, int n) {
		HashMap<String, Integer> map = new HashMap<>();
		int limit = str.length() - (n - 1);
		for (int i = 0; i < limit; i++) {
			String sub = str.substring(i, i + n);
			Integer counter = map.get(sub);
			if (counter == null) {
				counter = 0;
			}
			if (!sub.contains(" ")) {
				map.put(sub, ++counter);
			}
		}
		return map;
	}

	public static HashMap<String, Integer> Ngram(String text, int n) {

		String doc_string = text.replaceAll("[^A-Za-z]", "");
		doc_string = doc_string.toUpperCase();
		String find_word = "";

		doc_string = doc_string.replaceAll("\\s+", " "); // removing all new lines or spaces
		// System.out.println("-- "+doc_string);
		HashMap<String, Integer> result = new HashMap<>();
		result = findOccurences(doc_string, n);

		for (HashMap.Entry<String, Integer> entry : result.entrySet()) {
			find_word = find_word + entry.getKey() + " : " + entry.getValue() + '\n';
			// System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		return result;
	}
}

package Model;

import java.util.ArrayList;
import java.util.Random;

public class Initialize {

	/**
	 * @author: Bharathi, Johnpaul
	 * @Student_Number: 201595964, 201599234
	 * @email: mailto:bs6523@mun.ca, jjpadinjakka@mun.ca
	 */

	public Initialize() {
		// TODO Auto-generated constructor stub
	}

	public static ArrayList<ArrayList<Character>> initializePopulation(int count) {

		ArrayList<ArrayList<Character>> population = new ArrayList<ArrayList<Character>>();
		int repetationCheck;
		int n;
		ArrayList<Character> alphabetsEng = new ArrayList<Character>();
		ArrayList<Integer> randomMapping = new ArrayList<Integer>();

		for (int i = 0; i < 26; i++) {
			alphabetsEng.add((char) (65 + i));
		}

		Random rand = new Random();

		for (int k = 0; k < count; k++) {
			randomMapping.clear();
			ArrayList<Character> keyEng = new ArrayList<Character>();

			while (randomMapping.size() < 26) {
				for (int i = 1; i <= 26; i++) {

					repetationCheck = 0;
					n = rand.nextInt(26) + 1;

					for (int j = 0; j < randomMapping.size(); j++) {
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
			for (int i = 0; i < 26; i++) {
				keyEng.add(alphabetsEng.get(randomMapping.get(i) - 1));
			}
			// System.out.println(keyEng);
			population.add(keyEng);

		}

		// System.out.println("--"+population.get(4).toString());

		return population;
	}
}

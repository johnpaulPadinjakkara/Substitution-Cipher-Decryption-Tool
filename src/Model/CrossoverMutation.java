package Model;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author: Bharathi, Johnpaul
 * @Student_Number: 201595964, 201599234
 * @email: mailto:bs6523@mun.ca, jjpadinjakka@mun.ca
 */

public class CrossoverMutation {

	public CrossoverMutation() {
		// TODO Auto-generated constructor stub
	}

	public static ArrayList<Character> Crossover(ArrayList<Character> parent_1, ArrayList<Character> parent_2,
			int points) {
		ArrayList<Character> cross_individual = new ArrayList<>(26);
		// cross_individual = individual;

		for (int i = 0; i < 26; i++) {
			cross_individual.add((char) (45));
		}

		int Pt1 = 0;
		Random r = new Random();

		for (int x = 0; x < points; x++) {
			Pt1 = r.nextInt(25);
			cross_individual.set(Pt1, parent_1.get(Pt1));
		}

		// System.out.println("Parent1 : " + parent_1);
		// System.out.println("Parent2 : " + parent_2);

		// System.out.println("Pppppp1 : " + cross_individual);

		int po = 0;

		for (int i = 0; i < 26; i++) {

			if (cross_individual.contains(parent_2.get(i))) {
			} else {
				while (cross_individual.get(po) != '-') {
					po++;
				}
				cross_individual.set(po, parent_2.get(i));
			}
		}

		// System.out.println("Pppppp2 : " + cross_individual);
		return cross_individual;

	}

	public static ArrayList<Character> mutate(ArrayList<Character> individual) {
		ArrayList<Character> mutated_individual = new ArrayList<>();
		mutated_individual = individual;
		char temp;
		int mutPt1 = 0;
		int mutPt2 = 0;
		Random r = new Random();
		mutPt1 = r.nextInt(26);
		mutPt2 = r.nextInt(26);
		temp = individual.get(mutPt1);
		mutated_individual.set(mutPt1, individual.get(mutPt2));
		mutated_individual.set(mutPt2, temp);

		return mutated_individual;

	}

}

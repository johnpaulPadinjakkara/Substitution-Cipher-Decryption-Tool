/**
 * 
 */
package Model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*@FileInputOutput.java*/
/**
 * @author: Bharathi, Johnpaul
 * @Student_Number: 201595964, 201599234
 * @email: mailto:bs6523@mun.ca, jjpadinjakka@mun.ca
 */
public class FileInputOutput {

	// static String filePath = "";
	/**
	 * 
	 */
	public FileInputOutput() {
	}

	public static String readFile(String filePath) throws IOException {

		String everything;

		BufferedReader br = new BufferedReader(new FileReader(filePath));
		try {
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			while (line != null) {
				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();
			}
			everything = sb.toString();
		} finally {
			br.close();
		}

		return everything;
	}
}

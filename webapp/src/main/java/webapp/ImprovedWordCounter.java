package webapp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class ImprovedWordCounter {

	public static void main(String[] args) {
		ArrayList<String> text = new ArrayList<String>();
		StringTokenizer st;
		String word;
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		
		try {
			FileReader file = new FileReader("wordCount.txt");
			BufferedReader buff = new BufferedReader(file);
			boolean eof = false;
			while (!eof) {
				String line = buff.readLine();
				if (line == null) {
					eof = true;

				} else {
					System.out.println(line);
					st = new StringTokenizer(line, " ");

					while (st.hasMoreTokens()) {
						word = st.nextToken();
						if(!hm.containsKey(word)){
							hm.put(word, 1);
						}
						else if(hm.containsKey(word)){
							hm.put(word, hm.get(word)+1);
						}
					}
				}
			}
			buff.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.print(hm.toString());

	}
}

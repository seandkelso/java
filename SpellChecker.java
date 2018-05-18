import java.util.*;
import java.io.*;


public class SpellChecker {

	// find suggestions based on rules
	// append to sugs list
	public static void suggestionsCheck(String word, HashSet<String> dict, 
																			LinkedList<String> sugs) {

		// use HashSet to avoid duplicate suggestions
		HashSet<String> hsSugs = new HashSet<>();

		// Add one character
		// We insert at position i
		for (int i = 0; i <= word.length(); i++) {
			for (char k = 'a'; k <= 'z'; k++) {
				StringBuilder sb = new StringBuilder();
				sb.append(word);
				sb.insert(i, k);


				// if dict contains suggestion
				// and it hasn't been seen before
				String str = sb.toString();
				if (dict.contains(str) && !hsSugs.contains(str)) {
					hsSugs.add(str);
					sugs.add(str);
				}
			}
		}

		// Remove one character
		for (int i = 0; i < word.length(); i++) {
			String str = word.substring(0, i) + word.substring(i+1);
			if (dict.contains(str) && !hsSugs.contains(str)) {
				hsSugs.add(str);
				sugs.add(str);
			}
		}

		// Swap to adjacent characters
		for (int i = 0; i < word.length()-1; i++) { 
			StringBuilder sb = new StringBuilder();
			sb.append(word);
			char prev = word.charAt(i);
			char next = word.charAt(i+1);
			// swap
			sb.setCharAt(i, next);
			sb.setCharAt(i+1, prev);
			String str = sb.toString();
			if (dict.contains(str) && !hsSugs.contains(str)) { 
				hsSugs.add(str);
				sugs.add(str);
			}
		}
	}

	public static final void main(String[] args) {
		//take file names from command line argument
		System.out.println("Dictionary file name: " + args[0]);
		System.out.println("Spellcheck target file name: " + args[1]);
		File dictFile = new File(args[0]);
		File text = new File(args[1]);
		Scanner readDict = null;
		Scanner readText = null;
				
		// in case the user inputs an invalid file - try/catch for both files
		try {
			readDict = new Scanner(dictFile);
			System.out.println("Dictionary text file successfully read.");		
		}
		catch(FileNotFoundException x){
			System.out.println("Reading failed - dictionary file might"
					+ " not exist.");
			System.exit(1);
		}
		try {
			readText = new Scanner(text);
			System.out.println("Spellcheck target file successfully read.");
		}
		catch(FileNotFoundException x){
			System.out.println("Reading failed - spellcheck target"
					+ " file might not exist.");
			System.exit(1);
		}

		// now that we got that mess sorted...
		// read in entire dictionary into HashSet
		HashSet<String> dict = new HashSet<>();
		while(readDict.hasNextLine()) {
			String word = readDict.nextLine().toLowerCase();

			// add to dictionary HashSet
			dict.add(word);
		}
			
		//now working on target file.
		int lineIndex = 1;
		while(readText.hasNextLine()) {
			String nextLine = readText.nextLine();

			// if line is empty
			if(nextLine.length()==0) {
				lineIndex++;
				continue;
			}

			// line isn't empty
			else {
					String line = nextLine.toLowerCase();
			    // parsing line into individual strings demarcated by spaces...
			    String[] lineA = line.split("\\s+");
			    for (String str : lineA) {
						// We use regular expressions to strip all
						// punctuation from the end and beginning
						str = str.replaceAll("[^A-z0-9]+$", "")
							       .replaceAll("^[^A-z0-9]+", "");

						// If we can't find str in dictionary,
						// then perform tests to suggests words
						if (!dict.contains(str)) {
							System.out.print("[" +	lineIndex + "] " + 
																	str + ": ");
							
							// HashSet to make sure suggestions are unique
							// LinkedList to store them
							LinkedList<String> sugs = new LinkedList<>();
							suggestionsCheck(str, dict, sugs);
							System.out.print(sugs);
							System.out.println();
						}
			    }
			    lineIndex++;
			}
		}
	}
}

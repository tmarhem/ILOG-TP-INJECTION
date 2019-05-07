package eu.tl1.injection.tp;

import java.util.HashSet;
import java.util.Set;

public class WordIndexer implements TextAnalyzer {
	
	Set<String> wordSet;
	
	public WordIndexer( Set<String> mySet) {
		wordSet = mySet;
	}
	
	@Override
	public void processLine(String text) {
		String[] textWords = text.split("\\s");
		for (String word : textWords) {
			if(!wordSet.contains(word))	wordSet.add(word);	
		}
	}

	@Override
	public Object getResult() {
		return wordSet;
	}

	@Override
	public void reset() {
		wordSet = new HashSet<String>();
	}

}

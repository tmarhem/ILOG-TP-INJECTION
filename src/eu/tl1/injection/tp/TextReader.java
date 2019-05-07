package eu.tl1.injection.tp;

import java.util.List;

public class TextReader {
	
	protected TextAnalyzer txtAnalyzer;

	public TextReader( TextAnalyzer tA) {
		super();
		this.txtAnalyzer = tA;

	} 

	public void scan(List<String> text) {
		for (String line: text) {
			txtAnalyzer.processLine(line);
		}
	}
	
	public Object getResult() {
		return txtAnalyzer.getResult();
	}
	
	public void reset() {
		txtAnalyzer.reset();
	}
}

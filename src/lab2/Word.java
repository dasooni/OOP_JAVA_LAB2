package lab2;

public class Word {
	
	private String theWord;
	private int counts, outputformat;
    
    
    public Word(String Word) {
    	theWord = Word;
    }
    
    public String getWord() {
    	return theWord;
    }
    
    public int getCounts() {
    	return counts;
    }
    
    public void IncreaseCounts() {
    	 counts++;
    }
    
    public void changeoutputformat(int outputformat) {
    	outputformat = 0;
    }
    
    public String toString() {
    	
    	if (outputformat == 0) {
    		return theWord;
    	} else {
    		return String.valueOf(getCounts());
    	}
    
    }
}

package lab2;
import java.util.*;
import java.io.*;
public class Dictionary {

	private ArrayList<Word> theDictionary;
	private BufferedWriter outputWriter;
	
	public Dictionary() {
		theDictionary = new ArrayList<Word>();
	}
	
	public Dictionary(String arg) {
		theDictionary = new ArrayList<Word>();
		addWords(arg);
	}
	public void  addWords(String arg) {
		String[] array = arg.split(" ");
		for (int i= 0; i < array.length; i++) {
			Word words = new Word(array[i]);
			theDictionary.add(words);
		}
	}
	public int numbersOfWords() {
		return theDictionary.size();
	}
	
	public void removeDuplicates() {
		
		for(int j = 0; j < numbersOfWords();j++ ) {
			for(int k = j + 1; k < numbersOfWords(); k++) {
				if(theDictionary.get(j).getWord().equals(theDictionary.get(k).getWord())) {
					theDictionary.get(j).IncreaseCounts();
					theDictionary.remove(k);
				}
			}
		}
		
	}
	
	public String countOccurences() {
		
		int count = 0;
		for (int n = 0; n < numbersOfWords(); n++) {
			if(theDictionary.get(n).getCounts() > count) {
				count = theDictionary.get(n).getCounts();
			}
		}
		
		return "??";
	}
	public void sortDictionaryByCounts() {
		
		for(int i = 0; i < numbersOfWords(); i++) {
			for (int j=i+1; j < (numbersOfWords()); j++) {
				if(theDictionary.get(i).getCounts() > theDictionary.get(j).getCounts()) {
					theDictionary.add(i,theDictionary.get(j));
					theDictionary.remove(j+1);
				}
			}
		}
	}
	public void setFileName(String filename) {
		File createdFile = new File(filename);
		try {
			createdFile.createNewFile();
			//outputWriter = BufferedWriter(filename);
		} catch(IOException e) {
			System.out.println("Error!");
		}
	}
	
	public void saveFile() {
		try {
			outputWriter.write(toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String toString() {
		return null;
		
	}
	}





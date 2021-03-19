package it.polito.tdp.alien;

import java.util.ArrayList;
import java.util.List;

public class AlienDictionary {
	
	List<WordEnhanced> dictionary;
	
	public AlienDictionary() {
		dictionary=new ArrayList<WordEnhanced>();
	}
	
	public void addWord(String alienWord, String translation) {
		WordEnhanced w=new WordEnhanced(alienWord);
		
		if(dictionary.contains(w)) {
			dictionary.get(dictionary.indexOf(w)).setTranslation(translation);
			return;
		}
		//se invece la traduzione non è registrata
		w.setTranslation(translation);
		dictionary.add(w);
		return;
	}
	
	public String translateWord(String alienWord) {
		WordEnhanced w= new WordEnhanced(alienWord);
		
		if(dictionary.contains(w)) {
			return dictionary.get(dictionary.indexOf(w)).getTranslation();
		}
		return null;
	}
	
	public void resetDictionary(){
		dictionary.clear();
		return;
	}

}

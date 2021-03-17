package it.polito.tdp.alien;

import java.util.LinkedList;
import java.util.List;

public class AlienDictionary {
	
	List<Word> dictionary;
	
	public AlienDictionary() {
		dictionary=new LinkedList<Word>();
	}
	
	public void addWord(String alienWord, String translation) {
		Word w=new Word(alienWord, translation);
		
		if(dictionary.contains(w)) {
			dictionary.get(dictionary.indexOf(w)).setTransaltion(translation);
		}
		else dictionary.add(w);
		
		return;
	}
	
	public String translateWord(String alienWord) {
		Word w= new Word(alienWord);
		
		if(dictionary.contains(w))
			return dictionary.get(dictionary.indexOf(w)).getTransaltion();
		return null;
	}
	
	public void resetDictionary(){
		dictionary.clear();
		return;
	}

}

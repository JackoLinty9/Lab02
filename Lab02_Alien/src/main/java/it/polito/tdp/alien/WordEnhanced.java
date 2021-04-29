package it.polito.tdp.alien;

import java.util.ArrayList;
import java.util.List;

public class WordEnhanced {
	private String alienWord;
	private List<String> translations; //lista di tutte le traduzioni di una parola
	
	public WordEnhanced(String alienWord) {
		super();
		this.alienWord = alienWord;
		this.translations = new ArrayList<String>();
	}

	public WordEnhanced(String alienWord, String translations) {
		super();
		this.alienWord = alienWord;
		this.translations = new ArrayList<String>();
		this.translations.add(translations);
	}
	
	public String getTranslation(){
		String s="";
		for(String stringa: translations) {
			s=s +stringa+"\n";
		}
		return s;
	}

	public void setTranslation(String translation) {
		if(!translations.contains(translation)) {
			translations.add(translation);
		}
	}

	public String getAlienWord() {
		return alienWord;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alienWord == null) ? 0 : alienWord.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WordEnhanced other = (WordEnhanced) obj;
		if (alienWord == null) {
			if (other.alienWord != null)
				return false;
		} else if (!alienWord.equals(other.alienWord))
			return false;
		return true;
	}
}

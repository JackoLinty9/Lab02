package it.polito.tdp.alien;

public class Word {

	private String alienWord;
	private String translation;
	
	public Word(String alienWord) { //costruttore per quando mi viene data solo la parola
		super();
		this.alienWord = alienWord;
	}

	public Word(String alienWord, String transaltion) { //costruttore per quando mi viene data la traduzione insieme alla parola
		super();
		this.alienWord = alienWord;
		this.translation = transaltion;
	}

	public String getAlienWord() {
		return alienWord;
	}

	public void setAlienWord(String alienWord) {
		this.alienWord = alienWord;
	}

	public String getTransaltion() {
		return translation;
	}

	public void setTransaltion(String transaltion) {
		this.translation = transaltion;
	}
	
    //devo implementare metodi equals e hasCode
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
		Word other = (Word) obj;
		if (alienWord == null) {
			if (other.alienWord != null)
				return false;
		} else if (!alienWord.equals(other.alienWord))
			return false;
		return true;
	}
}

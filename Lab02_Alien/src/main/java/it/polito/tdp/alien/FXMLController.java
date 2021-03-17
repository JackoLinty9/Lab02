package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	AlienDictionary dictionary= new AlienDictionary();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private TextField txtAlieno;

    @FXML
    private Button btnTranslate;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnReset;

    @FXML
    void doReset(ActionEvent event) {
    	txtResult.clear();
    	txtAlieno.clear();
    	dictionary.resetDictionary(); //metodo implementato nella classe AlienDictionary
    }

    @FXML
    void doTranslate(ActionEvent event) {
    	
    	txtResult.clear();
    	String inserito= txtAlieno.getText();
    	
    	//controllo che sia stato inserito qualcosa
    	if(inserito.length()==0) { 
    		txtResult.setText("Non è stata inserita nessuna parola");
    		return;
    	}
    	
    	//controllo che non ci siano numeri o caratteri speciali nel testo inserito
    	if(inserito.matches("((?=.*\\d).{1,200})")==true || inserito.matches("((?=.*[!?@#]).{1,200})")==true ) { 
			txtResult.setText("Errore nel formato: la parola non può contenere nè numeri nè caratteri speciali");
			return;
    	}
    	
		//controllo il formato dell'input (1 o 2 parole)
    	if(!inserito.contains(" ")) {
    			String result=dictionary.translateWord(inserito);
    			if(result==null) {
    				txtResult.setText("Traduzione per la parola "+inserito+" non trovata");
    				return;
    			}
    		    txtResult.setText("La parola "+inserito+" significa "+result);
    		    return;
    	}
    	
    	else {
    		String[] ins=inserito.split(" ");
    		if(ins.length==2) {
    			String alien=ins[0];
    			String trad=ins[1];
    			dictionary.addWord(alien, trad);
    			txtResult.setText("La parola "+alien+" è stata aggiunta al dictionary");
    			txtAlieno.clear();
    			return;
    		}
    	}	
    }

    @FXML
    void initialize() {
        assert txtAlieno != null : "fx:id=\"txtAlieno\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}

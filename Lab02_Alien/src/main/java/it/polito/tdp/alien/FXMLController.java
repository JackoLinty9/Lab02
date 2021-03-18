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
    	
    	String[] ins=inserito.split(" ");
    	
    	//controllo che siano state inserite al più 2 parole
    	if(ins.length>2) {
    		txtResult.setText("Errore: si possono inserire al massimo due parole");
		    return;
    	}
    	
		if(ins.length==2) {
			String alien=ins[0];
			String trad=ins[1];
			if(alien.matches("[a-z]+")==false || trad.matches("[a-z]+")==false){
				txtResult.setText("Errore nel formato: le parole non possono contenere nè numeri nè caratteri speciali");
			    return;
			    }
			else {
				dictionary.addWord(alien, trad);
				txtResult.setText("La parola "+alien+" è stata aggiunta al dictionary");
				txtAlieno.clear();
				return;
			}
    	}
    	else {
    		String alien=ins[0];
    		String result=dictionary.translateWord(alien);
			if(result==null) {
				txtResult.setText("Traduzione per la parola "+alien+" non trovata");
				return;
			}
		    txtResult.setText("La parola "+alien+" significa "+result);
		    return;
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

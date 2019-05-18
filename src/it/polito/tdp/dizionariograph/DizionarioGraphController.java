package it.polito.tdp.dizionariograph;
import java.net.URL;
import java.util.ResourceBundle;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;

import it.polito.tdp.dizionariograph.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class DizionarioGraphController {
	Model model;
	
    public void setModel(Model model) {
		this.model = model;
	}

	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea txtResult;

    @FXML
    private TextField inputNumeroLettere;

    @FXML
    private TextField inputParola;

    @FXML
    private Button btnGeneraGrafo;

    @FXML
    private Button btnTrovaVicini;

    @FXML
    private Button btnTrovaGradoMax;

    @FXML
    void doGeneraGrafo(ActionEvent event) {
    	/*
    	controlli sul numero di lettere in input:
    	- se è NULL
    	- se non è stato inserito un valore numerico!
    	*/
    	String numLettere = inputNumeroLettere.getText();
    	int count1 = 0;
    	for(int i=0; i<numLettere.length(); i++) {
    		if(Character.isAlphabetic((numLettere.charAt(i)))) {
    			count1++;
    		}
    	}
    	if(count1 >0 || numLettere == null) {
    		txtResult.appendText("Inserire numero corretto!");
    	}
    	/* 
    	 controllo che la parola inserita sia effettivamente una stringa di caratteri
    	 */
    	String parolaInput = inputParola.getText();
    	parolaInput.toLowerCase();
    	int count2 = 0;
    	for(int i=0; i<parolaInput.length(); i++) {
    		if(Character.isDigit(parolaInput.charAt(i))) {
    			count2++;
    		}
    	}
    	if(count2 > 0 || parolaInput == null) {
    		txtResult.appendText("\nInserire parola corretta!");
    	}
    	model.createGraph(Integer.parseInt(numLettere));
    }

    @FXML
    void doReset(ActionEvent event) {
    	txtResult.clear();
    	inputNumeroLettere.clear();
    	inputParola.clear();
    }

    @FXML
    void doTrovaGradoMax(ActionEvent event) {

    }

    @FXML
    void doTrovaVicini(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'DizionarioGraph.fxml'.";
        assert inputNumeroLettere != null : "fx:id=\"inputNumeroLettere\" was not injected: check your FXML file 'DizionarioGraph.fxml'.";
        assert inputParola != null : "fx:id=\"inputParola\" was not injected: check your FXML file 'DizionarioGraph.fxml'.";
        assert btnGeneraGrafo != null : "fx:id=\"btnGeneraGrafo\" was not injected: check your FXML file 'DizionarioGraph.fxml'.";
        assert btnTrovaVicini != null : "fx:id=\"btnTrovaVicini\" was not injected: check your FXML file 'DizionarioGraph.fxml'.";
        assert btnTrovaGradoMax != null : "fx:id=\"btnTrovaGradoMax\" was not injected: check your FXML file 'DizionarioGraph.fxml'.";

    }
}
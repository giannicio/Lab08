package it.polito.tdp.dizionariograph.model;

import java.util.List;

import it.polito.tdp.dizionariograph.db.WordDAO;

public class TestModel {

	public static void main(String[] args) {
		
		Model model = new Model();
		WordDAO dao = new WordDAO();
		List<String> listaParole = dao.getAllWordsFixedLength(4);
		model.createGraph(4);
		System.out.println(String.format("**Grafo creato**\n"));
		
		
		List<String> vicini = model.displayNeighbours("casa");
		System.out.println("Neighbours di casa: " + vicini + "\n");
		
		System.out.println("Cerco il vertice con grado massimo...");
		System.out.println(model.findMaxDegree(listaParole));
		
	}

}

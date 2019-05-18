package it.polito.tdp.dizionariograph.model;

import java.util.ArrayList;
import java.util.List;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import it.polito.tdp.dizionariograph.db.WordDAO;

public class Model {
	Graph<String, DefaultEdge> grafo = new SimpleGraph<>(DefaultEdge.class);

	public void createGraph(int numeroLettere) {
		WordDAO dao = new WordDAO();
		List<String> listaParole = dao.getAllWordsFixedLength(numeroLettere);
		Graphs.addAllVertices(grafo, listaParole);
		System.out.print(grafo.vertexSet().size());
		
		for(String p1: listaParole) {
			for(String p2: listaParole) {
				if(differUnCarattere(p1,p2)) {
					grafo.addEdge(p1, p2);
				}
			}
		}
		System.out.println(grafo);
	}

	private boolean differUnCarattere(String p1, String p2) {
		boolean result = false;
		int count = 0;
		for(int i = 0; i < p1.length(); i++) {
			if(p1.charAt(i) != p2.charAt(i)) {
				count++;
			}
		}
		if(count == 1) {
			result = true;
			return result;
		}
		return false;
	}

	public List<String> displayNeighbours(String parolaInserita) {
		List<String> vicini = Graphs.neighborListOf(grafo, parolaInserita);
		return vicini;
	}
	
	public String findMaxDegree(List<String> listaParole) {
		int gradoBest = 0;
		String parolaMaxGrado = null;
		for(String p: listaParole) {
			List<String> vicini = Graphs.neighborListOf(grafo, p);
			if(vicini.size() > gradoBest) {
				gradoBest = vicini.size();
				parolaMaxGrado = p;
			}
		}
		return parolaMaxGrado;
	}

}

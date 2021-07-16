package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;


import java.util.List;

import it.polito.tdp.anagrammi.DAO.AnagrammaDAO;

public class Model {
	
	AnagrammaDAO anagrammaDAO = new AnagrammaDAO();
	
	public List<String> anagrammiDataParola(String parola) {
		List<String> anagrammi = new ArrayList<>();
		permuta("", parola, 0 ,anagrammi);
		return anagrammi;
	}
	
	public boolean isCorrect(String anagramma) {
		return anagrammaDAO.isCorrect(anagramma);
	}
	
	private void permuta(String parziale, String lettere, int livello, List<String> anagrammi) {
		if(lettere.length() == 0) {
			anagrammi.add(parziale);
		} else {
			for(int pos = 0; pos < lettere.length(); pos++) {
				char tentativo = lettere.charAt(pos); 
				
				String nuovaParziale = parziale + tentativo;
				String nuovaLettere = lettere.substring(0, pos) + lettere.substring(pos+1);
				
				permuta(nuovaParziale, nuovaLettere, livello+1, anagrammi);
			}
		}
	}
}

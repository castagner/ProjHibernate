package br.com.rest.teste;

import br.com.rest.entidade.Ferramenta;
import com.google.gson.Gson;

public class TesteJson {

	public static void main(String[] args) {
		
		String jsontext = "{\"descricao\":\"Martelo\",\"id\":1";
		
		System.out.println(jsontext);
		
		Gson gson = new Gson();
		
		Ferramenta ferramenta = gson.fromJson(jsontext, Ferramenta.class);
		
		System.out.println("ID: " +ferramenta.getId());
		System.out.println("Descricao: "+ferramenta.getDescricao());
	}
}

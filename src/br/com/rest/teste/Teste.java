package br.com.rest.teste;

import br.com.rest.dados.FerramentaDB;
import br.com.rest.entidade.Ferramenta;

public class Teste {
	
	public static void main (String[] args) {
		
		for (Ferramenta f : FerramentaDB.getInstance().getListaFerramenta(Ferramenta.QUERY_CONSULTA)) {
			System.out.println("ID: "+f.getId());
			System.out.println("Descricao: " +f.getDescricao());
		}
	}
	
	private static void inserir() {
		
		Ferramenta f = new Ferramenta();
		f.setId(1);
		f.setDescricao("Martelo");
		
		if(FerramentaDB.getInstance().inserir(f)) {
			System.out.println("Registro inserido com sucesso");
		}else {
			System.out.println("Erro ao inserir registro");
		}
	}

}

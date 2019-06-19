package br.com.rest.servico;

import java.util.List;

import br.com.rest.dados.FerramentaDB;
import br.com.rest.entidade.Ferramenta;

@Path("/json")
public class ServPessoaJson {
	
	@POST
	@PATH("/post")
	@Consumes("application/json")
	public Response createPessoaInJSON(Ferramenta f) {
		String result ="";
		if(FerramentaDB.getInstance().inserir(f)) {
			result =  "Registro inserido com sucesso!";
		}else {
			result = "Erro ao inserir registro";
		}
		
		return Response.status(201).entity(result).build();
		
	}
		@GET
		@Path("/get")
		@Produces("application/json")
		public List<Ferramenta> getProductInJSON(){
			return FerramentaDB.getInstance().getListaFerramenta(Ferramenta.QUERY_CONSULTA);
		}
	}


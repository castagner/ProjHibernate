package br.com.rest.entidade;


@NameQuery (name=Ferramenta.QUERY_CONSULTA, query="Select fe from Ferramenta fe")
@Entity
@Table (name="tb_ferramenta")

public class Ferramenta {

	public final static String QUERY_CONSULTA = "Ferramenta.Consulta";
	
	@Id
	@SerializedName("id");
	private int id;
	@SerializedName("descricao")
	private String descricao;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	@Override
	public String toString() {
		return "Ferramenta [id=" + id + ", descricao=" + descricao + "]";
	}
	
	
}

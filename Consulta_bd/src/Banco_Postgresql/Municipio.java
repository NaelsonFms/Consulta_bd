package Banco_Postgresql;

public class Municipio {
	
	private Long id;
	private Long id_estado;
	private String municipio;
	
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(long novo) {
		this.id = novo;
	}
	public Long getId_estado() {
		return id_estado;
	}
	public void setId_estado(Long novo) {
		this.id_estado = novo;
	}
	public String getMunicipio() {
		return municipio;
	}
	public void setMunicipio(String novo) {
		this.municipio = novo;
	}
	

}

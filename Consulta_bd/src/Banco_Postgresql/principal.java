package Banco_Postgresql;


import java.sql.SQLException;


public class principal {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		Estado estado = new Estado();
		Estado estado1 = new Estado();
		Municipio municipio = new Municipio();
		conexao con = new conexao();

		// CADASTRANDO ESTADOS
		
		//estado.setId(2);
		//estado.setNome("Rio Janeiro");
		//estado.setSigla("RJ");
		//estado.setId(2);
		

		 //con.adiciona(estado);
		//System.out.println("Estado Cadastrado");

		/// CADASTRO MUNICIPIO
	    municipio.setId(1);
		municipio.setId_estado((long) 2);
		municipio.setMunicipio("pernambuco");

		// con.adiciona(municipio);
		//System.out.println("Municipio Cadastrado");
		
		//estado1.setId(3);
		
		con.altera(municipio);
		
		//con.remove(estado1);
		
		
		
		
		
		
	}

}

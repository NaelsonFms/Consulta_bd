package Banco_Postgresql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

     


	public class conexao {
		
		public Estado estado;
		public Municipio municipio;
		private String url;
		private String usuario;
		private String senha;
		private Connection con;
		
		conexao(){
			//passar o driver  //passar o metodo de conexao //local do servidor
			//passar o database
			url = "jdbc:postgresql://localhost:5432/postgres";
			usuario = "postgres";
			senha = "123";		
			try {
				
				Class.forName("org.postgresql.Driver");
				con = DriverManager.getConnection(url, usuario, senha);
				System.out.println("Conexão aberta!");
			
			} catch (Exception e) {
				//capturar qualquer error
				e.printStackTrace();
			}
			
			
			
		}
		
		
	   
	
	    public void adiciona(Estado estado) {
	        String sql = "insert into estado " +
	                "(id,nome,sigla)" +
	                " values (?,?,?)";

	        try {
	            // prepared statement para inserção
	            PreparedStatement stmt = con.prepareStatement(sql);

	            // seta os valores
	            stmt.setLong(1,estado.getId());
	            stmt.setString(2,estado.getNome());
	            stmt.setString(3,estado.getSigla());
	           

	            // executa
	            stmt.execute();
	            System.out.println("ADICIONADO COM SUCESSO");
	            stmt.close();
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	    }
	    
	    public void adiciona(Municipio municipio) {
	        String sql = "insert into municipio " +
	                "(id,id_estado,municipio)" +
	                " values (?,?,?)";

	        try {
	            // prepared statement para inserção
	            PreparedStatement stmt = con.prepareStatement(sql);

	            // seta os valores
	            stmt.setLong(1,municipio.getId());
	            stmt.setLong(2,municipio.getId_estado());
	            stmt.setString(3,municipio.getMunicipio());
	           

	            // executa
	            stmt.execute();
	            stmt.close();
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	    }
	    
	    
	    public void altera(Estado estado) {
	        String sql = "update estado set id=? , nome=?, sigla=? where id=?";
	        
	        try {
	            PreparedStatement stmt = con.prepareStatement(sql);
	            stmt.setLong(1, estado.getId());
	            stmt.setString(2, estado.getNome());
	            stmt.setString(3, estado.getSigla());
	            stmt.setLong(4, estado.getId());
	            
	            stmt.executeUpdate();
	            stmt.execute();
	            System.out.println("ALTERADO COM SUCESSO");
	            stmt.close();
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	    }
	    
	    public void altera(Municipio municipio) {
	        String sql = "update municipio set id=? , id_estado=?, municipio=? where id=?";
	        
	        try {
	            PreparedStatement stmt = con.prepareStatement(sql);
	            stmt.setLong(1, municipio.getId());
	            stmt.setLong(2, municipio.getId_estado());
	            stmt.setString(3, municipio.getMunicipio());
	            stmt.setLong(4, municipio.getId());
	            
	            stmt.executeUpdate();
	            stmt.execute();
	            System.out.println("ALTERADO COM SUCESSO");
	            stmt.close();
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	    }
	    
	    
	    public void remove(Estado estado) {
	        try {
	            PreparedStatement stmt = con.prepareStatement("delete " +
	                    "from estado where id=?");
	            stmt.setLong(1, estado.getId());
	            stmt.execute();
                System.out.println("REMOVIDO COM SUCESSO");
	            stmt.close();
	        } catch (SQLException e) {
	            throw new RuntimeException( "Erro ao Remover" + e);
	        }
	    }
	    
	    public void remove(Municipio municipio) {
	        try {
	            PreparedStatement stmt = con.prepareStatement("delete " +
	                    "from municipio where id=?");
	            stmt.setLong(1, municipio.getId());
	            stmt.execute();
                System.out.println("REMOVIDO COM SUCESSO");
	            stmt.close();
	        } catch (SQLException e) {
	            throw new RuntimeException( "Erro ao Remover" + e);
	        }
	    }
	 
	}
	
	
	
	


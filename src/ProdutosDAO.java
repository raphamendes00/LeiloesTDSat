/**
 *
 * @author Adm
 */

import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ProdutosDAO {
    
    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
    public boolean conectar(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/uc_11","root","metalend");
            return true;
        }catch(ClassNotFoundException | SQLException ex){
            System.out.println("Erro ao conectar: " + ex.getMessage());
            return false;
        }
    }
    
    public void cadastrarProduto (ProdutosDTO produto){
        int status;
        try{
            prep = conn.prepareStatement("INSERT INTO produtos VALUES(?,?,?)");
            prep.setString(1, produto.getNome());
            prep.setInt(2, produto.getValor());
            prep.setString(3, produto.getStatus());
            status = prep.executeUpdate();
            
        }catch(SQLException ex){
            System.out.println("Erro de conexão "+ ex.getMessage());
        }
        
    }
    
    public ArrayList<ProdutosDTO> listarProdutos(){
        
        return listagem;
    }
    
    public void desconectar(){
        try{
            conn.close();
        }catch(SQLException ex){
            
        }
    }
    
    
    
        
}


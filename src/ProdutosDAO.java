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
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/uc_11?useSSL=false","root","metalend");
            return true;
        }catch(ClassNotFoundException | SQLException ex){
            System.out.println("Erro ao conectar: " + ex.getMessage());
            return false;
        }
    }
    
    public int cadastrarProduto (ProdutosDTO produto){
        int status;
        try{
            prep = conn.prepareStatement("INSERT INTO produtos (nome,valor) VALUES (?,?)");
            prep.setString(1, produto.getNome());
            prep.setInt(2, produto.getValor());
            status = prep.executeUpdate();
            return status;
        }catch(SQLException ex){
            System.out.println("Erro de conexão "+ ex.getMessage());
            return ex.getErrorCode();
        }
        
    }
    
    public ProdutosDTO consultar(int id){
        ProdutosDTO produtos = null;
        try{
            produtos = new ProdutosDTO();
            prep = conn.prepareStatement("SELECT * FROM produtos WHERE id = ?");
            prep.setInt(1, id);
            resultset = prep.executeQuery();
            
            if(resultset.next()){
                produtos.setId(resultset.getInt("id"));
                produtos.setNome(resultset.getString("nome"));
                produtos.setValor(resultset.getInt("valor"));
                produtos.setStatus(resultset.getString("status"));
                return produtos;
            }else {
                return null;
            }
            
        }catch(SQLException ex){
            System.out.println("Erro ao buscar produtos "+ ex.getMessage());
            return null;
        }
    }
    
    public int vender(ProdutosDTO produto){
        int status;
        try{
            prep = conn.prepareStatement("UPDATE produtos SET nome = ?, valor = ?, status = ? WHERE id = ?");
            prep.setString(1, produto.getNome());
            prep.setInt(2, produto.getValor());
            prep.setString(3, "Vendido");
            prep.setInt(4, produto.getId());
            status = prep.executeUpdate();
            return status;
        }catch(SQLException ex){
            System.out.println("Venda não realizada "+ ex.getMessage());
            return ex.getErrorCode();
        }
    }
    
    public ArrayList<ProdutosDTO> listarProdutos(){
            ArrayList<ProdutosDTO> listagem = new ArrayList<>();
            try{
                prep = conn.prepareStatement("SELECT * FROM produtos");
                resultset = prep.executeQuery();
                
                while(resultset.next()){
                    ProdutosDTO produto = new ProdutosDTO();
                    produto.setId(resultset.getInt("id"));
                    produto.setNome(resultset.getString("nome"));
                    produto.setValor(resultset.getInt("valor"));
                    produto.setStatus(resultset.getString("status"));
                    listagem.add(produto);
                }
            }catch(SQLException ex){
                System.out.println("Erro ao listar produtos "+ ex.getMessage());
            }
        return listagem;
        }
    
    public ArrayList<ProdutosDTO> listarProdutosVendidos(){
            ArrayList<ProdutosDTO> listagem = new ArrayList<>();
            try{
                prep = conn.prepareStatement("SELECT * FROM produtos WHERE status = ?");
                prep.setString(1, "Vendido");
                resultset = prep.executeQuery();
                
                while(resultset.next()){
                    ProdutosDTO produto = new ProdutosDTO();
                    produto.setId(resultset.getInt("id"));
                    produto.setNome(resultset.getString("nome"));
                    produto.setValor(resultset.getInt("valor"));
                    produto.setStatus(resultset.getString("status"));
                    listagem.add(produto);
                }
            }catch(SQLException ex){
                System.out.println("Erro ao listar produtos "+ ex.getMessage());
            }
        return listagem;
        }
    
    public void desconectar(){
        try{
            conn.close();
        }catch(SQLException ex){
            
        }
    }
    
    
    
        
}


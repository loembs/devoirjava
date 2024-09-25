package com.natsi.repositories.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.natsi.entities.Article;
import com.natsi.repositories.list.ArticleRepository;

public class ArticleRepositoryBD extends DataServiceImpl<Article> implements ArticleRepository{
    public boolean insert(Article article) {
        boolean nbrLigne =false;
        String querypg="INSERT INTO article (reference, libelle, prix, qteStock) VALUES ($1, $2, $3, $4)";
        
        String query =  "INSERT INTO `article` (`reference`, `libelle`, `prix`, `qteStock`) VALUES (?, ?, ?, ?);";
        try (Connection conn =getConnection(); 
             PreparedStatement stmt = conn.prepareStatement(querypg, Statement.RETURN_GENERATED_KEYS)
            
             ) {
            stmt.setString(1, article.getRef());
            stmt.setString(2, article.getLibelle());
            stmt.setInt(3, article.getPrix());
            stmt.setInt(4, article.getQtestock());
    
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        article.setId(generatedKeys.getInt(1));
                        return true;
                    } else {
                        throw new SQLException("Échec de la création du client, aucun ID généré.");
                    }
                }
            } else {
                return false;
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Erreur de connexion ou d'exécution : " + e.getMessage());
        }finally {
            closeConnexion();
        }
        return nbrLigne;
    }
    

    public boolean delete(int id) {
        String query = "DELETE FROM `article` WHERE `id` = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Erreur de connexion ou d'exécution : " + e.getMessage());
            return false;
        }finally {
            closeConnexion();
        }
    }

    public List<Article> selectAll() {
        List<Article> articles = new ArrayList<>();
        String query = "SELECT * FROM `article`";
        try (Connection conn =getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                articles.add(convertToObject(rs));
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Erreur de connexion ou d'exécution : " + e.getMessage());
        }finally {
            closeConnexion();
        }
        return articles;
    }

    public  Article selectByQte(){
        Article article = null;
        String query ="SELECT * FROM article WHERE qteStock!=0";
        try (Connection conn =getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                   article=this.convertToObject(rs);
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Erreur de connexion ou d'exécution : " + e.getMessage());
        }finally {
            closeConnexion();
        }
        return article;
      
    }
     public  Article selectById(int id){
        Article article = null;
        String query = "SELECT a.* FROM `article` a WHERE a.id = ?";
        try (Connection conn =getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    article =this.convertToObject(rs);
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Erreur de connexion ou d'exécution : " + e.getMessage());
        }finally {
            closeConnexion();
        }
        return article;
       
    }
    public  Article selectBylibelle(String libelle){
        Article article = null;
        String query = "SELECT * FROM article WHERE libelle = ?";
        try (Connection conn =getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, libelle);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    article=this.convertToObject(rs);
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Erreur de connexion ou d'exécution : " + e.getMessage());
        }finally {
            closeConnexion();
        }
        return article;
       
    } 
    public boolean updateArticle(Article article) {
        String query = "UPDATE article SET reference = ?, libelle = ?, prix = ?, qteStock = ? WHERE id = ?";
        
        try (Connection conn =getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setString(1, article.getRef());
            stmt.setString(2, article.getLibelle());
            stmt.setInt(3, article.getPrix());
            stmt.setInt(4, article.getQtestock());
            stmt.setInt(5, article.getId());
            
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
            
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Erreur lors de la mise à jour de l'article : " + e.getMessage());
            return false;
        }finally {
            closeConnexion();
        }
    }
@Override
public Article convertToObject(ResultSet rs) throws SQLException {
    
    Article article = new Article();
    article.setId(rs.getInt("id"));
    article.setRef(rs.getString("reference"));
    article.setLibelle(rs.getString("libelle"));
    article.setPrix(rs.getInt("prix"));
    article.setQtestock(rs.getInt("qteStock"));
    return article;
}
    /*@Override
    public boolean insert(Article article) {
        String query = "INSERT INTO `article` (`reference`, `libelle`, `prix`, `qteStock`) VALUES (?, ?, ?, ?)";
        try {
            return insertArticle(article, query);
        } catch (SQLException | IllegalAccessException | NoSuchFieldException e) {
            System.out.println("Erreur lors de l'insertion de l'article : " + e.getMessage());
            return false;
        }
    }

    public boolean insertArticle(Article article, String query) throws SQLException, IllegalAccessException, NoSuchFieldException {
        return insert(article, query);
    }*/
      
}

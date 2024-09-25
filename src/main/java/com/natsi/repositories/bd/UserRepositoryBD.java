package com.natsi.repositories.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.natsi.entities.Etat;
import com.natsi.entities.Role;
import com.natsi.entities.User;
import com.natsi.repositories.list.UserRepository;

public class UserRepositoryBD extends DataServiceImpl<User> implements UserRepository<User>{
    private final ClientRepositoryBD clientRepositoryBD;

    public UserRepositoryBD(ClientRepositoryBD clientRepositoryBD) {
        this.clientRepositoryBD = clientRepositoryBD;
    }
    public boolean insert(User user) {
        boolean nbrLigne =false;
        String query = "INSERT INTO `user` (`login`, `nom`, `prenom`, `password`, `id_client`, `id_role`, `id_etat`) VALUES (?,?,?,?,?,?,?);";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1,  user.getLogin());
            stmt.setString(2,  user.getNom());
            stmt.setString(3,  user.getPrenom());
            stmt.setString(4,  user.getPassword());
            stmt.setInt(5, user.getClient().getId());
            stmt.setInt(6, user.getRole().getId());
            stmt.setInt(7, user.getEtat().getId());

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        user.setId(generatedKeys.getInt(1));
                    } else {
                        throw new SQLException("Échec de la création de la transaction, aucun ID généré.");
                    }
                }
                return true;
            } else {
                return false;
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Erreur de connexion ou d'exécution : " + e.getMessage());
        }finally{
            closeConnexion();
        }
        return nbrLigne;
    }

    public boolean delete(int id) {
        String query = "DELETE FROM `user` WHERE `id` = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Erreur de connexion ou d'exécution : " + e.getMessage());
            return false;
        }finally{
            closeConnexion();
        }
    }

    public List<User> selectAll() {
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM `user`";
        try (Connection conn =getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                users.add(this.convertToObject(rs));
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Erreur de connexion ou d'exécution : " + e.getMessage());
        }finally{
            closeConnexion();
        }
        return users;
    }

     public  User selectByLogin(String login){
        User user = null;
        String query = "SELECT * FROM user WHERE login = ?";
        try (Connection conn =getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, login);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    user=this.convertToObject(rs);
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Erreur de connexion ou d'exécution : " + e.getMessage());
        }finally{
            closeConnexion();
        }
        return user;
       
    }
    public List<User> selectByRole(Role role) {
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM user WHERE id_role = ?";
        try (Connection conn =getConnection(); 
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, role.getId());
            
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    users.add(this.convertToObject(rs));
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Erreur de connexion ou d'exécution : " + e.getMessage());
        }finally{
            closeConnexion();
        }
    
        return users;
    } 
    public User convertToObject(ResultSet rs) throws SQLException{
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setLogin(rs.getString("login"));
        user.setNom(rs.getString("nom"));
        user.setPrenom(rs.getString("prenom"));
        user.setPassword(rs.getString("password"));
        user.setClient(clientRepositoryBD.selectById(rs.getInt("id_client")));
        int roleId = rs.getInt("id_role");
        user.setRole(Role.getById(roleId));
        int etatId = rs.getInt("id_etat");
        user.setEtat(Etat.getById(etatId));
        return user;
    }   
}

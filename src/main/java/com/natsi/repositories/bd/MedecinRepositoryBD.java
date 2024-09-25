package com.natsi.repositories.bd;
import java.util.ArrayList;
import java.util.List;

import com.natsi.entities.Medecin;
import com.natsi.repositories.MedecinRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class MedecinRepositoryBD extends DataServiceImpl<Medecin> implements MedecinRepository  {
    public boolean insert(Medecin med) {
        boolean nbrLigne = false;
        String query =  "INSERT INTO `client` (`surname`, `telephone`, `adresse`, `id_user`) VALUES (?, ?, ?,NULL)";
        Connection conn = null;
        try {
            conn = getConnection();
            try (PreparedStatement stmt = conn.prepareStatement(query , Statement.RETURN_GENERATED_KEYS)) {
                stmt.setString(1, med.getNom());
                stmt.setString(2, med.getPrenom());
               
    
                int rowsAffected = stmt.executeUpdate();
                if (rowsAffected > 0) {
                    try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                        if (generatedKeys.next()) {
                            med.setId(generatedKeys.getInt(1));
                            return true;
                        } else {
                            throw new SQLException("Échec de la création du client, aucun ID généré.");
                        }
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Erreur de connexion ou d'exécution : " + e.getMessage());
        } finally {
            closeConnexion();
        }
        return nbrLigne;
    }
    
    
    

    public List<Medecin> selectAll() {
        List<Medecin> clients = new ArrayList<>();
        String query = "SELECT * FROM `medecin`";
        Connection conn = null;
        try {
            conn = getConnection();
            try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
                while (rs.next()) {
                    clients.add(this.convertToObject(rs));
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Erreur de connexion ou d'exécution : " + e.getMessage());
        } finally {
            closeConnexion();
        }
        return clients;
    }
    

    public Medecin selectById(int id) {
        Medecin med = null;
        String query = "SELECT m.* " +
                       "FROM `medecin` m " +
                       "WHERE m.id = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    med=this.convertToObject(rs);
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Erreur de connexion ou d'exécution : " + e.getMessage());
        }
        return med;
    }
    @Override
    public Medecin convertToObject(ResultSet rs) throws SQLException{
        Medecin med = new Medecin();
        med.setId(rs.getInt("id"));
        med.setNom(rs.getString("nom"));
        med.setPrenom(rs.getString("prenom"));
        return med ;
    }




    @Override
    public Medecin selectByName(String name) {
        Medecin med = null;
        String query = "SELECT m.* " +
                       "FROM `medecin` m " +
                       "WHERE m.nom = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, name);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    med=this.convertToObject(rs);
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Erreur de connexion ou d'exécution : " + e.getMessage());
        }
        return med;
    }
 
}

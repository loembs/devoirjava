package com.natsi.repositories.bd;
import java.util.ArrayList;
import java.util.List;

import com.natsi.entities.Rendezvous;
import com.natsi.repositories.RdvRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class RendezVousRepositoryBD extends DataServiceImpl<Rendezvous> implements RdvRepository  {
    public boolean insert(Rendezvous rdv) {
        boolean nbrLigne = false;
        String query =  "INSERT INTO `client` (`surname`, `telephone`, `adresse`, `id_user`) VALUES (?, ?, ?,NULL)";
        Connection conn = null;
        try {
            conn = getConnection();
            try (PreparedStatement stmt = conn.prepareStatement(query , Statement.RETURN_GENERATED_KEYS)) {
                stmt.setString(1, rdv.getDate());
                stmt.setString(2, rdv.getHeure());
                stmt.setInt(3, rdv.getMed().getId());
               
    
                int rowsAffected = stmt.executeUpdate();
                if (rowsAffected > 0) {
                    try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                        if (generatedKeys.next()) {
                            rdv.setId(generatedKeys.getInt(1));
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
    
    
    

    public List<Rendezvous> selectAll() {
        List<Rendezvous> rdvs = new ArrayList<>();
        String query = "SELECT * FROM `medecin`";
        Connection conn = null;
        try {
            conn = getConnection();
            try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
                while (rs.next()) {
                    rdvs.add(this.convertToObject(rs));
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Erreur de connexion ou d'exécution : " + e.getMessage());
        } finally {
            closeConnexion();
        }
        return rdvs;
    }
    

    public Rendezvous selectById(int id) {
        Rendezvous rdv = null;
        String query = "SELECT m.* " +
                       "FROM `rendezvous` m " +
                       "WHERE m.id = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    rdv=this.convertToObject(rs);
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Erreur de connexion ou d'exécution : " + e.getMessage());
        }
        return rdv;
    }
    @Override
    public Rendezvous convertToObject(ResultSet rs) throws SQLException{
        Rendezvous rdv = new Rendezvous();
        rdv.setId(rs.getInt("id"));
        rdv.setDate(rs.getString("date"));
        rdv.setHeure(rs.getString("heure"));

        return rdv ;
    }




    @Override
    public Rendezvous selectBydate(String date) {
        Rendezvous rdv = null;
        String query = "SELECT m.* " +
                       "FROM `rendezvous` m " +
                       "WHERE m.date = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, date);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    rdv=this.convertToObject(rs);
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Erreur de connexion ou d'exécution : " + e.getMessage());
        }
        return rdv;
    }




   
 
}

package com.natsi.entities;
import lombok.*;
@Getter
@Setter
public class User {
    private int id;
    private String login;
    private String nom;
    private String prenom;
    private String password;
    private Client client;
    private Role role ;
    private Etat etat;
    @Override
    public String toString() {
        return "User [login=" + login + ", nom=" + nom + ", prenom=" + prenom + ", password=" + password + ", client="
                + client + ", role=" + role + ", etat=" + etat + "]";
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((login == null) ? 0 : login.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (login == null) {
            if (other.login != null)
                return false;
        } else if (!login.equals(other.login))
            return false;
        return true;
    }
    
}

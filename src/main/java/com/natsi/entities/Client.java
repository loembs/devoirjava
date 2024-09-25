package com.natsi.entities;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
public class Client {
    private int id;
    private String surname;
    private String telephone;
    private String adresse;
    private User user;

    @Override
    public String toString() {
        return "Client [surname=" + surname + ", telephone=" + telephone + ", adresse=" + adresse+"]";
    }   
}

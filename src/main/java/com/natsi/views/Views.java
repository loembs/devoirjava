package com.natsi.views;
import java.util.List;
import java.util.Scanner;
public interface Views<T> {
    T saisie();
    void afficher(List<T> a);
    void setScanner(Scanner b);
    
}

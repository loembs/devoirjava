package com.natsi.views;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public abstract class ViewImpl<T> implements Views<T> {
    protected static Scanner scanner;
    static{
        scanner = new Scanner(System.in);
    }
    public ViewImpl(){

    }
    @Override
    public void afficher(List<T> datas) {
        for (T data : datas) {
            System.out.println(data);
        }
       
    }
    @Override
    public void setScanner(Scanner scanner) {
        ViewImpl.scanner=  scanner;
       
    }
    public LocalDate formatDate(String date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return LocalDate.parse(date,formatter);
    }
    public LocalDate formatDate(String date,String format ){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return LocalDate.parse(date,formatter);
    }
    
}

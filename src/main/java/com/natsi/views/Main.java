package com.natsi.views;

import com.natsi.core.factory.FactoryServ;
import com.natsi.core.factory.FactoryView;

import java.util.List;
import java.util.Scanner;

import com.natsi.entities.Article;
import com.natsi.entities.Client;
import com.natsi.entities.Etat;
import com.natsi.entities.Role;
import com.natsi.entities.User;



public class Main {
    private static Scanner  scanner= new Scanner(System.in);
    public static void main(String[] args) {

        FactoryView factoryView=new FactoryView();
        
        FactoryServ factoryServ=new FactoryServ();

        int choix;
        int choix2;
        String phone;
        do {
            choix=menu();
            scanner.nextLine();
            switch (choix) {
                    
                case 1:

                    factoryServ.getInstanceClientService().create(factoryView.getInstanceClientView().saisie());

                    break;
                case 2:
                        List<Client> listClients = factoryServ.getInstanceClientService().findAll();
                        listClients.forEach(System.out::println);
                    break;
                case 3:
                    factoryServ.getInstanceClientService().findAll();
                break;
                case 4:
                    System.out.println("Entrer votre numero de telephone");
                    phone=scanner.nextLine();
                    Client cl=factoryServ.getInstanceClientService().search(phone);
                    System.out.println(cl);

                    break;
                case 5:
                User user = new User();
                System.out.println("Choisissez votre profil");
                System.out.println("1-Creer un compte pour un client");
                System.out.println("2-Creer un compte");
                int choix1=scanner.nextInt();
                scanner.nextLine();
                switch (choix1) {
                    case 1: 
                        System.out.println("Entrer votre numero");
                        String numero=scanner.nextLine();
                        Client cl1=factoryServ.getInstanceClientService().search(numero); 
                        System.out.println(cl1);
                        System.out.println("Entrer votre login");
                        user.setLogin(scanner.nextLine());
                        System.out.println("Entrer le nom");
                        user.setNom(scanner.nextLine());
                        System.out.println("Entrer le prenom");
                        user.setPrenom(scanner.nextLine());
                        System.out.println("Entrer le password");
                        user.setPassword(scanner.nextLine());
                        user.setClient(cl1);
                        user.setRole(Role.values()[2]);
                        user.setEtat(Etat.values()[1]);
                        if (cl1==null) {
                            System.out.println("Client est null");    
                        }
                        cl1.setUser(user);
                        break;
                    case 2:
                            System.out.println("Entrer votre login");
                            user.setLogin(scanner.nextLine());
                            System.out.println("Entrer le nom");
                            user.setNom(scanner.nextLine());
                            System.out.println("Entrer le prenom");
                            user.setPrenom(scanner.nextLine());
                            System.out.println("Entrer le password");
                            user.setPassword(scanner.nextLine());
                            System.out.println("Entrer votre status");
                            user.setRole(saisietype());
                            user.setEtat(Etat.values()[1]);
                            break;
                    default:
                        break;
                }
                    factoryServ.getInstanceUserServiceImpl().create(user);
                    break;
                case 6:
                    System.out.println("Entrer votre choix");
                    System.out.println("1-Activer un compte");
                    System.out.println("2-desactiver un compte");
                    System.out.println("3-Quitter");
                    choix2=scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Entrer le login du compte");
                    String login=scanner.nextLine();
                    User compte=factoryServ.getInstanceUserServiceImpl().search(login);
                    scanner.nextLine();
                    if (compte == null) {
                        System.out.println("Aucun compte trouvé pour le login: " + login);
                    }else{
                        switch (choix2) {
                            case 1:
                                compte.setEtat(Etat.ACTIVER);
                                System.out.println("Compte activé.");
                                break;
                            case 2:
                                compte.setEtat(Etat.DESACTIVER);
                                System.out.println("Compte désactivé."); 
                                break;
                        
                            default:
                                break;
                        }
                    }
                    break;
                case 7:
                        System.out.println("Entrer votre choix");
                        System.out.println("1-Admin");
                        System.out.println("2-Boutiquier");
                        System.out.println("3-CLient");
                        int choix3=scanner.nextInt();
                        scanner.nextLine();
                        switch (choix3) {
                            case 1:
                                List<User> list1=factoryServ.getInstanceUserServiceImpl().searchrole(Role.ADMIN);
                                list1.forEach(System.out::println);

                                break;
                            case 2:
                                List<User> list2=factoryServ.getInstanceUserServiceImpl().searchrole(Role.BOUTIQUIER);
                                list2.forEach(System.out::println);
                                break;
                            case 3:
                                List<User> list3=factoryServ.getInstanceUserServiceImpl().searchrole(Role.CLIENT);
                                list3.forEach(System.out::println);
                                break;
                            default:
                                break;
                        }
                        
                    break;
                case 8:
                    factoryServ.getInstanceArticleServiceImpl().create(factoryView.getInstanceArticleView().saisie());
                    break;
                case 9:
                        List<Article> listArticles = factoryServ.getInstanceArticleServiceImpl().findAll();
                        listArticles.forEach(System.out::println);
                    break;
                case 10:
                    List<Article> list = factoryServ.getInstanceArticleServiceImpl().findAll();
                    list.forEach(System.out::println);
                    System.out.println("Entrer l'id de l'article");
                    int id=scanner.nextInt();
                    Article article=factoryServ.getInstanceArticleServiceImpl().searchById(id);
                    System.out.println("Entrer la quantite");
                    int qte=scanner.nextInt();
                    article.setQtestock(qte);
                    //updateArticle(article);
                    break;
                default:
                        break;
            }
            
        } while (choix!=12);
       
        
    }
    public static int menu(){
            System.out.println("1-Creer client");
            System.out.println("2-Lister client");
            System.out.println("3-creer une dette");
            System.out.println("4-rechercher un client");
            System.out.println("5-creer un compte");
            System.out.println("6- Activer ou Desactiver un compte");
            System.out.println("7- Lister les Comptes par role");
            System.out.println("8- Creer un Article");
            System.out.println("9- Lister Article");
            System.out.println("10- Mettre à jour Qtestock Article");
            System.out.println("11- Archiver les dettes soldés");
            System.out.println("12-Quitter");
            return scanner.nextInt();
    }

    public static Role saisietype() {
        int type;
        do {
           System.out.println("1-Boutiquier");
           System.out.println("2-Admin");
           type = scanner.nextInt();
        } while(type < 1 || type >4);
  
        return Role.values()[type - 1];
     }
    
}
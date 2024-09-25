package com.natsi.views;

import java.util.List;

import com.natsi.entities.Article;

public class ArticleView extends ViewImpl<Article> {
    public ArticleView() {

}
public Article saisie(){
    Article article = new  Article();
    System.out.println("Entrer le libelle");
    article.setLibelle(scanner.nextLine());
    System.out.println("Entrer le prix");
    article.setPrix(scanner.nextInt());
    System.out.println("Entrer la quantité en stock");
    article.setQtestock(scanner.nextInt());
    scanner.nextLine();
    return article;
}
public void afficher(List<Article> datas) {
        for (Article data : datas) {
            if(data==null){
                return;
            }
            System.out.println(data);
        }                 
}
    
}

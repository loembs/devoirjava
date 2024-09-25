package com.natsi.repositories.list.Impl;
import com.natsi.entities.Article;
import com.natsi.repositories.list.ArticleRepository;


public class ArticleRepositoryList extends RepositoryImpl<Article> implements ArticleRepository{
   
    public  Article selectByQte(){
        return list.stream()
                .filter(article ->article.getQtestock()!=0)
                .findFirst()
                .orElse(null);
    }
     public  Article selectById(int id){
        return list.stream()
                .filter(article ->article.getId()==id)
                .findFirst()
                .orElse(null);
    }
    public  Article selectBylibelle(String libelle){
        return list.stream()
                .filter(article ->article.getLibelle().compareTo(libelle)==0)
                .findFirst()
                .orElse(null);
    }    
}

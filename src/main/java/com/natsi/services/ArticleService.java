package com.natsi.services;

import java.util.List;

import com.natsi.entities.Article;

public interface ArticleService {
    void create(Article article);
    List<Article>findAll();
    Article search();
    Article searchById(int id);
    Article searchBylibelle(String libelle);
    
}

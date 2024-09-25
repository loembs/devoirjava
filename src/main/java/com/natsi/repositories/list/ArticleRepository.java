package com.natsi.repositories.list;

import com.natsi.entities.Article;

public interface ArticleRepository extends Repository<Article>{
    Article selectByQte();
    Article selectById(int id);
    Article selectBylibelle(String libelle);
    
}

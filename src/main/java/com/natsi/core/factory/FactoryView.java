package com.natsi.core.factory;

import com.natsi.services.ClientService;
import com.natsi.services.Impl.ArticleServiceImpl;
import com.natsi.services.Impl.UserServiceImpl;
import com.natsi.views.ArticleView;
import com.natsi.views.ClientView;

public class FactoryView {
        ClientView clientView= null;
        ArticleView articleView= null;
        
    public  ClientView getInstanceClientView(){
        if(clientView==null){
            clientView=new ClientView();
        }
        return clientView;
    }
    public  ArticleView getInstanceArticleView(){
        if(articleView==null){
            articleView=new  ArticleView();
        }
        return articleView;
    }
    
}

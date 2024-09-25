package com.natsi.core.factory;

import com.natsi.entities.User;
import com.natsi.repositories.bd.ArticleRepositoryBD;
import com.natsi.repositories.bd.ClientRepositoryBD;
import com.natsi.repositories.list.ArticleRepository;
import com.natsi.repositories.list.ClientRepository;
import com.natsi.repositories.list.UserRepository;
import com.natsi.repositories.list.Impl.ArticleRepositoryList;
import com.natsi.repositories.list.Impl.ClientRepositoryList;
import com.natsi.repositories.list.Impl.UserRepositoryList;

public class FactoryRepo {
     
        private  ArticleRepository articleRepository=null;
        private  ClientRepository clientRepo=null;
        private  UserRepository<User> userRepository=null;
        
    public  ClientRepository getInstanceClientRepository(){
        if(clientRepo==null){
            clientRepo=new ClientRepositoryBD();
        }
        return clientRepo;
    }
    public  UserRepository<User>  getInstanceUserRepository(){
        if( userRepository==null){
            userRepository= new UserRepositoryList();
        }
        return  userRepository;
    }
    public  ArticleRepository  getInstanceArticleRepository(){
        if(articleRepository==null){
            articleRepository= new ArticleRepositoryBD();
        }
        return  articleRepository;
    }

    //ClientRepositoryBD clientRepositoryBD = new ClientRepositoryBD();
    //UserRepository<User> userRepository= new UserRepositoryBD(clientRepositoryBD);
    
}

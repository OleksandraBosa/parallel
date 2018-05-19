/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mathpar.students.ukma17i41.bosa.parallel.engine;
//package com.mathpar.students.ukma17i41.sidko.engine;

import java.util.ArrayList;

/**
 *
 * @author alla
 */
public class Firtree {
    
    ArrayList<Amin> body;
   
    int state;
    
    public Firtree(){
        body = new ArrayList();
    }
    
    public Amin GetCurrentAmin(){
        for(int i = body.size()-1; i<=0; i--){
            if(body.get(i)!=null){
                return body.get(i);    
            }
        }
        return body.get(0);
    } 
    
    public int GetMyAmin(DropTask dp){
        for(int i=0; i<body.size();i++){
            if(body.get(i).branch.contains(dp)){
                return body.get(i).branch.indexOf(dp);
            }
        }
        return 0;
    }
    
    public int CheckState(){
        int st;
        for(int i=0; i<body.size(); i++){
            body.get(i).SetState();
            if(body.get(i).aminState!=1){
                st=0;
              return st;
            }
        }
        st=1;
        return st;
    }  
    
    public int GetState(){
        return state;
    }
    
    public void SetState(int st){
        state=st;
    }
}

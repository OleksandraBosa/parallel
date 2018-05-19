/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mathpar.students.ukma17i41.bosa.parallel.engine;
//package com.mathpar.students.ukma17i41.sidko.engine;

import com.mathpar.number.Element;
import java.util.ArrayList;

public class Amin {
    int parentProc;
    int parentAmin;
    int dropId;
    int type;
    int aminIdInFirtree;
    /**
     * 0-нет пока входных данных,
     * 1-идет счет,2-идет листовой счет,
     * 3-закончено,
     * 4-результаты все отправлены
     */
    int aminState;
    int recNumb;
    ArrayList<DropTask> branch;
    
    Element[] inputData;
    Element[] outputData;
    Element[] resultForOutFunction;
    
    
    

    public Amin(int type, int pProc, int pAmin, int dropNum, int index){
        
        DropTask drop = null; 
    	switch (type){
            
    		case 0: drop = new Multiply();
                        break;
    		case 1: drop = new MultiplyAdd();
                        break;
    		     
    		case 2: drop = new MultiplyMinus();
                    break;
    		case 3: drop = new Inversion();
                    break;
    		case 4: drop = new InversionAdd();
                    break;
    		//case 5: branch = new Cholesky();
    		//case 6: branch = new MultiplyExtended();*/
    	}
        
        this.type = type;
        branch = drop.doAmin(); 
        setIndexToDrops(index);
        inputData = new Element[drop.inputDataLength];
        resultForOutFunction = new Element[drop.resultForOutFunctionLength];
        outputData = null;
        parentProc = pProc;
        parentAmin = pAmin;
        dropId = dropNum;
        aminState = 0;
        recNumb = 0;
        aminIdInFirtree = index;
   
    }
    
     private void setIndexToDrops(int index)
     {
         for(int i = 0; i< branch.size(); i++)
             branch.get(i).aminFirtree = index;  
     }
     @Override
        public String toString() {
           String str = "";
           for (DropTask i: branch) {
                 str += i+"\n";
           }
           
           return str;
        }
        
         public int GetMyDrop(DropTask dp){
            return branch.indexOf(dp);
         }
         
        public int SetState(){
        for(int i=0; i<branch.size(); i++){
            if(branch.get(i).state!=1&&branch.get(i).state!=5){
                aminState=0;
              return aminState;
            }
        }
        aminState=1;
        return aminState;
    }  
    
}

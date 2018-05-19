/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mathpar.students.ukma17i41.bosa.parallel.engine;
//package com.mathpar.students.ukma17i41.sidko.engine;

import com.mathpar.matrix.MatrixS;
import com.mathpar.number.Element;
import com.mathpar.number.Ring;
import java.util.ArrayList;

/**
 *
 * @author sasha
 */
public class Multiply extends DropTask{
    
    public Multiply(){
    inData = new Element[2];
    outData = new Element[1];
    numberOfMainComponents = 2;
    state = 0;
     arcs=new int [][]{{1,0,0,1,4,1, 2,1,0,2,6,1, 3,0,0,3,5,1, 4,1,0,4,7,1,
        5,2,0,5,4,1, 6,3,0,6,6,1, 7,2,0,7,5,1, 8,3,0,8,7,1},
        {2,0,2},{9,0,0},{4,0,2},{9,0,1},{6,0,2},{9,0,2},{8,0,2},{9,0,3},{}};
    type=0;
    resultForOutFunctionLength = 4;
    inputDataLength = 2;
    
    }
    
    @Override
    public ArrayList<DropTask> doAmin(){
        amin = new ArrayList<DropTask>();
        
        amin.add(new Multiply());
        amin.add(new MultiplyAdd());
        amin.add(new Multiply());
        amin.add(new MultiplyAdd());
        amin.add(new Multiply());
        amin.add(new MultiplyAdd());
        amin.add(new Multiply());
        amin.add(new MultiplyAdd());  

        return amin;     
    }
    
    @Override
    public void sequentialCalc(){   
        outData[0] = inData[0].multiply(inData[1], Ring.ringZxyz);
         System.out.println("result of MULTIPLY sequentialCalc"+outData[0]);
       
    }
    
    @Override
    public MatrixS[] inputFunction(Element []input){
        
      MatrixS ms =  (MatrixS)input[0];
      MatrixS ms1 = (MatrixS)input[1];
       
      MatrixS []res = Tools.concatTwoArrays(ms.split(), ms1.split());
      
      for (MatrixS m: res) {
            System.out.println(m.toString());  
          }
     return res;
    }
    
    @Override
    public MatrixS[] outputFunction(Element[] input) {
      
        MatrixS[] resmat = new MatrixS[input.length];
       for(int i=0; i<input.length;i++){
         resmat[i] = (MatrixS)input[i];
       }
       
        MatrixS[] res = new MatrixS[]{MatrixS.join(resmat)};  
        
         for(int i=0; i<res.length;i++){
          System.out.println("res = "+res[i]);
       }
        
        return res;        
       
    }
    
    @Override
    public boolean isItLeaf(){
        MatrixS ms = (MatrixS)inData[0];
        return (ms.size <= 1);
    }

  
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package com.mathpar.students.ukma17i41.sidko.engine;
package com.mathpar.students.ukma17i41.bosa.parallel.engine;

import com.mathpar.matrix.MatrixS;
import com.mathpar.number.Element;
import com.mathpar.number.Ring;

/**
 *
 * @author alla
 */
public class MultiplyExtended extends Multiply {
    public MultiplyExtended(){
    inData = new Element[2];
    outData = new Element[2];
    numberOfMainComponents = 1;
    state = 0;
    arcs=new int [][]{{1,0,0,1,4,1, 2,1,0,2,6,1, 3,0,0,3,5,1, 4,1,0,4,7,1,
        5,2,0,5,4,1, 6,3,0,6,6,1, 7,2,0,7,5,1, 8,3,0,8,7,1},
        {2,0,2},{9,0,0},{4,0,2},{9,0,1},{6,0,2},{9,0,2},{8,0,2},{9,0,3},{}};
    type=6;
    resultForOutFunctionLength = 4;
    inputDataLength = 2;
    }
    
     @Override
    public void sequentialCalc(){   
        MatrixS b = ((MatrixS)inData[0]).transpose();
        outData[1] = b;
        MatrixS multMinus = Tools.setMinus(b.multiply(inData[0], Ring.ringZxyz));
        MatrixS matrix = (MatrixS)inData[1];
        //Element  mas = b;
        
        //Element res = inData[1].add(b, Ring.ringZpX);
        //outData[0] = res;
        
        Element n = new Element();
        System.out.println("n= "+ n.doubleValue());
        //System.out.println("outData[0]= "+ outData[0]);
        //System.out.println("outData[1]= " + outData[1]);
    }
    
    @Override
    public MatrixS[] inputFunction(Element []input){
        
      MatrixS ms =  ((MatrixS)input[0]).transpose();
      MatrixS ms1 = (MatrixS)input[0];
       
      MatrixS []res = Tools.concatTwoArrays(ms.split(), ms1.split());
      
      for (MatrixS m: res) {
            System.out.println(m.toString());  
          }
     return res;
    }
    
    @Override
    public MatrixS[] outputFunction(Element[] input) {
       
        MatrixS[] resmat = (MatrixS[])input;
        Element[] res = new Element[]{inData[1].add(Tools.setMinus(MatrixS.join(resmat)), Ring.ringZxyz)}; 
        System.out.println("res in outputFunction = "+res[0]);
        return (MatrixS[])res;        
      
    }
    
}

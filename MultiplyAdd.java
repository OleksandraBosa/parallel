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


public class MultiplyAdd extends Multiply{
    
    public MultiplyAdd(){
        inData = new Element[3];
        outData = new Element[1];
        numberOfMainComponents = 2;
        state = 0;
        arcs=new int[][]{{1,0,0,1,4,1, 2,1,0,2,6,1, 3,0,0,3,5,1, 4,1,0,4,7,1,
            5,2,0,5,4,1, 6,3,0,6,6,1, 7,2,0,7,5,1, 8,3,0,8,7,1},
            {2,0,2},{9,0,0},{4,0,2},{9,0,1},{6,0,2},{9,0,2},{8,0,2},{9,0,3},{}};
        type=1;
        resultForOutFunctionLength = 5;
        inputDataLength = 3;
        connectionsOfNotMain = new int[]{4};
    }

 
    @Override
    public void sequentialCalc(){  
        boolean flag=true;
        while(flag){
            if(inData[2]==null)
            continue;
            else{
            outData[0] = inData[0].multiply(inData[1], Ring.ringZxyz).add(inData[2],Ring.ringZxyz);
            System.out.println("result of multiplyADD sequentialCalc"+outData[0]);
            flag=false;
            }
             } 
        }
      
    @Override
    public MatrixS[] outputFunction(Element[] input){
        
       
       MatrixS[] resmat = new MatrixS[input.length];
       for(int i=0; i<input.length;i++){
         resmat[i] = (MatrixS)input[i];
       } 
        MatrixS[] res = new MatrixS[]{MatrixS.join(resmat).add((MatrixS)input[4], Ring.ringZxyz)};  
        return res;
        
    }
}

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
 * @author sasha
 */
public class MultiplyMinus extends Multiply {
    public MultiplyMinus(){       
    super();
    type=2;
    }
    
    @Override
    public void sequentialCalc(){     
        outData[0] = inData[0].multiply(inData[1], Ring.ringZpX).negate(Ring.ringZpX);
        System.out.println(outData[0]);
    }
      
    @Override
    public MatrixS[] outputFunction(Element[] input){
        MatrixS[] resmat = (MatrixS[])input;
        Element[] res = new Element[]{ Tools.setMinus(MatrixS.join(resmat))};
        return (MatrixS[])res;
        
    }
    
    
}

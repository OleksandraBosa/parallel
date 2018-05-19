/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mathpar.students.ukma17i41.bosa.parallel.engine;

import com.mathpar.matrix.MatrixS;
import com.mathpar.number.Element;
import com.mathpar.number.Ring;
import java.util.ArrayList;

/**
 *Дроп для обернення 
 * @author sasha
 */

    
    /**
     * inData - масив з вхідної матриці для обернення
     * outData - вихідний масив з оберненою матрицею
     * numberOfMainComponents - 1, бо на вхід тільки один компонент
     * state - стан обчислень в Дропі, 0 за замовчуванням
     * arcs - двовимірний масив усіх зв'язів графа
     * type - 2, позначає тип Дропу обернення
     * resultForOutFunctionLength - 4 блоки матриці
     * inputDataLength - довжина вхідного масиву
     */


public class Inversion extends Multiply  {

    public Inversion(){
    inData = new Element[1];
    outData = new Element[1];
    numberOfMainComponents = 1;
    state = 0;
    arcs = new int [][]{{1,0,1, 2,2,1, 3,1,1, 4,2,1, 5,3,1},{2,0,0,3,0,0},
        {7,0,1,8,0,0},{4,0,0},{5,0,0},{6,0,0,7,0,0,9,0,3},{8,0,1,9,0,2},{9,0,1},
        {9,0,0},{}};
           
    type=3;
    resultForOutFunctionLength = 4;
    inputDataLength = 1;
    }
    
    /**
     * 
     * @return 
     */
    @Override
    public ArrayList<DropTask> doAmin(){
        amin = new ArrayList<DropTask>();
        amin.add(new Inversion());
        amin.add(new Multiply());
        amin.add(new Multiply());
        amin.add(new MultiplyMinus());
        amin.add(new InversionAdd());
        amin.add(new MultiplyMinus());
        amin.add(new Multiply());
        amin.add(new MultiplyAdd());  

        return amin;     
    }
    
    /**
     * послідовне обчислення оберненої матриці, якщо задача листова
     */
    @Override
    public void sequentialCalc(){
     
        amin.add(new Multiply());
        outData[0] = inData[0].inverse(Ring.ringZxyz);
        System.out.println(outData[0]);
    }
    
    /**
     * функція поділу матриці на блоки
     * @param input - масив з однієї матриці
     * @return масив з чотирьох блоків цієї матриці
     */
    @Override
    public MatrixS[] inputFunction(Element []input){
        
      MatrixS ms =  (MatrixS)input[0];
       
      MatrixS []res = ms.split();
      
     // for (Element m: inData) {
      //      System.out.println(m.toString());  
       //   }
     return res;
    }
}

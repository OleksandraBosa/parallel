/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mathpar.students.ukma17i41.bosa.parallel.engine;

import com.mathpar.matrix.MatrixS;
import com.mathpar.number.Element;
import com.mathpar.number.Ring;

/**
 *Дроп для обернення з додаванням
 * @author sasha
 */
public class InversionAdd extends Inversion{
    /**
     * inData - масив з вхідної матриці для обернення
     * outData - вихідний масив з оберненою матрицею
     * numberOfMainComponents - 1, можна зробити важку операцію обернення без другого доданка
     * state - стан обчислень в Дропі, 0 за замовчуванням
     * arcs - двовимірний масив усіх зв'язів графа
     * type - 3, позначає тип Дропу обернення з додаванням
     * resultForOutFunctionLength - 5, 4 блоки матриці і матриця - другий доданок
     * inputDataLength - довжина вхідного масиву
     */
     public InversionAdd(){
    inData = new Element[2];
    outData = new Element[1];
    numberOfMainComponents = 2;
    state = 0;
    arcs = new int [][]{{1,0,0, 2,2,1, 3,1,1, 4,2,1, 5,3,1},{2,0,0,3,0,0},
        {7,0,1,8,0,0},{4,0,0},{5,0,0},{6,0,0,7,0,0,9,0,3},{8,0,1,9,0,2},{9,0,1},
        {9,0,0},{}};
           
    type=4;
    resultForOutFunctionLength = 5;
    inputDataLength = 1;
    }
    
     /**
      * якщо задача листова входимо в послідовний рахунок: обернення матриці і додаємо до неї другу матрицю
      */
     @Override
    public void sequentialCalc(){     
        outData[0] = inData[0].add(inData[1], Ring.ringZpX).inverse(Ring.ringZpX);
        System.out.println(outData[0]);
    }
  
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mathpar.students.ukma17i41.bosa.parallel.engine;
//package com.mathpar.students.ukma17i41.sidko.engine;

import com.mathpar.matrix.MatrixS;
import com.mathpar.number.Array;
import com.mathpar.number.Ring;
import com.mathpar.parallel.ddp.MD.examples.multiplyMatrix.FactoryMultiplyMatrix;
import com.mathpar.parallel.ddp.MD.examples.multiplyMatrix.TaskMultiplyMatrix;
import mpi.MPI;
import mpi.MPIException;

//openmpi/bin/mpirun --hostfile hostfile -np 16 java -cp /home/sasha/stemedu/stemedu/target/classes  com/mathpar/students/ukma17i41/bosa/parallel/engine/Multtest

public class Multtest {
    
    public static void main(String[]args) throws MPIException{
        
        
                MPI.Init(args);
                int rank = MPI.COMM_WORLD.getRank();
                Ring ring = new Ring("R64[]");
                Firtree f = new Firtree();
              
                MatrixS A = Tools.init(8);
		MatrixS B = Tools.init(8);
                
                  
                if (rank==0){
                    System.out.println("A= "+ A);
                    System.out.println("B= "+ B);}
                 MatrixS [] init = new MatrixS[]{A,B};
                 MatrixS [] initA = new MatrixS[]{A};
                
                DispThread disp = new DispThread(0, f, 100, args, init);
               
             
                    //MatrixS result = (MatrixS)f.body.get(0).branch.get(f.body.get(0).branch.size()-1).outData[0];
                    //System.out.println("A*B = "+result.toString());
                   // MatrixS res = A.multiply(B,Ring.ringZxyz);
                    //System.out.println("res="+res);

                   // MatrixS sub = result.subtract(res, Ring.ringZxyz);


               // if (sub.isZero(Ring.ringZxyz)) {
             //   System.out.println("ok");
              //  } else{
             //   System.out.println("error");
          // }
        
                    
		/*MatrixS A = Tools.init(2);
		MatrixS B = Tools.init(2);
		System.out.println("-------Multiply-------");
		Multiply m = new Multiply();
		m.inData[0]=A;
		m.inData[1]=B;
		System.out.println("A = " + A.toString());
		System.out.println("B = " + B.toString());
                System.out.println("inData[0] = " + m.inData[0].toString());
		System.out.println("inData[1] = " + m.inData[1].toString());
		System.out.println("doAmin = " + m.doAmin());
		System.out.println("inputDrop = ");
		m.inputDrop();
                System.out.println("OutputDrop = ");
		m.outputDrop(A.split());
                System.out.println("sequentialCalc = ");
		m.sequentialCalc();
		System.out.println("isItLeaf = "+ m.isItLeaf());
		


		System.out.println("-------MultiplyAdd-------");
		MatrixS C = Tools.init(2);
		MultiplyAdd m1 = new MultiplyAdd();
		m1.inData[0]=A;
		m1.inData[1]=B;
		m1.inData[2]=C;
		System.out.println("A = " + A.toString());
		System.out.println("B = " + B.toString());
		System.out.println("C = " + C.toString());
		System.out.println("doAmin = " + m1.doAmin());
		System.out.println("inputDrop = ");
		m1.inputDrop();
                System.out.println("OutputDrop = ");
		m1.outputDrop(A.split());
                System.out.println("sequentialCalc = ");
		m1.sequentialCalc();
		System.out.println("isItLeaf = "+ m1.isItLeaf());
                */
                

                MPI.Finalize();
	}
    
}


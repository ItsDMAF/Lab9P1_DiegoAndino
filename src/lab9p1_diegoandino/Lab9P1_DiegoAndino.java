
package lab9p1_diegoandino;

import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.util.ArrayList;



public class Lab9P1_DiegoAndino {
    
    static Scanner leer = new Scanner(System.in);
    static Random aleatorio = new Random();
    static Game g = new Game();


    public static void main(String[] args) {
        int opcion = menu();
       
        do{
        switch(opcion){
            case 1:
//------------------------------------------------------------------------------   
              System.out.println("GAME OF LIFE...");
                System.out.println("Ingrese el numero de rondas: ");
                int  rondas = leer.nextInt();
                
                int [][] tablero = new int [10][10];
                int [][] tableronew  = new int [10][10];
                ArrayList<String> list = new ArrayList<>();
               
                tablero = TableroFill(tablero, tableronew, list);
                g.setMatrixint(tablero);
                g.setMatrixnew(tableronew);
                g.setRondas (rondas);
                
                g.jugar(rondas);
                  
//------------------------------------------------------------------------------
                 break;
        }
        opcion = menu();
        }while(opcion != 2);
         
        }
    public static int menu(){
        int opcion;
        System.out.println("-------MENU-------");
        System.out.println("1<- GAME OF LIFE ");
        System.out.println("2<- SALIDAS");
        System.out.println("Ingrese su opcion:");

        opcion = leer.nextInt();
         return opcion;
    }
    
    public static int [][] TableroFill (int [][]tablero, int[][] tableronew, ArrayList<String>list){
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                if (i == 0 || j == 0 || i == 9 || j == 9) {
                    tablero[i][j] = 0;
                }
                else{
                    tablero[i][j] = aleatorio.nextInt(2);
                    if (tablero[i][j] == 1) {
                        list.add(Integer.toString(i) + ":" + Integer.toString(j));  
                    }
                }
            }  
        }
        g.setCoords(list);
        return tablero;   
}
    
    
}
        
    
    
    
            


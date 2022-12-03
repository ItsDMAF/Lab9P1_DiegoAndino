
package lab9p1_diegoandino;

import java.util.ArrayList;

public class Game {
    int [][] Matrixint = new int [10][10];
    int [][] Matrixnew = new int [10][10];
    ArrayList<String> coords = new ArrayList<>();
    int Rondas = 0;
    
    public Game(){
        
    }
    
   
//------------------------------------------------------------------------------
//------------------------------------------------------------------------------
    public int[][] getMatrixint() {
        return Matrixint;
    }

    public void setMatrixint(int[][] Matrixint) {
        this.Matrixint = Matrixint;
    }

    public int[][] getMatrixnew() {
        return Matrixnew;
    }

    public void setMatrixnew(int[][] Matrixnew) {
        this.Matrixnew = Matrixnew;
    }

    public ArrayList<String> getCoords() {
        return coords;
    }

    public void setCoords(ArrayList<String> coords) {
        this.coords = coords;
    }

    public int getRondas() {
        return Rondas;
    }

    public void setRondas(int Rondas) {
        this.Rondas = Rondas;
    }
//------------------------------------------------------------------------------
//------------------------------------------------------------------------------
      public int getNumves (int i, int j){
        int cont = 0;
        for (int k = -1; k < 1; k++) {
            if (i + k > -1 &&  i + k < 10 && j - 1 > -1) {
                if (Matrixint[i+k][j-1] == 1 && i + k != i) {
                    cont++;  
                } 
            }
            else if (i+k > -1 && i + k < 10 && j + 1 < 10){
                if (Matrixint[i + k][j - 1] == 1 && i + k != i){
                    cont++;
                }
            }
            else if (i+k > -1 && j + k < 10 && i+1 > -1){
                if (Matrixint [i-1][j+k]==1 && j + k != i) {
                    cont++;
                }
            }
            else if (j + j > -1 && j + k < 10 && i + 1 < 10){
                if (Matrixint [i+1][j+k] == 1 && i + k != i) {
                    cont++;
                    
                }
            }
        }
        return cont;
    }
    
    public void NextGeneration() {
        coords.clear();
        
        for (int i = 1; i <9; i++) {
            for (int j = 1; j <9; j++) {
                if (Matrixint[i][j] == 1 && getNumves(i, j) < 2) {
                    Matrixnew[i][j] = 0;
                    
                } else if (Matrixint[i][j] == 1 && getNumves(i, j) > 3) {
                    Matrixnew[i][j] = 0;
                    
                } else if (Matrixint[i][j] == 0 && getNumves(i, j) == 3) {
                    Matrixnew[i][j] = 1;
                    
                } else if (Matrixint[i][j] == 1 && getNumves(i, j) == 2) {
                    Matrixnew[i][j] = 1;
                    
                } else {
                    Matrixnew[i][j] = 0;
                }
                if(Matrixnew[i][j]==1){
                    coords.add(Integer.toString(i)+" : "+Integer.toString(j)); 
                }
            }
        }

        Matrixint = Matrixnew;
        Matrixnew = new int[10][10];

    }
    
    public void print(ArrayList<String> list){
        String output = "";
        int[][] temp = new int [10][10];
        for (int i = 0; i < list.size(); i++) {
            String [] coor = list.get(i).split(":");
            
            temp[Integer.parseInt(coor[0])][Integer.parseInt(coor[1])]=1;   
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                output += "[" + temp[i][j] + "]";
            }   
            output += "\n";
        }
        System.out.println(coords);
        System.out.println(output);
    }
    
    public void jugar(int rondas) {
        for (int i = 0; i < rondas; i++) {
            print(coords);
            NextGeneration();
        }
        System.out.println("");
        System.out.println("");
    }
    
   
}



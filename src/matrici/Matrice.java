/*
 * Matrice: una classe wrapper
 * per una matrice bidimensionale di interi.
 */

package matrici;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sandro Gallo
 */
public class Matrice {
    
    int[][] theMatrix;
    
    // costruttore uno
    public Matrice(int x, int y) {
        theMatrix = new int [x][y];
    }
    
    // costruttore due
    public Matrice(int[][] m) {
        theMatrix = m;
    }
    
    public void fillRandom() {
      for (int i = 0; i < theMatrix.length; i++) {
        for (int j = 0; j < theMatrix[i].length; j++) {
          theMatrix[i][j] = (int) (Math.random()*10);
        }
      }
    }

    @Override
    public String toString() {
     String s = "";
        for (int i = 0; i < theMatrix.length; i++) {
            for (int j = 0; j < theMatrix[i].length; j++) {
                s += theMatrix[i][j];
                if (j<theMatrix[i].length -1) s+= ";";
                      }s += "\n";
        }return s;
    }

    public void toFile( String filename ) {
        try {
            FileWriter fw = new FileWriter (filename);
            fw.write(this.toString());
            fw.close();
                
        } catch (IOException ex) {
            Logger.getLogger(Matrice.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void fromFile( String filename ) {
        int x=0;
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            while(br.ready()){
                String s = br.readLine();
                //riempie theMatrix[0];
                String[] ss = s.split(";");
                if (ss.length != theMatrix[x].length) {
                    System.out.println("ERRORE: la riga corrente non ha il giusto numero di elementi");
                    continue;
                }
                for (int i = 0; i < theMatrix[x].length; i++) {
                    theMatrix[x][i] = Integer.parseInt(ss[i]);
                    
                }
                x++;
            }
            br.close();
                    
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Matrice.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Matrice.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private int FileReader(String filename) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

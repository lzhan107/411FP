/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fp;

import GUIUtilities.FPIndexForm;
import javax.swing.SwingUtilities;

/**
 *
 * @author Hao
 */
public class FP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Initiate the Swing application
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() {
                new FPIndexForm().setVisible(true);
            }
        });
    }
}

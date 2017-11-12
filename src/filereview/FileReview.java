/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filereview;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author wkuan
 */
public class FileReview {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int tamx = 800;
        int tamy = 600;
        JFrame mainFrame = new JFrame("File Review");
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        mainFrame.setBounds(dim.width/2-tamx/2, dim.height/2-tamy/2, tamx, tamy);
        List<String> aList = new ArrayList<>();
        
        for(int i=0;i<200;i++){
            aList.add("Lorem ipsum dolor sit amet, atqui mediocritatem in nec. Vix dictas atomorum scripserit an, veniam vulputate in est, nec tempor impetus te. Et usu amet prompta, cu offendit gubergren aliquando his. Eos vidisse tibique eleifend ut. Ad patrioque rationibus pri, et blandit deserunt vix. Nec case probatus id, quo et vocibus commune menandri.");
        }
        mainFrame.add(new ContentComparisonPanel(aList,aList));
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    }
    
}

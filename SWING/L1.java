package SWING;

import javax.swing.*;

/**
 * Created by Дмитрий on 15.02.2015.
 */
public class L1 {

    L1() {


        JFrame jfrm = new JFrame("A simple Swing prog");

        jfrm.setSize(275, 100);

        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel jlab = new JLabel("SWENG..............");

        jfrm.getContentPane().add(jlab);


        jfrm.setVisible(true);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new L1();
            }
        });

    }


}

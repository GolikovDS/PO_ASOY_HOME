package SWING;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Дмитрий on 19.02.2015.
 */
public class ComboBox {

    JLabel jlab;
    JComboBox jcbx;

    String[] apples = {"Winesap", "Cortland", "Red Delicious",
            "Golden Delicious", "Gala", "Fuji",
            "Granny Smith", "Jonathan"};

    ComboBox() {
        JFrame jfrm = new JFrame("JListModel");
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfrm.setSize(180, 240);
        jfrm.getContentPane().setLayout(new FlowLayout());

        jcbx = new JComboBox(apples);

        jlab = new JLabel();

        jcbx.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String item = (String) jcbx.getSelectedItem();
                jlab.setText("Current selection: " + item);
            }
        });


        jcbx.setSelectedIndex(0);

        jfrm.getContentPane().add(jcbx);
        jfrm.getContentPane().add(jlab);

        jfrm.setVisible(true);


    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ComboBox();
            }
        });
    }
}

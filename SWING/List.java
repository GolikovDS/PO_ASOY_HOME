package SWING;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Дмитрий on 19.02.2015.
 */
public class List {

    JLabel jlab;
    JScrollPane jsp;
    JList jlst;
    JButton jbtn;

    String[] apples = {"Winesap", "Cortland", "Red Delicious",
            "Golden Delicious", "Gala", "Fuji",
            "Granny Smith", "Jonathan"};


    List() {

        JFrame jfrm = new JFrame("List");
        jfrm.setSize(250, 300);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfrm.getContentPane().setLayout(new FlowLayout());

        jlst = new JList(apples);
        jlst.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        jsp = new JScrollPane(jlst);
        jsp.setPreferredSize(new Dimension(120, 90));

        jlab = new JLabel("Please choose an apple.");

        jlst.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int index = jlst.getSelectedIndex();

                if (index != -1)
                    jlab.setText("Current selection " + apples[index]);
                else
                    jlab.setText("Please choose an apple.");
            }
        });

        jbtn = new JButton("Buy apple");

        jbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = jlst.getSelectedIndex();

                if (index != -1)
                    jlab.setText("You purchased  " + apples[index]);
                else
                    jlab.setText("No apple has been selected.");
            }
        });

        jfrm.getContentPane().add(jsp);
        jfrm.getContentPane().add(jbtn);
        jfrm.getContentPane().add(jlab);

        jfrm.setVisible(true);


    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new List();
            }
        });
    }
}

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
public class ListModel {

    JLabel jlab;
    JList jlst;
    JScrollPane jsp;
    JButton jbtnBuy;
    JButton jbtAddDel;

    ListModel() {

        JFrame jfrm = new JFrame("JListModel");
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfrm.setSize(180, 240);
        jfrm.getContentPane().setLayout(new FlowLayout());

        DefaultListModel lm = new DefaultListModel();

        lm.addElement("Winesap");
        lm.addElement("Cortland");
        lm.addElement("Red Delicious");
        lm.addElement("Golden Delicious");
        lm.addElement("Gala");

        jlst = new JList(lm);

        jsp = new JScrollPane(jlst);

        jlab = new JLabel("Please choose apple");

        jlst.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

                String what = "";

                Object[] values = jlst.getSelectedValues();

                if (values.length == 0) {
                    jlab.setText("Please choose an apple");
                    return;
                }

                for (int i = 0; i < values.length; i++)
                    what += values[i] + "<br>";
                jlab.setText("<html>Current selection: <br> " + what);
            }
        });

        jbtnBuy = new JButton("Buy apple");

        jbtnBuy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String what = "";

                Object[] values = jlst.getSelectedValues();

                if (values.length == 0) {
                    jlab.setText("No apple has been selected");
                    return;
                }

                for (int i = 0; i < values.length; i++)
                    what += values[i] + "<br>";
                jlab.setText("<html>Apple purchased: <br> " + what);
            }
        });

        jbtAddDel = new JButton("Add more variant");

        jbtAddDel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultListModel lm = (DefaultListModel) jlst.getModel();

                if (lm.getSize() > 5) {

                    for (int i = 7; i > 4; i--)
                        lm.remove(i);
                    jbtAddDel = new JButton("Add more variant");
                } else {

                    lm.addElement("Fuji");
                    lm.addElement("Granny Smith");
                    lm.addElement("Jonathan");
                    jbtAddDel.setText("Remove Extra Varieties");
                }
            }
        });

        jfrm.getContentPane().add(jsp);
        jfrm.getContentPane().add(jbtnBuy);
        jfrm.getContentPane().add(jbtAddDel);
        jfrm.getContentPane().add(jlab);

        jfrm.setVisible(true);


    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ListModel();
            }
        });
    }


}

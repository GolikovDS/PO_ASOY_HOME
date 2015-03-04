package SWING;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Дмитрий on 15.02.2015.
 */
public class L2 implements ActionListener {

    JLabel jlab;
    JTextField jtxf;

    L2() {
        JFrame jfrm = new JFrame("A Button");
        jfrm.getContentPane().setLayout(new FlowLayout());
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfrm.setSize(300, 200);
        JButton jbtnFirst = new JButton("First");

        JButton jbtnSecond = new JButton("Second");

        jbtnFirst.addActionListener(this);
        jbtnSecond.addActionListener(this);

        jfrm.getContentPane().add(jbtnFirst);
        jfrm.getContentPane().add(jbtnSecond);

        jlab = new JLabel("Press a button");

        jfrm.getContentPane().add(jlab);

        jtxf = new JFormattedTextField(10);

        jfrm.getContentPane().add(jtxf);

        jfrm.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new L2();
            }
        });
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("First")) {
            jlab.setText("First button action" + jtxf.getText());

        } else {
            jlab.setText("Second button action");
        }
    }

/*
    @Override
    public void actionPerformed(ActionEvent e) {

    }*/
}


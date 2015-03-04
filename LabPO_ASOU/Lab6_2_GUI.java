package LabPO_ASOU;

import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.*;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by Дмитрий on 20.02.2015.
 */
public class Lab6_2_GUI {

    JTable jtab;
    JLabel jlabNamePane;
    JTabbedPane jpnl2;
    JButton jbAdd;
    JButton jbDel;
    JButton jbChange;

    JPanel jpAdd;
    JPanel jpDel;

    JTextField tfName;
    JTextField tfPhone;
    JTextField tfEmail;
    JTextField tfIndex;

    final String[] tableHeading  = {"Индекс", "Имя", "Телефон", "e-mail"};


    public Lab6_2_GUI(){




        JLabel lName = new JLabel("Имя");
        JLabel lPhone = new JLabel("Телефон");
        JLabel lEmale = new JLabel("E-mail");
        JLabel lIndex = new JLabel("Индекс");


        final DAL_AddresBook dal_addresBook = new DAL_AddresBook();
        final ArrayList<Address_6_2> date = (ArrayList<Address_6_2>) dal_addresBook.printAllNode();
        TableModel addModel = new TableModel() {
            @Override
            public int getRowCount() {
                return date.size();
            }

            @Override
            public int getColumnCount() {
                return 4;
            }

            @Override
            public String getColumnName(int columnIndex) {
                switch (columnIndex) {
                    case 0:
                        return "Индекс";
                    case 1:
                        return "Имя";
                    case 2:
                        return "Телефон";
                    case 3:
                        return "E-mail";
                }
                return "";
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return String.class;
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                switch (columnIndex) {
                    case 0:
                        return Integer.toString(rowIndex + 1);
                    case 1:
                        return date.get(rowIndex).getName();
                    case 2:
                        return date.get(rowIndex).getPhone();
                    case 3:
                        return date.get(rowIndex).getEmail();
                }
                return "";
            }

            @Override
            public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

            }

            @Override
            public void addTableModelListener(TableModelListener l) {

            }

            @Override
            public void removeTableModelListener(TableModelListener l) {

            }
        };

        jbAdd = new JButton("Добавить");
        jbAdd.setPreferredSize(new Dimension(90, 30));

        jbDel = new JButton("Удалить");
        jbDel.setPreferredSize(new Dimension(90, 30));

        jbChange = new JButton("Изменить");
        jbChange.setPreferredSize(new Dimension(90, 30));

        tfName = new JTextField();
        tfPhone = new JTextField();
        tfEmail = new JTextField();
        tfIndex = new JTextField();

        //Данные таблицы
        //final String[][] date = addressToStrinfArray(dal_addresBook.printAllNode());

        final JFrame jfrm = new JFrame("Lab6_2");
        jfrm.getContentPane().setLayout(new FlowLayout());
        jfrm.setSize(630, 300);
        jfrm.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        jtab = new JTable(addModel);
        jtab.setEnabled(false);
        TableColumn column = jtab.getColumnModel().getColumn(0);
        column.setPreferredWidth(30);

        JScrollPane jspnl = new JScrollPane(jtab);
        jspnl.setPreferredSize(new Dimension(300, 200));
        jspnl.setBorder(BorderFactory.createLineBorder(Color.BLUE));

        /////////////////////////////////////////////////////////////////
        //Панель добавить
        ////////////////////////////////////////////////////////////////
        jpAdd = new JPanel();
        jpAdd.setLayout(new GridLayout(2, 1));
        JPanel jpInstr = new JPanel();
        jpInstr.setLayout(new GridLayout(3, 2));
        JPanel jpForBtn = new JPanel();
        jpForBtn.setLayout(new FlowLayout());

        jpForBtn.add(jbAdd);

        jpInstr.add(lName);
        jpInstr.add(tfName);
        jpInstr.add(lPhone);
        jpInstr.add(tfPhone);
        jpInstr.add(lEmale);
        jpInstr.add(tfEmail);

        jpAdd.add(jpInstr);
        jpAdd.add(jpForBtn);

        jbAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                dal_addresBook.add(new Address_6_2(tfName.getText(), tfPhone.getText(), tfEmail.getText()));
                jtab.updateUI();
            }
        });
        ////////////////////////////////////////////////////////////////

        ////////////////////////////////////////////////////////////////
        //Панель удалить
        ////////////////////////////////////////////////////////////////
        jpDel = new JPanel();
        jpDel.setLayout(new FlowLayout());
        JPanel pIndexDel =  new JPanel();
        pIndexDel.setLayout(new GridLayout(1, 2));
        JPanel pBtnDel = new JPanel();

        pBtnDel.add(jbDel);
        pIndexDel.add(lIndex);
        pIndexDel.add(tfIndex);

        jpDel.add(pIndexDel);
        jpDel.add(pBtnDel);

        jbDel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dal_addresBook.delete(Integer.valueOf(tfIndex.getText()) - 1);
                jtab.updateUI();
            }
        });
        /////////////////////////////////////////////////////////////////

        /////////////////////////////////////////////////////////////////
        //Панель изменить
        /////////////////////////////////////////////////////////////////
        JPanel pChange = new JPanel();
        pChange.setLayout(new GridLayout(2, 1));

        final JTextField tfIndexChange = new JTextField();
        final JTextField tfNameChange = new JTextField();
        final JTextField tfPhoneChange = new JTextField();
        final JTextField tfEmailChange = new JTextField();

        JLabel lIndexChange = new JLabel("Индекс");
        JLabel lNameChange = new JLabel("Имя");
        JLabel lPhoneChange = new JLabel("Телефон");
        JLabel lEmailChange = new JLabel("E-mail");

        JPanel jpForInstr = new JPanel();
        jpForInstr.setLayout(new GridLayout(4, 2));
        jpForInstr.add(lIndexChange);
        jpForInstr.add(tfIndexChange);
        jpForInstr.add(lNameChange);
        jpForInstr.add(tfNameChange);
        jpForInstr.add(lPhoneChange);
        jpForInstr.add(tfPhoneChange);
        jpForInstr.add(lEmailChange);
        jpForInstr.add(tfEmailChange);

        JPanel jpForBtnChange = new JPanel();
        jpForBtnChange.setLayout(new FlowLayout());

        jpForBtnChange.add(jbChange);

        pChange.add(jpForInstr);
        pChange.add(jpForBtnChange);

        tfIndexChange.addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                try {
                    tfNameChange.setText(dal_addresBook.searchIndex(Integer.valueOf(tfIndexChange.getText()) - 1).getName());
                    tfPhoneChange.setText(dal_addresBook.searchIndex(Integer.valueOf(tfIndexChange.getText()) - 1).getPhone());
                    tfEmailChange.setText(dal_addresBook.searchIndex(Integer.valueOf(tfIndexChange.getText()) - 1).getEmail());

                    jbChange.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            dal_addresBook.change(new Address_6_2(tfNameChange.getText(),
                                                  tfPhoneChange.getText(), tfEmailChange.getText()),
                                                  Integer.valueOf(tfIndexChange.getText()) - 1 );
                            jtab.updateUI();
                        }
                    });

                }catch (NumberFormatException ex){

                }catch (IndexOutOfBoundsException ex1){

                }

            }
        });

        /////////////////////////////////////////////////////////////////

        /////////////////////////////////////////////////////////////////
        //Панель поиска
        /////////////////////////////////////////////////////////////////

        JTabbedPane jtpSearch = new JTabbedPane();


        /////////////////////////////////////////////////////////////////
        //Поиск по индексу
        /////////////////////////////////////////////////////////////////
        JPanel jpSearchIndex = new JPanel();
        JLabel lIndexSearch = new JLabel("Индекс");
        final JTextField tfIndexSearch = new JTextField(20);
        JPanel jpSearchIndexText = new JPanel();
        jpSearchIndexText.setLayout(new FlowLayout());
        jpSearchIndexText.setPreferredSize(new Dimension(100, 200));
        jpSearchIndexText.add(lIndexSearch);
        jpSearchIndexText.add(tfIndexSearch);
        final JLabel rezultSearchName = new JLabel("");
        final JLabel rezultSearchPhone = new JLabel("");
        final JLabel rezultSearchEmail = new JLabel("");


        tfIndexSearch.addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                try {
                    Address_6_2 getSearch = dal_addresBook.searchIndex(Integer.valueOf(tfIndexSearch.getText()) - 1);
                    rezultSearchName.setText("Имя: " + getSearch.getName());
                    rezultSearchPhone.setText("Телефон: " + getSearch.getPhone());
                    rezultSearchEmail.setText("E-mail: " + getSearch.getEmail());
                }catch (NumberFormatException ex){
                    rezultSearchName.setText("");
                    rezultSearchPhone.setText("");
                    rezultSearchEmail.setText("");
                }catch (IndexOutOfBoundsException ex1){
                    rezultSearchName.setText("");
                    rezultSearchPhone.setText("");
                    rezultSearchEmail.setText("");
                }
            }
        });

        JPanel jpSearchIndexRezult = new JPanel();
        jpSearchIndexRezult.setLayout(new GridLayout(3, 1));
        jpSearchIndexRezult.add(rezultSearchName);
        jpSearchIndexRezult.add(rezultSearchPhone);
        jpSearchIndexRezult.add(rezultSearchEmail);

        jpSearchIndex.setLayout(new GridLayout(2, 1));

        jpSearchIndex.add(jpSearchIndexText);
        jpSearchIndex.add(jpSearchIndexRezult);


        /////////////////////////////////////////////////////////////////

        /////////////////////////////////////////////////////////////////
        //Поиск по имени
        /////////////////////////////////////////////////////////////////
        JPanel jpSearchName = new JPanel();
        JLabel lNameSearch = new JLabel("Имя");
        final JTextField tfNameSearch = new JTextField(20);
        JPanel jpSearchNameText = new JPanel();
        jpSearchNameText.setLayout(new FlowLayout());
        jpSearchNameText.setPreferredSize(new Dimension(100, 200));
        jpSearchNameText.add(lNameSearch);
        jpSearchNameText.add(tfNameSearch);

        final JLabel rezultSearchIndexName = new JLabel("");
        final JLabel rezultSearchNameName = new JLabel("");
        final JLabel rezultSearchPhoneName = new JLabel("");
        final JLabel rezultSearchEmailName = new JLabel("");
        tfNameSearch.addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {

                try {
                    List<Integer> getSearch = dal_addresBook.searchName(tfNameSearch.getText(), 0);

                    String index = "";
                    String name = "";
                    String phone = "";
                    String email = "";

                    for(int i = 0; i < getSearch.size(); i++){
                        index += (getSearch.get(i) + 1) + "; ";
                        name += date.get(getSearch.get(i)).getName() + "; ";
                        phone+= date.get(getSearch.get(i)).getPhone() + "; ";
                        email+= date.get(getSearch.get(i)).getEmail() + "; ";

                    }
                    rezultSearchIndexName.setText("Индекс: " + index);
                    rezultSearchNameName.setText("Имя: " + name);
                    rezultSearchPhoneName.setText("Телефон: " + phone);
                    rezultSearchEmailName.setText("E-mail: " + email);

                }catch (NumberFormatException ex){
                    rezultSearchIndexName.setText("");
                    rezultSearchNameName.setText("");
                    rezultSearchPhoneName.setText("");
                    rezultSearchEmailName.setText("");
                }catch (IndexOutOfBoundsException ex1){
                    rezultSearchIndexName.setText("");
                    rezultSearchNameName.setText("");
                    rezultSearchPhoneName.setText("");
                    rezultSearchEmailName.setText("");
                }
            }
        });

        JPanel jpSearchNameRezult = new JPanel();
        jpSearchNameRezult.setLayout(new GridLayout(4, 1));
        jpSearchNameRezult.add(rezultSearchIndexName);
        jpSearchNameRezult.add(rezultSearchNameName);
        jpSearchNameRezult.add(rezultSearchPhoneName);
        jpSearchNameRezult.add(rezultSearchEmailName);

        jpSearchName.setLayout(new GridLayout(2, 1));

        jpSearchName.add(jpSearchNameText);
        jpSearchName.add(jpSearchNameRezult);
        /////////////////////////////////////////////////////////////////
        jtpSearch.addTab("Поиск по индексу", jpSearchIndex);
        jtpSearch.addTab("Поиск по имени", jpSearchName);

        /////////////////////////////////////////////////////////////////

        jpnl2 = new JTabbedPane();
        jpnl2.addTab("Добавить", jpAdd);
        jpnl2.addTab("Удалить", jpDel);
        jpnl2.addTab("Изменить", pChange);
        jpnl2.addTab("Поиск", jtpSearch);

        jlabNamePane = new JLabel("");

        jpnl2.setPreferredSize(new Dimension(300, 200));
        jpnl2.setBorder(BorderFactory.createLineBorder(Color.BLUE));



        jfrm.add(jspnl);
        jfrm.add(jpnl2);
        jfrm.setVisible(true);

        jfrm.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                dal_addresBook.saveAndExit();
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent e) {


            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Lab6_2_GUI();
            }
        });
    }


    public String[][] addressToStrinfArray(java.util.List<Address_6_2> dateToParse){
        String[][] parsingDate = new String[dateToParse.size()][4];
        for (int i = 0; i < dateToParse.size(); i++){
            parsingDate[i][0] = Integer.toString(i);
            parsingDate[i][1] = dateToParse.get(i).getName();
            parsingDate[i][2] = dateToParse.get(i).getPhone();
            parsingDate[i][3] = dateToParse.get(i).getEmail();

        }
        return parsingDate;
    }




}

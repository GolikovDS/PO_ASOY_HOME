package LabPO_ASOU;

import jdk.nashorn.internal.objects.annotations.Where;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Дмитрий on 22.02.2015.
 */
public class ConsoleInterface {



    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int guess;
        DAL_AddresBook dal_addresBook = new DAL_AddresBook();


        while (true) {
            mainMenu(dal_addresBook);
            guess = in.nextInt();
            switch (guess) {

                case 1:
                    dal_addresBook.add(enterNameMenu()); break;
                case 2:
                    searchNode(dal_addresBook); break;
                case 3:
                    printAllNode(dal_addresBook.printAllNode()); break;
                case 4:
                    System.out.println("Введите индек элемента для удаления: ");
                    dal_addresBook.delete(in.nextInt() - 1);
                    break;
                case 5:
                    System.out.println("Введите индек элемента для изменения: ");
                    int index = in.nextInt() - 1;
                    dal_addresBook.change(enterNameMenu (), index);
                    break;
                case 6:
                    dal_addresBook.saveAndExit(); break;
                default:
                    System.out.println("Error namb");

            }
        }
    }

    public static void mainMenu (DAL_AddresBook dal_addresBook){

        System.out.println("******************************************************\n" +
                        "*       Главное меню                                 *\n" +
                        "******************************************************\n" +
                        "Всего записей: " + dal_addresBook.data.size() + "\n\n" +
                        "  1-Добавить запись\n" +
                        "  2-Поиск записи   \n" +
                        "  3-Вывести все записи   \n" +
                        "  4-Удалить запись   \n" +
                        "  5-Изменить запись    \n" +
                        "  6-Выход   \n"
        );
    }

    public static Address_6_2 enterNameMenu (){

        String name, phone, email;
        Scanner in = new Scanner(System.in);
        System.out.println("Введите новое имя:");
        name = in.nextLine();
        System.out.println("Введите новый телефон:");
        phone = in.nextLine();
        System.out.println("Введите новую почту:");
        email = in.nextLine();
        Address_6_2 newNode = new Address_6_2(name, phone, email);
        return newNode;

    }

    public static void searchNode(DAL_AddresBook node){
        Scanner in = new Scanner(System.in);

        System.out.println("Для поиска по имени нажмите 1\nДля поиска по индексу нажмите 2 ");

        int nambSearch = in.nextInt();
        if (nambSearch == 1){
            Scanner inLi = new Scanner(System.in);
            System.out.println("Введите имя: ");
            String name;
            name = inLi.nextLine();
            List <Address_6_2> searchNode = node.searchName(name);
            for (int i = 0; i < searchNode.size(); i++ ) {
                printNode(searchNode.get(i));
            }
            System.out.println("Поиск завершон");

        }else if(nambSearch == 2) {
            System.out.println("Введите индекс: ");
            printNode (node.searchIndex(in.nextInt() - 1));
        } else {

            System.out.println("Не верно введено значение");
        }


    }

    public static void printAllNode(List<Address_6_2> allNode){
        for (int i = 0; i < allNode.size(); i++){
            System.out.println("************Запись №" + Integer.toString(i + 1));
            System.out.println("Имя: " + allNode.get(i).getName());
            System.out.println("Телефон: " + allNode.get(i).getPhone());
            System.out.println("E-mail: " + allNode.get(i).getEmail());
            System.out.println("**************************************");
        }
    }

    public static void printNode(Address_6_2 Node){

            System.out.println("******************************************************************");
            System.out.println("Имя: " + Node.getName());
            System.out.println("Телефон: " + Node.getPhone());
            System.out.println("E-mail: " + Node.getEmail());
            System.out.println("******************************************************************");

    }


}

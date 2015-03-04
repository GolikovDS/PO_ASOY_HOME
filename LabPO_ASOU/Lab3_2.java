package LabPO_ASOU;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by Дмитрий on 13.02.2015.
 */
public class Lab3_2 {
    public static void main(String[] args) {
        int guess;
        int number = new Random().nextInt(100) + 1;
        Scanner in = new Scanner(System.in);


        while (true){
            guess = in.nextInt();            // число, прочитанное с клавиатуры
            if ( guess == number ) {
                System.out.println("Верно!!!");
                System.exit(0);
            } else {
                if ( guess > number )
                 System.out.println("Меньше");
                else
                 System.out.println("Больше");
            }

        }
    }
}

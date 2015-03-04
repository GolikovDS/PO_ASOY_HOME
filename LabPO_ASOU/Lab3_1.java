package LabPO_ASOU;

import javafx.beans.binding.Bindings;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Дмитрий on 13.02.2015.
 */
public class Lab3_1 {
    public static void main(String[] args) throws IOException {
        String reply = "";

        //Scanner in = new Scanner(System.in);
        for (int namber = 1; namber < 100; namber++) {

            if (namber % 5 == 0 && namber % 7 == 0) {
                reply += "ABBA ";
            } else {
                if (namber % 5 == 0)
                    reply += "A ";
                else if (namber % 7 == 0)
                    reply += "B ";
                else
                    reply += Integer.toString(namber) + " ";
            }
        }

        System.out.println(reply);
    }


}

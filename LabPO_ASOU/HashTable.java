package LabPO_ASOU;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Дмитрий on 02.03.2015.
 */
public class HashTable {

    public static void main(String[] args) throws FileNotFoundException {

        try {
            File f = new File("text.txt");
            Scanner sFile = new Scanner(f);
            System.out.println(f.getName());
            String textFile = sFile.next();
            sFile.useDelimiter("\\n");
            System.out.println(textFile);
        }catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }
}

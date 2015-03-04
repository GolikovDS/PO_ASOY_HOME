package LabPO_ASOU;

import com.sun.deploy.util.ArrayUtil;

import java.lang.reflect.Array;

/**
 * Created by Дмитрий on 13.02.2015.
 */
public class Lab4_2 {
    public static void main(String[] args) {
        int [] a = {1, 2, 3};
        int [] b = {7, 8};
        int [] z = new int[a.length + b.length];
        for (int i = 0; i < z.length; i++){
            if (i < a.length)
                z[i] = a[i];
            else
                z[i] = b[i - a.length];

        }
        for (int i = 0; i < z.length; i++)
            //System.out.println(Integer.toString(z[i]));
            System.out.println(z[i]);

    }
}

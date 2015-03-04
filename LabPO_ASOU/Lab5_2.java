package LabPO_ASOU;

/**
 * Created by Дмитрий on 13.02.2015.
 */
public class Lab5_2 {

    public static void main(String[] args) {
        int [] a = {1, 2, 3};
        int [] b = {7, 8};
        int [] z = concat (a, b);
        for (int i = 0; i < z.length; i++)
            System.out.println(Integer.toString(z[i]));
    }
    protected static int[] concat (int []x, int []y){
        int [] z = new int[x.length + y.length];
        for (int i = 0; i < z.length; i++){
            if (i < x.length)
                z[i] = x[i];
            else
                z[i] = y[i - x.length];

        }
        return z;
    }

}

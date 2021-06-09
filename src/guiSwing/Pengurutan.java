package guiSwing;

import java.util.ArrayList;
import java.util.List;

public class Pengurutan {
    public static int[] getascending(String text, int amount){
        int angka, i, j, temp;
        angka = amount;
        int arrA[] = new int[angka];


        int x = 0;
        String[] tmp = text.split(",");
        for (String psh : tmp){
            arrA[x] = Integer.parseInt(psh.trim());
            x++;
        }
        for (i=0; i<(angka-1); i++) {
            for (j=0; j<angka-i-1; j++) {
                if (arrA[j]>arrA[j+1])
                {
                    temp = arrA[j];
                    arrA[j] = arrA[j+1];
                    arrA[j+1] = temp;
                }
            }
        }
        return arrA;
    }

    public static int[] getdescending(String text, int amount){
        int angka, i, j, temp;
        angka = amount;
        int arrA[] = new int[angka];

        int x = 0;
        String[] tmp = text.split(",");

        for (String psh : tmp){
            arrA[x] = Integer.parseInt(psh.trim());
            x++;
        }
        for (i=0; i<(angka-1); i++) {
            for (j=0; j<angka-i-1; j++) {
                if (arrA[j]<arrA[j+1])
                {
                    temp = arrA[j];
                    arrA[j] = arrA[j+1];
                    arrA[j+1] = temp;
                }
            }
        }
        return arrA;
    }
}



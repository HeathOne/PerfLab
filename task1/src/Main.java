package com.company;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.io.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File(args[0]);
        ArrayList<Short> list = new ArrayList<>();
        Scanner scan = new Scanner(file);
        while (scan.hasNextLine()){
            list.add(scan.nextShort());
        }
        Collections.sort(list);

        double s = ((double) 90/100)*(list.size()-1)+1;
        int g = (int)Math.floor(s);
        double remains = s - g;
        double percentile = list.get(g - 1) +remains*(list.get(g) - list.get(g - 1));
        System.out.printf("%.2f%n", percentile);

        double medianochka;
        if(list.size() % 2 == 0)
            medianochka = list.get(list.size() / 2);
        else
            medianochka = ((double)list.get(list.size() / 2) + list.get((list.size() / 2) - 1))/2;
        System.out.printf("%.2f%n", medianochka);

        System.out.printf("%.2f%n", (double) Collections.max(list));

        System.out.printf("%.2f%n", (double) Collections.min(list));

        int summa = 0;
        for(short i: list) summa+=i;
        System.out.printf("%.2f%n", (double)summa/list.size());
    }
}

package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File file = new File("Input/input.txt");
        Scanner input = null;
        try {
            input = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Заполните массив");
        int mas[] = new int[5];
        for (int i = 0; i < mas.length; i++) {
            mas[i] = input.nextInt();
        }
        System.out.println("Не отсортированный массив:");
        System.out.println(Arrays.toString(mas));

        boolean isSorted = false;
        int buf;
        while(!isSorted) {
            isSorted = true;
            for (int i = 0; i < mas.length-1; i++) {
                if(mas[i] > mas[i+1]){
                    isSorted = false;

                    buf = mas[i];
                    mas[i] = mas[i+1];
                    mas[i+1] = buf;
                }
            }
        }
        System.out.println("Отсортированный массив:");
        System.out.println(Arrays.toString(mas));
        String sortedArrayAsString = Arrays.toString(mas);

        byte[] sortedArrayAsBytes = sortedArrayAsString.getBytes();

        try {
            Files.write(Paths.get("output/output.txt"), sortedArrayAsBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
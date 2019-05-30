/*
package org.eltech.ddm.runner;

import java.io.*;

public class VerDistr {
    public static void main(String[] args){

        String csvFile = "/home/derkach/test/100mb.csv";
        String csvSplitBy = ",";
        partCopyCSV(csvFile, "/home/derkach/test/100-1.csv", csvSplitBy, 0, 32);
        partCopyCSV(csvFile, "/home/derkach/test/100-2.csv", csvSplitBy, 33, 66);


        System.exit(0);
    }

    public static void partCopyCSV(String input, String output, String csvSplitBy, int from, int to){


        try(
                BufferedWriter writer = new BufferedWriter(new FileWriter(output));
                BufferedReader reader = new BufferedReader(new FileReader(input))) {

            String line;
            String[] cells;
            StringBuilder newLine = new StringBuilder("");

            String[] title = reader.readLine().split(csvSplitBy);
            int numberOfAttributes = title.length;
            for (int i = from; i <= to; i++)
                newLine.append(title[i]).append(csvSplitBy);
            writer.write(newLine.append(title[numberOfAttributes-1]).append('\n').toString());

            System.out.println(numberOfAttributes);

            if(from > to || numberOfAttributes <= to)
                throw new IllegalArgumentException();

            while ((line = reader.readLine()) != null){
                cells = line.split(csvSplitBy);
                if(cells.length != numberOfAttributes)
                    continue;
                newLine.delete(0, newLine.length());
                for (int i = from; i <= to ; i++) {
                    newLine.append(cells[i]).append(csvSplitBy);
                }
                newLine.append(cells[numberOfAttributes-1]);

                writer.write(newLine.append('\n').toString());
            }

        }
        catch (IOException e){
            e.printStackTrace();
        }

    }
}*/
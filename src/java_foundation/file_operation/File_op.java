package java_foundation.file_operation;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.HashMap;

public class File_op {

    public static void main(String[] args) {

        String url = "/home/cjy/OOSD_2026S2_Jerry.C/src/Java_foundation/student.txt";
        //String pattern = "\w:(pattern)";

        try (Scanner sc = new Scanner(new File(url))) {
            String[] partSet, part;
            HashMap <Integer, HashMap<String, Object>> dict = new HashMap<Integer, HashMap<String, Object>>();
            int index = 0;
            while (sc.hasNextLine()) {
                partSet = sc.nextLine().split(", ");
                HashMap <String, Object> subDict = new HashMap<String, Object>();
                for (String s : partSet) {
                    part = s.split(": ");
                    subDict.put(part[0], part[1]);
                }
                dict.put(index, subDict);
                index++;
            }

            System.out.println(dict.toString());

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

    }

}

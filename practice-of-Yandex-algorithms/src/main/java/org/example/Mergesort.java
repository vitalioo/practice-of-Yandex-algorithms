package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Mergesort {
    private int listSize1;
    private List<Integer> list1;
    private int listSize2;
    private List<Integer> list2;

    private void inputData() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            listSize1 = Integer.parseInt(reader.readLine());
            list1 = new ArrayList<>(listSize1);

            String[] values = reader.readLine().split(" ");
            for(int i = 0; i < listSize1; ++i) {
                list1.add(Integer.parseInt(values[i]));
            }

            listSize2 = Integer.parseInt(reader.readLine());
            list2 = new ArrayList<>(listSize2);

            values = reader.readLine().split(" ");
            for(int i = 0; i < listSize2; ++i) {
                list2.add(Integer.parseInt(values[i]));
            }

        } catch (IOException exception) {
            exception.printStackTrace();
            System.out.println(exception.getMessage());
        }
    }

    public void merge() {
        inputData();

        int bufferSize = listSize1 + listSize2;
        ArrayList<Integer> buffer = new ArrayList<>(bufferSize);

        int index1 = 0, index2 = 0;
        while (index1 < listSize1 && index2 < listSize2) {
            if (list1.get(index1) < list2.get(index2)) {
                buffer.add(list1.get(index1));
                ++index1;
            } else if (list1.get(index1) > list2.get(index2)) {
                buffer.add(list2.get(index2));
                ++index2;
            } else {
                buffer.add(list2.get(index2));
                ++index2;

                buffer.add(list1.get(index1));
                ++index1;
            }
        }

        if(index1 == listSize1) {
            while (index2 < listSize2) {
                buffer.add(list2.get(index2));
                ++index2;
            }
        } else if (index2 == listSize2) {
            while (index1 < listSize1) {
                buffer.add(list1.get(index1));
                ++index1;
            }
        }

        System.out.println(Arrays.toString(buffer.toArray()));
    }

}

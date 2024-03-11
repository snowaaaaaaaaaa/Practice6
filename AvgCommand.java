package com.mycompany.ex02;

import java.util.List;

public class AvgCommand implements Runnable {
    private final List<Integer> collection;

    public AvgCommand(List<Integer> collection) {
        this.collection = collection;
    }

    @Override
    public void run() {
        double avg = collection.stream().mapToInt(Integer::intValue).average().orElse(0);
        System.out.println("Average value: " + avg);
    }
}

package com.mycompany.ex02;

import java.util.Collection;

public class MaxCommand implements Runnable {
    private final Collection<Integer> numbers;
    private int result;

    public MaxCommand(Collection<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public void run() {
        result = ItemProcessor.findMax(numbers);
    }

    public int getResult() {
        return result;
    }

    void execute() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

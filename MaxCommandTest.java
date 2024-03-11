package com.mycompany.ex02;

import java.util.ArrayList;
import java.util.Collection;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MaxCommandTest {

    public void testMax() {
        Collection<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(5);
        numbers.add(20);
        numbers.add(15);

        MaxCommand maxCommand = new MaxCommand(numbers);
        maxCommand.execute();

        int maxNumber = maxCommand.getResult();
        assertEquals(20, maxNumber);
    }
}

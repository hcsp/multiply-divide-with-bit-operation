package com.github.hcsp.calculation;

import com.github.hcsp.test.helper.ProjectSourceFileReader;
import java.util.Random;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MainTest {
    @Test
    public void test() throws Exception {
        int number = new Random().nextInt(10000);

        Assertions.assertEquals(number / 16, Main.divide16(number));
        Assertions.assertEquals(number * 16, Main.multiply16(number));
        Assertions.assertEquals(-16 / 16, Main.divide16(-16));
        Assertions.assertEquals(-1 * 16, Main.multiply16(-1));

        String mainJava = ProjectSourceFileReader.readAsString(Main.class);
        Assertions.assertFalse(mainJava.contains("*"));
        Assertions.assertFalse(mainJava.replaceAll("/", "").contains("/"));
    }
}

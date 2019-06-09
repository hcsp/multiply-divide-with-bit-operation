package com.github.hcsp.calculation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.io.*;
import java.util.stream.Stream;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;

public class MainTest {

    @Test
    public void test() throws Exception {
        int number = new java.util.Random().nextInt(10000);

        assertEquals(number / 16, Main.divide16(number));
        assertEquals(number * 16, Main.multiply16(number));
        assertEquals(-16 / 16, Main.divide16(-16));
        assertEquals(-1 * 16, Main.multiply16(-1));
        assertFalse(readFileContent().contains("*"));
        assertFalse(readFileContent().replaceAll("/", "").contains("/"));
    }

    public String readFileContent() throws Exception {
        Stream<String> entries =
                Stream.of(System.getProperty("java.class.path").split(File.pathSeparator));
        File targetClassDir =
                entries.filter(
                                entry ->
                                        entry.endsWith("target/classes")
                                                || entry.endsWith("target\\classes"))
                        .findFirst()
                        .map(File::new)
                        .orElseThrow(IllegalStateException::new);
        File mainDotJava =
                new File(
                        targetClassDir,
                        "../../src/main/java/com/github/hcsp/calculation/Main.java");

        return IOUtils.toString(new FileReader(mainDotJava));
    }
}

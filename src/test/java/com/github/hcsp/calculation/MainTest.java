package com.github.hcsp.calculation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

class MainTest {
    @Test
    public void test() {
        int number = new java.util.Random().nextInt(10000);

        assertEquals(number / 16, Main.divide16(number));
        assertEquals(number * 16, Main.multiply16(number));
        assertFalse(readFileContent().contains("*"));
        assertFalse(readFileContent().contains("/"));
    }

    public String readFileContent() throws IOException {
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
        File mainDotJava = new File(targetClassDir, "../../src/main/java/Main.java");

        return IOUtils.toString(new FileReader(mainDotJava));
    }
}

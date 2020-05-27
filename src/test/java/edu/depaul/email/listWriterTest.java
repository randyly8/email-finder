package edu.depaul.email;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class listWriterTest {
    @Test
    @DisplayName("Constructor Test")
    void constructorTest() {
        OutputStream stream = null;
        try {
            stream = new FileOutputStream("empty.txt");
        } catch (FileNotFoundException e) {e.printStackTrace();}
        ListWriter list = new ListWriter(stream);
        assertNotNull(list);
    }
}

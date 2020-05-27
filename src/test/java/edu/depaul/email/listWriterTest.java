package edu.depaul.email;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class listWriterTest {
    String e1 = "e1@gmail.com";
    String e2 = "e2@gmail.com";
    String e3 = "e3@gmail.com";
    String g1 = "http://www.google.com";
    String g2 = "http://www.twitter.com";
    String g3 = "http://www.live.com";
    String b1 = "http://www.g1oqowg2le66e.com";
    String b2 = "http://www.tawsidtftgeh4s2465r.com";
    String b3 = "http://www.lqiwve346e.com";

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

    @Test
    @DisplayName("Email write Test")
    void emailWriteTest() {
        OutputStream stream = null;
        try {
            stream = new FileOutputStream("email.txt");
        } catch (FileNotFoundException e) {e.printStackTrace();}
        ListWriter list = new ListWriter(stream);

        Collection<String> collection = new ArrayList<>();
        collection.add(e1);
        collection.add(e2);
        collection.add(e3);
        BufferedReader reader;
        try {
            list.writeList(collection);
            reader = new BufferedReader(new FileReader("email.txt"));
            String line = reader.readLine();
            while (line != null) {
                for (String collectionItem : collection){
                    assertEquals(collectionItem, line);
                    line = reader.readLine();
                }
            }
            reader.close();
        } catch (IOException e) {e.printStackTrace();}
    }

    @Test
    @DisplayName("Good link write Test")
    void goodLinksWriteTest() {
        OutputStream stream = null;
        try {
            stream = new FileOutputStream("good-links.txt");
        } catch (FileNotFoundException e) {e.printStackTrace();}
        ListWriter list = new ListWriter(stream);

        Collection<String> collection = new ArrayList<>();
        collection.add(g1);
        collection.add(g2);
        collection.add(g3);
        BufferedReader reader;
        try {
            list.writeList(collection);
            reader = new BufferedReader(new FileReader("good-links.txt"));
            String line = reader.readLine();
            while (line != null) {
                for (String collectionItem : collection){
                    assertEquals(collectionItem, line);
                    line = reader.readLine();
                }
            }
            reader.close();
        } catch (IOException e) {e.printStackTrace();}
    }

    @Test
    @DisplayName("Bad link write Test")
    void badLinksWriteTest() {
        OutputStream stream = null;
        try {
            stream = new FileOutputStream("badlinks.txt");
        } catch (FileNotFoundException e) {e.printStackTrace();}
        ListWriter list = new ListWriter(stream);

        Collection<String> collection = new ArrayList<>();
        collection.add(b1);
        collection.add(b2);
        collection.add(b3);
        BufferedReader reader;
        try {
            list.writeList(collection);
            reader = new BufferedReader(new FileReader("badlinks.txt"));
            String line = reader.readLine();
            while (line != null) {
                for (String collectionItem : collection){
                    assertEquals(collectionItem, line);
                    line = reader.readLine();
                }
            }
            reader.close();
        } catch (IOException e) {e.printStackTrace();}
    }
}

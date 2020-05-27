package edu.depaul.email;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class storageServiceTest {
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
        StorageService storage = new StorageService();
        assertNotNull(storage);
    }

    @Test
    @DisplayName("Empty array Test on email")
    void EmptyEmailTest() {
        StorageService storage = new StorageService();
        Collection<String> collection = new ArrayList<String>();
        assertThrows(EmailFinderException.class, () -> storage.storeList(StorageService.StorageType.EMAIL, collection));
    }

    @Test
    @DisplayName("Empty array Test on good links")
    void emptyGoodLinksTest() {
        StorageService storage = new StorageService();
        Collection<String> collection = new ArrayList<String>();
        assertThrows(EmailFinderException.class, () -> storage.storeList(StorageService.StorageType.BADLINKS, collection));
    }

    @Test
    @DisplayName("Empty array Test on bad links")
    void emptyBadLinksTest() {
        StorageService storage = new StorageService();
        Collection<String> collection = new ArrayList<String>();
        assertThrows(EmailFinderException.class, () -> storage.storeList(StorageService.StorageType.BADLINKS, collection));
    }

    @Test
    @DisplayName("NonEmpty array Test on email")
    void writeEmailTest() {
        String path = "email.txt";
        try {
            new FileOutputStream(path).close();
        } catch (Exception e) {System.out.println(e);}

        StorageService storage = new StorageService();
        Collection<String> collection = new ArrayList<String>();
        collection.add(e1);
        collection.add(e2);
        collection.add(e3);
        storage.addLocation(StorageService.StorageType.EMAIL, path);
        storage.storeList(StorageService.StorageType.EMAIL, collection);

        try {
            List<String> lines = Files.readAllLines(Paths.get(path));
            assertEquals(collection, lines);
        } catch (Exception e) {e.printStackTrace();}
    }

    @Test
    @DisplayName("NonEmpty array Test on bad links")
    void writeGoodLinksTest() {
        String path = "good-links.txt";
        try {
            new FileOutputStream(path).close();
        } catch (Exception e) {System.out.println(e);}

        StorageService storage = new StorageService();
        Collection<String> collection = new ArrayList<String>();
        collection.add(g1);
        collection.add(g2);
        collection.add(g3);
        storage.addLocation(StorageService.StorageType.GOODLINKS, path);
        storage.storeList(StorageService.StorageType.GOODLINKS, collection);

        try {
            List<String> lines = Files.readAllLines(Paths.get(path));
            assertEquals(collection, lines);
        } catch (Exception e) {e.printStackTrace();}
    }

    @Test
    @DisplayName("NonEmpty array Test on bad links")
    void writeBadLinksTest() {
        String path = "badlinks.txt";
        try {
            new FileOutputStream(path).close();
        } catch (Exception e) {System.out.println(e);}

        StorageService storage = new StorageService();
        Collection<String> collection = new ArrayList<String>();
        collection.add(b1);
        collection.add(b2);
        collection.add(b3);
        storage.addLocation(StorageService.StorageType.BADLINKS, path);
        storage.storeList(StorageService.StorageType.BADLINKS, collection);

        try {
            List<String> lines = Files.readAllLines(Paths.get(path));
            assertEquals(collection, lines);
        } catch (Exception e) {e.printStackTrace();}
    }
}
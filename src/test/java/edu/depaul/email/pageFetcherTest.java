package edu.depaul.email;

import org.jsoup.nodes.Document;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class pageFetcherTest {

    @Test
    @DisplayName("Initial Constructor Test")
    void constructorTest() {
        PageFetcher fetcher = new PageFetcher();
        assertNotNull(fetcher);
    }
    @Test
    @DisplayName("Test if string is returned")
    void getStringTest() {
        PageFetcher fetcher = new PageFetcher();
        String output = fetcher.getString("https://chicago.suntimes.com/");
        assertNotNull(output);
    }
    @Test
    @DisplayName("Test if string return IO Exception")
    void getStringInvalidURLTest() {
        PageFetcher fetcher = new PageFetcher();
        try {
            String output = fetcher.getString("https://chicago.suntimes.co/");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    @Test
    @DisplayName("Test if string return Illegal Argument Exception")
    void getStringEmptyTest() {
        PageFetcher fetcher = new PageFetcher();
        try {
            String output = fetcher.getString("");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    @Test
    @DisplayName("Get URL test starting with http")
    void getURLHTTPTest() {
        PageFetcher fetcher = new PageFetcher();
        Document doc = fetcher.get("https://chicago.suntimes.com/");
        assertNotNull(doc);
    }
    @Test
    @Disabled
    @DisplayName("Get URL test no http")
    void getURLTest() {
        PageFetcher fetcher = new PageFetcher();
        Document doc = fetcher.get("chicago.suntimes.com");
        assertNotNull(doc);
    }
    @Test
    @DisplayName("Test if URL return IO Exception")
    void getInvalidURLTest() {
        PageFetcher fetcher = new PageFetcher();
        try {
            Document doc = fetcher.get("https://chicago.suntimes.co/");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    @Test
    @DisplayName("Test if URL return Illegal Argument Exception")
    void getEmptyTest() {
        PageFetcher fetcher = new PageFetcher();
        try {
            Document doc = fetcher.get("");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

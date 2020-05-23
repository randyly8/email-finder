package edu.depaul.email;

import org.jsoup.nodes.Document;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class pageFetcherTest {

    @Test
    @DisplayName("Initial Constructor Test")
    void constructorTest() {
        PageFetcher fetcher = new PageFetcher();
        assertNotNull(fetcher);
    }
    @Test
    @DisplayName("Test if string is returned from valid URL")
    void getStringTest() {
        PageFetcher fetcher = new PageFetcher();
        String output = fetcher.getString("https://chicago.suntimes.com/");
        assertNotNull(output);
    }
    @Test
    @DisplayName("Test for invalid URL of length greater than 1")
    void getStringInvalidURLTest() {
        PageFetcher fetcher = new PageFetcher();
        try {
            fetcher.getString("https://chicago.suntimes.co/");
        } catch (Exception e) {
            assertEquals(e.toString(), "edu.depaul.email.EmailFinderException: unable to fetch https://chicago.suntimes.co/");
        }
    }
    @Test
    @DisplayName("Test for invalid URL of length less than 1")
    void getStringEmptyTest() {
        PageFetcher fetcher = new PageFetcher();
        try {
            fetcher.getString("");
        } catch (Exception e) {
            assertEquals(e.toString(), "edu.depaul.email.EmailFinderException: Invalid URL ");
        }
    }


    @Test
    @DisplayName("Get test on URL with http")
    void getURLTest() {
        PageFetcher fetcher = new PageFetcher();
        Document doc = fetcher.get("https://chicago.suntimes.com/");
        assertNotNull(doc);
    }
    @Test
    @DisplayName("Get test on invalid URL with http")
    void getInvalidURLTest() {
        PageFetcher fetcher = new PageFetcher();
        try {
            fetcher.get("https://chicago.suntimes.co/");
        } catch (Exception e) {
            assertEquals(e.toString(), "edu.depaul.email.EmailFinderException: unable to fetch https://chicago.suntimes.co/");
        }
    }
    @Test
    @DisplayName("Get path test")
    void getPathTest() {
        PageFetcher fetcher = new PageFetcher();
        Document doc = fetcher.get("stringForTesting");
        assertNotNull(doc);
    }
    @Test
    @DisplayName("Get invalid path test")
    void getInvalidPathTest() {
        PageFetcher fetcher = new PageFetcher();
        try {
            fetcher.get("nonexistentPath");
        } catch (Exception e) {
            assertEquals(e.toString(), "edu.depaul.email.EmailFinderException: unable to fetch nonexistentPath");
        }
    }





    @Test
    @DisplayName("Test get on path/URL of length less than 1")
    void getEmptyTest() {
        PageFetcher fetcher = new PageFetcher();
        try {
            fetcher.get("");
        } catch (Exception e) {
            assertEquals(e.toString(), "edu.depaul.email.EmailFinderException: unable to fetch ");
        }
    }
}

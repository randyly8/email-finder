package edu.depaul.email;

import org.jsoup.nodes.Document;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class pageParserTest {
    @Test
    @DisplayName("Find email test on valid URL")
    void findEmailTest() {
        PageFetcher fetcher = new PageFetcher();
        Document doc = fetcher.get("validEmailForTesting");
        PageParser parser = new PageParser();
        parser.findEmails(doc);
    }
    @Test
    @DisplayName("Find email test on valid URL")
    void findEmailInvalidTest() {
        PageFetcher fetcher = new PageFetcher();
        Document doc = fetcher.get("invalidEmailForTesting");
        PageParser parser = new PageParser();
        parser.findEmails(doc);
    }

    @Test
    @DisplayName("Find link test on invalid URL")
    void findLinksTest() {
        PageFetcher fetcher = new PageFetcher();
        Document doc = fetcher.get("validURLForTesting");
        PageParser parser = new PageParser();
        parser.findLinks(doc);
    }
    @Test
    @DisplayName("Find link test on invalid URL")
    void findLinksInvalidTest() {
        PageFetcher fetcher = new PageFetcher();
        Document doc = fetcher.get("invalidURLForTesting");
        PageParser parser = new PageParser();
        parser.findLinks(doc);
    }
}

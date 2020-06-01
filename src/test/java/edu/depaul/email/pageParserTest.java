package edu.depaul.email;

import org.jsoup.nodes.Document;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class pageParserTest {
    String validEmails = "[earmstro@yahoo.com, kronvold@gmail.com, barjam@comcast.net, seanq@optonline.net, north@icloud.com, demmel@att.net, sthomas@hotmail.com, novanet@outlook.com, miltchev@gmail.com, fallorn@gmail.com, citadel@yahoo.com, grolschie@gmail.com]";
    String validLinks = "[http://www.youtube.com, http://www.facebook.com, http://www.baidu.com, http://www.yahoo.com, http://www.amazon.com, http://www.wikipedia.org, http://www.qq.com, http://www.google.com, http://www.twitter.com, http://www.live.com]";
    @Test
    @DisplayName("Constructor Test")
    void constructorTest() {
        PageParser parser = new PageParser();
        assertNotNull(parser);
    }
    @Test
    @DisplayName("Find no emails")
    void findNoEmailTest() {
        PageFetcher fetcher = new PageFetcher();
        Document doc = fetcher.get("stringForTesting");
        PageParser parser = new PageParser();
        Set<String> content = parser.findEmails(doc);
        assertEquals(content.toString(), "[]");
    }
    @Test
    @DisplayName("Find (1) email")
    void findEmailTest() {
        PageFetcher fetcher = new PageFetcher();
        Document doc = fetcher.get("validEmailForTesting");
        PageParser parser = new PageParser();
        Set<String> content = parser.findEmails(doc);
        assertEquals(content.toString(), "[bsatterfield@yahoo.com]");
    }
    @Test
    @DisplayName("Find emails")
    void findMultipleEmailsTest() {
        PageFetcher fetcher = new PageFetcher();
        Document doc = fetcher.get("multipleValidEmailsForTesting.txt");
        PageParser parser = new PageParser();
        Set<String> content = parser.findEmails(doc);
        assertEquals(content.toString(), validEmails);
    }
    @Test
    @DisplayName("Find valid email in list of invalid emails and links")
    void findEmailInRandomListTest() {
        PageFetcher fetcher = new PageFetcher();
        Document doc = fetcher.get("valid-Invalid-emails-links.txt");
        PageParser parser = new PageParser();
        Set<String> content = parser.findEmails(doc);
        assertEquals(content.toString(), "[seanq@optonline.net]");
    }
    @Test
    @DisplayName("Find no links")
    void findNoLinkTest() {
        PageFetcher fetcher = new PageFetcher();
        Document doc = fetcher.get("stringForTesting");
        PageParser parser = new PageParser();
        Set<String> content = parser.findLinks(doc);
        assertEquals(content.toString(), "[]");
    }
    @Test
    @DisplayName("Find (1) link")
    void findLinkTest() {
        PageFetcher fetcher = new PageFetcher();
        Document doc = fetcher.get("validURLForTesting");
        PageParser parser = new PageParser();
        Set<String> content = parser.findLinks(doc);
        assertEquals(content.toString(), "[https://d2l.depaul.edu/d2l/home]");
    }
    @Test
    @DisplayName("Find links")
    void findMultipleLinksTest() {
        PageFetcher fetcher = new PageFetcher();
        Document doc = fetcher.get("multipleValidURLsForTesting.txt");
        PageParser parser = new PageParser();
        Set<String> content = parser.findLinks(doc);
        assertEquals(content.toString(), validLinks);
    }
    @Test
    @DisplayName("Find valid link in list of invalid emails and links")
    void findLinkInRandomListTest() {
        PageFetcher fetcher = new PageFetcher();
        Document doc = fetcher.get("valid-Invalid-emails-links.txt");
        PageParser parser = new PageParser();
        Set<String> content = parser.findLinks(doc);
        assertEquals(content.toString(), "[http://www.youtube.com]");
    }
}

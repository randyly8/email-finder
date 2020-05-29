package edu.depaul.email;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class pageCrawlerTest {
    @Test
    @DisplayName("Constructor Test")
    void constructorTest() {
        StorageService storage = new StorageService();
        PageCrawler crawler = new PageCrawler(storage);
        assertNotNull(crawler);
    }
    @Test
    @DisplayName("Nonexistent file test on email")
    void noFileEmailTest() {
        StorageService storage = new StorageService();
        PageCrawler crawling = new PageCrawler(storage);
        crawling.crawl("fakeFile.txt");
        assertEquals(crawling.getEmails().size(), 0);
    }
    @Test
    @DisplayName("Empty test on email")
    void emptyEmailTest() {
        StorageService storage = new StorageService();
        PageCrawler crawling = new PageCrawler(storage);
        crawling.crawl("empty.txt");
        assertEquals(crawling.getEmails().size(), 0);
    }
    @Test
    @DisplayName("Test on 1 email")
    void singleEmailTest() {
        StorageService storage = new StorageService();
        PageCrawler crawling = new PageCrawler(storage);
        crawling.crawl("validEmailForTesting");
        assertEquals(crawling.getEmails().size(), 1);
    }
    @Test
    @DisplayName("Test on more than 1 email")
    void multipleEmailTest() {
        StorageService storage = new StorageService();
        PageCrawler crawling = new PageCrawler(storage);
        crawling.crawl("multipleValidEmailsForTesting.txt");
        assertTrue(crawling.getEmails().size() > 1);
    }

    @Test
    @DisplayName("Nonexistent file test on good link")
    void noFileGoodLinkTest() {
        StorageService storage = new StorageService();
        PageCrawler crawling = new PageCrawler(storage);
        crawling.crawl("fakeFile.txt");
        assertEquals(crawling.getGoodLinks().size(), 0);
    }
    @Test
    @Disabled
    @DisplayName("Empty test on good link")
    void emptyGoodLinkTest() {
        StorageService storage = new StorageService();
        PageCrawler crawling = new PageCrawler(storage);
        crawling.crawl("empty.txt");
        assertEquals(crawling.getGoodLinks().size(), 0);
    }
    @Test
    @DisplayName("Test on 1 good link")
    void singleGoodLinkTest() {
        StorageService storage = new StorageService();
        PageCrawler crawling = new PageCrawler(storage);
        crawling.crawl("validURLForTesting");
        assertEquals(crawling.getGoodLinks().size(), 1);
    }
    @Test
    @Disabled
    @DisplayName("Test on more than 1 good link")
    void multipleGoodLinkTest() {
        StorageService storage = new StorageService();
        PageCrawler crawling = new PageCrawler(storage);
        crawling.crawl("multipleValidURLsForTesting.txt");
        assertTrue(crawling.getGoodLinks().size() > 1);
    }

    @Test
    @DisplayName("Nonexistent file test on bad link")
    void noFileBadLinkTest() {
        StorageService storage = new StorageService();
        PageCrawler crawling = new PageCrawler(storage);
        crawling.crawl("fakeFile.txt");
        assertEquals(crawling.getBadLinks().size(), 1);
    }
    @Test
    @DisplayName("Empty test on bad link")
    void emptyBadLinkTest() {
        StorageService storage = new StorageService();
        PageCrawler crawling = new PageCrawler(storage);
        crawling.crawl("empty.txt");
        assertEquals(crawling.getBadLinks().size(), 0);
    }
    @Test
    @Disabled
    @DisplayName("Test on 1 bad link")
    void singleBadLinkTest() {
        StorageService storage = new StorageService();
        PageCrawler crawling = new PageCrawler(storage);
        crawling.crawl("invalidURLForTesting.txt");
        assertEquals(crawling.getBadLinks().size(), 1);
    }
    @Test
    @Disabled
    @DisplayName("Test on more than 1 bad link")
    void multipleBadLinkTest() {
        StorageService storage = new StorageService();
        PageCrawler crawling = new PageCrawler(storage);
        crawling.crawl("multipleInvalidIURLsForTesting.txt");
        assertTrue(crawling.getBadLinks().size() > 1);
    }
}


package edu.depaul.email;

import org.jsoup.nodes.Document;
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
    void StringTest() {
        PageFetcher a = new PageFetcher();
        String output = a.getString("https://chicago.suntimes.com/");
        assertNotNull(output);
    }
    @Test
    @DisplayName("Get URL test")
    void URLTest() {
        PageFetcher fetcher = new PageFetcher();
        Document doc = fetcher.get("https://chicago.suntimes.com/");
        assertNotNull(doc);
    }
}

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
}

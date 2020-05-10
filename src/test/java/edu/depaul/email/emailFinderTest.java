package edu.depaul.email;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class emailFinderTest {
    @Test
    @DisplayName("Default Valid URL")
    void ValidURLTest() {
        EmailFinder.main(new String[] {"https://d2l.depaul.edu/d2l/home"});
    }
    @Test
    @DisplayName("Invalid URL with length greater than 1")
    void InvalidURLFormatTest() {
        EmailFinder.main(new String[] {"aidgbi:x/d2l.depaul.edu/d2l/home"});
    }
    @Test
    @DisplayName("Invalid URL with length less than 1")
    void URLOfSizeLessThan1Test() {
        EmailFinder.main(new String[] {""});
    }
    @Test
    @DisplayName("Null URL")
    void nullURLTest() {
        EmailFinder.main(new String[] {});
    }
}

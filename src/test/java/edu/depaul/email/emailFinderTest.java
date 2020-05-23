package edu.depaul.email;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class emailFinderTest {
    @Test
    @DisplayName("Default Valid URL")
    void ValidURLTest() {
        EmailFinder finder = new EmailFinder();
        String[] url = {"validEmailForTesting"};
        finder.run(url);
        String path = "email.txt";
        String email;
        try (Stream<String> lines = Files.lines(Paths.get(path))){
            String content = lines.collect(Collectors.joining(System.lineSeparator()));
            email = content;
            assertEquals(email,"bsatterfield@yahoo.com");
        } catch (Exception e) {}
    }

    @Test
    @DisplayName("Invalid URL with length greater than 1")
    void InvalidURLFormatTest() {
        EmailFinder.main(new String[] {"qwerty://cdm.depaul.edu"});
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

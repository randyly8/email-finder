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
    @DisplayName("Valid URL")
    void ValidURLTest() {
        EmailFinder finder = new EmailFinder();
        String[] url = {"validEmailForTesting"};
        finder.run(url);
        String path = "good-links.txt";
        try (Stream<String> lines = Files.lines(Paths.get(path))) {
            String content = lines.collect(Collectors.joining(System.lineSeparator()));
            assertEquals(content, "validEmailForTesting");
        } catch (IOException e) {e.printStackTrace();}
    }

    @Test
    @DisplayName("Invalid URL with length greater than 1")
    void InvalidURLFormatTest() {
        EmailFinder finder = new EmailFinder();
        String[] url = {"nonexistentPath"};
        finder.run(url);
        String path = "badlinks.txt";
        try (Stream<String> lines = Files.lines(Paths.get(path))) {
            String content = lines.collect(Collectors.joining(System.lineSeparator()));
            assertEquals(content, "nonexistentPath");
        } catch (IOException e) {e.printStackTrace();}
    }

    @Test
    @DisplayName("Invalid URL with length less than 1")
    void URLOfSizeLessThan1Test() {
        EmailFinder finder = new EmailFinder();
        String[] url = {""};
        finder.run(url);
        String path = "badlinks.txt";
        try (Stream<String> lines = Files.lines(Paths.get(path))) {
            String content = lines.collect(Collectors.joining(System.lineSeparator()));
            assertEquals(content, "");
        } catch (IOException e) {e.printStackTrace();}
    }

    @Test
    @DisplayName("Null URL")
    void nullURLTest() {
        EmailFinder finder = new EmailFinder();
        String[] url = {};
        finder.run(url);
        String path = "badlinks.txt";
        try (Stream<String> lines = Files.lines(Paths.get(path))) {
            String content = lines.collect(Collectors.joining(System.lineSeparator()));
            assertEquals(content, "");
        } catch (IOException e) {e.printStackTrace();}
    }

    @Test
    @DisplayName("Valid URL with valid email")
    void validEmailTest() {
        EmailFinder finder = new EmailFinder();
        String[] url = {"validEmailForTesting"};
        finder.run(url);
        String path = "email.txt";
        try (Stream<String> lines = Files.lines(Paths.get(path))) {
            String content = lines.collect(Collectors.joining(System.lineSeparator()));
            assertEquals(content, "bsatterfield@yahoo.com");
        } catch (IOException e) {e.printStackTrace();}
    }

    @Test
    @DisplayName("Valid URL with invalid email")
    void invalidEmailTest() {
        EmailFinder finder = new EmailFinder();
        String[] url = {"invalidEmailForTesting"};
        finder.run(url);
        String path = "email.txt";
        try (Stream<String> lines = Files.lines(Paths.get(path))) {
            String content = lines.collect(Collectors.joining(System.lineSeparator()));
            assertEquals(content, "");
        } catch (IOException e) {e.printStackTrace();}
    }
}

import static org.junit.Assert.*;
import org.junit.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void testFile1() throws IOException {
        String contents= Files.readString(Path.of("./test-file.md"));
        List<String> expect = List.of("https://something.com", "some-page.html");
        assertEquals(MarkdownParse.getLinks(contents), expect);
    }

    @Test
    public void testMyFile2() throws IOException {
	String contents = Files.readString(Path.of("test2.md"));
	List<String> expect = List.of("https://duckduckgo.com", "https://kde.org");
	assertEquals(MarkdownParse.getLinks(contents), expect);
    }

    @Test
    public void testMyFile3() throws IOException {
	String contents = Files.readString(Path.of("test3.md"));
	List<String> expect = List.of();
	assertEquals(MarkdownParse.getLinks(contents), expect);
    }

    @Test
    public void testMyFile4() throws IOException {
	String contents = Files.readString(Path.of("test4.md"));
	List<String> expect = List.of();
	assertEquals(MarkdownParse.getLinks(contents), expect);
    }

    @Test
    public void testFile3() throws IOException {
	String contents = Files.readString(Path.of("test-file3.md"));
	List<String> expect = List.of();
	assertEquals(MarkdownParse.getLinks(contents), expect);
    }

    @Test
    public void failingTest() {
	assertEquals(3, 1+2);
    }

    @Test
    public void testMyFile5() throws IOException {
	String contents = Files.readString(Path.of("test5.md"));
	List<String> expect = List.of("https://archlinux.org");
	assertEquals(MarkdownParse.getLinks(contents), expect);
    }

    @Test
    public void testSnippet1() throws IOException {
	String contents = Files.readString(Path.of("snippet1.md"));
	List<String> expect = List.of("`google.com", "google.com", "ucsd.edu");
	assertEquals(MarkdownParse.getLinks(contents), expect);
    }

    @Test
    public void testSnippet2() throws IOException {
	String contents = Files.readString(Path.of("snippet2.md"));
	List<String> expect = List.of("a.com", "a.com(())", "example.com");
	assertEquals(MarkdownParse.getLinks(contents), expect);
    }

    @Test
    public void testSnippet3() throws IOException {
	String contents = Files.readString(Path.of("snippet3.md"));
	List<String> expect = List.of("https://ucsd-cse15l-w22.github.io/");
	assertEquals(MarkdownParse.getLinks(contents), expect);
    }
}

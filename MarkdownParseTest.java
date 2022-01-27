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
}

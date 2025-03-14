// File reading code from https://howtodoinjava.com/java/io/java-read-file-to-string-examples/
import java.io.IOException;
import java.nio.file.Files;
import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {
    //comment
    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then take up to
        // the next )
        int currentIndex = 0;
        while(currentIndex < markdown.length()) {
            int nextOpenBracket = markdown.indexOf("[", currentIndex);
            int nextCloseBracket = markdown.indexOf("]", nextOpenBracket);
	    if(nextOpenBracket == -1 || nextCloseBracket == -1) {
		break;
	    }
	    if (markdown.charAt(nextCloseBracket + 1) != '(') {
		currentIndex = nextCloseBracket+1;
		continue;
	    }
	    int openParen = nextCloseBracket+1;
            int closeParen = markdown.indexOf(")", openParen);
            if(openParen == -1 || closeParen == -1) {
		        break;
	        }
	    if((nextOpenBracket != 0 && markdown.charAt(nextOpenBracket - 1) == '!') ||
	       markdown.substring(openParen + 1, closeParen).indexOf(" ") != -1) {
		currentIndex = closeParen + 1;
		continue;
	        }
            toReturn.add(markdown.substring(openParen + 1, closeParen));
            currentIndex = closeParen + 1;
        }
        return toReturn;
    }
    public static void main(String[] args) throws IOException {
	Path fileName = Path.of(args[0]);
	if(fileName.toFile().isDirectory()) {
	    for(File f : fileName.toFile().listFiles()) {
		String contents = Files.readString(f.toPath());
		ArrayList<String> links = getLinks(contents);
		System.out.println(links);
	    }
	    return;
	}
	String contents = Files.readString(fileName);
        ArrayList<String> links = getLinks(contents);
        System.out.println(links);
    }
}

package by.epam.task2.logic;

import by.epam.task2.composite.Text;
import by.epam.task2.parsing.TextParser;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.Assert.*;

public class WordFinderTest extends TestCase {

    @Test
    public void testFind() throws Exception {
        TextParser parser = new TextParser();
        String str = "";
        str = new Scanner(new File("resources/text.txt")).useDelimiter("\\Z").next();
        Text textComponents = parser.parseText(str);
        ArrayList<String> expected = new ArrayList<>();
        WordFinder finder = new WordFinder();
        ArrayList<String> actual = finder.find(textComponents);
        Assert.assertEquals(expected, actual);
    }
}
package by.epam.task2.main;

import by.epam.task2.composite.Text;
import by.epam.task2.logic.WordFinder;
import by.epam.task2.logic.WordsRemover;
import by.epam.task2.parsing.TextParser;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Vika on 8/1/14.
 */
public class Main {
    private static Logger logger = Logger.getLogger(Main.class.getName());
    private static final String TEXT_FILE_PATH = "resources/text.txt";
    private static final String LOG4J_PROPERTY_FILE = "log4j.properties";
    private static final int WORD_LENGTH = 4;

    static {
        PropertyConfigurator.configure(LOG4J_PROPERTY_FILE);
    }

    public static void main(String[] args) {
        TextParser parser = new TextParser();
        String str = "";
        try {
            str = new Scanner(new File(TEXT_FILE_PATH)).useDelimiter("\\Z").next();
        } catch (FileNotFoundException e) {
            logger.error("File not found");
        }
        Text textComponents = parser.parseText(str);
        logger.info(textComponents.toString());
        WordFinder finder = new WordFinder();
        logger.info("Unique words in first sentence: " + finder.find(textComponents));
        WordsRemover remover = new WordsRemover();
        remover.removeFromText(textComponents, WORD_LENGTH);
        logger.info(textComponents);
    }
}

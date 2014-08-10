package by.epam.task2.parsing;

import by.epam.task2.composite.*;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Vika on 04.08.2014.
 */
public class TextParser {
    private static Logger logger = Logger.getLogger(TextParser.class);
    private static Properties properties = new Properties();

    static {
        try (InputStream stream = TextParser.class.getResourceAsStream("/regex.properties")){
            properties.load(stream);
        } catch (IOException e) {
            logger.error("Regex wasn't loaded");
        }
    }

    public Text parseText(String text){
        Text textComponents = new Text();
        Pattern pattern = Pattern.compile(properties.getProperty("paragraph")
                + "|" + properties.getProperty("code"));
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()){
            String string = matcher.group();
            if (Pattern.matches(properties.getProperty("code"),string)){
                logger.info("Found code");
                textComponents.add(new Code(string));
                textComponents.add(new Punctuation("\n"));
            } else {
                logger.info("Found paragraph");
                textComponents.add(parseParagraph(string));
                textComponents.add(new Punctuation("\n"));
            }
        }
        return textComponents;
    }

    private Text parseParagraph(String paragraph){
        Text textComponents = new Text();
        Pattern pattern = Pattern.compile(properties.getProperty("sentence"));
        Matcher matcher = pattern.matcher(paragraph);
        while (matcher.find()){
            logger.info("Found sentence");
            textComponents.add(parseSentence(matcher.group()));
        }
        return textComponents;
    }

    private Text parseSentence(String sentence){
        Text textComponents = new Text();
        Pattern pattern = Pattern.compile(properties.getProperty("word")
        + "|" + properties.getProperty("punctuation"));
        Matcher matcher = pattern.matcher(sentence);
        while (matcher.find()){
            String string = matcher.group();
            if (Pattern.matches(properties.getProperty("word"),string)){
                logger.info("Found word");
                textComponents.add(new Word(string + " "));
            } else {
                logger.info("Found punctuation");
                textComponents.add(new Punctuation(string + " "));
            }
        }
        return textComponents;
    }
}

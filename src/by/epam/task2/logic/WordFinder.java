package by.epam.task2.logic;

import by.epam.task2.composite.Text;
import by.epam.task2.composite.TextComponent;
import by.epam.task2.composite.Word;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Vika on 10.08.2014.
 */
public class WordFinder {
    private static Logger logger = Logger.getLogger(WordFinder.class);

    public ArrayList<String> find(Text text){
        ArrayList<String> foundWords = new ArrayList<>();
        TextComponent firstSentence = text.getChild(0).getChild(0);
        Iterator<TextComponent> iterator = firstSentence.iterator();
        while (iterator.hasNext()){
            TextComponent firstSentenceWord = iterator.next();
            if (firstSentenceWord.getClass() == Word.class){
                boolean isUnique = true;
                for (TextComponent paragraph: text){
                    for (TextComponent sentence: paragraph){
                        if (sentence != firstSentence){
                            for (TextComponent word: sentence){
                                if (word.getClass() == Word.class){
                                    if ( firstSentenceWord.getText().trim().equalsIgnoreCase(word.getText().trim())){
                                        isUnique = false;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    if (!isUnique){
                        break;
                    }
                }
                if (isUnique) {
                    foundWords.add(firstSentenceWord.toString());
                    logger.info("Found unique word");
                }
            }
        }
        return foundWords;
    }
}

package by.epam.task2.logic;

import by.epam.task2.composite.Text;
import by.epam.task2.composite.TextComponent;
import by.epam.task2.composite.Word;
import org.apache.log4j.Logger;

import java.util.*;

/**
 * Created by Vika on 07.08.2014.
 */
public class WordsRemover {
    private HashSet<Character> consonants = new HashSet<>();
    private int length;
    private static Logger logger = Logger.getLogger(WordsRemover.class);

    public WordsRemover() {
        Collections.addAll(consonants, 'a', 'e', 'i', 'o', 'u', 'y');
    }

    public void removeFromText(Text text, int length){
        setLength(length);
        ArrayList<TextComponent> words = new ArrayList<>();
        removeFromParagraph(text, words);
        for (TextComponent word: words){
            if (text.remove(word)){
                logger.info("Word removed");
            } else {
                logger.info("Word was not remove");
            }
        }
    }

    private void removeFromParagraph(TextComponent text,
                                     ArrayList<TextComponent> words){
        for (TextComponent paragraph: text){
            removeFromSentence(paragraph, words);
        }
    }

    private void removeFromSentence(TextComponent paragraph,
                                    ArrayList<TextComponent> words){
        for (TextComponent sentence: paragraph){
            removeWords(sentence, words);
        }
    }

    private void removeWords(TextComponent sentence,
                             ArrayList<TextComponent> words){
        for (TextComponent word: sentence){
            if (word.getClass() == Word.class){
                if ((word.getText().length()-1 == length) &&
                        (!consonants.contains(word.getText().charAt(0)))){
                    words.add(word);
                }
            }
        }
    }

    private void setLength(int length){
        this.length = length;
    }
}

package by.epam.task2.composite;

import by.epam.task2.composite.iterator.EndIterator;

import java.util.Iterator;

/**
 * Created by Vika on 03.08.2014.
 */
public class Word extends TextComponent {
    private String word;

    public Word(String word) {
        this.word = word;
    }

    @Override
    public String getText() {
        return word;
    }

    @Override
    public Iterator<TextComponent> iterator() {
        return new EndIterator();
    }

    @Override
    public String toString() {
        return word;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Word word1 = (Word) o;

        if (!word.equals(word1.word)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return word.hashCode();
    }
}

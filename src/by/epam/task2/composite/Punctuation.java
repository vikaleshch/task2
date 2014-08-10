package by.epam.task2.composite;

import by.epam.task2.composite.iterator.EndIterator;

import java.util.Iterator;

/**
 * Created by Vika on 03.08.2014.
 */
public class Punctuation extends TextComponent {
    private String punctuation;

    public Punctuation(String punctuation) {
        this.punctuation = punctuation;
    }

    @Override
    public String getText() {
        return punctuation;
    }

    @Override
    public Iterator<TextComponent> iterator() {
        return new EndIterator();
    }

    @Override
    public String toString() {
        return punctuation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Punctuation that = (Punctuation) o;

        if (!punctuation.equals(that.punctuation)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return punctuation.hashCode();
    }
}

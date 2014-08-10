package by.epam.task2.composite.iterator;

import by.epam.task2.composite.TextComponent;

import java.util.Iterator;

/**
 * Created by Vika on 03.08.2014.
 */
public class EndIterator implements Iterator<TextComponent> {
    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public TextComponent next() {
        return null;
    }
}

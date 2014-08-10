package by.epam.task2.composite;

import by.epam.task2.composite.iterator.EndIterator;

import java.util.Iterator;

/**
 * Created by Vika on 03.08.2014.
 */
public class Code extends TextComponent {
    private String code;

    public Code(String code) {
        this.code = code;
    }

    @Override
    public String getText() {
        return code;
    }

    @Override
    public Iterator<TextComponent> iterator() {
        return new EndIterator();
    }

    @Override
    public String toString() {
        return code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Code that = (Code) o;

        if (!code.equals(that.code)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return code.hashCode();
    }
}

package by.epam.task2.composite;

import java.util.Iterator;

/**
 * Created by Vika on 03.08.2014.
 */
public abstract class TextComponent implements Iterable<TextComponent>{
    public void add(TextComponent component){
        throw new UnsupportedOperationException();
    }

    public boolean remove(TextComponent component){
        throw new UnsupportedOperationException();
    }

    public TextComponent getChild(int i){
        throw new UnsupportedOperationException();
    }

    public String getText(){
        throw new UnsupportedOperationException();
    }

    public abstract Iterator<TextComponent> iterator();

    public abstract String toString();

    public abstract boolean equals(Object o);

    public abstract int hashCode();
}

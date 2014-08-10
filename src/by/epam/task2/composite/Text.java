package by.epam.task2.composite;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Vika on 03.08.2014.
 */
public class Text extends TextComponent {
    private ArrayList<TextComponent> text = new ArrayList<TextComponent>();

    public Text() {}

    @Override
    public void add(TextComponent component) {
        text.add(component);
    }

    @Override
    public boolean remove(TextComponent component) {
        if (text.remove(component)){
            return true;
        } else {
            for (TextComponent textComponent: text){
                if ((textComponent.getClass() == Word.class) ||
                        (textComponent.getClass() == Punctuation.class) ||
                        (textComponent.getClass() == Code.class)){
                    continue;
                } else if (textComponent.remove(component)){
                    return true;
                }
            }
            return false;
        }
    }

    @Override
    public TextComponent getChild(int i) {
        return text.get(i);
    }

    @Override
    public Iterator<TextComponent> iterator() {
        return text.iterator();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (TextComponent component: text){
            builder.append(component.toString());
        }
        return builder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Text that = (Text) o;

        if (!text.equals(that.text)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return text.hashCode();
    }
}

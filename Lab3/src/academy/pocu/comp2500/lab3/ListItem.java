package academy.pocu.comp2500.lab3;

import java.util.ArrayList;

public class ListItem {
    private String text;             //List Name
    private char bulletStyle = '*';
    private ArrayList<ListItem> sublistItems = new ArrayList<>();

    public ListItem(String text, char bulletStyle) {
        this.text = text;
        this.bulletStyle = bulletStyle;
    }
    public ListItem(String text) {
        this(text, '*');
    }

    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }

    public char getBulletStyle() {
        return bulletStyle;
    }
    public void setBulletStyle(char bulletStyle) {
        this.bulletStyle = bulletStyle;
    }

    public ListItem getSublistItem(int index) {
        return sublistItems.get(index);
    }

    public void addSublistItem(ListItem sublistItem) {
        sublistItems.add(sublistItem);
    }
    public void removeSublistItem(int index) {
        sublistItems.remove(index);
    }

    public String toString() {
        return this.toString(1);
    }

    private String toString(int level) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%c %s%s", this.bulletStyle, this.text, System.lineSeparator()));

        if (this.sublistItems.size() > 0) {
            for (ListItem sublistItem : this.sublistItems) {
                for (int i = 0; i < level; i++) {
                    sb.append("    ");
                }
                sb.append(String.format("%s", sublistItem.toString(level + 1)));
            }
        }

        return sb.toString();
    }
}

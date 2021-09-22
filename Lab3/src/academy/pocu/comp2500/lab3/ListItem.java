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
    public void setText(String newText) {
        text = newText;
    }

    public char getBulletStyle() {
        return bulletStyle;
    }
    public void setBulletStyle(char newBulletStyle) {
        bulletStyle = newBulletStyle;
    }

    public ArrayList<ListItem> getSublistItems() {
        return sublistItems;
    }

    public void addSublistItem(ListItem sublistItemText) {
        for (ListItem sublistItem : this.sublistItems) {
            if (sublistItemText.equals(sublistItem.getText())) {
                System.out.println("same text already exist. please use different text");
            }
        }
        sublistItems.add(sublistItemText);
    }
    public void removeSublistItem(String sublistItemText) {
        for (ListItem sublistItem : this.sublistItems) {
            if (sublistItemText.equals(sublistItem.getText())) {
                this.sublistItems.remove(sublistItem);
            }
        }
        System.out.println("text does not exist.");
    }

    public String toString() {
        return this.toString(1);
    }

    public String toString(int level) {
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

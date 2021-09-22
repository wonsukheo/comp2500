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
        this.text = newText;
    }

    public char getBulletStyle() {
        return bulletStyle;
    }
    public void setBulletStyle(char newBulletStyle) {
        this.bulletStyle = newBulletStyle;
    }

    public ArrayList<ListItem> getSublistItems() {
        return sublistItems;
    }

    public boolean addSublistItem(ListItem sublistItemText) {
        for (ListItem sublistItem : this.sublistItems) {
            if (sublistItemText.equals(sublistItem.getText())) {
                System.out.println("same text already exist. please use different text");
                return false;
            }
        }
        sublistItems.add(sublistItemText);
        return true;
    }
    public boolean removeSublistItem(String sublistItemText) {
        for (ListItem sublistItem : this.sublistItems) {
            if (sublistItemText.equals(sublistItem.getText())) {
                this.sublistItems.remove(sublistItem);
                return true;
            }
        }
        System.out.println("text does not exist.");
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%c %s%s", this.bulletStyle, this.text, System.lineSeparator()));

        if (this.sublistItems != null) {
            for (ListItem sublistItem : this.sublistItems) {
                sb.append(String.format("    %s", sublistItem.toString()));
            }
        }

        return sb.toString();
    }
}

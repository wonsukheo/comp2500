package academy.pocu.comp2500.assignment4;

import java.util.HashMap;
import java.util.LinkedList;

public final class OverdrawAnalyzer extends Canvas {
    private HashMap<Integer, LinkedList<Character>> pixelHistory = new HashMap<>();

    public OverdrawAnalyzer(int x, int y) {
        super(x, y);
    }

    private Integer getPixelHash(int x, int y) {
        return x * 17 + y * 13;
    }

    private void updateHistory(int x, int y) {
        if (pixelHistory.get(getPixelHash(x, y)) == null) {
            pixelHistory.put(getPixelHash(x, y), new LinkedList<>());
        }

        pixelHistory.get(getPixelHash(x, y)).add(super.getPixel(x, y));
    }

    public void drawPixel(int x, int y, char c) {
        if (x >= 0 && x < super.getWidth() && y >= 0 && y < super.getHeight()) {
            if (super.getPixel(x, y) != c) {
                super.drawPixel(x, y, c);

                updateHistory(x, y);
            }
        }
    }

    public boolean increasePixel(int x, int y) {
        if (super.increasePixel(x, y)) {
            updateHistory(x, y);

            return true;
        }

        return false;
    }

    public boolean decreasePixel(int x, int y) {
        if (super.decreasePixel(x, y)) {
            updateHistory(x, y);

            return true;
        }

        return false;
    }

    public void toUpper(int x, int y) {
        if (x >= 0 && x < super.getWidth() && y >= 0 && y < super.getHeight()) {
            char c = super.getPixel(x, y);

            if (c >= 97 && c <= 122) {
                super.drawPixel(x, y, c &= ~32);

                updateHistory(x, y);
            }
        }
    }

    public void toLower(int x, int y) {
        if (x >= 0 && x < super.getWidth() && y >= 0 && y < super.getHeight()) {
            char c = super.getPixel(x, y);

            if (c >= 65 && c <= 90) {
                super.drawPixel(x, y, c |= 32);

                updateHistory(x, y);
            }
        }
    }

    public void fillHorizontalLine(int y, char c) {
        if (y >= 0 && y < super.getHeight()) {
            for (int i = 0; i < super.getWidth(); i++) {
                if (super.getPixel(i, y) != c) {
                    super.drawPixel(i, y, c);

                    updateHistory(i, y);
                }
            }
        }
    }

    public void fillVerticalLine(int x, char c) {
        if (x >= 0 && x < super.getWidth()) {
            for (int i = 0; i < super.getHeight(); i++) {
                if (super.getPixel(x, i) != c) {
                    super.drawPixel(x, i, c);

                    updateHistory(x, i);
                }
            }
        }
    }

    public void clear() {
        for (int i = 0; i < super.getHeight(); i++) {
            for (int j = 0; j < super.getWidth(); j++) {
                if (super.getPixel(i, j) != ' ') {
                    super.drawPixel(j, i, ' ');

                    updateHistory(i, j);
                }
            }
        }
    }

    public LinkedList<Character> getPixelHistory(int x, int y) {
        if (pixelHistory.get(getPixelHash(x, y)) == null) {
            return new LinkedList<>();
        }

        return pixelHistory.get(getPixelHash(x, y));
    }

    public int getOverdrawCount(int x, int y) {
        return getPixelHistory(x, y).size();
    }

    public int getOverdrawCount() {
        int result = 0;

        for (LinkedList<Character> list : pixelHistory.values()) {
            result += list.size();
        }

        return result;
    }
}

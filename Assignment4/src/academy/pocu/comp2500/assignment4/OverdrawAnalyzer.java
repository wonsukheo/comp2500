package academy.pocu.comp2500.assignment4;

import java.util.HashMap;
import java.util.LinkedList;

public final class OverdrawAnalyzer extends Canvas {
    private HashMap<Integer, LinkedList<Character>> pixelHistory = new HashMap<>();

    public OverdrawAnalyzer(int x, int y) {
        super(x,y);
    }

    private Integer getPixelHash(int x, int y) {
        return x * 17 + y * 13;
    }

    private void updateHistory(int x, int y) {
        LinkedList<Character> history = pixelHistory.get(getPixelHash(x, y));

        if (history == null) {
            history = new LinkedList<Character>();

            history.add(super.getPixel(x,y));

            pixelHistory.put(getPixelHash(x, y), history);
        } else {
            history.add(super.getPixel(x,y));

            pixelHistory.put(getPixelHash(x, y), history);
        }
    }

    public void drawPixel(int x, int y, char c) {
        //char arg is always valid ASCII character

        if (x >= 0 || x <= super.getWidth() - 1 || y >= 0 || y <= super.getHeight() - 1) {
            if (super.getPixel(x, y) != c) {
                super.drawPixel(x, y, c);

                updateHistory(x ,y);
            }
        }
    }

    public boolean increasePixel(int x, int y) {
        if (x >= 0 || x <= super.getWidth() - 1 || y >= 0 || y <= super.getHeight() - 1) {
            if (super.getPixel(x, y) < 126) {
                super.drawPixel(x, y, (char) (super.getPixel(x, y) + 1));

                updateHistory(x ,y);

                return true;
            }
        }

        return false;
    }

    public boolean decreasePixel(int x, int y) {
        if (x >= 0 || x <= super.getWidth() - 1 || y >= 0 || y <= super.getHeight() - 1) {
            if (super.getPixel(x, y) > 32) {
                super.drawPixel(x, y, (char) (super.getPixel(x, y) - 1));

                updateHistory(x ,y);

                return true;
            }
        }

        return false;
    }

    public void toUpper(int x, int y) {
        if (x >= 0 || x <= super.getWidth() - 1 || y >= 0 || y <= super.getHeight() - 1) {
            if (super.getPixel(x, y) >= 97 && super.getPixel(x, y) <= 122) {
                char c = super.getPixel(x, y);

                super.drawPixel(x, y, c &= ~32);

                updateHistory(x ,y);
            }
        }
    }

    public void toLower(int x, int y) {
        if (x >= 0 || x <= super.getWidth() - 1 || y >= 0 || y <= super.getHeight() - 1) {
            if (super.getPixel(x, y) >= 65 && super.getPixel(x, y) <= 90) {
                char c = super.getPixel(x, y);

                super.drawPixel(x, y, c |= 32);

                updateHistory(x ,y);
            }
        }
    }

    public void fillHorizontalLine(int y, char c) {
        if (y >= 0 && y <= super.getHeight()) {
            for (int i = 0; i < super.getWidth(); i++) {
                if (super.getPixel(i, y) != c) {
                    super.drawPixel(i, y, c);

                    updateHistory(i, y);
                }
            }
        }
    }

    public void fillVerticalLine(int x, char c) {
        if (x >= 0 && x <= super.getWidth()) {
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

    public String getDrawing() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < super.getHeight() + 2; i++) {
            for (int j = 0; j < super.getWidth() + 2; j++) {
                if (i == 0 || i == super.getHeight() + 1) {
                    if (j == 0 || j == super.getWidth() + 1) {
                        sb.append('+');
                    } else {
                        sb.append('-');
                    }
                } else {
                    if (j == 0 || j == super.getWidth() + 1) {
                        sb.append('|');
                    } else {

                        sb.append(super.getPixel(j - 1, i - 1));
                    }
                }
            }

            sb.append(System.lineSeparator());
        }

        return sb.toString();
    }

    public LinkedList<Character> getPixelHistory(int x, int y) {
        return pixelHistory.get(getPixelHash(x, y));
    }

    public int getOverdrawCount(int x, int y) {
        return pixelHistory.get(getPixelHash(x, y)).size();
    }

    public int getOverdrawCount() {
        int result = 0;

        for (LinkedList<Character> list : pixelHistory.values()) {
            result += list.size();
        }

        return result;
    }
}

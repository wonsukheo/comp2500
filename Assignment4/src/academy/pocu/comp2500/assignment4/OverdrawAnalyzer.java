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

        if (x >= 0 || x <= super.width - 1 || y >= 0 || y <= super.height - 1) {
            if (super.getPixel(x, y) != c) {
                super.canvas[y][x] = c;

                updateHistory(x ,y);
            }
        }
    }

    public boolean increasePixel(int x, int y) {
        if (x >= 0 || x <= this.width - 1 || y >= 0 || y <= this.height - 1) {
            if (canvas[y][x] < 126) {
                canvas[y][x]++;

                updateHistory(x ,y);

                return true;
            }
        }

        return false;
    }

    public boolean decreasePixel(int x, int y) {
        if (x >= 0 || x <= this.width - 1 || y >= 0 || y <= this.height - 1) {
            if (canvas[y][x] > 32) {
                canvas[y][x]--;

                updateHistory(x ,y);

                return true;
            }
        }

        return false;
    }

    public void toUpper(int x, int y) {
        if (x >= 0 || x <= this.width - 1 || y >= 0 || y <= this.height - 1) {
            if (canvas[y][x] >= 97 && canvas[y][x] <= 122) {
                canvas[y][x] &= ~32;

                updateHistory(x ,y);
            }
        }
    }

    public void toLower(int x, int y) {
        if (x >= 0 || x <= this.width - 1 || y >= 0 || y <= this.height - 1) {
            if (canvas[y][x] >= 65 && canvas[y][x] <= 90) {
                canvas[y][x] |= 32;

                updateHistory(x ,y);
            }
        }
    }

    public void fillHorizontalLine(int y, char c) {
        if (y >= 0 && y <= this.height) {
            for (int i = 0; i < this.width; i++) {
                if (super.getPixel(i, y) != c) {
                    canvas[y][i] = c;

                    updateHistory(i, y);
                }
            }
        }
    }

    public void fillVerticalLine(int x, char c) {
        if (x >= 0 && x <= this.width) {
            for (int i = 0; i < this.height; i++) {
                if (super.getPixel(x, i) != c) {
                    canvas[i][x] = c;

                    updateHistory(x, i);
                }
            }
        }
    }

    public void clear() {
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                if (super.getPixel(i, j) != ' ') {
                    canvas[i][j] = ' ';

                    updateHistory(i, j);
                }
            }
        }
    }

    public String getDrawing() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < height + 2; i++) {
            for (int j = 0; j < width + 2; j++) {
                if (i == 0 || i == height + 1) {
                    if (j == 0 || j == width + 1) {
                        sb.append('+');
                    } else {
                        sb.append('-');
                    }
                } else {
                    if (j == 0 || j == width + 1) {
                        sb.append('|');
                    } else {
                        sb.append((char) canvas[i - 1][j - 1]);
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

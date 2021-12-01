package academy.pocu.comp2500.assignment4;

public class Canvas {
    protected int width;
    protected int height;
    protected int[][] canvas;

    public Canvas(int width, int height) {
        //user input is always > 0
        this.width = width;
        this.height = height;
        this.canvas = new int[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                canvas[i][j] = ' ';
            }
        }
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void drawPixel(int x, int y, char c) {
        //char arg is always valid ASCII character
        if (x >= 0 && x <= this.width - 1 && y >= 0 && y <= this.height - 1) {
            canvas[y][x] = c;
        }
    }

    public char getPixel(int x, int y) {
        if (x >= 0 && x <= this.width - 1 && y >= 0 && y <= this.height - 1) {
            return (char) canvas[y][x];
        }

        return ' ';
    }

    public boolean increasePixel(int x, int y) {
        if (x >= 0 && x <= this.width - 1 && y >= 0 && y <= this.height - 1) {
            if (canvas[y][x] < 126) {
                canvas[y][x]++;

                return true;
            }
        }

        return false;
    }

    public boolean decreasePixel(int x, int y) {
        if (x >= 0 && x <= this.width - 1 && y >= 0 && y <= this.height - 1) {
            if (canvas[y][x] > 32) {
                canvas[y][x]--;

                return true;
            }
        }

        return false;
    }

    public void toUpper(int x, int y) {
        if (x >= 0 && x <= this.width - 1 && y >= 0 && y <= this.height - 1) {
            if (canvas[y][x] >= 97 && canvas[y][x] <= 122) {
                canvas[y][x] &= ~32;
            }
        }
    }

    public void toLower(int x, int y) {
        if (x >= 0 && x <= this.width - 1 && y >= 0 && y <= this.height - 1) {
            if (canvas[y][x] >= 65 && canvas[y][x] <= 90) {
                canvas[y][x] |= 32;
            }
        }
    }

    public void fillHorizontalLine(int y, char c) {
        if (y >= 0 && y <= this.height) {
            for (int i = 0; i < this.width; i++) {
                canvas[y][i] = c;
            }
        }
    }

    public void fillVerticalLine(int x, char c) {
        if (x >= 0 && x <= this.width) {
            for (int i = 0; i < this.height; i++) {
                canvas[i][x] = c;
            }
        }
    }

    public void clear() {
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                canvas[i][j] = ' ';
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
}

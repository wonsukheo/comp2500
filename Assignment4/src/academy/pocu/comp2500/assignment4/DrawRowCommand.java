package academy.pocu.comp2500.assignment4;

public final class DrawRowCommand implements ICommand {
    private final int y;
    private final char c;
    private Canvas canvas;
    private char[] previousRow;

    private boolean isExecuted;
    private boolean isUndo;

    public DrawRowCommand(int y, char c) {
        this.y = y;
        this.c = c;
    }

    public boolean execute(Canvas canvas) {
        if (!isExecuted) {
            if (y >= 0 && y < canvas.getHeight()) {
                this.canvas = canvas;
                this.previousRow = new char[canvas.getWidth()];

                for (int i = 0; i < canvas.getWidth(); i++) {
                    previousRow[i] = canvas.getPixel(i, y);

                    canvas.drawPixel(i, y, c);
                }

                isExecuted = true;

                return true;
            }
        }

        return false;
    }

    public boolean undo() {
        if (!isExecuted) {
            return false;
        }

        for (int i = 0; i < canvas.getWidth(); i++) {
            if (canvas.getPixel(i, y) != c) {
                return false;
            }
        }

        for (int i = 0; i < canvas.getWidth(); i++) {
            canvas.drawPixel(i, y, previousRow[i]);
        }

        isUndo = true;

        return true;
    }

    public boolean redo() {
        if (!isUndo) {
            return false;
        }

        for (int i = 0; i < canvas.getWidth(); i++) {
            if (canvas.getPixel(i, y) != previousRow[i]) {
                return false;
            }
        }

        for (int i = 0; i < canvas.getWidth(); i++) {
            canvas.drawPixel(i, y, c);
        }

        isUndo = false;

        return true;
    }
}

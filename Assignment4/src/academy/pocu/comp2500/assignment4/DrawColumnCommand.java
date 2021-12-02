package academy.pocu.comp2500.assignment4;

public final class DrawColumnCommand implements ICommand {
    private final int x;
    private final char c;
    private Canvas canvas;
    private char[] previousColumn;

    private boolean isExecuted;
    private boolean isUndo;

    public DrawColumnCommand(int x, char c) {
        this.x = x;
        this.c = c;
    }

    public boolean execute(Canvas canvas) {
        if (!isExecuted) {
            if (x >= 0 && x < canvas.getWidth()) {
                this.canvas = canvas;
                previousColumn = new char[canvas.getHeight()];

                for (int i = 0; i < canvas.getHeight(); i++) {
                    previousColumn[i] = canvas.getPixel(x, i);

                    canvas.drawPixel(x, i, c);
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

        for (int i = 0; i < canvas.getHeight(); i++) {
            if (canvas.getPixel(x, i) != c) {
                return false;
            }
        }

        for (int i = 0; i < canvas.getHeight(); i++) {
            canvas.drawPixel(x, i, previousColumn[i]);
        }

        isUndo = true;

        return true;
    }

    public boolean redo() {
        if (!isUndo) {
            return false;
        }

        for (int i = 0; i < canvas.getHeight(); i++) {
            if (canvas.getPixel(x, i) != previousColumn[i]) {
                return false;
            }
        }

        for (int i = 0; i < canvas.getHeight(); i++) {
            canvas.drawPixel(x, i, c);
        }

        isUndo = false;

        return true;
    }
}

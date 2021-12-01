package academy.pocu.comp2500.assignment4;

public final class DrawColumn implements ICommand {
    private final int x;
    private final char c;
    private boolean isExecuted;
    private boolean isUndo;
    private Canvas canvas;
    private int[] previousColumn;

    public DrawColumn(int x, char c) {
        this.x = x;
        this.c = c;
    }

    public boolean execute(Canvas canvas) {
        if (!isExecuted) {
            if (x >= 0 || x <= canvas.getWidth() - 1) {
                previousColumn = new int[canvas.getHeight()];

                for (int i = 0; i < canvas.getHeight(); i++) {
                    this.canvas = canvas;

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
            canvas.drawPixel(x, i, (char) previousColumn[i]);
        }

        isUndo = true;

        return true;
    }

    public boolean redo() {
        if (!isUndo) {
            return false;
        }

        for (int i = 0; i < canvas.getHeight(); i++) {
            canvas.drawPixel(x, i, c);
        }

        isUndo = false;

        return true;
    }

}

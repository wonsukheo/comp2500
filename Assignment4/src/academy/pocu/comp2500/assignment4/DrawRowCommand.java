package academy.pocu.comp2500.assignment4;

public final class DrawRowCommand implements ICommand {
    private final int y;
    private final char c;
    private boolean isExecuted;
    private boolean isUndo;
    private Canvas canvas;
    private int[] previousRow;

    public DrawRowCommand(int y, char c) {
        this.y = y;
        this.c = c;
    }

    public boolean execute(Canvas canvas) {
        if (!isExecuted) {
            if (y >= 0 && y <= canvas.getHeight() - 1) {
                previousRow = new int[canvas.getWidth()];

                for (int i = 0; i < canvas.getWidth(); i++) {
                    this.canvas = canvas;

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
        boolean isSame = true;

        for (int i = 0; i < canvas.getWidth(); i++) {
            if (canvas.getPixel(i, y) != c) {
                isSame = false;
                break;
            }
        }

        if (isExecuted && isSame) {
            for (int i = 0; i < canvas.getWidth(); i++) {
                canvas.drawPixel(i, y, (char) previousRow[i]);
            }

            isUndo = true;

            return true;
        }

        return false;
    }

    public boolean redo() {
        boolean isSame = true;

        for (int i = 0; i < canvas.getWidth(); i++) {
            if (canvas.getPixel(i, y) != previousRow[i]) {
                isSame = false;
                break;
            }
        }

        if (isUndo && isSame) {
            for (int i = 0; i < canvas.getWidth(); i++) {
                canvas.drawPixel(i, y, c);
            }

            isUndo = false;

            return true;
        }

        return false;
    }

}

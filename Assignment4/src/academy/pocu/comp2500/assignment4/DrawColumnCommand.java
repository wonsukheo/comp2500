package academy.pocu.comp2500.assignment4;

public final class DrawColumnCommand implements ICommand {
    private final int x;
    private final char c;
    private boolean isExecuted;
    private boolean isUndo;
    private Canvas canvas;
    private int[] previousColumn;

    public DrawColumnCommand(int x, char c) {
        this.x = x;
        this.c = c;
    }

    public boolean execute(Canvas canvas) {
        if (!isExecuted) {
            if (x >= 0 && x <= canvas.getWidth() - 1) {
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
        boolean isSame = true;

        for (int i = 0; i < canvas.getHeight(); i++) {
            if (canvas.getPixel(x, i) != c) {
                isSame = false;
                break;
            }
        }

        if (isExecuted && isSame) {
            for (int i = 0; i < canvas.getHeight(); i++) {
                canvas.drawPixel(x, i, (char) previousColumn[i]);
            }

            isUndo = true;

            return true;
        }

        return false;
    }

    public boolean redo() {
        boolean isSame = true;

        for (int i = 0; i < canvas.getHeight(); i++) {
            if (canvas.getPixel(x, i) != previousColumn[i]) {
                isSame = false;
                break;
            }
        }

        if (isUndo && isSame) {
            for (int i = 0; i < canvas.getHeight(); i++) {
                canvas.drawPixel(x, i, c);
            }

            isUndo = false;

            return true;
        }

        return false;
    }

}

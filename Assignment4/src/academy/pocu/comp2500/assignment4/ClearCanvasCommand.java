package academy.pocu.comp2500.assignment4;

public final class ClearCanvasCommand implements ICommand {
    private boolean isExecuted;
    private boolean isUndo;
    private int[][] pixels;
    private Canvas canvas;

    public boolean execute(Canvas canvas) {
        if (!isExecuted) {
            this.pixels = new int[canvas.getHeight()][canvas.getWidth()];

            for (int i = 0; i < canvas.getHeight(); i++) {
                for (int j = 0; j < canvas.getWidth(); j++) {
                    this.pixels[i][j] = canvas.getPixel(j, i);
                    canvas.drawPixel(j, i, ' ');
                }
            }

            this.canvas = canvas;

            isExecuted = true;

            return true;
        }

        return false;
    }

    public boolean undo() {
        if (!isExecuted) {
            return false;
        }

        for (int i = 0; i < canvas.getHeight(); i++) {
            for (int j = 0; j < canvas.getWidth(); j++) {
                if (canvas.getPixel(j, i) != ' ') {
                    return false;
                }
            }
        }

        for (int i = 0; i < canvas.getHeight(); i++) {
            for (int j = 0; j < canvas.getWidth(); j++) {
                canvas.drawPixel(j, i, (char) pixels[i][j]);
            }
        }

        isUndo = true;

        return true;
    }

    public boolean redo() {
        if (!isUndo) {
            return false;
        }

        for (int i = 0; i < canvas.getHeight(); i++) {
            for (int j = 0; j < canvas.getWidth(); j++) {
                if (canvas.getPixel(j, i) != pixels[i][j]) {
                    return false;
                }
            }
        }

        for (int i = 0; i < canvas.getHeight(); i++) {
            for (int j = 0; j < canvas.getWidth(); j++) {
                canvas.drawPixel(j, i, ' ');
            }
        }

        return true;
    }

}

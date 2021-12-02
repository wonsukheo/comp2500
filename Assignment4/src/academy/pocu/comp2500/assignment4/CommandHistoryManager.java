package academy.pocu.comp2500.assignment4;

import java.util.ArrayList;

public final class CommandHistoryManager {
    private Canvas canvas;
    private ArrayList<ICommand> iCommands = new ArrayList<>();
    private ArrayList<Integer> isCommandsExecuted = new ArrayList<>();

    public CommandHistoryManager(Canvas canvas) {
        this.canvas = canvas;
    }

    public boolean execute(ICommand iCommand) {
        Canvas copyCanvas = new Canvas(canvas.getWidth(), canvas.getHeight());

        for (int i = 0; i < canvas.getHeight(); i++) {
            for (int j = 0; j < canvas.getWidth(); j++) {
                copyCanvas.drawPixel(j, i, canvas.getPixel(j, i));
            }
        }

        if (iCommand.execute(canvas)) {
            iCommands.add(iCommand);


            isCommandsExecuted.add(1);


            if (isCommandsExecuted.size() > 1) {
                if (isCommandsExecuted.get(isCommandsExecuted.size() - 2) == 2) {
                    for (int i = 0; i < isCommandsExecuted.size(); i ++) {
                        if (isCommandsExecuted.get(i) == 2) {
                            isCommandsExecuted.set(i, 3);
                        }
                    }
                }
            }

            return true;
        }

        return false;
    }

    public boolean canUndo() {
        for (Integer i : isCommandsExecuted) {
            if (i == 1) {
                return true;
            }
        }

        return false;
    }

    public boolean undo() {
        int i = isCommandsExecuted.lastIndexOf(1);

        if (canUndo()) {
            if (iCommands.get(i).undo()) {
                isCommandsExecuted.set(i, 2);

                return true;
            }
        }

        return false;
    }

    public boolean canRedo() {
        for (Integer i : isCommandsExecuted) {
            if (i == 2) {
                return true;
            }
        }

        return false;
    }

    public boolean redo() {
        int i = isCommandsExecuted.indexOf(2);

        if (i == -1) {
            return false;
        }

        if (i != isCommandsExecuted.size() - 1) {
            for (int j = i; j < isCommandsExecuted.size() - 1; j++) {
                if (isCommandsExecuted.get(j) != 2) {
                    return false;
                }
            }
        }

        if (iCommands.get(i).redo()) {
            isCommandsExecuted.set(i, 1);
            return true;
        } else {
            return false;
        }

    }

}

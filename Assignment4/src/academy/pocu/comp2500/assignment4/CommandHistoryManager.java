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
        if (iCommand.execute(canvas)) {
            iCommands.add(iCommand);

            isCommandsExecuted.add(1);

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

        if (canRedo()) {
            iCommands.get(i).redo();

            isCommandsExecuted.set(i, 1);

            return true;
        }

        return false;
    }

}

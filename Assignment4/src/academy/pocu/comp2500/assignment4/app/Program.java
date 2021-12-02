package academy.pocu.comp2500.assignment4.app;

import academy.pocu.comp2500.assignment4.App;
import academy.pocu.comp2500.assignment4.registry.Registry;
import academy.pocu.comp2500.assignment4.*;

import java.util.ArrayList;
import java.util.LinkedList;

public class Program {

    public static void main(String[] args) {
        {
            Canvas canvas = new Canvas(30, 30);

            CommandHistoryManager manager = new CommandHistoryManager(canvas);

            DrawColumnCommand drawColumnCommand3b = new DrawColumnCommand(3, 'b');
            ToLowerPixelCommand toLowerPixelCommand2114 = new ToLowerPixelCommand(21, 14);
            DrawRowCommand drawRowCommand14 = new DrawRowCommand(1, '4');
            DrawPixelCommand drawPixelCommand55k = new DrawPixelCommand(5, 5, 'k');
            ToLowerPixelCommand toLowerPixelCommand200 = new ToLowerPixelCommand(20, 0);
            ToLowerPixelCommand toLowerPixelCommand224 = new ToLowerPixelCommand(2, 24);
            ToUpperPixelCommand toUpperPixelCommand2317 = new ToUpperPixelCommand(23, 17);
            DecreasePixelCommand decreasePixelCommand234 = new DecreasePixelCommand(23, 4);
            ClearCanvasCommand clearCanvasCommand = new ClearCanvasCommand();
            ClearCanvasCommand clearCanvasCommand1 = new ClearCanvasCommand();

            manager.execute(drawColumnCommand3b);
            System.out.println(canvas.getDrawing());

            manager.execute(clearCanvasCommand);
            System.out.println(canvas.getDrawing());

            manager.execute(toLowerPixelCommand2114);
            System.out.println(canvas.getDrawing());

            manager.undo();
            System.out.println(canvas.getDrawing());

            manager.undo();
            System.out.println(canvas.getDrawing());

            manager.execute(drawRowCommand14);
            System.out.println(canvas.getDrawing());

            manager.undo();
            System.out.println(canvas.getDrawing());

            manager.execute(drawPixelCommand55k);
            System.out.println(canvas.getDrawing());

            manager.execute(toLowerPixelCommand200);
            System.out.println(canvas.getDrawing());

            manager.execute(toLowerPixelCommand224);
            System.out.println(canvas.getDrawing());

            manager.execute(toUpperPixelCommand2317);
            System.out.println(canvas.getDrawing());

            manager.execute(clearCanvasCommand1);
            System.out.println(canvas.getDrawing());

            manager.undo();
            System.out.println(canvas.getDrawing());

            manager.execute(decreasePixelCommand234);
            System.out.println(canvas.getDrawing());

            manager.redo();
            System.out.println(canvas.getDrawing());
        }


    }


    {
        Canvas canvas = new Canvas(30, 30);

        CommandHistoryManager manager = new CommandHistoryManager(canvas);

        DrawRowCommand drawRowCommand10t = new DrawRowCommand(10, 't');
        DrawRowCommand drawRowCommand2k = new DrawRowCommand(2, 'k');
        DrawPixelCommand drawPixelCommand860 = new DrawPixelCommand(8, 6, 'O');
        DrawPixelCommand drawPixelCommand2218 = new DrawPixelCommand(22, 18, 'K');

        DrawRowCommand drawRowCommand12B = new DrawRowCommand(12, 'B');
        DecreasePixelCommand decreasePixelCommand277 = new DecreasePixelCommand(27, 7);
        DecreasePixelCommand decreasePixelCommand2612 = new DecreasePixelCommand(26, 12);

        ToUpperPixelCommand toUpperPixelCommand1414 = new ToUpperPixelCommand(14, 14);
        ToUpperPixelCommand toUpperPixelCommand318 = new ToUpperPixelCommand(3, 18);



        ClearCanvasCommand clearCanvasCommand = new ClearCanvasCommand();
        ClearCanvasCommand clearCanvasCommand1 = new ClearCanvasCommand();
        ClearCanvasCommand clearCanvasCommand2 = new ClearCanvasCommand();


        manager.execute(drawRowCommand10t);
        System.out.println(canvas.getDrawing());

        manager.execute(drawRowCommand2k);
        System.out.println(canvas.getDrawing());

        manager.execute(drawPixelCommand860);
        System.out.println(canvas.getDrawing());

        manager.execute(clearCanvasCommand);
        System.out.println(canvas.getDrawing());

        manager.undo();
        System.out.println(canvas.getDrawing());

        manager.undo();
        System.out.println(canvas.getDrawing());

        manager.execute(clearCanvasCommand1);
        System.out.println(canvas.getDrawing());

        manager.execute(drawPixelCommand2218);
        System.out.println(canvas.getDrawing());

        manager.execute(clearCanvasCommand2);
        System.out.println(canvas.getDrawing());

        manager.undo();
        System.out.println(canvas.getDrawing());

        manager.execute(drawRowCommand12B);
        System.out.println(canvas.getDrawing());

        manager.execute(decreasePixelCommand277);
        System.out.println(canvas.getDrawing());

        manager.undo();
        System.out.println(canvas.getDrawing());

        manager.execute(decreasePixelCommand2612);
        System.out.println(canvas.getDrawing());

        manager.execute(toUpperPixelCommand1414);
        System.out.println(canvas.getDrawing());

        manager.execute(toUpperPixelCommand318);
        System.out.println(canvas.getDrawing());

        manager.redo();
        System.out.println(canvas.getDrawing());
    }

    {
        Canvas canvas = new Canvas(30, 30);

        CommandHistoryManager manager = new CommandHistoryManager(canvas);

        DrawColumnCommand drawColumnCommand3b = new DrawColumnCommand(3, 'b');
        ToLowerPixelCommand toLowerPixelCommand2114 = new ToLowerPixelCommand(21, 14);
        DrawRowCommand drawRowCommand14 = new DrawRowCommand(1, '4');
        DrawPixelCommand drawPixelCommand55k = new DrawPixelCommand(5, 5, 'k');
        ToLowerPixelCommand toLowerPixelCommand200 = new ToLowerPixelCommand(20, 0);
        ToLowerPixelCommand toLowerPixelCommand224 = new ToLowerPixelCommand(2, 24);
        ToUpperPixelCommand toUpperPixelCommand2317 = new ToUpperPixelCommand(23, 17);
        DecreasePixelCommand decreasePixelCommand234 = new DecreasePixelCommand(23, 4);
        ClearCanvasCommand clearCanvasCommand = new ClearCanvasCommand();
        ClearCanvasCommand clearCanvasCommand1 = new ClearCanvasCommand();

        manager.execute(drawColumnCommand3b);
        System.out.println(canvas.getDrawing());

        manager.execute(clearCanvasCommand);
        System.out.println(canvas.getDrawing());

        manager.execute(toLowerPixelCommand2114);
        System.out.println(canvas.getDrawing());

        manager.undo();
        System.out.println(canvas.getDrawing());

        manager.undo();
        System.out.println(canvas.getDrawing());

        manager.execute(drawRowCommand14);
        System.out.println(canvas.getDrawing());

        manager.undo();
        System.out.println(canvas.getDrawing());

        manager.execute(drawPixelCommand55k);
        System.out.println(canvas.getDrawing());

        manager.execute(toLowerPixelCommand200);
        System.out.println(canvas.getDrawing());

        manager.execute(toLowerPixelCommand224);
        System.out.println(canvas.getDrawing());

        manager.execute(toUpperPixelCommand2317);
        System.out.println(canvas.getDrawing());

        manager.execute(clearCanvasCommand1);
        System.out.println(canvas.getDrawing());

        manager.undo();
        System.out.println(canvas.getDrawing());

        manager.execute(decreasePixelCommand234);
        System.out.println(canvas.getDrawing());

        manager.redo();
        System.out.println(canvas.getDrawing());
    }

    {
        Canvas canvas = new Canvas(20, 10);
        CommandHistoryManager chm = new CommandHistoryManager(canvas);
        ArrayList<ICommand> commandList = new ArrayList<>();

        commandList.add(new DrawRowCommand(3, 'h'));
        commandList.add(new DrawColumnCommand(3, 'h'));

        for (ICommand command : commandList) {
            assert (chm.execute(command) == true);
            System.out.println(canvas.getDrawing());
            assert (chm.undo() == true);
            assert (chm.redo() == true);
            System.out.println(canvas.getDrawing());
            canvas.drawPixel(9, 9, '5');
            System.out.println(canvas.getDrawing());
            assert (chm.undo() == false);
            canvas.drawPixel(9, 9, ' ');
            assert (chm.undo() == true);
            canvas.drawPixel(9, 9, '5');
            assert (chm.redo() == false);
            canvas.drawPixel(9, 9, ' ');
            assert (chm.redo() == true);
        }
    }


    {
        OverdrawAnalyzer analyzer = new OverdrawAnalyzer(6, 6);
        CommandHistoryManager manager = new CommandHistoryManager((Canvas) analyzer);

        ArrayList<ICommand> commands = new ArrayList<>();
        commands.add(new ClearCanvasCommand());
        commands.add(new DrawColumnCommand(1, '.'));
        commands.add(new IncreasePixelCommand(0, 3));
        commands.add(new ToUpperPixelCommand(1, 0));
        commands.add(new DrawRowCommand(4, 'X'));
        commands.add(new DrawRowCommand(4, 'V'));
        commands.add(new DrawColumnCommand(4, 't'));
        commands.add(new IncreasePixelCommand(4, 2));
        commands.add(new ToLowerPixelCommand(2, 3));
        commands.add(new IncreasePixelCommand(0, 0));
        commands.add(new DrawColumnCommand(2, 'm'));
        commands.add(new ToLowerPixelCommand(0, 4));
        commands.add(new ToLowerPixelCommand(1, 0));
        commands.add(new DrawPixelCommand(3, 1, 'o'));
        commands.add(new DrawColumnCommand(2, 'y'));
        commands.add(new DrawRowCommand(1, 'A'));


        for (int i = 0; i < 8; i++) {
            manager.execute(commands.get(i));
        }

        manager.redo();

        for (int i = 8; i < 10; i++) {
            manager.execute(commands.get(i));
        }

        manager.redo();

        manager.execute(commands.get(10));

        manager.undo();

        for (int i = 11; i < 14; i++) {
            manager.execute(commands.get(i));
        }

        manager.undo();

        for (int i = 14; i < 16; i++) {
            manager.execute(commands.get(i));
        }


        System.out.print(analyzer.getDrawing());

        LinkedList<Character> result = analyzer.getPixelHistory(0, 1);

        for (Character c : result) {
            System.out.print(c);
        }


    }


    {
        //overdraw test
        OverdrawAnalyzer overdrawAnalyzer = new OverdrawAnalyzer(10, 10);
        overdrawAnalyzer.drawPixel(5, 5, 'c');
        overdrawAnalyzer.drawPixel(5, 5, 'd');

        LinkedList<Character> result = overdrawAnalyzer.getPixelHistory(5, 5);

        for (Character c : result) {
            System.out.print(c);
            System.out.print("->");
        }
        System.out.println();

        overdrawAnalyzer.drawPixel(5, 5, 'd');

        result = overdrawAnalyzer.getPixelHistory(5, 5);

        for (Character c : result) {
            System.out.print(c);
        }
        System.out.println();
    }

    {
        // undo & redo test
        Canvas canvas1 = new Canvas(10, 10);
        CommandHistoryManager commandHistoryManager = new CommandHistoryManager(canvas1);

        // 1. drawPixel
        DrawPixelCommand drawPixel = new DrawPixelCommand(5, 5, 'a');

        commandHistoryManager.execute(drawPixel);
        System.out.println(canvas1.getDrawing());

        assert (commandHistoryManager.canUndo());
        commandHistoryManager.undo();
        System.out.println(canvas1.getDrawing());

        assert (commandHistoryManager.canRedo());
        commandHistoryManager.redo();
        System.out.println(canvas1.getDrawing());

        // 2. toLowerPixel & UpperPixel

        ToLowerPixelCommand toLowerPixel = new ToLowerPixelCommand(5, 5);
        ToUpperPixelCommand toUpperPixel = new ToUpperPixelCommand(5, 5);

        commandHistoryManager.execute(toUpperPixel);
        System.out.println(canvas1.getDrawing());

        assert (commandHistoryManager.canUndo());
        commandHistoryManager.undo();
        System.out.println(canvas1.getDrawing());

        assert (commandHistoryManager.canRedo());
        commandHistoryManager.redo();
        System.out.println(canvas1.getDrawing());
        //

        commandHistoryManager.execute(toLowerPixel);
        System.out.println(canvas1.getDrawing());

        assert (commandHistoryManager.canUndo());
        commandHistoryManager.undo();
        System.out.println(canvas1.getDrawing());

        assert (commandHistoryManager.canRedo());
        commandHistoryManager.redo();
        System.out.println(canvas1.getDrawing());

        // 3. Increase & decrease pixel

        DecreasePixelCommand decreasePixel = new DecreasePixelCommand(5, 5);
        IncreasePixelCommand increasePixel = new IncreasePixelCommand(5, 5);

        commandHistoryManager.execute(increasePixel);
        System.out.println(canvas1.getDrawing());

        assert (commandHistoryManager.canUndo());
        commandHistoryManager.undo();
        System.out.println(canvas1.getDrawing());

        assert (commandHistoryManager.canRedo());
        commandHistoryManager.redo();
        System.out.println(canvas1.getDrawing());
        //

        commandHistoryManager.execute(decreasePixel);
        System.out.println(canvas1.getDrawing());

        assert (commandHistoryManager.canUndo());
        commandHistoryManager.undo();
        System.out.println(canvas1.getDrawing());

        assert (commandHistoryManager.canRedo());
        commandHistoryManager.redo();
        System.out.println(canvas1.getDrawing());

        // draw Colum & Row
        DrawColumnCommand drawColumn = new DrawColumnCommand(5, '!');
        DrawRowCommand drawRow = new DrawRowCommand(5, '?');

        commandHistoryManager.execute(drawColumn);
        System.out.println(canvas1.getDrawing());

        assert (commandHistoryManager.canUndo());
        commandHistoryManager.undo();
        System.out.println(canvas1.getDrawing());


        //

        commandHistoryManager.execute(drawRow);
        System.out.println(canvas1.getDrawing());

        commandHistoryManager.redo();
        System.out.println(canvas1.getDrawing());

        assert (commandHistoryManager.canUndo());
        commandHistoryManager.undo();
        System.out.println(canvas1.getDrawing());

        assert (!commandHistoryManager.undo());
        System.out.println(canvas1.getDrawing());

        assert (commandHistoryManager.canRedo());
        commandHistoryManager.redo();
        System.out.println(canvas1.getDrawing());

        ClearCanvasCommand clearCanvas = new ClearCanvasCommand();

        commandHistoryManager.execute(clearCanvas);
        System.out.println(canvas1.getDrawing());

        assert (commandHistoryManager.canUndo());
        commandHistoryManager.undo();
        System.out.println(canvas1.getDrawing());

        assert (commandHistoryManager.canRedo());
        commandHistoryManager.redo();
        System.out.println(canvas1.getDrawing());
    }
}


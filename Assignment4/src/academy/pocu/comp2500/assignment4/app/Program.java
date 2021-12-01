package academy.pocu.comp2500.assignment4.app;

import academy.pocu.comp2500.assignment4.App;
import academy.pocu.comp2500.assignment4.registry.Registry;
import academy.pocu.comp2500.assignment4.*;

import java.util.ArrayList;
import java.util.LinkedList;

public class Program {

    public static void main(String[] args) {
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
            System.out.println(analyzer.getPixelHistory(0, 1));
        }

        {
            // 1. Canvas function test
            Canvas canvas = new Canvas(10, 10);

            canvas.drawPixel(0, 0, ' ');
            canvas.drawPixel(1, 2, '~');
            canvas.drawPixel(0, 1, '&');
            canvas.drawPixel(8, 8, 'a');
            canvas.drawPixel(9, 9, 'C');

            // draw should fail
            canvas.drawPixel(10, 11, 'X');
            canvas.drawPixel(-5, 2, 'X');

            System.out.println(canvas.getDrawing());
            //

            canvas.increasePixel(0, 1);
            canvas.decreasePixel(9, 9);

            // should fail
            canvas.increasePixel(1, 2);
            canvas.decreasePixel(0, 0);

            System.out.println(canvas.getDrawing());
            //

            canvas.toUpper(8, 8);
            canvas.toLower(9, 9);

            // should fail
            canvas.toUpper(0, 0);
            canvas.toLower(0, 1);

            System.out.println(canvas.getDrawing());
            //

            canvas.fillHorizontalLine(5, '!');
            canvas.fillVerticalLine(5, '?');

            System.out.println(canvas.getDrawing());

            canvas.clear();

            System.out.println(canvas.getDrawing());
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
}

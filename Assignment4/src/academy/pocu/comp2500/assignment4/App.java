package academy.pocu.comp2500.assignment4;

import academy.pocu.comp2500.assignment4.registry.Registry;

public class App {
    public App(Registry registry) {
        // Register like this
        // registry.registerDrawPixelCommandCreator("Foo");
        // OR
        // registry.registerDrawPixelCommandCreator("Foo", "bar");
        registry.registerClearCommandCreator("ClearCanvasCommand");

        registry.registerIncreasePixelCommandCreator("IncreasePixelCommand");

        registry.registerDecreasePixelCommandCreator("DecreasePixelCommand");

        registry.registerFillHorizontalLineCommandCreator("DrawRowCommand");

        registry.registerFillVerticalLineCommandCreator("DrawColumnCommand");

        registry.registerToLowercaseCommandCreator("ToLowerPixelCommand");

        registry.registerToUppercaseCommandCreator("ToUpperPixelCommand");

        registry.registerDrawPixelCommandCreator("DrawPixelCommand");
    }
}

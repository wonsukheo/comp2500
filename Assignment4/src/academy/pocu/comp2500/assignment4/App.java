package academy.pocu.comp2500.assignment4;

import academy.pocu.comp2500.assignment4.registry.Registry;

public class App {
    public App(Registry registry) {
        // Register like this
        // registry.registerDrawPixelCommandCreator("Foo");
        // OR
        // registry.registerDrawPixelCommandCreator("Foo", "bar");
        registry.registerClearCommandCreator("ClearCanvas");

        registry.registerIncreasePixelCommandCreator("IncreasePixel");

        registry.registerDecreasePixelCommandCreator("DecreasePixel");

        registry.registerFillHorizontalLineCommandCreator("DrawRow");

        registry.registerFillVerticalLineCommandCreator("DrawColumn");

        registry.registerToLowercaseCommandCreator("ToLowerPixel");

        registry.registerToUppercaseCommandCreator("ToUpperPixel");

        registry.registerDrawPixelCommandCreator("DrawPixel");
    }
}

package academy.pocu.comp2500.assignment2;

import academy.pocu.comp2500.assignment2.registry.Registry;

public class App {
    public App(Registry registry) {
        // register your classes or methods here
        registry.registerRedStampCreator("Stamp");
        registry.registerBlueStampCreator("Stamp");
        registry.registerGreenStampCreator("Stamp");

        registry.registerWallCalendarCreator("Calender");
        registry.registerMagnetCalendarCreator("Calender");
        registry.registerDeskCalendarCreator("Calender");

        registry.registerLandscapeBannerCreator("Banner");
        registry.registerPortraitBannerCreator("Banner");;
        registry.registerGlossBannerCreator("Banner");;
        registry.registerScrimBannerCreator("Banner");
        registry.registerMeshBannerCreator("Banner");

        registry.registerLandscapeBusinessCardCreator("BusinessCard");
        registry.registerPortraitBusinessCardCreator("BusinessCard");
        registry.registerIvoryBusinessCardCreator("BusinessCard");
        registry.registerGrayBusinessCardCreator("BusinessCard");
        registry.registerWhiteBusinessCardCreator("BusinessCard");

        registry.registerLaidBusinessCardCreator("BusinessCard");
        registry.registerLinenBusinessCardCreator("BusinessCard");
        registry.registerSmoothBusinessCardCreator("BusinessCard");
        registry.registerSingleSidedBusinessCardCreator("BusinessCard");
        registry.registerDoubleSidedBusinessCardCreator("BusinessCard");

        registry.registerCartCreator("ShoppingCart");
        registry.registerProductAdder("ShoppingCart", "addProduct");
        registry.registerProductRemover("ShoppingCart", "removeProduct");
        registry.registerTotalPriceGetter("ShoppingCart", "getTotalPrice");


        registry.registerLandscapeBannerTextApertureAdder("ProductAperture", "addTextAperture");
        registry.registerLandscapeBannerImageApertureAdder("ProductAperture", "addImageAperture");
        registry.registerPortraitBannerTextApertureAdder("ProductAperture", "addTextAperture");
        registry.registerPortraitBannerImageApertureAdder("ProductAperture", "addImageAperture");
        registry.registerGlossBannerTextApertureAdder("ProductAperture", "addTextAperture");
        registry.registerGlossBannerImageApertureAdder("ProductAperture", "addImageAperture");
        registry.registerScrimBannerTextApertureAdder("ProductAperture", "addTextAperture");
        registry.registerScrimBannerImageApertureAdder("ProductAperture", "addImageAperture");
        registry.registerMeshBannerTextApertureAdder("ProductAperture", "addTextAperture");
        registry.registerMeshBannerImageApertureAdder("ProductAperture", "addImageAperture");

        registry.registerLandscapeBusinessCardTextApertureAdder("ProductAperture", "addTextAperture");
        registry.registerLandscapeBusinessCardImageApertureAdder("ProductAperture", "addImageAperture");
        registry.registerPortraitBusinessCardTextApertureAdder("ProductAperture", "addTextAperture");
        registry.registerPortraitBusinessCardImageApertureAdder("ProductAperture", "addImageAperture");

        registry.registerIvoryBusinessCardTextApertureAdder("ProductAperture", "addTextAperture");
        registry.registerIvoryBusinessCardImageApertureAdder("ProductAperture", "addImageAperture");
        registry.registerGrayBusinessCardTextApertureAdder("ProductAperture", "addTextAperture");
        registry.registerGrayBusinessCardImageApertureAdder("ProductAperture", "addImageAperture");
        registry.registerWhiteBusinessCardTextApertureAdder("ProductAperture", "addTextAperture");
        registry.registerWhiteBusinessCardImageApertureAdder("ProductAperture", "addImageAperture");

        registry.registerLaidBusinessCardTextApertureAdder("ProductAperture", "addTextAperture");
        registry.registerLaidBusinessCardImageApertureAdder("ProductAperture", "addImageAperture");
        registry.registerLinenBusinessCardTextApertureAdder("ProductAperture", "addTextAperture");
        registry.registerLinenBusinessCardImageApertureAdder("ProductAperture", "addImageAperture");
        registry.registerSmoothBusinessCardTextApertureAdder("ProductAperture", "addTextAperture");
        registry.registerSmoothBusinessCardImageApertureAdder("ProductAperture", "addImageAperture");

        registry.registerSingleSidedBusinessCardTextApertureAdder("BusinessCard", "addTextAperture");
        registry.registerSingleSidedBusinessCardImageApertureAdder("BusinessCard", "addImageAperture");
        registry.registerDoubleSidedBusinessCardTextApertureAdder("ProductAperture", "addTextAperture");
        registry.registerDoubleSidedBusinessCardImageApertureAdder("ProductAperture", "addImageAperture");
    }
}

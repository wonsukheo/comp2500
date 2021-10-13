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

        registry.registerLaidBusinessCardCreator("Banner");
        registry.registerLinenBusinessCardCreator("Banner");
        registry.registerSmoothBusinessCardCreator("Banner");
        registry.registerSingleSidedBusinessCardCreator("Banner");
        registry.registerDoubleSidedBusinessCardCreator("Banner");

        registry.registerCartCreator("ShoppingCart");
        registry.registerProductAdder("ShoppingCart", "addProduct");
        registry.registerProductRemover("ShoppingCart", "removeProduct");
        registry.registerTotalPriceGetter("ShoppingCart", "getTotalPrice");


        registry.registerLandscapeBannerTextApertureAdder("Personalized", "addTextAperture");
        registry.registerLandscapeBannerImageApertureAdder("Personalized", "addImageAperture");
        registry.registerPortraitBannerTextApertureAdder("Personalized", "addTextAperture");
        registry.registerPortraitBannerImageApertureAdder("Personalized", "addImageAperture");
        registry.registerGlossBannerTextApertureAdder("Personalized", "addTextAperture");
        registry.registerGlossBannerImageApertureAdder("Personalized", "addImageAperture");
        registry.registerScrimBannerTextApertureAdder("Personalized", "addTextAperture");
        registry.registerScrimBannerImageApertureAdder("Personalized", "addImageAperture");
        registry.registerMeshBannerTextApertureAdder("Personalized", "addTextAperture");
        registry.registerMeshBannerImageApertureAdder("Personalized", "addImageAperture");

        registry.registerLandscapeBusinessCardTextApertureAdder("Personalized", "addTextAperture");
        registry.registerLandscapeBusinessCardImageApertureAdder("Personalized", "addImageAperture");
        registry.registerPortraitBusinessCardTextApertureAdder("Personalized", "addTextAperture");
        registry.registerPortraitBusinessCardImageApertureAdder("Personalized", "addImageAperture");

        registry.registerIvoryBusinessCardTextApertureAdder("Personalized", "addTextAperture");
        registry.registerIvoryBusinessCardImageApertureAdder("Personalized", "addImageAperture");
        registry.registerGrayBusinessCardTextApertureAdder("Personalized", "addTextAperture");
        registry.registerGrayBusinessCardImageApertureAdder("Personalized", "addImageAperture");
        registry.registerWhiteBusinessCardTextApertureAdder("Personalized", "addTextAperture");
        registry.registerWhiteBusinessCardImageApertureAdder("Personalized", "addImageAperture");

        registry.registerLaidBusinessCardTextApertureAdder("Personalized", "addTextAperture");
        registry.registerLaidBusinessCardImageApertureAdder("Personalized", "addImageAperture");
        registry.registerLinenBusinessCardTextApertureAdder("Personalized", "addTextAperture");
        registry.registerLinenBusinessCardImageApertureAdder("Personalized", "addImageAperture");
        registry.registerSmoothBusinessCardTextApertureAdder("Personalized", "addTextAperture");
        registry.registerSmoothBusinessCardImageApertureAdder("Personalized", "addImageAperture");

        registry.registerSingleSidedBusinessCardTextApertureAdder("Personalized", "addTextAperture");
        registry.registerSingleSidedBusinessCardImageApertureAdder("Personalized", "addImageAperture");
        registry.registerDoubleSidedBusinessCardTextApertureAdder("Personalized", "addTextAperture");
        registry.registerDoubleSidedBusinessCardImageApertureAdder("Personalized", "addImageAperture");
    }
}

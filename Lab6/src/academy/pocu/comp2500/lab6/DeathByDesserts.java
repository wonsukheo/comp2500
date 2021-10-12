package academy.pocu.comp2500.lab6;

public class DeathByDesserts extends ComboMeal {
    public DeathByDesserts() {
        super(20, 0, 0, 4);
    }

    public void setDesserts(Dessert dessert1, Dessert dessert2, Dessert dessert3, Dessert dessert4) {
        super.desserts.clear();

        super.desserts.add(dessert1);
        super.desserts.add(dessert2);
        super.desserts.add(dessert3);
        super.desserts.add(dessert4);

        checkValid();
    }
}
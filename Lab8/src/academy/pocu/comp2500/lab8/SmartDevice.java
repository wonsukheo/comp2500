package academy.pocu.comp2500.lab8;

public abstract class SmartDevice {
    protected boolean powerOn;
    protected int currentTick;
    protected int lastUpdatedTick;
    protected Planter planter;

    public boolean isOn() {
        return powerOn;
    }

    public abstract void onTick();

    public int getTicksSinceLastUpdate() {
        return currentTick - lastUpdatedTick;
    }

    public void setPlanter(Planter planter) {
        if (planter != null) {
            this.planter = planter;
        }
    }
}

package academy.pocu.comp2500.lab8;

public class Drainer extends SmartDevice implements IWaterDetectable, IDrainable {
    private static final int DRAIN_PER_TICK = 7;

    private final int drainStart;

    public Drainer(int drainStart) {
        this.drainStart = drainStart;
    }

    public void onTick() {
        currentTick++;

        if (this.planter != null) {
            detect(this.planter.getWaterAmount());
            drain(this.planter);
        }
    }

    public void drain(Planter planter) {
        if (this.powerOn) {
            planter.updateWater(-DRAIN_PER_TICK);
        }
    }

    public void detect(final int waterLevel) {
        if (waterLevel >= drainStart) {
            if (!powerOn) {
                lastUpdatedTick = currentTick;
            }
            this.powerOn = true;
        } else {
            if (powerOn) {
                lastUpdatedTick = currentTick;
            }
            this.powerOn = false;
        }
    }
}

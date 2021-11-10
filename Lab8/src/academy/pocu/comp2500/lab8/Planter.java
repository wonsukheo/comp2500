package academy.pocu.comp2500.lab8;

import java.util.ArrayList;

public class Planter {
    private static final int CONSUME_PER_TICK = 2;

    private ArrayList<SmartDevice> smartDeviceList = new ArrayList<>();
    private int waterAmount;
    protected int waterUpdateAmount;

    public Planter(int waterAmount) {
        this.waterAmount = waterAmount;
    }

    public int getWaterAmount() {
        return this.waterAmount;
    }

    public void updateWater(int waterAmount) {
        this.waterUpdateAmount += waterAmount;
    }

    public void installSmartDevice(SmartDevice smartDevice) {
        if (smartDevice != null) {
            smartDeviceList.add(smartDevice);
            smartDevice.setPlanter(this);
        }
    }

    public void tick() {
        for (SmartDevice smartDevice : smartDeviceList) {
            smartDevice.onTick();
        }

        this.waterAmount = Math.max(0, this.waterAmount + waterUpdateAmount - CONSUME_PER_TICK);
        this.waterUpdateAmount = 0;
    }
}

package academy.pocu.comp2500.lab8;

import java.util.ArrayList;

public class Sprinkler extends SmartDevice implements ISprayable{
    private static final int SPRAY_PER_TICK = 15;

    private ArrayList<Schedule> scheduleList = new ArrayList<>();
    private Schedule currentSchedule;
    private int schedulePosition;

    public Sprinkler() {
    }

    public void addSchedule(Schedule schedule) {
        if (schedule.start != 0) {
            this.scheduleList.add(schedule);
        }
    }

    public void onTick() {
        currentTick++;

        updateSchedule();

        if (currentSchedule != null) {
            this.powerOn = true;
        } else {
            this.powerOn = false;
        }

        if (this.planter != null && powerOn) {
            this.spray(this.planter);
        }
    }

    private void updateSchedule() {
        if (currentSchedule == null && schedulePosition < scheduleList.size()) {
            Schedule schedule = scheduleList.get(schedulePosition);

            if (schedule.start + schedule.stayOn <= currentTick) {
                schedule = scheduleList.get(++schedulePosition);
            }

            if (schedule.start == currentTick) {
                currentSchedule = schedule;
                schedulePosition++;
                lastUpdatedTick = currentTick;
            }
        }

        if (currentSchedule != null) {
            if (currentSchedule.start + currentSchedule.stayOn == currentTick) {
                currentSchedule = null;
                lastUpdatedTick = currentTick;
            }
        }
    }

    public void spray(Planter planter) {
        planter.updateWater(SPRAY_PER_TICK);
    }
}

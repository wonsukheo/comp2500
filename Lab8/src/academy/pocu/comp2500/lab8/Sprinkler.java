package academy.pocu.comp2500.lab8;

import java.util.ArrayList;

public class Sprinkler extends SmartDevice implements ISprayable {
    private static final int SPRAY_PER_TICK = 15;

    private ArrayList<Schedule> scheduleList = new ArrayList<>();
    private Schedule currentSchedule;
    private boolean scheduleInEffect;
    private int schedulePosition;

    public Sprinkler() {
    }

    public void addSchedule(Schedule schedule) {
        this.scheduleList.add(schedule);
    }

    public void onTick() {
        currentTick++;

        updateSchedule();

        if (currentSchedule != null && scheduleInEffect) {
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

        if (this.planter != null && powerOn) {
            this.spray(this.planter);
        }
    }

    private void updateSchedule() {
        if (currentSchedule == null && schedulePosition < scheduleList.size()) {
            Schedule schedule = scheduleList.get(schedulePosition);

            if (schedule.start == 0 || schedule.start + schedule.stayOn <= currentTick) {
                schedulePosition++;

                if (schedulePosition < scheduleList.size()) {
                    schedule = scheduleList.get(schedulePosition);
                } else {
                    schedule = null;
                }
            }

            if (schedule != null) {
                currentSchedule = schedule;
                schedulePosition++;

                if (schedule.start == currentTick) {
                    scheduleInEffect = true;
                }
            }
        }

        if (currentSchedule != null) {
            if (currentSchedule.start == currentTick) {
                scheduleInEffect = true;
            }

            if (currentSchedule.start + currentSchedule.stayOn == currentTick) {
                currentSchedule = null;
                scheduleInEffect = false;
            }
        }
        /*if (currentSchedule == null && schedulePosition < scheduleList.size()) {
            Schedule schedule = scheduleList.get(schedulePosition);

            if (schedule.start == 0 || schedule.start + schedule.stayOn <= currentTick) {
                schedulePosition++;
                if (schedulePosition < scheduleList.size()) {
                    schedule = scheduleList.get(schedulePosition);
                } else {
                    schedule = null;
                }
            }

            if (schedule != null && schedule.start == currentTick) {
                currentSchedule = schedule;
                schedulePosition++;
                lastUpdatedTick = currentTick;
            }
        }

        if (currentSchedule != null) {
            if (currentSchedule.start + currentSchedule.stayOn == currentTick) {
                //this.scheduleList.remove(currentSchedule);
                schedulePosition++;
                currentSchedule = null;
                lastUpdatedTick = currentTick;
            }
        }*/
    }

    public void spray(Planter planter) {
        planter.updateWater(SPRAY_PER_TICK);
    }



}

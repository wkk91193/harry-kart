package se.atg.service.harrykart.java.model;

public class ParticipantInfo {

    private final int lane;
    private final String name;
    private final float baseSpeed;

    public ParticipantInfo(int lane, String name, float baseSpeed) {
        this.lane = lane;
        this.name = name;
        this.baseSpeed = baseSpeed;
    }

    public int getLane() {
        return lane;
    }

    public String getName() {
        return name;
    }

    public float getBaseSpeed() {
        return baseSpeed;
    }
}

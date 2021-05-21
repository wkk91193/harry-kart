package se.atg.service.harrykart.java.model;

public class PowerUpInfo {
    private final int lane;
    private final int powerUpValue;

    public PowerUpInfo(int lane, int powerUpValue) {
        this.lane = lane;
        this.powerUpValue = powerUpValue;
    }

    public int getLane() {
        return lane;
    }

    public int getPowerUpValue() {
        return powerUpValue;
    }
}

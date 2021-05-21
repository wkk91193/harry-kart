package se.atg.service.harrykart.java.model;

public class RaceResult {
    private final int position;
    private final String horseName;

    public RaceResult(int position, String horseName) {
        this.position = position;
        this.horseName = horseName;
    }

    public int getPosition() {
        return position;
    }

    public String getHorseName() {
        return horseName;
    }
}

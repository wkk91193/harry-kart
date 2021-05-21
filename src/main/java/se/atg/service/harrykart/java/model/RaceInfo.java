package se.atg.service.harrykart.java.model;

import java.util.List;
import java.util.Map;

public class RaceInfo {
    private final int numberOfLoops;
    private final List<ParticipantInfo> participantInfoList;
    private final Map<Integer,List<PowerUpInfo>> powerUpMap;

    public RaceInfo(int numberOfLoops, List<ParticipantInfo> participantInfoList, Map<Integer, List<PowerUpInfo>> powerUpMap) {
        this.numberOfLoops = numberOfLoops;
        this.participantInfoList = participantInfoList;
        this.powerUpMap = powerUpMap;
    }

    public int getNumberOfLoops() {
        return numberOfLoops;
    }

    public List<ParticipantInfo> getParticipantInfoList() {
        return participantInfoList;
    }

    public Map<Integer, List<PowerUpInfo>> getPowerUpMap() {
        return powerUpMap;
    }
}

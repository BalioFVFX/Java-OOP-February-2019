package models;

import enums.MissionState;
import interfaces.Mission;

public class MissionImpl implements Mission {

    private String codeName;
    private MissionState missionState;

    public MissionImpl(String codeName, MissionState missionState) {
        this.codeName = codeName;
        this.missionState = missionState;
    }

    @Override
    public String getCodeName() {
        return this.codeName;
    }

    @Override
    public MissionState getState() {
        return this.missionState;
    }

    @Override
    public void completeMission() {
        this.missionState = MissionState.Finished;
    }

    @Override
    public String toString() {
        return String.format("Code Name: %s State: %s",
                this.getCodeName(),
                this.getState());
    }
}

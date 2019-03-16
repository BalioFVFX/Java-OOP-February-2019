package interfaces;

import enums.MissionState;

public interface Mission {
    String getCodeName();
    MissionState getState();
    void completeMission();
}

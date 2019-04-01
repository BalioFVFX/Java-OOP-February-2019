package models.system;

import models.hardware.Hardware;

import java.util.ArrayList;
import java.util.List;

public class Dump {
    private List<Hardware> hardwareList;

    public Dump() {
        this.hardwareList = new ArrayList<>();
    }

    public void add(Hardware hardware){
        this.hardwareList.add(hardware);
    }

    public Hardware restoreHardwareByName(String name){
        for (Hardware hardware : hardwareList) {
            if(hardware.getName().equals(name)){
                hardwareList.remove(hardware);
                return hardware;
            }
        }
        return null;
    }

    public String analysis(){
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Power Hardware Components:").append(" ").append(this.getPowerHardwareComponentsCount()).append("\n");
        stringBuilder.append("Heavy Hardware Components:").append(" ").append(this.getHeavyHardwareComponentsCount()).append("\n");
        stringBuilder.append("Express Software Components:").append(" ").append(this.getExpressSoftwareComponentsCount()).append("\n");
        stringBuilder.append("Light Software Components:").append(" ").append(this.getLightSoftwareComponentsCount()).append("\n");
        stringBuilder.append("Total Dumped Memory:").append(" ").append(this.getTotalMemory()).append("\n");
        stringBuilder.append("Total Dumped Capacity:").append(" ").append(this.getTotalCapacity());

        return stringBuilder.toString();
    }

    public void destroyHardwareByName(String name) {
        for (Hardware hardware : hardwareList) {
            if(hardware.getName().equals(name)){
                hardwareList.remove(hardware);
                return;
            }
        }
    }

    private int getExpressSoftwareComponentsCount(){
        int count = 0;

        for (Hardware hardware : hardwareList) {
            count += hardware.getExpressSoftwareCount();
        }
        return count;
    }

    private int getLightSoftwareComponentsCount(){
        int count = 0;

        for (Hardware hardware : hardwareList) {
            count += hardware.getLightSoftwareCount();
        }

        return count;
    }

    private int getPowerHardwareComponentsCount(){
        int counter = 0;

        for (Hardware hardware : hardwareList) {
            if(hardware.getType().equals("Power")){
                counter++;
            }
        }

        return counter;
    }

    private int getHeavyHardwareComponentsCount(){
        int counter = 0;

        for (Hardware hardware : hardwareList) {
            if(hardware.getType().equals("Heavy")){
                counter++;
            }
        }

        return counter;
    }

    private int getTotalMemory(){
        int counter = 0;

        for (Hardware hardware : hardwareList) {
            counter += hardware.getMemory();
        }
        return counter;
    }

    private int getTotalCapacity(){
        int counter = 0;

        for (Hardware hardware : hardwareList) {
            counter += hardware.getCapacity();
        }
        return counter;
    }
}

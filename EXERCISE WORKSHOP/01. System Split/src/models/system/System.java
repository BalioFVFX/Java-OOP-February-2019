package models.system;

import models.hardware.Hardware;
import models.software.Software;

import java.util.LinkedHashMap;

public class System {
    private LinkedHashMap<String, Hardware> hardwareComponents;
    private Dump dump;

    public System() {
        this.hardwareComponents = new LinkedHashMap<>();
        this.dump = new Dump();
    }


    public void addHardwareComponent(Hardware hardware) {
        this.hardwareComponents.put(hardware.getName(), hardware);
    }

    public String analyze() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("System Analysis").append("\n");

        stringBuilder.append("Hardware Components:").append(" ").append(this.hardwareComponents.size()).append("\n");

        stringBuilder.append("Software Components:").append(" ").append(this.getSoftwareCount()).append("\n");

        stringBuilder.append("Total Operational Memory:").append(" ").append(this.getUsedMemory()).append(" / ").append(this.getTotalMemory()).append("\n");

        stringBuilder.append("Total Capacity Taken:").append(" ").append(this.getUsedCapacity()).append(" / ").append(this.getTotalCapacity());

        return stringBuilder.toString();
    }

    public void addSoftwareOnHardware(String hardwareName, Software software) {

        Hardware hardware = this.hardwareComponents.get(hardwareName);

        if (hardware == null) {
            return;
        }

        hardware.addSoftware(software);
    }


    private int getUsedMemory() {
        int totalUsedMemory = 0;

        for (Hardware hardware : hardwareComponents.values()) {
            totalUsedMemory += hardware.getUsedMemory();
        }
        return totalUsedMemory;
    }

    private int getUsedCapacity() {
        int totalUsedCapacity = 0;

        for (Hardware hardware : hardwareComponents.values()) {
            totalUsedCapacity += hardware.getUsedCapacity();
        }
        return totalUsedCapacity;
    }

    private int getTotalMemory() {
        int totalMemory = 0;

        for (Hardware hardware : hardwareComponents.values()) {
            totalMemory += hardware.getMemory();
        }
        return totalMemory;
    }

    private int getTotalCapacity() {
        int totalCapacity = 0;
        for (Hardware hardware : hardwareComponents.values()) {
            totalCapacity += hardware.getCapacity();
        }

        return totalCapacity;
    }

    public void releaseSoftwareFrom(String hardwareComponentName, String softwareComponentName) {
        Hardware hardware = this.hardwareComponents.get(hardwareComponentName);

        if (hardware == null) {
            return;
        }

        hardware.releaseSoftwareByName(softwareComponentName);
    }

    private int getSoftwareCount() {

        int softwareCounter = 0;

        for (Hardware hardware : hardwareComponents.values()) {
            softwareCounter += hardware.getSoftwareCount();
        }
        return softwareCounter;
    }

    public String split() {
        StringBuilder stringBuilder = new StringBuilder();

        this.hardwareComponents.entrySet().stream().sorted((a, b) -> {
            String classA = a.getValue().getClass().getSimpleName();
            String classB = b.getValue().getClass().getSimpleName();

            return classB.compareTo(classA);
        }).forEach(entry -> {
            stringBuilder.append("Hardware Component").append(" - ").append(entry.getValue().getName()).append("\n");
            stringBuilder.append("Express Software Components").append(" - ").append(entry.getValue().getExpressSoftwareCount()).append("\n");
            stringBuilder.append("Light Software Components").append(" - ").append(entry.getValue().getLightSoftwareCount()).append("\n");
            stringBuilder.append("Memory Usage:").append(" ").append(entry.getValue().getUsedMemory()).append(" / ").append(entry.getValue().getMemory()).append("\n");
            stringBuilder.append("Capacity Usage:").append(" ").append(entry.getValue().getUsedCapacity()).append(" / ").append(entry.getValue().getCapacity()).append("\n");
            stringBuilder.append("Type:").append(" ").append(entry.getValue().getType()).append("\n");
            stringBuilder.append("Software Components: ").append(entry.getValue().getSoftwareComponents()).append("\n");
        });
        if (stringBuilder.length() == 0){
            return "";
        }
        stringBuilder.replace(stringBuilder.length() - 1, stringBuilder.length(), "");

        return stringBuilder.toString();
    }

    public void dumpHardwareByName(String name) {
        Hardware hardware = this.hardwareComponents.get(name);

        if (hardware == null) {
            return;
        }

        this.dump.add(hardware);
        this.removeHardware(hardware);
    }

    public void restoreHardwareByName(String name) {
        Hardware hardware = this.dump.restoreHardwareByName(name);

        if (hardware == null) {
            return;
        }

        this.addHardwareComponent(hardware);
    }


    public void destroyHardwareByName(String name) {
        this.dump.destroyHardwareByName(name);
    }

    public String dumpAnalyze() {
        return "Dump Analysis" + "\n" + this.dump.analysis();
    }

    private void removeHardware(Hardware hardware) {
        this.hardwareComponents.remove(hardware.getName());
    }
}

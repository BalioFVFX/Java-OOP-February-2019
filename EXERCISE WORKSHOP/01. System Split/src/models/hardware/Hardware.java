package models.hardware;

import models.software.ExpressSoftware;
import models.software.LightSoftware;
import models.software.Software;

import java.util.ArrayList;
import java.util.List;

public abstract class Hardware {
    private String name;
    private int capacity;
    private int memory;
    private int usedMemory;
    private int usedCapacity;
    private int expressSoftwareCount;
    private int lightSoftwareCount;
    private List<Software> softwareList;

    public Hardware(String name, int capacity, int memory) {
        this.setName(name);
        this.setCapacity(capacity);
        this.setMemory(memory);
        this.usedMemory = 0;
        this.usedCapacity = 0;
        this.softwareList = new ArrayList<>();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public void addSoftware(Software software) {
        if (this.usedMemory + software.getMemory() > this.memory) {
            return;
        }
        if (this.usedCapacity + software.getCapacity() > this.capacity) {
            return;
        }

        this.softwareList.add(software);
        this.updateResources(software, "Add");
        this.updateSoftwareCount(software, "Add");
    }

    public void releaseSoftwareByName(String softwareComponentName) {
        for (int i = 0; i < softwareList.size(); i++) {

            Software software = softwareList.get(i);

            if (software.getName().equals(softwareComponentName)) {
                softwareList.remove(i);
                this.updateResources(software, "Remove");
                this.updateSoftwareCount(software, "Remove");
                return;
            }
        }
    }

    public int getSoftwareCount() {
        return this.softwareList.size();
    }

    private void updateResources(Software software, String command) {
        if (command.equals("Add")) {
            this.usedMemory += software.getMemory();
            this.usedCapacity += software.getCapacity();
        } else {
            this.usedMemory -= software.getMemory();
            this.usedCapacity -= software.getCapacity();
        }

    }

    public int getUsedMemory() {
        return this.usedMemory;
    }

    public int getUsedCapacity() {
        return this.usedCapacity;
    }

    private void updateSoftwareCount(Software software, String command) {
        if (command.equals("Add")) {
            if (software instanceof ExpressSoftware) {
                this.expressSoftwareCount++;
            } else if (software instanceof LightSoftware) {
                this.lightSoftwareCount++;
            }
        } else {
            if (software instanceof ExpressSoftware) {
                this.expressSoftwareCount--;
            } else if (software instanceof LightSoftware) {
                this.lightSoftwareCount--;
            }
        }

    }

    public int getExpressSoftwareCount() {
        return this.expressSoftwareCount;
    }

    public int getLightSoftwareCount() {
        return this.lightSoftwareCount;
    }

    public String getSoftwareComponents() {
        StringBuilder stringBuilder = new StringBuilder();

        for (Software software : softwareList) {
            stringBuilder.append(software.getName()).append(", ");
        }

        if(stringBuilder.length() == 0){
            return "None";
        }

        stringBuilder = stringBuilder.replace(stringBuilder.length() - 2, stringBuilder.length(), "");

        return stringBuilder.toString();
    }

    public abstract String getType();
}

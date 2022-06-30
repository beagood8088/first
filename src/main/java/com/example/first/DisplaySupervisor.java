package com.example.first;

import com.example.first.consumingrest.Manager;

public class DisplaySupervisor {
    private String supervisor;
    private String identificationNumber;

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public static DisplaySupervisor from (Manager manager) {
        DisplaySupervisor displaySupervisor = new DisplaySupervisor();
        displaySupervisor.supervisor = manager.getJurisdiction() + " - " + manager.getLastName() + ", " + manager.getLastName();
        displaySupervisor.identificationNumber = manager.getIdentificationNumber();
        return displaySupervisor;
    }
}

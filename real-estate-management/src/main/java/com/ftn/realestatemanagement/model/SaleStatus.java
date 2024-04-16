package com.ftn.realestatemanagement.model;

import java.util.Arrays;

public enum SaleStatus {
    SALE("Sale"), RENTAL("Rental");

    private final String displayName;

    SaleStatus(String displayName){
        this.displayName = displayName;
    }
    public String getDisplayName(){
        return displayName;
    }
    public static SaleStatus fromDisplayName(String displayName) {
        return Arrays.stream(SaleStatus.values())
                .filter(enumValue -> enumValue.getDisplayName().equals(displayName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Nema enum vrednosti za displayName: " + displayName));

    }
}

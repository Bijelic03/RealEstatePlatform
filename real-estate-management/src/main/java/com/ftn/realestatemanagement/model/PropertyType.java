package com.ftn.realestatemanagement.model;
import java.awt.*;
import java.util.Arrays;

public enum PropertyType {
    HOUSE("House"), FLAT("Flat"), OFFICE("Office"), COTTAGE("Cottage");

    private final String displayName;

    PropertyType(String displayName){
        this.displayName = displayName;
    }
    public String getDisplayName(){
        return displayName;
    }

    public static PropertyType fromDisplayName(String displayName) {
        return Arrays.stream(PropertyType.values())
                .filter(enumValue -> enumValue.getDisplayName().equals(displayName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Nema enum vrednosti za displayName: " + displayName));

}
}

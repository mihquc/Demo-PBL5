package com.example.demo1.model;

import java.io.Serializable;
import java.util.List;

public class Plant implements Serializable {
    String id;

    String Name;
    String description;
    String type;

    int wateringFrequency;
    int fertilizingFrequency;
    int sprayingFrequency;

    String image;

    boolean isVerified;
    List<Advice> advicesList;

    public Plant() {
    }

    public boolean isVerified() {
        return isVerified;
    }

    public List<Advice> getAdvicesList() {
        return advicesList;
    }

    public void setAdvicesList(List<Advice> advicesList) {
        this.advicesList = advicesList;
    }

    public Plant(String name,
                 String description,
                 String type,
                 int wateringFrequency,
                 int fertilizingFrequency,
                 int sprayingFrequency,
                 String photoUri,
                 boolean isVerified,
                 List<Advice> advices) {
        this.Name = name;
        this.type = type;
        this.description = description;
        this.wateringFrequency = wateringFrequency;
        this.fertilizingFrequency = fertilizingFrequency;
        this.sprayingFrequency = sprayingFrequency;
        this.image = photoUri;
        this.isVerified = isVerified;
        this.advicesList = advices;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getWateringFrequency() {
        return wateringFrequency;
    }

    public void setWateringFrequency(int wateringFrequency) {
        this.wateringFrequency = wateringFrequency;
    }

    public int getFertilizingFrequency() {
        return fertilizingFrequency;
    }

    public void setFertilizingFrequency(int fertilizingFrequency) {
        this.fertilizingFrequency = fertilizingFrequency;
    }

    public int getSprayingFrequency() {
        return sprayingFrequency;
    }

    public void setSprayingFrequency(int sprayingFrequency) {
        this.sprayingFrequency = sprayingFrequency;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setVerified(boolean verified) {
        isVerified = verified;
    }
}

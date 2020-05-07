package com.wipro.model;

import java.util.Arrays;

public class JSONData {
    long id;
    String findDuplicates;
    String whiteSpacesGalore;
    String validateMeOnlyIActuallyShouldBeABoolean;
    int[] numbersMeetNumbers;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFindDuplicates() {
        return findDuplicates;
    }

    public void setFindDuplicates(String findDuplicates) {
        this.findDuplicates = findDuplicates;
    }

    public String getWhiteSpacesGalore() {
        return whiteSpacesGalore;
    }

    public void setWhiteSpacesGalore(String whiteSpacesGalore) {
        this.whiteSpacesGalore = whiteSpacesGalore;
    }

    public String getValidateMeOnlyIActuallyShouldBeABoolean() {
        return validateMeOnlyIActuallyShouldBeABoolean;
    }

    public void setValidateMeOnlyIActuallyShouldBeABoolean(String validateMeOnlyIActuallyShouldBeABoolean) {
        this.validateMeOnlyIActuallyShouldBeABoolean = validateMeOnlyIActuallyShouldBeABoolean;
    }

    public int[] getNumbersMeetNumbers() {
        return numbersMeetNumbers;
    }

    public void setNumbersMeetNumbers(int[] numbersMeetNumbers) {
        this.numbersMeetNumbers = numbersMeetNumbers;
    }

    @Override
    public String toString() {
        return "JSONData{" +
                "id=" + id +
                ", findDuplicates='" + findDuplicates + '\'' +
                ", whiteSpacesGalore='" + whiteSpacesGalore + '\'' +
                ", validateMeOnlyIActuallyShouldBeABoolean='" + validateMeOnlyIActuallyShouldBeABoolean + '\'' +
                ", numbersMeetNumbers=" + Arrays.toString(numbersMeetNumbers) +
                '}';
    }
}

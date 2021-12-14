package com.training.keyskillback.pojo;

public class DifficultyLevelRequest {
    private Long idLevel;
    private int length;
    private int keyZone;
    private int maxTimeKick;
    private int maxErrors;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getKeyZone() {
        return keyZone;
    }

    public void setKeyZone(int keyZone) {
        this.keyZone = keyZone;
    }

    public int getMaxTimeKick() {
        return maxTimeKick;
    }

    public void setMaxTimeKick(int maxTimeKick) {
        this.maxTimeKick = maxTimeKick;
    }

    public int getMaxErrors() {
        return maxErrors;
    }

    public void setMaxErrors(int maxErrors) {
        this.maxErrors = maxErrors;
    }

    public Long getIdLevel() {
        return idLevel;
    }

    public void setIdLevel(Long idLevel) {
        this.idLevel = idLevel;
    }
}

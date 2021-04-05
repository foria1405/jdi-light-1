package io.github.com.entities;

public enum ProgressBarModes {
    DETERMINATE("determinate"),
    INDETERMINATE("indeterminate"),
    BUFFER("buffer"),
    QUERY("query");

    private String mode;

    ProgressBarModes(String mode) {
        this.mode = mode;
    }

    public String getMode() {
        return this.mode;
    }
}

package com.example.no_1n;

public enum PlayState {

    PLAY("재생 중"), STOP("멈춤");

    private String state;

    PlayState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public boolean isStopping() {
        return this == STOP;
    }

    public boolean isPlaying() {
        return this == PLAY;
    }
}

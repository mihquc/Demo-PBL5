package com.example.demo1.core.check;

public class CheckInteractor implements CheckContract.Interactor {
    CheckContract.Listener checkListener;

    public CheckInteractor(CheckContract.Listener checkListener) {
        this.checkListener = checkListener;
    }
}
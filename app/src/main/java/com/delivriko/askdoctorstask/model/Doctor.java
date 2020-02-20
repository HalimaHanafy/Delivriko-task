package com.delivriko.askdoctorstask.model;


public class Doctor {

    private String mTextResource;
    private String mTitleResource;

    public Doctor(String title, String text) {
        mTitleResource = title;
        mTextResource = text;
    }

    public String getText() {
        return mTextResource;
    }

    public String getTitle() {
        return mTitleResource;
    }
}

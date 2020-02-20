package com.delivriko.askdoctorstask.viewmodel;

import com.delivriko.askdoctorstask.model.Insurance;


public class InsuranceModel {

    private String title;
    private String desc;

    public InsuranceModel(Insurance news) {
        this.title = news.title;
        this.desc = news.desc;
    }
}

package com.example.designapp_final;

public class Model {


    String mCycleName;
    String mCycleDetail;
    int mCyclePhoto;

    public Model(String mCycleName, String mCycleDetail, int mCyclePhoto) {
        this.mCycleName = mCycleName;
        this.mCycleDetail = mCycleDetail;
        this.mCyclePhoto = mCyclePhoto;
    }



    public String getmCycleName() {
        return mCycleName;
    }

    public String getmCycleDetail() {
        return mCycleDetail;
    }

    public int getmCyclePhoto() {
        return mCyclePhoto;
    }
}

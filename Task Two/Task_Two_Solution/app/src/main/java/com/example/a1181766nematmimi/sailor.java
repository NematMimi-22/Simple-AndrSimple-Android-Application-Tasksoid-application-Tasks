package com.example.a1181766nematmimi;

import java.util.ArrayList;

public class sailor {
    public static ArrayList<sailor> customersArrayList=new ArrayList<sailor>();
    private int mSailorId ;
    private long mBoatId ;
    private String mName;
    private String mNationality;
public  sailor(){

}
    public sailor(int mSailorId, int mBoatId, String mName, String mNationality) {
        this.mSailorId = mSailorId;
        this.mBoatId = mBoatId;
        this.mName = mName;
        this.mNationality = mNationality;
    }

    public long getmBoatId() {
        return mBoatId;
    }

    public void setmBoatId(long mBoatId) {
        this.mBoatId = mBoatId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmNationality() {
        return mNationality;
    }

    public void setmNationality(String mNationality) {
        this.mNationality = mNationality;
    }

    @Override
    public String toString() {
        return "sailor{" +
                "mSailorId=" + mSailorId +
                ", mBoatId=" + mBoatId +
                ", mName='" + mName + '\'' +
                ", mNationality='" + mNationality + '\'' +
                '}';
    }
}


package com.example.mountainapp;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class MountainPeak implements Parcelable, Serializable {


        private static int id;
        private String mountainPeak;
        private int height;
        private int verticalGain;
        private float distance;
        private int idList = 0;
        private int  numOfTrips =0;


        public MountainPeak(String mountainPeak, int height, int verticalGain, float distance) {
            this.id++;
            this.mountainPeak = mountainPeak;
            this.height = height;
            this.verticalGain = verticalGain;
            this.distance = distance;
            idList = id;
            numOfTrips = id;
        }

    protected MountainPeak(Parcel in) {
        mountainPeak = in.readString();
        height = in.readInt();
        verticalGain = in.readInt();
        distance = in.readFloat();
        idList = in.readInt();
    }

    public static final Creator<MountainPeak> CREATOR = new Creator<MountainPeak>() {
        @Override
        public MountainPeak createFromParcel(Parcel in) {
            return new MountainPeak(in);
        }

        @Override
        public MountainPeak[] newArray(int size) {
            return new MountainPeak[size];
        }
    };

         public int getId() {
            return id;
        }

    public int getIdList() {
        return idList;
    }

    public String getMountainPeak() {
            return mountainPeak;
        }



        public int getHeight() {
            return height;
        }



        public int getVerticalGain() {
            return verticalGain;
        }


        public float getDistance() {
            return distance;
        }

    public int getNumOfTrips() {
        return numOfTrips;
    }


    @Override
        public String toString() {
            return "MOUNTAIN PEAK " +
                    "id=" + id +
                    ", mountainPeak='" + mountainPeak + '\'' +
                    ", height=" + height +
                    ", verticalGain=" + verticalGain +
                    ", distance=" + distance +
                    ']';
        }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(mountainPeak);
        dest.writeInt(height);
        dest.writeInt(verticalGain);
        dest.writeFloat(distance);
        dest.writeInt(idList);
    }
}

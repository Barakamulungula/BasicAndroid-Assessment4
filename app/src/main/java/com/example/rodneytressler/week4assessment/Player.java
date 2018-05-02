package com.example.rodneytressler.week4assessment;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by rodneytressler on 12/17/17.
 */

public class Player implements Parcelable{
    private String name;
    private int number;
    private String team;

    public Player(String name, int number, String team) {
        this.name = name;
        this.number = number;
        this.team = team;
    }

    protected Player(Parcel in) {
        name = in.readString();
        number = in.readInt();
        team = in.readString();
    }

    public static final Creator<Player> CREATOR = new Creator<Player>() {
        @Override
        public Player createFromParcel(Parcel in) {
            return new Player(in);
        }

        @Override
        public Player[] newArray(int size) {
            return new Player[size];
        }
    };

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public String getTeam() {
        return team;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeInt(number);
        parcel.writeString(team);
    }
}

package model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class usersave implements Parcelable {
    public static ArrayList<user> savelist = new ArrayList<>();
    protected usersave(Parcel in) {
    }

    public static final Creator<usersave> CREATOR = new Creator<usersave>() {
        @Override
        public usersave createFromParcel(Parcel in) {
            return new usersave(in);
        }

        @Override
        public usersave[] newArray(int size) {
            return new usersave[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }
}

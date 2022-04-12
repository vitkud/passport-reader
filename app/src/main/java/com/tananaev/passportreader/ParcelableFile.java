package com.tananaev.passportreader;

import android.os.Parcel;
import android.os.Parcelable;

public class ParcelableFile implements Parcelable {
    private final String name;
    private final byte[] data;

    public ParcelableFile(String name, byte[] data) {
        this.name = name;
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public byte[] getData() {
        return data;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(data.length);
        dest.writeByteArray(data);
    }

    private ParcelableFile(Parcel source) {
        name = source.readString();
        data = new byte[source.readInt()];
        source.readByteArray(data);
    }

    public static final Parcelable.Creator<ParcelableFile> CREATOR = new Creator<ParcelableFile>() {
        @Override
        public ParcelableFile createFromParcel(Parcel source) {
            return new ParcelableFile(source);
        }

        @Override
        public ParcelableFile[] newArray(int size) {
            return new ParcelableFile[size];
        }
    };
}

package com.academy.fundamentals.mymovieapp.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.DrawableRes;

public class MovieModel implements Parcelable {

    private String name;
    @DrawableRes
    private int imageRes;
    @DrawableRes
    private int bgImageRes;
    private String overview;
    private String date;
    private String trailerUrl;

    public MovieModel() {

    }

    protected MovieModel(Parcel in) {
        name = in.readString();
        imageRes = in.readInt();
        bgImageRes = in.readInt();
        overview = in.readString();
        date = in.readString();
        trailerUrl = in.readString();
    }

    public static final Creator<MovieModel> CREATOR = new Creator<MovieModel>() {
        @Override
        public MovieModel createFromParcel(Parcel in) {
            return new MovieModel(in);
        }

        @Override
        public MovieModel[] newArray(int size) {
            return new MovieModel[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public int getImageRes() {
        return imageRes;
    }

    public void setImageRes(@DrawableRes int imageRes) {
        this.imageRes = imageRes;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getBgImageRes() {
        return bgImageRes;
    }

    public void setBgImageRes(int bgImageRes) {
        this.bgImageRes = bgImageRes;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeInt(this.imageRes);
        dest.writeString(this.overview);
        dest.writeString(this.date);
        dest.writeInt(this.bgImageRes);
        dest.writeString(this.trailerUrl);
    }

    @Override
    public String toString() {
       return "" +
               "MovieModel{ name = " + name + "imageRes = " + imageRes + "overview = " + overview + "date = " + date;

    }


    public String getTrailerUrl() {
        return trailerUrl;
    }

    public void setTrailerUrl(String trailerUrl) {
        this.trailerUrl = trailerUrl;
    }
}

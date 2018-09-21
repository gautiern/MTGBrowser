package com.example.garbu.mtgbrowser.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by garbu on 9/3/2018.
 */
@Entity(tableName = "sets",
            indices = {@Index(value = "code",unique = true)})
public class Set implements Parcelable
{
    @PrimaryKey
    @SerializedName("code")
    @Expose
    @NonNull
    private String code;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("border")
    @Expose
    private String border;
    @SerializedName("mkm_id")
    @Expose
    private Integer mkmId;
    @SerializedName("mkm_name")
    @Expose
    private String mkmName;
    @SerializedName("releaseDate")
    @Expose
    private String releaseDate;
    @SerializedName("gathererCode")
    @Expose
    private String gathererCode;
    @SerializedName("magicCardsInfoCode")
    @Expose
    private String magicCardsInfoCode;
    public final static Creator<Set> CREATOR = new Creator<Set>() {

        public Set createFromParcel(Parcel in) {
            return new Set(in);
        }

        public Set[] newArray(int size) {
            return (new Set[size]);
        }

    }
            ;

    private Set(Parcel in) {
        this.code = ((String) in.readValue((String.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.type = ((String) in.readValue((String.class.getClassLoader())));
        this.border = ((String) in.readValue((String.class.getClassLoader())));
        this.mkmId = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.mkmName = ((String) in.readValue((String.class.getClassLoader())));
        this.releaseDate = ((String) in.readValue((String.class.getClassLoader())));
        this.gathererCode = ((String) in.readValue((String.class.getClassLoader())));
        this.magicCardsInfoCode = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Set() {
        //empty constructor
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBorder() {
        return border;
    }

    public void setBorder(String border) {
        this.border = border;
    }

    public Integer getMkmId() {
        return mkmId;
    }

    public void setMkmId(Integer mkmId) {
        this.mkmId = mkmId;
    }


    public String getMkmName() {
        return mkmName;
    }

    public void setMkmName(String mkmName) {
        this.mkmName = mkmName;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getGathererCode() {
        return gathererCode;
    }

    public void setGathererCode(String gathererCode) {
        this.gathererCode = gathererCode;
    }

    public String getMagicCardsInfoCode() {
        return magicCardsInfoCode;
    }

    public void setMagicCardsInfoCode(String magicCardsInfoCode) {
        this.magicCardsInfoCode = magicCardsInfoCode;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(code);
        dest.writeValue(name);
        dest.writeValue(type);
        dest.writeValue(border);
        dest.writeValue(mkmId);
        dest.writeValue(mkmName);
        dest.writeValue(releaseDate);
        dest.writeValue(gathererCode);
        dest.writeValue(magicCardsInfoCode);
    }

    public int describeContents() {
        return 0;
    }

}

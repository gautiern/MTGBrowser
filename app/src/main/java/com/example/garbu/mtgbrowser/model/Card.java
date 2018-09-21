package com.example.garbu.mtgbrowser.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by garbu on 9/3/2018.
 */
@Entity(tableName = "cards",
foreignKeys = @ForeignKey(entity = Set.class,
        parentColumns = "code",
        childColumns = "setCode",
        onDelete = ForeignKey.CASCADE))
public class Card implements Parcelable
{

    @SerializedName("name")
    @Expose
    private String cardName;
    @SerializedName("manaCost")
    @Expose
    private String manaCost;
    @SerializedName("cmc")
    @Expose
    private Integer cmc;
    @SerializedName("colors")
    @Expose
    @Ignore
    private List<String> colors = null;
    @SerializedName("colorIdentity")
    @Expose
    @Ignore
    private List<String> colorIdentity = null;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("types")
    @Expose
    @Ignore
    private List<String> types = null;
    @SerializedName("subtypes")
    @Expose
    @Ignore
    private List<String> subtypes = null;
    @SerializedName("rarity")
    @Expose
    private String rarity;
    @SerializedName("setCode")
    @Expose
    private String setCode;
    @SerializedName("setName")
    @Expose
    private String setName;
    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("artist")
    @Expose
    private String artist;
    @SerializedName("number")
    @Expose
    private String number;
    @SerializedName("power")
    @Expose
    private String power;
    @SerializedName("toughness")
    @Expose
    private String toughness;
    @SerializedName("layout")
    @Expose
    private String layout;
    @SerializedName("multiverseid")
    @Expose
    private Integer multiverseid;
    @SerializedName("imageUrl")
    @Expose
    private String imageUrl;
    @SerializedName("printings")
    @Expose
    @Ignore
    private List<String> printings = null;
    @SerializedName("originalText")
    @Expose
    private String originalText;
    @SerializedName("originalType")
    @Expose
    private String originalType;
    @PrimaryKey
    @SerializedName("id")
    @Expose
    @NonNull
    private String id;
    @SerializedName("supertypes")
    @Expose
    @Ignore
    private List<String> supertypes = null;
    @SerializedName("loyalty")
    @Expose
    private Integer loyalty;
    @SerializedName("source")
    @Expose
    private String source;
    @SerializedName("flavor")
    @Expose
    private String flavor;
    @SerializedName("releaseDate")
    @Expose
    private String releaseDate;
    public final static Creator<Card> CREATOR = new Creator<Card>() {

        public Card createFromParcel(Parcel in) {
            return new Card(in);
        }

        public Card[] newArray(int size) {
            return (new Card[size]);
        }

    };

    private Card(Parcel in) {
        this.cardName = ((String) in.readValue((String.class.getClassLoader())));
        this.manaCost = ((String) in.readValue((String.class.getClassLoader())));
        this.cmc = ((Integer) in.readValue((Integer.class.getClassLoader())));
        in.readList(this.colors, (String.class.getClassLoader()));
        in.readList(this.colorIdentity, (String.class.getClassLoader()));
        this.type = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.types, (String.class.getClassLoader()));
        in.readList(this.subtypes, (String.class.getClassLoader()));
        this.rarity = ((String) in.readValue((String.class.getClassLoader())));
        this.setCode = ((String) in.readValue((String.class.getClassLoader())));
        this.setName = ((String) in.readValue((String.class.getClassLoader())));
        this.text = ((String) in.readValue((String.class.getClassLoader())));
        this.artist = ((String) in.readValue((String.class.getClassLoader())));
        this.number = ((String) in.readValue((String.class.getClassLoader())));
        this.power = ((String) in.readValue((String.class.getClassLoader())));
        this.toughness = ((String) in.readValue((String.class.getClassLoader())));
        this.layout = ((String) in.readValue((String.class.getClassLoader())));
        this.multiverseid = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.imageUrl = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.printings, (String.class.getClassLoader()));
        this.originalText = ((String) in.readValue((String.class.getClassLoader())));
        this.originalType = ((String) in.readValue((String.class.getClassLoader())));
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.supertypes, (String.class.getClassLoader()));
        this.loyalty = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.source = ((String) in.readValue((String.class.getClassLoader())));
        this.flavor = ((String) in.readValue((String.class.getClassLoader())));
        this.releaseDate = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Card() {
        //empty constructor
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String name) {
        this.cardName = name;
    }

    public String getManaCost() {
        return manaCost;
    }

    public void setManaCost(String manaCost) {
        this.manaCost = manaCost;
    }

    public Integer getCmc() {
        return cmc;
    }

    public void setCmc(Integer cmc) {
        this.cmc = cmc;
    }

    public List<String> getColors() {
        return colors;
    }

    public void setColors(List<String> colors) {
        this.colors = colors;
    }

    public List<String> getColorIdentity() {
        return colorIdentity;
    }

    public void setColorIdentity(List<String> colorIdentity) {
        this.colorIdentity = colorIdentity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    public List<String> getSubtypes() {
        return subtypes;
    }

    public void setSubtypes(List<String> subtypes) {
        this.subtypes = subtypes;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public String getSetCode() {
        return setCode;
    }

    public void setSetCode(String setCode) {
        this.setCode = setCode;
    }

    public String getSetName() {
        return setName;
    }

    public void setSetName(String setName) {
        this.setName = setName;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getToughness() {
        return toughness;
    }

    public void setToughness(String toughness) {
        this.toughness = toughness;
    }

    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }

    public Integer getMultiverseid() {
        return multiverseid;
    }

    public void setMultiverseid(Integer multiverseid) {
        this.multiverseid = multiverseid;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }


    public List<String> getPrintings() {
        return printings;
    }

    public void setPrintings(List<String> printings) {
        this.printings = printings;
    }

    public String getOriginalText() {
        return originalText;
    }

    public void setOriginalText(String originalText) {
        this.originalText = originalText;
    }

    public String getOriginalType() {
        return originalType;
    }

    public void setOriginalType(String originalType) {
        this.originalType = originalType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getSupertypes() {
        return supertypes;
    }

    public void setSupertypes(List<String> supertypes) {
        this.supertypes = supertypes;
    }

    public Integer getLoyalty() {
        return loyalty;
    }

    public void setLoyalty(Integer loyalty) {
        this.loyalty = loyalty;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(cardName);
        dest.writeValue(manaCost);
        dest.writeValue(cmc);
        dest.writeList(colors);
        dest.writeList(colorIdentity);
        dest.writeValue(type);
        dest.writeList(types);
        dest.writeList(subtypes);
        dest.writeValue(rarity);
        dest.writeValue(setCode);
        dest.writeValue(setName);
        dest.writeValue(text);
        dest.writeValue(artist);
        dest.writeValue(number);
        dest.writeValue(power);
        dest.writeValue(toughness);
        dest.writeValue(layout);
        dest.writeValue(multiverseid);
        dest.writeValue(imageUrl);
        dest.writeList(printings);
        dest.writeValue(originalText);
        dest.writeValue(originalType);
        dest.writeValue(id);
        dest.writeList(supertypes);
        dest.writeValue(loyalty);
        dest.writeValue(source);
        dest.writeValue(flavor);
        dest.writeValue(releaseDate);
    }

    public int describeContents() {
        return 0;
    }

}
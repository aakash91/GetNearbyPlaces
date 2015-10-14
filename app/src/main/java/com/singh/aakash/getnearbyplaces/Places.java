package com.singh.aakash.getnearbyplaces;

import java.io.Serializable;

/**
 * Created by aakash on 13-10-2015.
 */
public class Places implements Serializable {
    public static final long serialVersionUID=1L;
    private String name;
    private String icon ;
    private String vicinity;
    private String latitude;
    private String longitude;
    private String formatted_address;
    private String formatted_phone;
    private String website;
    private String rating;
    private String international_phone_number;
    private String url;

    public Places(String name,String icon, String vicinity, String latitude, String longitude, String formatted_address, String formatted_phone, String website, String rating, String international_phone_number, String url) {
        this.name=name;
        this.icon = icon;
        this.vicinity = vicinity;
        this.latitude = latitude;
        this.longitude = longitude;
        this.formatted_address = formatted_address;
        this.formatted_phone = formatted_phone;
        this.website = website;
        this.rating = rating;
        this.international_phone_number = international_phone_number;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getIcon() {
        return icon;
    }

    public String getVicinity() {
        return vicinity;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getFormatted_address() {
        return formatted_address;
    }

    public String getFormatted_phone() {
        return formatted_phone;
    }

    public String getWebsite() {
        return website;
    }

    public String getRating() {
        return rating;
    }

    public String getInternational_phone_number() {
        return international_phone_number;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "Places{" +
                "icon='" + icon + '\'' +
                ", vicinity='" + vicinity + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", formatted_address='" + formatted_address + '\'' +
                ", formatted_phone='" + formatted_phone + '\'' +
                ", website='" + website + '\'' +
                ", rating='" + rating + '\'' +
                ", international_phone_number='" + international_phone_number + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}

package com.wuujcik.prg14;


/**Place object represents the ArrayList element that describes the places
 * that can be visited in the neighbourhood of the office*/

public class Place {

    private String mTitle;
    private String mAddress;
    private int mIcon = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;
    private String mWebsite;


    //Create a new Place object
    //@param title is the name of the place described
    //@param description is the short description of the place described
    //@param icon is the ID of the drawable resource image that should be displayed
    //@param www is the website of the place
    public Place(String title, String address, int icon, String website){
        mTitle = title;
        mAddress = address;
        mIcon = icon;
        mWebsite = website;
    }

    //Create a new Place object
    //@param title is the name of the place described
    //@param description is the short description of the place described
    //@param icon is the ID of the drawable resource image that should be displayed
    public Place(String title, String address, int icon){
        mTitle = title;
        mAddress = address;
        mIcon = icon;
    }

    //Create a new Place object
    //@param title is the name of the place described
    //@param description is the short description of the place described
    public Place(String title, String address){
        mTitle = title;
        mAddress = address;
    }

    public String getmTitle() {
        return mTitle;
    }

    public String getmAddress() {
        return mAddress;
    }

    public int getmIcon() {
        return mIcon;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public void setmAddress(String mAddress) {
        this.mAddress = mAddress;
    }

    public void setmIcon(int mIcon) {
        this.mIcon = mIcon;
    }

    public boolean hasImage(){
        return mIcon != NO_IMAGE_PROVIDED;
    }


    public String getmWebsite() {
        return mWebsite;
    }

    public void setmWebsite(String mWebsite) {
        this.mWebsite = mWebsite;
    }
}

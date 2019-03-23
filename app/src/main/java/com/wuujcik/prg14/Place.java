package com.wuujcik.prg14;


/**Place object represents the ArrayList element that describes the places
 * that can be visited in the neighbourhood of the office*/

public class Place {

    private String mTitle;
    private String mDescription;
    private int mIcon = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;
    private String mWebsite;


    //Create a new Place object
    //@param title is the name of the place described
    //@param description is the short description of the place described
    //@param icon is the ID of the drawable resource image that should be displayed
    //@param www is the website of the place
    public Place(String title, String description, int icon, String website){
        mTitle = title;
        mDescription = description;
        mIcon = icon;
        mWebsite = website;
    }

    //Create a new Place object
    //@param title is the name of the place described
    //@param description is the short description of the place described
    //@param icon is the ID of the drawable resource image that should be displayed
    public Place(String title, String description, int icon){
        mTitle = title;
        mDescription = description;
        mIcon = icon;
    }

    //Create a new Place object
    //@param title is the name of the place described
    //@param description is the short description of the place described
    //@param www is the website of the place
    public Place(String title, String description, String website){
        mTitle = title;
        mDescription = description;
        mWebsite = website;
    }

    //Create a new Place object
    //@param title is the name of the place described
    //@param description is the short description of the place described
    public Place(String title, String description){
        mTitle = title;
        mDescription = description;
    }

    public String getmTitle() {
        return mTitle;
    }

    public String getmDescription() {
        return mDescription;
    }

    public int getmIcon() {
        return mIcon;
    }

    public String getmWebsite() {
        return mWebsite;
    }

    public boolean hasImage(){
        return mIcon != NO_IMAGE_PROVIDED;
    }





}

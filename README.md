# PRG14
App that helps Amazonians to navigate around PRG14.

This application helps to find the route to the office, restaurants and other useful services nearby and ideas how to spend evenings.
It also explains what businesses are handled in the entity and what they do (this part is still under construction)

If you would like to see the overview, here's the screen recording of the app:
https://youtu.be/4jlUpXxyFF8 

## Installation

For now the app is not yet released, so if you'd like to use it, please download the code and open in in Android Studio.

Please note that you will need to add your own key for maps API as this is not public.
To do so, please generate your own maps api key and create a string with a name "map_key_find" with a value of your key or else you can simply hardcode your key in the Manifest in meta-data (instead of _@string/map_key_find_):

 <!--<Maps Android Key-->
        <meta-data
            android:name="com.google.android.geo.API_KEY"
            android:value="@string/map_key_find"/>

<!--Maps-->

package com.example.weatherapp;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class weatherData {

    private String mTemperature, mIcon, mCity, mWeatherType;
    private int mCondition;

    public static weatherData fromJson(JSONObject jsonObject){
        try {
            weatherData weatherD = new weatherData();
            weatherD.mCity = jsonObject.getString("name");
            weatherD.mCondition = jsonObject.getJSONArray("weather").getJSONObject(0).getInt("id");
            weatherD.mWeatherType = jsonObject.getJSONArray("weather").getJSONObject(0).getString("main");
            weatherD.mIcon = updateWeatherIcon(weatherD.mCondition);
            double tempResult = jsonObject.getJSONObject("main").getDouble("temp")-273.15;
            int roundedValue = (int)Math.rint(tempResult);
            weatherD.mTemperature = Integer.toString(roundedValue);
            return weatherD;

        }
        catch (JSONException e){
                e.printStackTrace();
                return null;
        }

    }

    private static String updateWeatherIcon(int condition) {

        if (condition>=0 && condition<=300){
            return "thunderstorm";
        }

        else if (condition>=300 && condition<=500){
            return "lightrain";
        }

        else if (condition>=5000 && condition<=600){
            return "shower";
        }

        else if (condition>=600 && condition<=700){
            return "snow2";
        }

        else if (condition>=701 && condition<=771){
            return "fog";
        }

        else if (condition>=772 && condition<=800){
            return "overcast";
        }

        else if (condition == 800){
            return "sunny";
        }

        else if (condition>=801 && condition<=804){
            return "cloud";
        }

        else if (condition>=900 && condition<=902){
            return "storm";
        }

         if (condition==903){
            return "snowman";
        }

        if (condition==904){
            return "sunny";
        }

        if (condition>=905 && condition<=1000){
            return "thunderstorm";
        }
        return "dunno";

    }

    public String getmTemperature() {
        return mTemperature+"°C";
    }

    public void setmTemperature(String mTemperature) {
        this.mTemperature = mTemperature;
    }

    public String getmIcon() {
        return mIcon;
    }

    public void setmIcon(String mIcon) {
        this.mIcon = mIcon;
    }

    public String getmCity() {
        return mCity;
    }

    public void setmCity(String mCity) {
        this.mCity = mCity;
    }

    public String getmWeatherType() {
        return mWeatherType;
    }

    public void setmWeatherType(String mWeatherType) {
        this.mWeatherType = mWeatherType;
    }

    public int getmCondition() {
        return mCondition;
    }

    public void setmCondition(int mCondition) {
        this.mCondition = mCondition;
    }
}

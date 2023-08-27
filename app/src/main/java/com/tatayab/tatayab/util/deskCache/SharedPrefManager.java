package com.tatayab.tatayab.util.deskCache;


import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.tatayab.presentation.base.GiftModel;

import static com.tatayab.tatayab.util.deskCache.DeskCacheConstants.GIFT_MODEL_HOLDER;

/**
 * Created by a.akl on 9/29/2016.
 */
public class SharedPrefManager {

    Context context;
    SharedPreferences.Editor editor;
    SharedPreferences prefs;

    public SharedPrefManager(Context context) {
        this.context = context;
        prefs = context.getSharedPreferences(DeskCacheConstants.SHARD_PREF_NAME, context.MODE_PRIVATE);
        editor = context.getSharedPreferences(DeskCacheConstants.SHARD_PREF_NAME, context.MODE_PRIVATE).edit();
    }

    public void addStringToSharedPrederances(String title, String value) {
        try {
            editor.putString(title, value);
            editor.commit();

        } catch (Exception e) {
            System.out.println("Error /addStringToSharedPrederances / : " + e.getMessage());
        }
    }

    public String getStringFromSharedPrederances(String title) {
        String value = "";
        try {
            value = prefs.getString(title, "");

        } catch (Exception e) {
            System.out.println("Error /getStringFromSharedPrederances / : " + e.getMessage());
        }
        return value;
    }

    public void addIntegerToSharedPrederances(String title, int value) {
        try {
            editor.putInt(title, value);
            editor.commit();

        } catch (Exception e) {
            System.out.println("Error /addIntegerToSharedPrederances / : " + e.getMessage());
        }
    }

    public int getIntegerFromSharedPrederances(String title) {
        int value = 0;
        try {
            value = prefs.getInt(title, -1);

        } catch (Exception e) {
            System.out.println("Error /getIntegerFromSharedPrederances / : " + e.getMessage());
        }
        return value;


    }

    public void addBooleanToSharedPrederances(String title, Boolean value) {
        try {
            editor.putBoolean(title, value);
            editor.commit();

        } catch (Exception e) {
            System.out.println("Error /addBooleanToSharedPrederances / : " + e.getMessage());
        }
    }

    public Boolean getBooleanFromSharedPrederances(String title) {
        Boolean value = false;
        try {
            value = prefs.getBoolean(title, false);

        } catch (Exception e) {
            System.out.println("Error /getBooleanFromSharedPrederances / : " + e.getMessage());
        }
        return value;
    }
    public Boolean getBooleanFromSharedPrederances(String title,Boolean defaultValue) {
        Boolean value = defaultValue;
        try {
            value = prefs.getBoolean(title, defaultValue);

        } catch (Exception e) {
            System.out.println("Error /getBooleanFromSharedPrederances / : " + e.getMessage());
        }
        return value;
    }

    public void clearShardPref() {
        try {
            editor.clear();
            editor.apply();

        } catch (Exception e) {
            System.out.println("Error /addBooleanToSharedPrederances / : " + e.getMessage());
        }
    }

    public void saveObject(Object myObject, String key) {
        try {
            Gson gson = new Gson();
            String json = gson.toJson(myObject);
            editor.putString(key, json);
            editor.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addGiftModel(GiftModel mGiftModel) {
        try {
            Gson gson = new Gson();
            String json = gson.toJson(mGiftModel);
            editor.putString(GIFT_MODEL_HOLDER, json);
            editor.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public GiftModel getGiftModel() {
        try {
            Gson gson = new Gson();
            String json = prefs.getString(GIFT_MODEL_HOLDER, "");
            GiftModel mGiftModel = gson.fromJson(json, GiftModel.class);
            return mGiftModel;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}


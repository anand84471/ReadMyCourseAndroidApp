package com.example.myapplication.utilities;

import android.content.Context;
import android.content.SharedPreferences;
import android.provider.SyncStateContract;

import com.example.myapplication.annotations.SharedPreferenceValueTypeAnnotation;
import com.example.myapplication.constants.ConfigConstants;

import java.util.Objects;

import static android.content.Context.MODE_PRIVATE;

public class SharedPreferenceService implements ISharedPreferenceUtils {

    @Override
    public void setSharedPreferenceValue(Context context,String sharePreferenceName, Object value, @SharedPreferenceValueTypeAnnotation.SharedPreferenceValueTypDef int sharedPreferenceValueTypeAnnotation ) {

    }
    @Override
    public Object getSharedPreferenceValue(Context context,String sharePreferenceName,@SharedPreferenceValueTypeAnnotation.SharedPreferenceValueTypDef int sharedPreferenceValueTypeAnnotation ) {
        Object result=null;
        SharedPreferences pref =  Objects.requireNonNull(context).getSharedPreferences(ConfigConstants.APPLICATION_SHARED_PREFERENCE_NAME,MODE_PRIVATE);
        switch (sharedPreferenceValueTypeAnnotation)
        {
            case SharedPreferenceValueTypeAnnotation.BOOLEAN:
            {
                result=pref.getBoolean(sharePreferenceName,false);
                break;
            }
            case SharedPreferenceValueTypeAnnotation.INTEGER:
            {
                result=pref.getInt(sharePreferenceName,-1);
                break;
            }
            case SharedPreferenceValueTypeAnnotation.STRING:
            {
                result=pref.getString(sharePreferenceName,null);
            }
        }
        return result;
    }
}

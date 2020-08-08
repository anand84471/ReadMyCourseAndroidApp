package com.readmycourse.android.utilities.Concrete;

import android.content.Context;
import android.content.SharedPreferences;


import com.readmycourse.android.annotations.SharedPreferenceValueTypeAnnotation;
import com.readmycourse.android.constants.ConfigConstants;
import com.readmycourse.android.utilities.Abstract.ISharedPreferenceUtils;

import java.util.Objects;

import static android.content.Context.MODE_PRIVATE;

public class SharedPreferenceService implements ISharedPreferenceUtils {
    private static volatile SharedPreferenceService sharedPreferenceService;
    private SharedPreferenceService() {
        //Prevent form the reflection api.
        if (sharedPreferenceService != null) {
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
        }
    }
    public static SharedPreferenceService getInstance() {
        //Double check locking pattern
        if (sharedPreferenceService == null) { //Check for the first time
            synchronized (SharedPreferenceService.class) {   //Check for the second time.
                //if there is no instance available... create new one
                if (sharedPreferenceService == null) sharedPreferenceService = new SharedPreferenceService();
            }
        }
        return sharedPreferenceService;
    }

    public  void setSharedPreferenceValue(Context context,String sharePreferenceName, Object value, @SharedPreferenceValueTypeAnnotation.SharedPreferenceValueTypDef int sharedPreferenceValueTypeAnnotation ) {
        SharedPreferences pref = context.getSharedPreferences(ConfigConstants.APPLICATION_SHARED_PREFERENCE_NAME,MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        switch (sharedPreferenceValueTypeAnnotation)
        {
            case SharedPreferenceValueTypeAnnotation.BOOLEAN:
            {
                editor.putBoolean(sharePreferenceName, (Boolean) value);
                break;
            }
            case SharedPreferenceValueTypeAnnotation.INTEGER:
            {
                editor.putInt(sharePreferenceName,(Integer) value);
                break;
            }
            case SharedPreferenceValueTypeAnnotation.STRING:
            {
                editor.putString(sharePreferenceName,(String) value);
            }
        }
        editor.apply();
    }
    public   Object getSharedPreferenceValue(Context context,String sharePreferenceName,@SharedPreferenceValueTypeAnnotation.SharedPreferenceValueTypDef int sharedPreferenceValueTypeAnnotation ) {
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

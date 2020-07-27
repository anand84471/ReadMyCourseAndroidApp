package com.example.myapplication.utilities;

import android.content.Context;

import com.example.myapplication.annotations.SharedPreferenceValueTypeAnnotation;

public interface ISharedPreferenceUtils {
    public void setSharedPreferenceValue(Context context, String sharePreferenceName, Object value,
                                         @SharedPreferenceValueTypeAnnotation.SharedPreferenceValueTypDef int sharedPreferenceValueTypeAnnotation);
    public Object getSharedPreferenceValue(Context context, String sharePreferenceName, @SharedPreferenceValueTypeAnnotation.SharedPreferenceValueTypDef int sharedPreferenceValueTypeAnnotation);
}

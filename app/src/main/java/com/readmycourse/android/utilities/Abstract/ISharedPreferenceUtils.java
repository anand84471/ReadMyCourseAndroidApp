package com.readmycourse.android.utilities.Abstract;

import android.content.Context;


import com.readmycourse.android.annotations.SharedPreferenceValueTypeAnnotation;

public interface ISharedPreferenceUtils {
     void setSharedPreferenceValue(Context context, String sharePreferenceName, Object value,
                                         @SharedPreferenceValueTypeAnnotation.SharedPreferenceValueTypDef int sharedPreferenceValueTypeAnnotation);
    public Object getSharedPreferenceValue(Context context, String sharePreferenceName, @SharedPreferenceValueTypeAnnotation.SharedPreferenceValueTypDef int sharedPreferenceValueTypeAnnotation);
}

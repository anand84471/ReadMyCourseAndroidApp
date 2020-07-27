package com.example.myapplication.annotations;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class SharedPreferenceValueTypeAnnotation {
    public SharedPreferenceValueTypeAnnotation(@SharedPreferenceValueTypDef int sharedPreferenceValueTypDef)
    {
        this.sharedPreferenceValueTypDef=sharedPreferenceValueTypDef;
    }
    // Enumerate valid values for this interface
    @IntDef({BOOLEAN, STRING, INTEGER})
    // Describes when the annotation will be discarded
    @Retention(RetentionPolicy.SOURCE)
    // Create an interface for validating int types
    public @interface  SharedPreferenceValueTypDef{}
    // Declare the constants
    public static final int BOOLEAN=1;
    public static final int STRING=2;
    public static final int INTEGER=3;
    @SharedPreferenceValueTypDef
    int sharedPreferenceValueTypDef;
}

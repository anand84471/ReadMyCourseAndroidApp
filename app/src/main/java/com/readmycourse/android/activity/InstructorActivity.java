package com.readmycourse.android.activity;

import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.readmycourse.android.R;
import com.google.android.material.navigation.NavigationView;
import com.readmycourse.android.services.Concrete.ApplicationPermission;

public class InstructorActivity extends ApplicationPermission {

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructor);
        getAllPermissions();
        DrawerLayout drawer = findViewById(R.id.drawer_layout_instructor);
        NavigationView navigationView = findViewById(R.id.nav_view_instructor);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_instructor_home, R.id.nav_instructor_start_teaching,
                R.id.nav_instructor_profile,R.id.nav_instructor_activity,R.id.nav_instructor_contact)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.instructor_nav_host_fragment);
        //NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

    }


    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.instructor_nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}

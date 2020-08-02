package com.example.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.Menu;

import com.example.myapplication.R;
import com.example.myapplication.services.Concrete.ApplicationPermission;
import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

public class StudnetActivity extends ApplicationPermission {

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studnet);
        getAllPermissions();
        DrawerLayout drawer = findViewById(R.id.student_drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view_student);
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_student_home, R.id.nav_student_start_learning, R.id.nav_student_profile,
                R.id.nav_student_activity,R.id.nav_student_contact)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.student_nav_host_fragment);
        NavigationUI.setupWithNavController(navigationView, navController);
    }
    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.student_nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}

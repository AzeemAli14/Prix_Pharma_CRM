package com.prixpharma.crm.Activities;

//import android.support.v4.app.Fragment;
//import 	android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
//import android.support.annotation.NonNull;
//import android.support.design.widget.BottomNavigationView;
//import android.support.design.widget.NavigationView;
//import android.support.v4.view.GravityCompat;
//import android.support.v4.widget.DrawerLayout;
//import android.support.v7.app.ActionBarDrawerToggle;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.prixpharma.crm.Fragments.AgendaFragment;
import com.prixpharma.crm.Fragments.ContactsFragment;
import com.prixpharma.crm.Fragments.GalleryFragment;
import com.prixpharma.crm.Fragments.HomeFragment;
import com.prixpharma.crm.Fragments.LocationFragment;
import com.prixpharma.crm.Fragments.ProfileFragment;
import com.prixpharma.crm.Fragments.SettingsFragment;
import com.prixpharma.crm.Fragments.StatisticsFragment;
import com.prixpharma.crm.Fragments.NotificationFragment;
import com.prixpharma.crm.R;

public class StartActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private BottomNavigationView MainNav;
    private FrameLayout MainFrame;
    private HomeFragment homeFragment;
    private NotificationFragment notificationFragment;
    private ProfileFragment profileFragment;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        MainNav=(BottomNavigationView) findViewById(R.id.main_nav);
        MainFrame=(FrameLayout) findViewById(R.id.main_frame);
        MainNav.setOnNavigationItemSelectedListener(navlistner);
        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, new HomeFragment()).commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navlistner=
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment fragmentSelected = null;
                    switch (item.getItemId()){
                        case R.id.nav_home:
                            toolbar.setTitle("Home");
                            fragmentSelected = new HomeFragment();
                            break;
                        case R.id.nav_notify:
                            toolbar.setTitle("Notification");
                            fragmentSelected = new NotificationFragment();
                            break;
                        case R.id.nav_profile:
                            toolbar.setTitle("Profile");
                            fragmentSelected = new ProfileFragment();
                            break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, fragmentSelected).commit();
                    return true;
            }
    };

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void displaySelectedScreen(int id){
        Fragment fragment = null;
        switch (id)
        {
            case R.id.nav_contacts:
                fragment = new ContactsFragment();
                break;
            case R.id.nav_gallery:
                fragment = new GalleryFragment();
                break;
            case R.id.nav_location:
                fragment = new LocationFragment();
                break;
            case R.id.nav_agenda:
                fragment = new AgendaFragment();
                break;
            case R.id.nav_statistic:
                fragment = new StatisticsFragment();
                break;
            case R.id.nav_settings:
                fragment = new SettingsFragment();
                break;
        }
        if (fragment != null)
        {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.main_frag, fragment);
            ft.commit();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        displaySelectedScreen(id);
        return true;
    }
}

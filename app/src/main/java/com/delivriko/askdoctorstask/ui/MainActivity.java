package com.delivriko.askdoctorstask.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.bvapp.arcmenulibrary.ArcMenu;
import com.bvapp.arcmenulibrary.widget.FloatingActionButton;
import com.delivriko.askdoctorstask.R;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ArcMenu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        menu = findViewById(R.id.arcMenu);
        initBottomMenu();
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_insurance, R.id.nav_doctors)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }


    private void initBottomMenu() {
        final int[] itemDrawables = {R.drawable.ic_menu_gallery, R.drawable.ic_menu_send, R.drawable.ic_menu_camera,
                R.drawable.ic_menu_manage};
        final String[] str = {"one", "two", "three", "four"};
        menu.showTooltip(false);
        menu.setToolTipBackColor(Color.WHITE);
        menu.setToolTipCorner(6f);
        menu.setToolTipPadding(2f);
        menu.isClose();
        menu.setToolTipTextColor(Color.BLUE);
        menu.setAnim(300, 300, ArcMenu.ANIM_MIDDLE_TO_RIGHT, ArcMenu.ANIM_MIDDLE_TO_RIGHT,
                ArcMenu.ANIM_INTERPOLATOR_ACCELERATE_DECLERATE, ArcMenu.ANIM_INTERPOLATOR_ACCELERATE_DECLERATE);

        final int itemCount = itemDrawables.length;
        for (int i = 0; i < itemCount; i++) {
            FloatingActionButton item = new FloatingActionButton(this);  // Use internal FAB as child
            item.setSize(FloatingActionButton.SIZE_MINI); // set initial size for child, it will create fab first
            item.setIcon(itemDrawables[i]);
            switch (i) {
                case 0:
                case 3:
                    item.setBackgroundColor(getResources().getColor(R.color.colorPrimary)); // it will set fab child's color
                    break;
                default:
                    item.setBackgroundColor(getResources().getColor(R.color.green)); // it will set fab child's color
            }

            menu.setChildSize(item.getIntrinsicHeight()); // set absolout child size for menu

            menu.addItem(item, str[i], new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                }
            });
        }
    }

}

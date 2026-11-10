package com.example.projetopdm_ii;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class Quiz extends AppCompatActivity {
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private ActionBarDrawerToggle toggle;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_quiz);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        navigationView=findViewById(R.id.idnavigationquiz);
        toolbar = findViewById(R.id,toolbar3);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                if (menuItem.getItemId() == R.id.idhome){
                    drawerLayout.close();
                    startActivity(new Intent(Quiz.this, TelaHome.class));
                    return true;
                }
                if (menuItem.getItemId() == R.id.idTela02){
                    drawerLayout.close();
                    startActivity(new Intent(Quiz.this, Tela02.class));
                    return true;
                }
                if (menuItem.getItemId() == R.id.idtela03){
                    drawerLayout.close();
                    startActivity(new Intent(Quiz.this, Tela03.class));
                    return true;
                }
                if (menuItem.getItemId() == R.id.idquiz){
                    drawerLayout.close();
                    return true;
                }
                if (menuItem.getItemId() == R.id.idsobre){
                    drawerLayout.close();
                    startActivity(new Intent(Quiz.this, Quiz.class));

                    return true;
                }

                return false;
            }
        });
    }
}
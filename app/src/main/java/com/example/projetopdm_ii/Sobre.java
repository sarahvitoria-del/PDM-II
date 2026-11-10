package com.example.projetopdm_ii;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class Sobre extends AppCompatActivity {
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sobre);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.idlinearSobre), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        navigationView = findViewById(R.id.idnavigationsobre);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                if (menuItem.getItemId() == R.id.idhome){
                    drawerLayout.close();
                    startActivity(new Intent(Sobre.this, TelaHome.class));
                    return true;
                }
                if (menuItem.getItemId() == R.id.idTela02){
                    drawerLayout.close();
                    startActivity(new Intent(Sobre.this, Tela02.class));
                    return true;
                }
                if (menuItem.getItemId() == R.id.idtela03){
                    drawerLayout.close();
                    startActivity(new Intent(Sobre.this, Tela03.class));
                    return true;
                }
                if (menuItem.getItemId() == R.id.idquiz){
                    drawerLayout.close();
                    startActivity(new Intent(Sobre.this, Quiz.class));
                    return true;
                }
                if (menuItem.getItemId() == R.id.idsobre){
                    drawerLayout.close();
                    startActivity(new Intent(Sobre.this, Tela03.class));
                    return true;
                }

                return false;
            }
        });
    }
}
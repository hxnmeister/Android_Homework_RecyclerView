package com.ua.project.android_homework_recyclerview;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ua.project.android_homework_recyclerview.adapters.ClientAdapter;
import com.ua.project.android_homework_recyclerview.databinding.ActivityMainBinding;
import com.ua.project.android_homework_recyclerview.models.Client;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final List<Client> clients = Arrays.asList(
                Client.builder()
                        .id(1)
                        .firstName("Adam")
                        .lastName("Smasher")
                        .phoneNumber("0998877666")
                        .birthDate(new Date(Date.valueOf("2000-01-02").getTime()))
                        .build(),
                Client.builder()
                        .id(2)
                        .firstName("Nick")
                        .lastName("Smith")
                        .phoneNumber("0998117656")
                        .birthDate(new Date(Date.valueOf("2003-05-11").getTime()))
                        .build(),
                Client.builder()
                        .id(3)
                        .firstName("John")
                        .lastName("Johnson")
                        .phoneNumber("0991277633")
                        .birthDate(new Date(Date.valueOf("2001-07-30").getTime()))
                        .build(),
                Client.builder()
                        .id(4)
                        .firstName("Mick")
                        .lastName("Steiner")
                        .phoneNumber("0999833666")
                        .birthDate(new Date(Date.valueOf("2000-12-12").getTime()))
                        .build(),
                Client.builder()
                        .id(5)
                        .firstName("Josh")
                        .lastName("Kaiser")
                        .phoneNumber("0998877611")
                        .birthDate(new Date(Date.valueOf("2005-03-15").getTime()))
                        .build()
        );
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        ActionBar actionBar = getSupportActionBar();
        ClientAdapter clientAdapter = new ClientAdapter(clients, MainActivity.this);

        if(actionBar != null) {
            actionBar.setTitle("Clients DB");
        }

        binding.clientsRecycleView.setAdapter(clientAdapter);
        binding.clientsRecycleView.setLayoutManager(new LinearLayoutManager(MainActivity.this, RecyclerView.HORIZONTAL, false));
    }
}
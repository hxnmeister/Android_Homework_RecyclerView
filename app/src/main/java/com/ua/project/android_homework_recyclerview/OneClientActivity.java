package com.ua.project.android_homework_recyclerview;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.ua.project.android_homework_recyclerview.databinding.ActivityOneClientBinding;
import com.ua.project.android_homework_recyclerview.models.Client;

public class OneClientActivity extends AppCompatActivity {
    ActivityOneClientBinding binding;

    @RequiresApi(api = Build.VERSION_CODES.TIRAMISU)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityOneClientBinding.inflate(getLayoutInflater());

        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        Intent intent = getIntent();
        ActionBar actionBar = getSupportActionBar();
        Client client = (Client) intent.getSerializableExtra("client");

        if(actionBar != null) {
            actionBar.setTitle("Record for client with ID: " + (client != null ? client.getId() : null));
        }

        binding.firstNameEditText.setText(client != null ? client.getFirstName() : null);
        binding.lastNameEditText.setText(client != null ? client.getLastName() : null);
        binding.birthDateEditTextDate.setText(client != null ? client.getBirthDate().toString() : null);
        binding.phoneNumberTextPhone.setText(client != null ? client.getPhoneNumber() : null);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.one_client_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();

        if(itemId == R.id.backMenuItem) {
            Intent intent = new Intent(OneClientActivity.this, MainActivity.class);
            
            startActivity(intent);
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
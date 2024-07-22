package com.ua.project.android_homework_recyclerview.adapters;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ua.project.android_homework_recyclerview.OneClientActivity;
import com.ua.project.android_homework_recyclerview.R;
import com.ua.project.android_homework_recyclerview.models.Client;

import java.util.List;

public class ClientAdapter extends RecyclerView.Adapter<ClientAdapter.ClientViewHolder> {
    private final List<Client> clients;
    private final Activity activity;

    public ClientAdapter(List<Client> clients, Activity activity) {
        this.clients = clients;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ClientViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ClientViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.client_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ClientViewHolder holder, int position) {
        Client client = clients.get(position);

        holder.id = client.getId();
        holder.phoneNumberTextView.setText(client.getPhoneNumber());
        holder.birthDateTextView.setText(client.getBirthDate().toString());
        holder.fullNameTextView.setText(String.format("%s %s", client.getFirstName(), client.getLastName()));

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(activity, OneClientActivity.class);

            intent.putExtra("client", client);
            activity.startActivity(intent);
            activity.finish();
        });
    }

    @Override
    public int getItemCount() {
        return clients.size();
    }

    public static class ClientViewHolder extends RecyclerView.ViewHolder {
        Integer id;
        TextView fullNameTextView;
        TextView phoneNumberTextView;
        TextView birthDateTextView;

        public ClientViewHolder(@NonNull View itemView) {
            super(itemView);

            fullNameTextView = itemView.findViewById(R.id.fullNameTextView);
            phoneNumberTextView = itemView.findViewById(R.id.phoneNumberTextView);
            birthDateTextView = itemView.findViewById(R.id.birthDateTextView);
        }
    }
}

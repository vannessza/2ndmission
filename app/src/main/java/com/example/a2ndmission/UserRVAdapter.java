package com.example.a2ndmission;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import model.user;

public class UserRVAdapter extends RecyclerView.Adapter<UserRVAdapter.UserViewHolder> {
    private Context context;
    private ArrayList<user> ListUser;

    public UserRVAdapter(Context context, ArrayList<user> listUser) {
        this.context = context;
        ListUser = listUser;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.card_user, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserRVAdapter.UserViewHolder holder, int position) {
        holder.card_name.setText(ListUser.get(position).getName());
        holder.card_age.setText(String.valueOf(ListUser.get(position).getAge()));
        holder.card_address.setText(ListUser.get(position).getAddress());
    }

    @Override
    public int getItemCount() {
        return ListUser.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {
        private TextView card_name, card_age, card_address;
        ConstraintLayout constraint_layout;
        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            card_name = itemView.findViewById(R.id.card_name);
            card_age = itemView.findViewById(R.id.card_age);
            card_address = itemView.findViewById(R.id.card_address);
            constraint_layout = itemView.findViewById(R.id.constraint_layout);
            constraint_layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, DataUser.class);
                    intent.putExtra("datauser",ListUser.get(getAdapterPosition()));
                    intent.putExtra("pos",getAdapterPosition());
                    context.startActivity(intent);
                }
            });
        }
    }
}

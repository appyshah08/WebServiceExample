package com.example.dhaval.webserviceexample;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dhaval.webserviceexample.pojo.UserInfo;

import java.util.List;

/**
 * Created by dhaval on 10/2/17.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.UserViewHolder> {

    public static class UserViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        ImageView userProfilePicture;
        TextView username;
        TextView userDob;
        UserViewHolder(View view)
        {
            super(view);
            cardView=(CardView) view.findViewById(R.id.cardView);
            userProfilePicture=(ImageView) view.findViewById(R.id.userProfilePicture);
            username=(TextView) view.findViewById(R.id.username);
            userDob=(TextView) view.findViewById(R.id.userDob);
        }

    }

    List<UserInfo> userList;
    CustomAdapter(List<UserInfo> list)
    {
        this.userList=list;
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_custom,parent,false);
        UserViewHolder userViewHolder=new UserViewHolder(view);
        return userViewHolder;
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
       holder.userProfilePicture.setImageResource(userList.get(position).getUserProfilePicture());
        holder.username.setText(userList.get(position).getUserName());
        holder.userDob.setText(userList.get(position).getUserDob());

    }
}

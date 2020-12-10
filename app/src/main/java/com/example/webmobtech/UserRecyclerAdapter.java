package com.example.webmobtech;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.webmobtech.model.Data;
import com.example.webmobtech.model.Name;
import com.example.webmobtech.model.Result;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserRecyclerAdapter extends RecyclerView.Adapter<UserRecyclerAdapter.ViewHolder>  {

    List<Result> resultList;
    Context context;
    String encodeImgString;
    Bitmap bitmap;

    public UserRecyclerAdapter(Context context,List<Result> resultList) {
        this.resultList = resultList;
        this.context = context;
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtName,txtEmail,txtDob,txtPhone,txtUsername;
        CardView cardView;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtName=itemView.findViewById(R.id.txt_name);
            txtEmail=itemView.findViewById(R.id.txt_email);
            txtDob=itemView.findViewById(R.id.txt_dob);
            txtPhone=itemView.findViewById(R.id.txt_phone);
            txtUsername=itemView.findViewById(R.id.txt_user_name);
            cardView = itemView.findViewById(R.id.card_view);
            imageView = itemView.findViewById(R.id.img);
        }
    }

    @NonNull
    @Override
    public UserRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.layout_webmobtech, parent, false);

        UserRecyclerAdapter.ViewHolder viewHolder=new UserRecyclerAdapter.ViewHolder(view);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Name name = resultList.get(position).getName();
        holder.txtName.setText(name.getFirst() + " " + name.getLast() + "");
        holder.txtUsername.setText(resultList.get(position).getLogin().getUsername()+" ");
        holder.txtDob.setText(resultList.get(position).getDob().getDate().toString().substring(0,9));
        holder.txtEmail.setText(resultList.get(position).getEmail()+" ");
        holder.txtPhone.setText(""+resultList.get(position).getPhone()+" ");
        Glide.with(context)
                .load(resultList.get(position).getPicture().getLarge())
                .into(holder.imageView);

//        String dtStart = resultList.get(position).getDob().getDate();
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
//        try {
//            Date date = format.parse(dtStart);
//
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }

//        URL url = null;
//        try {
//            url = new URL(resultList.get(position).getPicture().getThumbnail());
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
//        Bitmap bmp = null;
//        try {
//            bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        holder.imageView.setImageBitmap(bmp);
//



    }





    @Override
    public int getItemCount() {
        return resultList.size();
    }

}



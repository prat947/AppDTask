package com.example.pratyush_200108037;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pratyush_200108037.details.Users;
//import com.google.firebase.database.core.Context;
import android.content.Context;

import java.util.ArrayList;

public class myAdapter extends RecyclerView.Adapter<myAdapter.MyViewHolder> {

    Context context;

    ArrayList<Users> list;

    public myAdapter(Context context, ArrayList<Users> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new MyViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull  myAdapter.MyViewHolder holder, int position) {

        Users user=list.get(position);
        holder.name.setText(user.getName());
        holder.college.setText(user.getCollege());
        holder.course.setText(user.getCourse());
        holder.year.setText(user.getYear());
        holder.roll.setText(user.getRoll());
        holder.email.setText(user.getEmailid());
        holder.phone.setText(user.getPhoneno());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public  static  class MyViewHolder extends  RecyclerView.ViewHolder{


        TextView name,college,course,year,roll,email,phone;


        public MyViewHolder(@NonNull  View itemView) {
            super(itemView);


            name= itemView.findViewById(R.id.tvName);
            college= itemView.findViewById(R.id.tvcollegeName);
            course= itemView.findViewById(R.id.tvcourse);
            year= itemView.findViewById(R.id.tvcurryear);
            roll= itemView.findViewById(R.id.tvroll);
            email= itemView.findViewById(R.id.tvemail);
            phone= itemView.findViewById(R.id.tvphone);


        }
    }
}

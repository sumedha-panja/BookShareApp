package com.firstapp.groupproject;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class myadapter extends RecyclerView.Adapter<myadapter.myviewholder> {

    ArrayList<BookDetails> datalist;

    public myadapter(ArrayList<BookDetails> datalist) {
        this.datalist = datalist;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
       View view =LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow,parent,false);
       return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myadapter.myviewholder holder, int position) {

        holder.t1.setText(datalist.get(position).getBook_name());
        holder.t2.setText(datalist.get(position).getBook_author());
        holder.t3.setText(datalist.get(position).getBook_genre());

        holder.fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(holder.fb.getContext(),details.class);
                intent.putExtra("uname",datalist.get(position).getBook_name());
                intent.putExtra("uauthor",datalist.get(position).getBook_author());
                intent.putExtra("upages",datalist.get(position).getBook_pages());
                intent.putExtra("ugenre",datalist.get(position).getBook_genre());
                intent.putExtra("udesc",datalist.get(position).getBook_desc());
                intent.putExtra("updf",datalist.get(position).getFileurl());

                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                holder.fb.getContext().startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    class myviewholder extends RecyclerView.ViewHolder{

        TextView t1,t2,t3;
        FloatingActionButton fb;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
            t1 = itemView.findViewById(R.id.t1);
            t2 = itemView.findViewById(R.id.t2);
            t3 = itemView.findViewById(R.id.t3);
            fb = itemView.findViewById(R.id.details);
        }
    }
}

package com.firstapp.groupproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.AbsListView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class VisitStoreActivity extends AppCompatActivity {

    RecyclerView recview;
    ArrayList<BookDetails> datalist;
    FirebaseFirestore db;
    myadapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visit_store);

        recview = (RecyclerView)findViewById(R.id.recview);
        recview.setLayoutManager(new LinearLayoutManager(this));
        datalist = new ArrayList<>();
        adapter = new myadapter(datalist);
        recview.setAdapter(adapter);

        db = FirebaseFirestore.getInstance();
        db.collection("Store").get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {

                        List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                        for(DocumentSnapshot d:list)
                        {
                            BookDetails obj = d.toObject(BookDetails.class);
                            datalist.add(obj);
                        }
                        adapter.notifyDataSetChanged();
                    }
                });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.sort_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.asc){
            datalist = new ArrayList<>();
            adapter = new myadapter(datalist);
            recview.setAdapter(adapter);
            db.collection("Store").orderBy("book_name").get()
                    .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                        @Override
                        public void onSuccess(QuerySnapshot queryDocumentSnapshots) {

                            List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                            for(DocumentSnapshot d:list)
                            {
                                BookDetails obj = d.toObject(BookDetails.class);
                                datalist.add(obj);
                            }
                            adapter.notifyDataSetChanged();
                        }
                    });

        }
        if(id == R.id.desc){
            datalist = new ArrayList<>();
            adapter = new myadapter(datalist);
            recview.setAdapter(adapter);
            db.collection("Store").orderBy("book_name", Query.Direction.DESCENDING).get()
                    .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                        @Override
                        public void onSuccess(QuerySnapshot queryDocumentSnapshots) {

                            List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                            for(DocumentSnapshot d:list)
                            {
                                BookDetails obj = d.toObject(BookDetails.class);
                                datalist.add(obj);
                            }
                            adapter.notifyDataSetChanged();
                        }
                    });

        }
        if(id == R.id.acad){
            datalist = new ArrayList<>();
            adapter = new myadapter(datalist);
            recview.setAdapter(adapter);
            db.collection("Store").whereEqualTo("book_genre","Academic").get()
                    .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                        @Override
                        public void onSuccess(QuerySnapshot queryDocumentSnapshots) {

                            List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                            for(DocumentSnapshot d:list)
                            {
                                BookDetails obj = d.toObject(BookDetails.class);
                                datalist.add(obj);
                            }
                            adapter.notifyDataSetChanged();
                        }
                    });

        }
        if(id == R.id.nonacad){
            datalist = new ArrayList<>();
            adapter = new myadapter(datalist);
            recview.setAdapter(adapter);
            db.collection("Store").whereEqualTo("book_genre","Non Academic").get()
                    .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                        @Override
                        public void onSuccess(QuerySnapshot queryDocumentSnapshots) {

                            List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                            for(DocumentSnapshot d:list)
                            {
                                BookDetails obj = d.toObject(BookDetails.class);
                                datalist.add(obj);
                            }
                            adapter.notifyDataSetChanged();
                        }
                    });

        }
        return super.onOptionsItemSelected(item);
    }
}
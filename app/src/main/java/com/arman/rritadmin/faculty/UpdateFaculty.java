package com.arman.rritadmin.faculty;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.arman.rritadmin.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class UpdateFaculty extends AppCompatActivity {

    FloatingActionButton fab;
    private RecyclerView csDepartment,informationDepartment,eceDepartment,civilDepartment;
    private LinearLayout csNoData,informationNoData,eceNoData,civilNoData;
    private List<TeacherData> list1,list2,list3,list4;

    private TeacherAdapter adapter;

    private DatabaseReference reference,dbRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_faculty);

        csDepartment=findViewById(R.id.csDepartment);
        informationDepartment=findViewById(R.id.informationDepartment);
        eceDepartment=findViewById(R.id.eceDepartment);
        civilDepartment=findViewById(R.id.civilDepartment);

        csNoData=findViewById(R.id.csNoData);
        informationNoData=findViewById(R.id.informationNoData);
        eceNoData=findViewById(R.id.eceNoData);
        civilNoData=findViewById(R.id.civilNoData);

        reference= FirebaseDatabase.getInstance().getReference().child("Teacher");

        csDepartment();
        informationDepartment();
        eceDepartment();
        civilDepartment();

        fab=findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UpdateFaculty.this,AddTeacher.class));
            }
        });
    }

    private void csDepartment() {
        dbRef=reference.child("Computer Science");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                list1=new ArrayList<>();
                if (!dataSnapshot.exists()){
                    csNoData.setVisibility(View.VISIBLE);
                    csDepartment.setVisibility(View.GONE);
                }else {
                    csNoData.setVisibility(View.GONE);
                    csDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot:dataSnapshot.getChildren()){
                        TeacherData data=snapshot.getValue(TeacherData.class);
                        list1.add(data);
                    }
                    csDepartment.setHasFixedSize(true);
                    csDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter=new TeacherAdapter(list1,UpdateFaculty.this,"Computer Science");
                    csDepartment.setAdapter(adapter);

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateFaculty.this,databaseError.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void informationDepartment() {
        dbRef=reference.child("Information Technology");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                list2=new ArrayList<>();
                if (!dataSnapshot.exists()){
                    informationNoData.setVisibility(View.VISIBLE);
                    informationDepartment.setVisibility(View.GONE);
                }else {
                    informationNoData.setVisibility(View.GONE);
                    informationDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot:dataSnapshot.getChildren()){
                        TeacherData data=snapshot.getValue(TeacherData.class);
                        list2.add(data);
                    }
                    informationDepartment.setHasFixedSize(true);
                    informationDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter=new TeacherAdapter(list2,UpdateFaculty.this,"Information Technology");
                    informationDepartment.setAdapter(adapter);

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateFaculty.this,databaseError.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void   eceDepartment() {
        dbRef=reference.child("Ece Department");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                list3=new ArrayList<>();
                if (!dataSnapshot.exists()){
                    eceNoData.setVisibility(View.VISIBLE);
                    eceDepartment.setVisibility(View.GONE);
                }else {
                    eceNoData.setVisibility(View.GONE);
                    eceDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot:dataSnapshot.getChildren()){
                        TeacherData data=snapshot.getValue(TeacherData.class);
                        list3.add(data);
                    }
                    eceDepartment.setHasFixedSize(true);
                    eceDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter=new TeacherAdapter(list3,UpdateFaculty.this,"Ece Department");
                    eceDepartment.setAdapter(adapter);

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateFaculty.this,databaseError.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void civilDepartment() {
        dbRef=reference.child("Civil Department");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                list4=new ArrayList<>();
                if (!dataSnapshot.exists()){
                    civilNoData.setVisibility(View.VISIBLE);
                    civilDepartment.setVisibility(View.GONE);
                }else {
                    civilNoData.setVisibility(View.GONE);
                    civilDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot:dataSnapshot.getChildren()){
                        TeacherData data=snapshot.getValue(TeacherData.class);
                        list4.add(data);
                    }
                    civilDepartment.setHasFixedSize(true);
                    civilDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter=new TeacherAdapter(list4,UpdateFaculty.this,"Civil Department");
                    civilDepartment.setAdapter(adapter);

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateFaculty.this,databaseError.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}
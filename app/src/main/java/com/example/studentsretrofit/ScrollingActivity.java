package com.example.studentsretrofit;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ScrollingActivity extends AppCompatActivity {
    RecyclerView verticalrecyclerview;
    private Adapter verticaladapter;
    LayoutInflater inflater;
    LinearLayoutManager llmanager;

    ArrayList<String> regno,name,dob,sclass,branch;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       // verticalrecyclerview=findViewById(R.id.vrview);

        regno=new ArrayList<>();
        name=new ArrayList<>();
        dob=new ArrayList<>();
        sclass=new ArrayList<>();
        branch=new ArrayList<>();


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });




initview();

    }

    private void initview() {
        verticalrecyclerview=findViewById(R.id.vrview);
        verticalrecyclerview.setHasFixedSize(false);
        RecyclerView.LayoutManager layoutmanager=new LinearLayoutManager(getApplicationContext());
        verticalrecyclerview.setLayoutManager(layoutmanager);
        loadJSON();

    }

    private void loadJSON() {


        Utils utils=new Utils();
        Call<StudentModel> profileModelCall=utils.getApi().viewStudent("CSE");
        profileModelCall.enqueue(new Callback<StudentModel>() {
            @Override
            public void onResponse(Call<StudentModel> call, Response<StudentModel> response) {
                if(response.isSuccessful())
                {
                    Toast.makeText(ScrollingActivity.this, "response success", Toast.LENGTH_SHORT).show();

                    String s=response.body().getResult();
                    if(s.equalsIgnoreCase("success"))
                    {

                        List<StudentDetail> ls= (List<StudentDetail>) response.body().getStudentDetails();

                        Toast.makeText(ScrollingActivity.this, "response parsed", Toast.LENGTH_SHORT).show();


                        for(int i=0;i<ls.size();i++)
                        {


                            regno.add("Reg no"+ls.get(i).getStudentRegNo());
                            name.add("Name"+ls.get(i).getStudentName());
                            dob.add("D O B "+ls.get(i).getStudentDob());
                            sclass.add("class "+ls.get(i).getStudentClass());
                            branch.add("Branch "+ls.get(i).getStudentBranch());






                        }

                     StudentAdapter   adapter=new StudentAdapter((ArrayList<StudentDetail>) ls);
                        verticalrecyclerview.setAdapter(adapter);



                    }else
                    {
                        Toast.makeText(ScrollingActivity.this, "response Failure", Toast.LENGTH_SHORT).show();

                    }




                }
            }

            @Override
            public void onFailure(Call<StudentModel> call, Throwable t) {

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

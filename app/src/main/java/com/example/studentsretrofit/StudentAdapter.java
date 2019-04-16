package com.example.studentsretrofit;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {

    private ArrayList<StudentDetail> stud;

    public StudentAdapter(ArrayList<StudentDetail> stud) {
        this.stud = stud;
    }


    @NonNull
    @Override
    public StudentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.listitem, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentAdapter.ViewHolder viewHolder, int i) {

        viewHolder.regno_a.setText(stud.get(i).getStudentRegNo());
        viewHolder.studentname_a.setText(stud.get(i).getStudentName());
        viewHolder.studentdob_a.setText(stud.get(i).getStudentDob());
        viewHolder.studentclass_a.setText(stud.get(i).getStudentClass());
        viewHolder.studentbranch_a.setText(stud.get(i).getStudentBranch());


    }

    @Override
    public int getItemCount() {
        return stud.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView regno_a;
        private TextView studentname_a;
        private TextView studentdob_a;
        private TextView studentclass_a;
        private TextView studentbranch_a;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            regno_a = itemView.findViewById(R.id.regnum);
            studentname_a = itemView.findViewById(R.id.sname);
            studentdob_a = itemView.findViewById(R.id.sdob);
            studentclass_a = itemView.findViewById(R.id.sclass);
            studentbranch_a = itemView.findViewById(R.id.sbranch);


        }
    }
}



package com.example.moblieprogrammingproject;

import android.database.SQLException;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class ChatFragment extends Fragment {
    DBconnection db = new DBconnection(getActivity());
    private DBconnection db2;
    ListView listView;
    EditText id,name;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_chat, container, false);


    }
//    @Override
//    public void onActivityCreated(Bundle savedInstanceState) {
//        // TODO Auto-generated method stub
//        super.onActivityCreated(savedInstanceState);
//        final EditText etFirstName = (EditText) getActivity().findViewById(
//                R.id.etFirstName);
//        final EditText etLastName = (EditText) getActivity().findViewById(
//                R.id.etLastName);
//        final EditText etEmail = (EditText) getActivity().findViewById(
//                R.id.etEmail);
//        final EditText etUsername = (EditText) getActivity().findViewById(
//                R.id.etUsername);
//        final EditText etPassword = (EditText) getActivity().findViewById(
//                R.id.etPassword);
//        Button bDone = (Button) getActivity().findViewById(R.id.bDone);
//        bDone.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                // TODO Auto-generated method stub
//                MySQLiteOpenHelper db = new MySQLiteOpenHelper(null);//do I need this??
//                db.addUser(new User(etFirstName.getText().toString(),
//                        etLastName.getText().toString(), etEmail.getText()
//                        .toString(), etUsername.getText().toString(),
//                        etPassword.getText().toString()));
//            }
//        });

//    }
}
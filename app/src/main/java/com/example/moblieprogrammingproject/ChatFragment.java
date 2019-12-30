package com.example.moblieprogrammingproject;

import android.database.Cursor;
import android.database.SQLException;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class ChatFragment extends Fragment {
ListView listView;
Button button;

DBHelper dbHelper;
DatabaseConnection myDb;
    Cursor res;
////////////////////////
RecyclerView recyclerView;
    List<Item> itemList;
    Button btnAddData;
    Button btnBookPage;

    EditText editName,editSurname,editMarks ,editTextId;
    ItemAdapter itemAdapter;



    public  static ChatFragment newInstance()
{
    return new ChatFragment();
}


//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//
//        View rootView = inflater.inflate(R.layout.fragment_chat, null);
//        myDb= new DatabaseConnection(getActivity());
//
//        res=myDb.getAllData();
//        itemList = new ArrayList<>();
//        StringBuffer buffer = new StringBuffer();
//        while (res.moveToNext()) {
//            buffer.append("Id :" + res.getString(0) + "\n");
//            buffer.append("Name :" + res.getString(1) + "\n");
//            buffer.append("Surname :" + res.getString(2) + "\n");
//            buffer.append("Marks :" + res.getString(3) + "\n\n");
////            buffer.append("Date :"+ res.getString(4)+"\n\n");
//
//            itemList.add(new Item(res.getString(0),res.getString(1), res.getString(2), res.getString(3), res.getString(4)));
//        }
//
//
//        // Show all data
////        showMessage("Data",buffer.toString());
////        buffer.toString();
//
//
//
//        return rootView;
//    }
    public void seperator2(){}

    //    public void showMessage(String title,String Message){
//        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//        builder.setCancelable(true);
//        builder.setTitle(title);
//        builder.setMessage(Message);
//        builder.show();
//    }
    public void seperator(){}
//    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
//        itemAdapter = new ItemAdapter(itemList,getContext());
//
//        recyclerView = (RecyclerView)getView().findViewById(R.id.recycler_view);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//        recyclerView.setAdapter(itemAdapter);
////        btnBookPage=(Button) view.findViewById(R.id.go_to_book_page);
//
//        editName = (EditText) view.findViewById(R.id.editText_add_data);
//        btnAddData=(Button) view.findViewById(R.id.add_data);
//        Toast.makeText(getActivity(),"Testing101",Toast.LENGTH_LONG).show();
//
//
////        ChooseOneBook();
//
//        // or  (ImageView) view.findViewById(R.id.foo);
//    }


}



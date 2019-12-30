package com.example.moblieprogrammingproject;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class BookFragment extends Fragment {
    ListView listView;
    Button button;

    DBHelper dbHelper;
    DatabaseConnection myDb;
    Cursor res;
    ////////////////////////
    RecyclerView recyclerView;
    List<Item> itemList;
    Button btnBookPage;

    EditText editName,editSurname,editMarks ,editTextId;
    TextView  testView;
    ItemAdapter itemAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_book,container,false);
        myDb= new DatabaseConnection(getActivity());

//        res=myDb.getAllData();
        itemList = new ArrayList<>();
        StringBuffer buffer = new StringBuffer();
//        while (res.moveToNext()) {
//            buffer.append("Id :" + res.getString(0) + "\n");
//            buffer.append("Name :" + res.getString(1) + "\n");
//            buffer.append("Surname :" + res.getString(2) + "\n");
//            buffer.append("Marks :" + res.getString(3) + "\n\n");
////            buffer.append("Date :"+ res.getString(4)+"\n\n");
//
//            itemList.add(new Item(res.getString(0), res.getString(1), res.getString(2), res.getString(3), res.getString(4)));
//        }


        // Show all data
//        showMessage("Data",buffer.toString());
//        buffer.toString();



        return rootView;
    }
    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        itemAdapter = new ItemAdapter(itemList,getContext());

        recyclerView = (RecyclerView)getView().findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(itemAdapter);
        editName = (EditText) view.findViewById(R.id.editText_add_data);

        btnBookPage=(Button) view.findViewById(R.id.add_data);
        ChooseOneBook();
        recyclerView.addOnItemTouchListener(new ItemAdapter.RecyclerTouchListener(getContext(), recyclerView, new ItemAdapter.ClickListener() {
            @Override
            public void onClick(View v, int position) {
                Intent details = new Intent(getContext(), Main4Activity.class);

                details.putExtra("bookName",itemList.get(position).getName());
                startActivity(details);
            }

            @Override
            public void onLongClick(View v, int position) {

            }
        }));
    }

        // or  (ImageView) view.findViewById(R.id.foo);

    public  void ChooseOneBook() {
        btnBookPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDb.insertData(editName.getText().toString(), "It is the novel that talks about everything and nothing ", "Shakespeare");

//                boolean  isInserted = myDb.insertData(editName.getText().toString(),
//                        "It is the novel that talks about everything and nothing ",
//                        "Shakespeare" );
//                if(isInserted == true)
                    Toast.makeText(getActivity(),"Data Inserted",Toast.LENGTH_LONG).show();

//                        else
//                    Toast.makeText(getActivity(),"Data not Inserted",Toast.LENGTH_LONG).show();

                res=myDb.getAllData();
                Intent i = new Intent(getActivity(), Main2Activity.class);
                    if( TextUtils.isEmpty(editName.getText())){

                        editName.setError( "Name is required!" );}
                    else{
                        String message=editName.getText().toString();
                        i.putExtra("personName",message);

                        startActivity(i);
                    }


//            Intent mailClient = new Intent(Intent.ACTION_VIEW);
//            mailClient.setClassName("com.google.android.gm", "com.google.android.gm.ConversationListActivity");
//            startActivity(mailClient);

//            Intent intent = getPackageManager().getLaunchIntentForPackage("com.google.android.gm");
//            startActivity(intent);

                ((Activity) getActivity()).overridePendingTransition(0, 0);
                while (res.moveToNext()) {

                    itemList.add(new Item(res.getString(0),res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5)));

                }


                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

                recyclerView.setAdapter(itemAdapter);


            }
                                       }
        );


    }



}




/*
btnBookPage.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                      Cursor result= myDb.getBookPage(res.getString(0));
                            Toast.makeText(getActivity(),"Data not Inserted",Toast.LENGTH_LONG).show();

                        while (result.moveToNext()) {

                            itemList.add(new Item(result.getString(0),result.getString(1),result.getString(2),result.getString(3),result.getString(4)));

                        }
                        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

                        recyclerView.setAdapter(itemAdapter);


                    }
                }
        );
 */
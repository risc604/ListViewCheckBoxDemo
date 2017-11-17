package com.demo.tomcat.listviewcheckboxdemo;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.Toast;


//menu & icon
//https://stackoverflow.com/questions/32969172/how-to-display-menu-item-with-icon-and-text-in-appcompatactivity

public class MainActivity extends ListActivity
{
    private final static String TAG = ListActivity.class.getSimpleName();
    String[] city = {
            "Bangalore", "Chennai", "Mumbai", "Pune", "Delhi",
            "Jabalpur", "Indore", "Ranchi", "Hyderabad", "Ahmedabad",
            "Kolkata", "Bhopal", "Taipei", "New Yorke", "Tokyo"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = getListView();
        listView.setChoiceMode(listView.CHOICE_MODE_MULTIPLE);
        listView.setTextFilterEnabled(true);
        setListAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_multiple_choice, city));
    }

    @Override
    protected void onListItemClick(ListView parent, View v, int position, long id)
    {
        //super.onListItemClick(l, v, position, id);
        CheckedTextView item = (CheckedTextView) v;
        Toast.makeText(this,
                        city[position] + " checked: " + item.isChecked(),
                        Toast.LENGTH_SHORT).show();
        Log.i(TAG, "id: " + id);
    }

    //------ User function --------------//
    private void initView()
    {


    }
}

package com.example.mynoteproject;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class AdapterNoteList extends ArrayAdapter<NoteItem> {
    Context context;
    ArrayList<NoteItem> items = null;


    public AdapterNoteList(Context context, int layoutTobeInflated, ArrayList<NoteItem> items){
        super(context,layoutTobeInflated,items);
        this.context = context;
        this.items = items;
    }

}

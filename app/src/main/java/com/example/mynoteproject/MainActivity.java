package com.example.mynoteproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class MainActivity extends AppCompatActivity {
    AdapterNoteList adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String path = this.getFilesDir().getAbsolutePath() + "/abc.xml";

        ListView lstNotes = (ListView) findViewById(R.id.lstNotes);
        adapter = new AdapterNoteList
                (getApplicationContext(),android.R.layout.simple_expandable_list_item_1,readByDOM(path));
        lstNotes.setAdapter(adapter);

    }


    private ArrayList<NoteItem> readByDOM(String file){
        ArrayList<NoteItem> items = new ArrayList<NoteItem>();
        NoteItem item = null;
        String title ="", content="";


        try {
            DocumentBuilderFactory fac = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = fac.newDocumentBuilder();

            FileInputStream fIn = new FileInputStream(file);
            Document doc = builder.parse(fIn);

            Element root = doc.getDocumentElement();
            NodeList list = root.getChildNodes();

            for(int i=0;i<list.getLength();i++)
            {
                Node node = list.item(i);
                if(node instanceof Element)
                {
                    Element element = (Element) node;
                    title = element.getAttribute("title");

                    NodeList listchild = element.getElementsByTagName("content");
                    content = listchild.item(0).getTextContent();

                    item = new NoteItem();
                    item.title = title;
                    item.content = content;
                    items.add(item);

                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        finally {
            return items;
        }
    }
}

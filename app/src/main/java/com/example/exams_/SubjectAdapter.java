package com.example.exams_;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.net.Uri;
import android.text.style.BackgroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SubjectAdapter extends BaseAdapter {

    Context ctx;
    LayoutInflater lInflater;
    ArrayList<Subject> objects;
    Button to_skype_btn;

    SubjectAdapter(Context context, ArrayList<Subject> products) {
        ctx = context;
        objects = products;
        lInflater = (LayoutInflater) ctx
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public Object getItem(int i) {
        return objects.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        View view = convertView;
        if (view == null) {
            view = lInflater.inflate(R.layout.subject_item, viewGroup, false);
        }

        Subject s = getSubject(i);

        ((ImageView) view.findViewById(R.id.dot)).setImageResource(s.getDot_icon());
        ((TextView) view.findViewById(R.id.subject_title)).setText(s.getTitle_param());
        ((TextView) view.findViewById(R.id.time_one)).setText(String.format("%d:%s - %d:%d", s.getTime_h_start(), s.getTime_m_start(), s.getTime_h_end(),
                                                                            s.getTime_m_end()));
        ((ImageView) view.findViewById(R.id.subject_icon)).setImageResource(s.getSubject_icon_param());
        ((TextView) view.findViewById(R.id.Teacher)).setText(s.getTeacher_param());

        to_skype_btn = (Button) view.findViewById(s.getSkype_btn_param());
        to_skype_btn.setOnClickListener(skype_link);


        return view;
    }


    View.OnClickListener skype_link = (new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.addCategory(Intent.CATEGORY_BROWSABLE);
            intent.setData(Uri.parse("https://www.skype.com/en/"));
            ctx.startActivity(intent);
        }
    });

    Subject getSubject(int position) {
        return ((Subject) getItem(position));
    }

}

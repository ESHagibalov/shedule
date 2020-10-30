package com.example.exams_

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


class classes : Fragment() {

    lateinit var mView: View
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_classes, container, false)
        displayAllSubjects()

        return mView
    }

    fun displayAllSubjects(){
        val allSubjects: ListView = mView.findViewById(R.id.all_subjects)
        val sbjAdapter: SubjectAdapter = SubjectAdapter(context, subjects)
        allSubjects.setAdapter(sbjAdapter)

    }




}
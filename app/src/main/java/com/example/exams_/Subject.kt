package com.example.exams_

import android.os.Bundle
import android.text.style.BackgroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TimePicker

class Subject(val title_param: String, val teacher_param: String, val skype_btn_param: Int, val subject_icon_param: Int,
              val dot_icon: Int, val time_h_start: Int,  val time_m_start: String, val time_h_end: Int,  val time_m_end: Int){
    lateinit var btn: Button

    fun setInvisibleBtn(skype_btn_param: Int){
        btn.findViewById<Button>(skype_btn_param)
        btn.visibility = View.INVISIBLE
    }
}

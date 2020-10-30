package com.example.exams_

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import java.text.SimpleDateFormat
import java.util.*

class home : Fragment() {

    var yearOfExam: Int = 2020 // hardcoded for this year
    var monthOfExam: Int = 11
    var examTimeDay: Int = 20
    var examTimeHours: Int = 10
    var examTimeMinutes: Int = 60
    var daysB4Exam: Int = 0
    var hoursB4exam: Int = 0
    var date = getCurrentDateTime()
    var currentYear = date.toString("yyyy").toInt()
    var currentDay = date.toString("dd").toInt()
    var currentHours = date.toString("HH").toInt()
    var currentMonth = date.toString("MM").toInt()
    var currentMinutes = date.toString("mm").toInt()
    var monthDays: Map<Int, Int> = mapOf(1 to 31, 2 to february(currentYear + 1), 3 to 31, 4 to 30, 5 to 31, 6 to 30, 7 to 31,
            8 to 31, 9 to 30, 10 to 31, 11 to 30, 12 to 31)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val mView: View = inflater.inflate(R.layout.fragment_home, container, false)

        if (currentHours > examTimeHours) {
            daysB4Exam = monthDays.getValue(currentMonth) - currentDay + daysCount() + examTimeDay + years() - 2
            hoursB4exam = 24 - currentHours + examTimeHours
        } else {
            daysB4Exam = monthDays.getValue(currentMonth) - currentDay + daysCount() + examTimeDay + years() - 1
            hoursB4exam = examTimeHours - currentHours
        }

        val minutesB4exam = examTimeMinutes - currentMinutes
        val daysBeforeExam: TextView = mView.findViewById(R.id.DaysBeforeExam)
        val HoursBeforeExam: TextView = mView.findViewById(R.id.HoursBeforeExam)
        val MinutesBeforeExam: TextView = mView.findViewById(R.id.MinutesBeforeExam)

        daysBeforeExam.text = daysB4Exam.toString()
        HoursBeforeExam.text = hoursB4exam.toString()
        MinutesBeforeExam.text = minutesB4exam.toString()

        val titleNextClass: TextView = mView.findViewById(R.id.subject_title)
        val timeNextClass: TextView = mView.findViewById(R.id.timeNextSbj)
        val iconNextClass: ImageView = mView.findViewById(R.id.subject_icon)
        titleNextClass.text = ContentService.title
        timeNextClass.text = ContentService.time
        iconNextClass.setImageResource(ContentService.idIcon)
        return mView
    }

    private fun february(year: Int): Int {
        return if(year % 4 == 0) {
            29
        }
        else
            28
    }

    fun years(): Int{
        var days: Int = 0
        if(currentYear + 1 < yearOfExam) {
            for (i: Int in currentYear + 1 until yearOfExam) {
                if(february(i) == 29)
                    days += 366
                else
                    days += 365
            }
        }
        return days
    }

    private fun daysCount(): Int {
        var sumOfDays: Int = 0

        if(currentMonth <= monthOfExam) {
            for (i: Int in currentMonth..monthOfExam)
                if (i + 1 < monthOfExam)
                    sumOfDays += monthDays.getValue(currentMonth)
        } else {
            for (i: Int in currentMonth..12)
                    sumOfDays += monthDays.getValue(currentMonth)

            for (i: Int in 1..monthOfExam)
                if (i + 1 < monthOfExam)
                    sumOfDays += monthDays.getValue(currentMonth)
        }
        return sumOfDays
    }

}
package com.example.exams_

object ContentService {

    val date = getCurrentDateTime()
    val currentHours = date.toString("HH").toInt()
    var title = when(currentHours) {
        8 -> subjects[1].title_param
        9 -> subjects[2].title_param
        10 -> subjects[3].title_param
        11 -> subjects[4].title_param
        12 -> subjects[5].title_param
        else -> subjects[0].title_param
    }

    var time: String = when(currentHours) {
        8 -> subjects[1].time_h_start.toString() + ":" + subjects[1].time_m_start + " - " +
                subjects[1].time_h_end.toString() + subjects[1].time_m_end.toString()
        9 -> subjects[2].time_h_start.toString() + ":" + subjects[2].time_m_start + " - " +
                subjects[2].time_h_end.toString() + subjects[2].time_m_end.toString()
        10 -> subjects[3].time_h_start.toString() + ":" + subjects[3].time_m_start + " - " +
                subjects[3].time_h_end.toString() + subjects[3].time_m_end.toString()
        11 -> subjects[4].time_h_start.toString() + ":" + subjects[4].time_m_start + " - " +
                subjects[4].time_h_end.toString() + subjects[4].time_m_end.toString()
        12 -> subjects[5].time_h_start.toString() + ":" + subjects[5].time_m_start + " - " +
                subjects[5].time_h_end.toString() + subjects[5].time_m_end.toString()
        else -> subjects[0].time_h_start.toString() + ":" + subjects[0].time_m_start + " - " +
                subjects[0].time_h_end.toString() + subjects[0].time_m_end.toString()
    }

    var idIcon = when(currentHours) {
        8 -> subjects[1].subject_icon_param
        9 -> subjects[2].subject_icon_param
        10 -> subjects[3].subject_icon_param
        11 -> subjects[4].subject_icon_param
        12 -> subjects[5].subject_icon_param
        else -> subjects[0].subject_icon_param
    }

}
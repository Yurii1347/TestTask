package com.yurii.vytivskyi.testtask.data

import com.yurii.vytivskyi.testtask.data.db.Onclick
import com.yurii.vytivskyi.testtask.data.db.Onload
import com.yurii.vytivskyi.testtask.data.db.Onsent

data class Analytics(
    val onclick: Onclick,
    val onload: Onload,
    val onsent: Onsent
)
package com.ardhacodes.subs1_jetpack.ui.tv

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class TvViewModelTest
{
    private lateinit var viewmodel: TvViewModel


    @Before
    fun setData(){
        viewmodel = TvViewModel()
    }

    @Test
    fun getMovie(){
        val tv = viewmodel.getdDataTv()
        val countdata = 11
        assertNotNull(tv)
        assertEquals(countdata, tv.size)
    }
}
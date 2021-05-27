package com.ardhacodes.subs1_jetpack.ui.tv

import com.ardhacodes.subs1_jetpack.data.CatalogRepository
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mock

class TvViewModelTest
{
    private lateinit var viewmodel: TvViewModel
    @Mock
    private lateinit var catalogRepository: CatalogRepository


    @Before
    fun setData(){
        viewmodel = TvViewModel(catalogRepository)
    }

    @Test
    fun getMovie(){
        val tv = viewmodel.getdDataTv()
        val countdata = 11
        assertNotNull(tv)
        assertEquals(countdata, tv.size)
    }
}
package com.ardhacodes.subs1_jetpack.injection

import com.ardhacodes.subs1_jetpack.data.CatalogRepository
import com.ardhacodes.subs1_jetpack.data.source.remote.RemoteDataSource

object Injection {
    fun provideCatalogRepository(): CatalogRepository {
        val remoteDataSource = RemoteDataSource.getInstance()
        return CatalogRepository.getInstance(remoteDataSource)
    }
}
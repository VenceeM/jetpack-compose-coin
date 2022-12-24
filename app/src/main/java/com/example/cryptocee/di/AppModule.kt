package com.example.cryptocee.di

import com.example.cryptocee.feature_crypto_main.data.core.CoinApi
import com.example.cryptocee.feature_crypto_main.data.repository.CoinRepositoryImpl
import com.example.cryptocee.feature_crypto_main.domain.repository.CoinRepository
import com.example.cryptocee.feature_crypto_main.domain.usecase.GetAllCoinUseCase
import com.example.cryptocee.util.Constant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRepository(api:CoinApi):CoinRepository{
        return CoinRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideUseCase(repository: CoinRepository): GetAllCoinUseCase{
        return GetAllCoinUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideCoinApi():CoinApi{
        return Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinApi::class.java)
    }

}
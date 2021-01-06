package com.sasquer.imagesgallery.di.modules

import com.sasquer.imagesgallery.BuildConfig
import com.sasquer.imagesgallery.data.interactor.ImagesInteractor
import com.sasquer.imagesgallery.data.interactor.ImagesInteractorImpl
import com.sasquer.imagesgallery.data.network.ImagesApi
import com.sasquer.imagesgallery.data.repository.ImagesRepository
import com.sasquer.imagesgallery.data.repository.ImagesRepositoryImpl
import com.sasquer.imagesgallery.di.HeaderInterceptor
import dagger.Binds
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit

@Module(
    includes = [
        DataModule.RepositoryModule::class,
        DataModule.RemoteModule::class
    ]
)
interface DataModule {

    @Module
    interface RepositoryModule {
        @Binds
        fun ImagesRepositoryImpl.bindRepository(): ImagesRepository

        @Binds
        fun ImagesInteractorImpl.bindInteractor(): ImagesInteractor
    }

    @Module(includes = [RemoteModule.NetworkModule::class])
    interface RemoteModule {

        @Module
        class NetworkModule {

            @Provides
            fun provideInterceptor(): HttpLoggingInterceptor {
                return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
            }

            @Provides
            fun provideOkHttpClient(httpLogging: HttpLoggingInterceptor): OkHttpClient =
                OkHttpClient.Builder().apply {
                    connectTimeout(2, TimeUnit.SECONDS)
                    readTimeout(2, TimeUnit.SECONDS)
                    writeTimeout(2, TimeUnit.SECONDS)
                    addInterceptor(httpLogging)
                    addInterceptor(HeaderInterceptor())
                }.build()

            @Provides
            fun OkHttpClient.provideRetrofit(): Retrofit = Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(this)
                .build()

            @Provides
            fun provideWeatherApi(retrofit: Retrofit): ImagesApi = retrofit.create()
        }
    }
}
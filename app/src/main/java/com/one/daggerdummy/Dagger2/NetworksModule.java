package com.one.daggerdummy.Dagger2;

import android.util.Log;

import com.squareup.moshi.Moshi;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

@Module
public class NetworksModule {
    @Singleton
    @Provides
    public Moshi provideMoshi(){
        return new Moshi.Builder().build();
    }

    @Singleton
    @Provides
    public Retrofit provideRetrofit(Moshi converter,@Named("url") String url){
        return new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(MoshiConverterFactory.create(converter))
                .build();
    }
}

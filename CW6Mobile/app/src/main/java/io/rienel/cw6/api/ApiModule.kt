package io.rienel.cw6.api

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApiModule {

	@Provides
	@Singleton
	fun provideRetrofit(): Retrofit = Retrofit.Builder()
		.addConverterFactory(JacksonConverterFactory.create())
		.baseUrl("http://192.168.0.105:8080")
		.build()

	@Provides
	@Singleton
	fun provideServerService(retrofit: Retrofit) = retrofit.create(Cw6ServerService::class.java)

}
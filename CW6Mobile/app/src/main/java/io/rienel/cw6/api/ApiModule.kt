package io.rienel.cw6.api

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApiModule {

	@Provides
	@Singleton
	fun provideDynamicHostService(): DynamicHostService = DynamicHostService()

	@Provides
	@Singleton
	fun provideOkHttpClient(
		dynamicHostInterceptor: DynamicHostInterceptor
	): OkHttpClient = OkHttpClient.Builder()
		.addInterceptor(dynamicHostInterceptor)
		.build()

	@Provides
	@Singleton
	fun provideRetrofit(dynamicBaseUrl: OkHttpClient): Retrofit = Retrofit.Builder()
		.client(dynamicBaseUrl)
		.addConverterFactory(JacksonConverterFactory.create())
		.baseUrl("http://localhost:8080")
		.build()

	@Provides
	@Singleton
	fun provideServerService(retrofit: Retrofit): Cw6ServerService = retrofit
		.create(Cw6ServerService::class.java)

}
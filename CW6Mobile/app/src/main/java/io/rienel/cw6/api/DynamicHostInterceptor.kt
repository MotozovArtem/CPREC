package io.rienel.cw6.api

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import io.rienel.cw6.R
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class DynamicHostInterceptor @Inject constructor(
	@ApplicationContext private val context: Context,
	private val dynamicHostService: DynamicHostService
) : Interceptor {

	override fun intercept(chain: Interceptor.Chain): Response {
		var request: Request = chain.request()
		val host = dynamicHostService.serverIp.value
		if (host == null) {
			Timber.i("Host is null")
			throw IllegalStateException(
				context.getString(R.string.server_ip_cannot_be_empty)
			)
		}
		val newUrl: HttpUrl = request.url().newBuilder()
			.host(host)
			.port(8080)
			.build()
		request = request.newBuilder()
			.url(newUrl)
			.build()
		return chain.proceed(request)
	}
}
package io.rienel.cw6.api

import androidx.lifecycle.MutableLiveData
import javax.inject.Singleton

@Singleton
class DynamicHostService {
	val serverIp: MutableLiveData<String> by lazy {
		MutableLiveData("192.168.0.105")
	}
}
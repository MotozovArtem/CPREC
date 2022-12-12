package io.rienel.cw6.ui.util

interface Bindable<T> {
	fun onBind(obj: T)
}
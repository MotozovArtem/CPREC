package io.rienel.cw6.ui

interface Bindable<T> {
	fun onBind(obj: T)
}
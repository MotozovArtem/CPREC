package io.rienel.cw6.ui.util

import io.rienel.cw6.R

enum class ResponseResult(val message: Int) {
	HOST_IS_UNREACHABLE(R.string.host_is_unreachable),
	CONNECTION_REFUSED(R.string.connection_refused),
	EMPTY_RESPONSE(R.string.empty_response),
	OK(R.string.ok),
	UNKNOWN(R.string.unknown_network_error),
}
package io.rienel.http;

import io.rienel.dto.ValCurs;
import retrofit.http.GET;
import retrofit.http.Query;

public interface CentralBankOfRussianService {
	@GET("/scripts/XML_daily.asp")
	ValCurs getExchange(@Query("date_req") String date);
}

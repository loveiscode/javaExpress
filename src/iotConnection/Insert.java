package iotConnection;



import java.io.IOException;

import okhttp3.*;

public class Insert {
	
	public static void main(String[] args)
	throws IOException {
		// set your proxy
		// System.setProperty("https.proxyHost", "proxy");
		// System.setProperty("https.proxyPort", "8080");

		// set your variables here
		String accountName = IOTConfig.accountName;
		String deviceId = IOTConfig.coffeeMachine;
		String deviceToken = IOTConfig.coffeeToken;
		String messageTypeId = IOTConfig.messageMaintenance;

	//	insertMaintenance(accountName, deviceId, deviceToken, messageTypeId);
		insertMaintenance(accountName, deviceId, deviceToken, messageTypeId, "1506185302", "180", "170", "", "160");
	}

	/**
	 * Sends messages to MMS
	 */
	public static void insertMaintenance(String accountName, String deviceId, String deviceToken,
		String messageTypeId, String timestamp, String waterLevel, String coffeeLevel, String filterClean, String milkLevel)
	throws IOException {
		OkHttpClient client = new OkHttpClient();

		MediaType mediaType = MediaType.parse("application/json");
		RequestBody body = RequestBody.create(mediaType, "{\"mode\":\"sync\",\"messageType\":\""+messageTypeId + "\",\"messages\":[{\n\"TIMESTAMP\": \""+timestamp+"\",\n\"WATER_LEVEL\":\""+waterLevel+"\",\n\"COFFEE_LEVEL\":\""+coffeeLevel+"\",\n\"FILTER_CLEAN\":\"YES\",\n\"FIELD1\":\""+milkLevel+"\",\n\"FIELD2\":\"\",\n\"FIELD3\":\"\",\n\"FIELD4\":\"\",\n\"FIELD5\":\"\"\n}]}");
		Request request = new Request.Builder()
		  .url(accountName + deviceId)
		  .post(body)
		  .addHeader("authorization", "Bearer " + deviceToken)
		  .addHeader("content-type", "application/json")
		  .addHeader("cache-control", "no-cache")
		  .addHeader("postman-token", "329a6c8e-466a-4ee4-063b-fc5b96dab9cb")
		  .build();

		Response response = client.newCall(request).execute();
		System.out.println(response.toString());
	}
	
	public static void insertOrder(String accountName, String deviceId, String deviceToken,
			String messageTypeId, String timestamp, String waterLevel, String coffeeLevel, String filterClean, String milkLevel)
		throws IOException {
			OkHttpClient client = new OkHttpClient();

			MediaType mediaType = MediaType.parse("application/json");
			RequestBody body = RequestBody.create(mediaType, "{\"mode\":\"sync\",\"messageType\":\""+messageTypeId + "\",\"messages\":[{\n\"TIMESTAMP\": \""+timestamp+"\",\n\"WATER_LEVEL\":\""+waterLevel+"\",\n\"COFFEE_LEVEL\":\""+coffeeLevel+"\",\n\"FILTER_CLEAN\":\"YES\",\n\"FIELD1\":\""+milkLevel+"\",\n\"FIELD2\":\"\",\n\"FIELD3\":\"\",\n\"FIELD4\":\"\",\n\"FIELD5\":\"\"\n}]}");
			Request request = new Request.Builder()
			  .url(accountName + deviceId)
			  .post(body)
			  .addHeader("authorization", "Bearer " + deviceToken)
			  .addHeader("content-type", "application/json")
			  .addHeader("cache-control", "no-cache")
			  .addHeader("postman-token", "329a6c8e-466a-4ee4-063b-fc5b96dab9cb")
			  .build();

			Response response = client.newCall(request).execute();
			System.out.println(response.toString());
		}
}

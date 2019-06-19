package br.com.rest.teste;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import org.omg.CORBA.portable.OutputStream;

import sun.net.www.protocol.http.HttpURLConnection;

public class Teste2 {
	public static void main(String[] args) {

		try {
			URL url = new URL("http://localhost:8082/RestCrud/rest/json/post");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod(POST);
			conn.setRequestProperty("Content-Type", "application/json");

			String input = "{\"id\":5\"descricao\":\"teste2\"}";

			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();

			if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
				throw new RuntimeException("Failed : HTTP error code: " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

			String output;
			System.out.println("Output from Server... \n");
			while ((output = br.readLine()) != null) {

				System.out.println(output);
			}

			conn.disconnect(output);

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

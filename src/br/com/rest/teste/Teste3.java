package br.com.rest.teste;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import br.com.rest.entidade.Ferramenta;
import sun.net.www.protocol.http.HttpURLConnection;

public class Teste3 {
	public static void main(String[] args) {
		try {

			URL url = new URL("http://localhost:8082/RestCrud/rest/json/get/get");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

			String output = "";
			System.out.println("Output form server ... \n");

			output = br.readLine();
			System.out.println(output);

			Type listType = new TypeToken<ArrayList<Ferramenta>>() {
			}.getType();

			List<Ferramenta> lstFerramentas = new Gson().fromJson(output, listType);

			System.out.println("Quantidade de registro: " + lstFerramentas.size());

			for (Ferramenta ferramenta : lstFerramentas) {
				System.out.println("ID: " + ferramenta.getId());
				System.out.println("Descricao: " + ferramenta.getDescricao());
			}

			conn.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();

		}

	}
}	
package com.plantplaces.dao;
//citeste datele de pe internet dintr-un format JSON si il returneaza intr-un String

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.springframework.stereotype.Component;

@Component
public class NetworkDAO {

	/**
	 * Returneaza datele aflate in endpoint-ul mentionat.
	 * Ne ajuta in procesul de parsare clasic din JSON in  Obiect
	 * @param endpoint s- un URL sau alta locatie in care vom gasi date in format JSON
	 * @return - tot fisierul JSON returnat sub forma unui String.
	 * @throws Exception
	 */
	public String request(String endpoint) throws Exception {

		StringBuilder sb = new StringBuilder();
		URL url = new URL(endpoint);

		// deschide o conexiune catre acest URL
		HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
		try {
						// citeste datele in format byte 0 si 1
						InputStream inputStream = urlConnection.getInputStream();
						// citeste date din inputStream-ul de sus intr-un buffer, un fel de memorie
						// interna ce e citita mai departe
						BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
			
						// citeste datele ca si caractere
						InputStreamReader inputStreamReader = new InputStreamReader(bufferedInputStream);
						BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			
						// citeste cate o lie pe rand
						String inputLine = bufferedReader.readLine();
						while (inputLine != null) {
			
							// adauga la output
							sb.append(inputLine);
							// citeste in continuare pana la null
							inputLine = bufferedReader.readLine();
			}
		} finally {
			urlConnection.disconnect();
		}
		return sb.toString();
	}
}

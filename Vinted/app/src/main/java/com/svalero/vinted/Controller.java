package com.svalero.vinted;

import android.util.Log;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Controller {
    private String urlBASE = "http://10.0.2.2:8080";

    public String callAPI(String modifier) throws IOException {
        String url = urlBASE+modifier; // URL de la API
        HttpURLConnection con = null;
        BufferedReader in = null;
        String response = "";

        try {
            URL apiUrl = new URL(url);
            con = (HttpURLConnection) apiUrl.openConnection();
            con.setRequestMethod("GET");

            in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                response += inputLine;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                in.close();
            }
            if (con != null) {
                con.disconnect();
            }
        }
        return response;
    }

    public String callAPIPostRegister(String modifier,String nombre,String email,String contrasena) throws IOException {
        String responseMessage = "";
        try {
            URL url = new URL(urlBASE+modifier);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setDoInput(true);

            // Aquí puedes establecer los headers de la petición
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Authorization", "Bearer token");

            // Aquí es donde se envían los datos
            JSONObject jsonParam = new JSONObject();
            jsonParam.put("nombre", nombre);
            jsonParam.put("email", email);
            jsonParam.put("contrasena", contrasena);

            OutputStream os = conn.getOutputStream();
            os.write(jsonParam.toString().getBytes("UTF-8"));
            os.flush();
            os.close();

            // Aquí se obtiene la respuesta del servidor
            int responseCode = conn.getResponseCode();
            responseMessage = conn.getResponseMessage();

            InputStream is = (responseCode < HttpURLConnection.HTTP_BAD_REQUEST) ? conn.getInputStream() : conn.getErrorStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line;
            StringBuilder response = new StringBuilder();
            while ((line = br.readLine()) != null) {
                response.append(line);
            }
            br.close();

            // Aquí puedes manejar la respuesta del servidor
            Log.d("TAG", "Response code: " + responseCode);
            Log.d("TAG", "Response message: " + responseMessage);
            Log.d("TAG", "Response body: " + response.toString());
            return response.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "0";
        }
    }

}


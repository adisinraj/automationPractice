package sendingSMSViaHttp;

import java.net.*;

public class SMSSending_By_HttpRequest {

        public static void main(String[] args) {
                try {
                        String recipient = "+919827609724";
                        String message = "Hello World";
                        String username = "admin";
                        String password = "admin1234";
                        String originator = "+918770167071";

                        String requestUrl  = "http://127.0.0.1:9501/api?action=sendmessage&" +
            "username=" + URLEncoder.encode(username, "UTF-8") +
            "&password=" + URLEncoder.encode(password, "UTF-8") +
            "&recipient=" + URLEncoder.encode(recipient, "UTF-8") +
            "&messagetype=SMS:TEXT" +
            "&messagedata=" + URLEncoder.encode(message, "UTF-8") +
            "&originator=" + URLEncoder.encode(originator, "UTF-8") +
            "&serviceprovider=HTTPServer0" +
            "&responseformat=html";



                        URL url = new URL(requestUrl);
                        HttpURLConnection uc = (HttpURLConnection)url.openConnection();

                        System.out.println(uc.getResponseMessage());

                        uc.disconnect();

                } catch(Exception ex) {
                        System.out.println(ex.getMessage());

                }
        }

}

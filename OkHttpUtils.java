package java0.nio02.netty;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class OkHttpUtils {
   
    public static OkHttpClient client = new OkHttpClient();

    
    public static String getAsString(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();
		/*
		 * try (Response response = client.newCall(request).execute()) { return
		 * response.body().string(); }catch(Exception e) { System.out.print(e); }
		 */
        
        Response response = client.newCall(request).execute();
        return response.body().string();
    }


    public static void main(String[] args) throws Exception {

        String url = "https://square.github.io/okhttp/";
        String text = OkHttpUtils.getAsString(url);
        System.out.println("url: " + url + " ; response: \n" + text);

        
        OkHttpUtils.client = null;
    }
}
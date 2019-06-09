package com.bawei.gaochenkai.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.TokenWatcher;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @Auther: 高晨凯
 * @Date: 2019/6/4 09:10:24
 * @Description:
 */
public class HttpUtil {
    //懒汉式单利模式
    private static HttpUtil util;

    private HttpUtil() {
    }

    public static HttpUtil getUtil() {
        if (util == null) {
            return util = new HttpUtil();
        }
        return util;
    }

    //判断网络
    public boolean isNetWork(Context context) {
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getActiveNetworkInfo();
        if (info != null) {
            return info.isAvailable();
        }
        return false;
    }

    //get网络请求
    public String HttpGet(String strurl) {
        try {
            URL url = new URL(strurl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");//请求方式
            connection.setConnectTimeout(5000); //连接超时时间
            connection.setReadTimeout(5000);//读取超时时间
            int code = connection.getResponseCode();//判断网络请求码
            if (code == HttpURLConnection.HTTP_OK) {
                InputStream stream = connection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
                StringBuffer buffer = new StringBuffer();
                String str = "";
                while ((str = reader.readLine()) != null) {
                    buffer.append(str);
                }
                stream.close();
                connection.disconnect();
                return buffer.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //接口
    public interface CCallBackstring {
        void getbackstring(String s);
    }

    public void getAsyncTask(String url, final CCallBackstring backstring) {
        new AsyncTask<String, Integer, String>() {
            @Override
            protected String doInBackground(String... strings) {
                return HttpGet(strings[0]);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                backstring.getbackstring(s);
            }
        }.execute(url);
    }
}

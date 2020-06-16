package com.shw.workdemo.Tools;

import android.app.ProgressDialog;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ProgressBar;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class ImageDownLoadAsyncTask extends AsyncTask<Void,Void, Drawable> {
    private String imagePath;
    private View imageView;
    private static final String SAVE_PATH=GetcontextHpler.getContext().getFilesDir().getAbsolutePath();

    public ImageDownLoadAsyncTask(String imagePath, View imageView) {
        this.imagePath = imagePath;
        this.imageView = imageView;
    }

    @Override
    protected Drawable doInBackground(Void... voids) {
        String filePath=SAVE_PATH+imagePath.substring(imagePath.lastIndexOf("/"));
        File mfile=new File(filePath);
        if(mfile.exists()){
            Bitmap bm= BitmapFactory.decodeFile(filePath);
            BitmapDrawable bd=new BitmapDrawable(Resources.getSystem(),bm);
            return bd;
        }else{
            URL url;
            try{
                url=new URL(imagePath);
                HttpsURLConnection connection=(HttpsURLConnection) url.openConnection();
                connection.setDoInput(true);
                connection.connect();
                InputStream inputStream=connection.getInputStream();
                Bitmap bitmap=BitmapFactory.decodeStream(inputStream);
                BitmapDrawable bd=new BitmapDrawable(Resources.getSystem(),bitmap);
                saveFile(bd,imagePath.substring(imagePath.lastIndexOf("/")));
                return bd;
            }catch (MalformedURLException e){
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return null;
    }

    @Override
    protected void onPostExecute(Drawable drawable) {
        super.onPostExecute(drawable);
        if(drawable!=null){
            imageView.setBackground(drawable);
        }
    }

    private void saveFile(BitmapDrawable bd, String substring) throws IOException {
        File dirFile=new File(SAVE_PATH);
        GetcontextHpler.getContext().getExternalFilesDir(null);
        if(!dirFile.exists()){
            dirFile.mkdirs();
        }
        File myfile=new File(SAVE_PATH+substring);
        BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(myfile));
        Bitmap b=bd.getBitmap();
        b.compress(Bitmap.CompressFormat.JPEG,80,bos); //图片压缩
        bos.flush();
        bos.close();
    }
}

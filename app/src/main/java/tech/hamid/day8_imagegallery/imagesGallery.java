package tech.hamid.day8_imagegallery;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import java.util.ArrayList;

public class imagesGallery {
    @SuppressLint("Recycle")
    public static ArrayList<String> listOfImages(Context context) {
        Uri uri;
        Cursor cursor;
        int column_index_data, Column_index_folder_name;
        ArrayList<String> listOfAllImages = new ArrayList<>();
        String absolutePathOfImages;
        uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;

        String[] projection = { MediaStore.MediaColumns.DATA,
                MediaStore.Images.Media.BUCKET_DISPLAY_NAME };

        String orderBy = MediaStore.Video.Media.DATE_TAKEN;

        cursor = context.getContentResolver().query(uri, projection, null,
                null, orderBy + " DESC");

        column_index_data = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA);

        while (cursor.moveToNext()) {
            absolutePathOfImages = cursor.getString(column_index_data);
            listOfAllImages.add(absolutePathOfImages);
        }
        return listOfAllImages;
    }





}

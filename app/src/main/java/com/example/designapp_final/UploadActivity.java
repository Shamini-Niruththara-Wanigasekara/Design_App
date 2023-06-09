package com.example.designapp_final;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.designapp_final.models.User;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class UploadActivity extends AppCompatActivity {

    EditText updateName, updateEmail;
    ImageView uploadImage;
    Button saveButton;
    private Uri uri;
    private Bitmap bitmapImage;
    UserDatabaseHelper userDatabaseHelper;

    User user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);

        updateEmail = findViewById(R.id.uploadEmail);
        uploadImage = findViewById(R.id.uploadImage);
        updateName = findViewById(R.id.uploadName);
        saveButton = findViewById(R.id.saveButton);
        userDatabaseHelper = new UserDatabaseHelper(this);
        user = userDatabaseHelper.getUser();
        updateEmail.setText(user.getEmail());
        updateName.setText(user.getName());

        byte[] image = user.getImage();
        if(image != null){
            uploadImage.setImageBitmap(BitmapFactory.decodeByteArray(image, 0, image.length));
        }

        ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == Activity.RESULT_OK){
                        Intent data = result.getData();
                        assert data != null;
                        uri = data.getData();
                        try {
                            bitmapImage = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                        } catch (IOException e) {
                            Toast.makeText(UploadActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                        uploadImage.setImageBitmap(bitmapImage);
                    } else {
                        Toast.makeText(UploadActivity.this, "No Image Selected", Toast.LENGTH_SHORT).show();
                    }
                }
        );

        uploadImage.setOnClickListener(view -> {
            try {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                activityResultLauncher.launch(intent);
            } catch (Exception e){
                Toast.makeText(UploadActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        saveButton.setOnClickListener(view -> storeImage());
    }

    private void storeImage(){
        if (!updateName.getText().toString().isEmpty() && !updateEmail.getText().toString().isEmpty()
                && uploadImage.getDrawable() != null && bitmapImage != null){
            user.setEmail(updateEmail.getText().toString());
            user.setName(updateName.getText().toString());

            byte [] image = getBytes(bitmapImage);
            user.setImage(image);
            userDatabaseHelper.updateUser(user);
            Intent intent = new Intent(UploadActivity.this, MainActivity.class);
            startActivity(intent);
        } else {
            Log.d("TAG", "storeImage: " + updateName.getText().toString().isEmpty());
            Log.d("TAG", "storeImage: " + updateEmail.getText().toString().isEmpty());
            Log.d("TAG", "storeImage: " + (uploadImage.getDrawable() == null));
            Log.d("TAG", "storeImage: " + (bitmapImage == null));
            Toast.makeText(this, "Fields are mandatory", Toast.LENGTH_SHORT).show();
        }
    }

    private byte [] getBytes(Bitmap bitmap){
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, stream);
        return stream.toByteArray();
    }
}
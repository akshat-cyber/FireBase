package com.fatdevs.databasefirebase;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.firebase.client.Firebase;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.iid.internal.FirebaseInstanceIdInternal;
import com.squareup.picasso.Picasso;
import java.io.File;
public class MainActivity extends AppCompatActivity {
public static int PICK_IMAGE_REQUEST = 1;
    private Button mChooseFile;
    private Button mUpload;
    private Button mShowUpload;
    private TextView FileName;
    private ProgressBar progressBar;
    private ImageView fileImage;
    private Uri uri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mChooseFile = findViewById(R.id.choose_file_button);
        mShowUpload = findViewById(R.id.show_button);
        mUpload = findViewById(R.id.upload_button);
        FileName = findViewById(R.id.file_name);
        fileImage = findViewById(R.id.imageVie);
        progressBar = findViewById(R.id.progress_horizontal);
mChooseFile.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
               onFileSelection();
    }
});
mUpload.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

    }
});
mShowUpload.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

    }
});
    }
    private void onFileSelection(){
        Intent intent = new Intent(); // new intent created for communication
        intent.setType("image/*");   // sets a path
        Log.i("s#################################################", String.valueOf(intent.setType("image/*")));
        intent.setAction(Intent.ACTION_GET_CONTENT);
       Log.i(" s#################################################", String.valueOf(intent.setAction(Intent.ACTION_GET_CONTENT)));
        // image directory * for any file
       startActivityForResult(intent,PICK_IMAGE_REQUEST);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
if(requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null ){
     uri = data.getData();
     //Picasso.get().load(mImageUri).into(mImageView);
Picasso.get().load(uri).into(fileImage);

}
    }
}
/*
     button  =  findViewById(R.id.dataButton);
     text = findViewById(R.id.editText);

     Firebase.setAndroidContext(this);
     ef = new Firebase("https://possible-sun-270517.firebaseio.com/");
     button.setOnClickListener(new View.OnClickListener() {
         //Name = (String) text.getText();
      @Override

      public void onClick(View v) {
 Firebase efChild = ef.child("Student:");
 efChild.setValue("Name");
      }
  });
    }
}*/
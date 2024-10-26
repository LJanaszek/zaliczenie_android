package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;


public class MainActivity extends AppCompatActivity {
//    public static UpDatabase upDatabase;
//
//    @Override
//    public void onCreate() {
//        super.onCreate();
//        appDatabase = AppDatabase.getDatabase(this);
//    }


    private Button btn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.button);

        UpDatabase upDatabase = UpDatabase.getDatabase(getApplicationContext());

        UserDao userDao = upDatabase.userDao();

        User newuser = new User();
        newuser.id = 1;
        newuser.name = "jan";

//        List<User> users = userDao.getAllUsers();
//        for (User user : users){
//            System.out.println(user.name + user.id);
//        }
        new DatabaseAsyncTask(upDatabase).execute();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Sudents.class);
                startActivity(intent);
            }

        });


    }
    private static class DatabaseAsyncTask extends AsyncTask<Void, Void, List<User>> {
        private final UserDao userDao;

        DatabaseAsyncTask(UpDatabase upDatabase) {
            this.userDao = upDatabase.userDao();
        }

        @Override
        protected List<User> doInBackground(Void... voids) {
            User newUser = new User();
            newUser.id = 1;
            newUser.name = "jan";
            userDao.insert(newUser);


            return userDao.getAllUsers();
        }

        @Override
        protected void onPostExecute(List<User> users) {

            for (User user : users) {
                System.out.println(user.name + " " + user.id);
            }
        }
    }

}
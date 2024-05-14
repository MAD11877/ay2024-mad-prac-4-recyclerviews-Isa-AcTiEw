package sg.edu.np.mad.madpractical4;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Random;

public class ListActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // create the list of 20 users

        ArrayList<User> userList = new ArrayList<User>();
        for (int i =0; i < 20; i++){
            Random random = new Random();
            Integer descriptionId = random.nextInt(99999);
            Integer nameId = random.nextInt(99999);
            Boolean followed = random.nextBoolean();
            String name = "name" + nameId.toString();
            String description = "decription" + descriptionId.toString();
            User user = new User(name,description,nameId,followed);

            userList.add(user);

        }

        // Starting the RecylcerView
        //Add This (RecyclerView)
        UserAdapter userAdapter = new UserAdapter(userList, this);
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(userAdapter);





    }





    public void createDialog(User user){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // Sets the title of the alert dialog
        builder.setTitle("Profile");

        //Sets the message of the alert dialog, block of text content (paragraph)

        builder.setMessage(user.getName());

        // Set the positive button

        builder.setPositiveButton("View", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Intents are used to start activity, broadcast services and more
                // navigate to the profile page using new Intent, from our source (ListActivity) -> (MainActivity) destination activity
                Intent ListToMain = new Intent(ListActivity.this,MainActivity.class);
                // pass data from ListActivity to MainActivity in a bundle
                Bundle extras = new Bundle();
                extras.putString("key1",user.getName());
                extras.putString("key2",user.getDescription());
                extras.putBoolean("key3",user.getFollowed());

                ListToMain.putExtras(extras);
                startActivity(ListToMain);


            }
        });

        // set the negative button
        builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        // show the dialog
        AlertDialog alert = builder.create();
        alert.show();




    }
}
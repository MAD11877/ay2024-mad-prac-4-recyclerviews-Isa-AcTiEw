package sg.edu.np.mad.madpractical4;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.security.SecureRandom;

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
    }


    public void createDialog(Context context){
        // Generate a SecureRandom integer
        SecureRandom secureRandom = new SecureRandom();
        Integer randint = Math.abs(secureRandom.nextInt());
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // Sets the title of the alert dialog
        builder.setTitle("Profile");

        //Sets the message of the alert dialog, block of text content (paragraph)

        builder.setMessage("MADness");

        // Set the positive button

        builder.setPositiveButton("View", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Intents are used to start activity, broadcast services and more
                // navigate to the profile page using new Intent, from our source (ListActivity) -> (MainActivity) destination activity
                Intent ListToMain = new Intent(ListActivity.this,MainActivity.class);
                // pass the variable to the next activity using putExtra() as a key-value pair (map)
                ListToMain.putExtra("1",randint.toString());
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
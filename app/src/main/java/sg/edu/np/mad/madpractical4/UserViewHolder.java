package sg.edu.np.mad.madpractical4;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

// defines the list of views and their position in the recyclerView

// Layout contains tv1 tv2 and img1, you would defined these views here and refrence them when your binding data to each view
public class UserViewHolder extends RecyclerView.ViewHolder {

    TextView name;
    TextView description;

    ImageView smallImg;

    ImageView bigImg;


    public UserViewHolder(@NonNull View itemView) {
        super(itemView);
        //Locations of image, name and description found in custom_activity_list.xml
        name = itemView.findViewById(R.id.usName);
        description = itemView.findViewById(R.id.usDesc);
        smallImg = itemView.findViewById(R.id.smallImg);
        bigImg = itemView.findViewById(R.id.bigImg);
    }
}

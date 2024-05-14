package sg.edu.np.mad.madpractical4;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter <UserViewHolder> {

    private ArrayList<User> userList;
    private ListActivity activity;


    // Constructor for viewAdapter class (pass the data (ArrayList) and the activity)
    public UserAdapter(ArrayList<User> userList, ListActivity activity){
        this.userList = userList;
        this.activity = activity;

    }


    @NonNull
    @Override
    // inflates the view, gets the layout for the recyclerView does not contain any data yet
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // retrives the layout for the recyclerView
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_activity_list, parent, false);
        UserViewHolder holder = new UserViewHolder(view);
        return holder;



    }

    @Override
    // implments the data or content defined for the ViewHolder layout
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
       User user = userList.get(position);
       holder.name.setText(user.getName());
       holder.description.setText(user.getDescription());

       if(user.name.endsWith("7")){
           holder.bigImg.setVisibility(View.VISIBLE);
       }

       holder.bigImg.setVisibility(View.GONE);

       // EventHandling when smallImg is clicked and then display an alertDialog
       holder.smallImg.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
                // use the createDialog() defined in ListActivity class
                activity.createDialog(user);
           }
       });





    }

    @Override
    // retrives the number of items in the dataset
    public int getItemCount() {
        return userList.size();
    }
}

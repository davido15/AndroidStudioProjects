package Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hi.recycleview.R;

import java.util.List;

import Model.ListItem;

/**
 * Created by Davido17 on 6/23/2018.
 */

public class myAdapter extends RecyclerView.Adapter<myAdapter.ViewHolder> {
    private Context context;
    private List <ListItem> ListItems;
    public myAdapter(Context context, List listitem){
        this.context= context;
        this.ListItems= listitem;

    }


    @Override
    public myAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(myAdapter.ViewHolder holder, int position) {
        ListItem Item = ListItems.get(position);
holder.name.setText(Item.getName());
        holder.description.setText(Item.getDescription());
    }

    @Override
    public int getItemCount()
    {
        return ListItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public TextView description;
        public ViewHolder(View itemView) {
            super(itemView);
            name =(TextView) itemView.findViewById(R.id.title);
            description =(TextView) itemView.findViewById(R.id.description);
        }
    }
}

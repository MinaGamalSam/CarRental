package carRent.com;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public class Adapter_Rec_ForClient extends RecyclerView.Adapter<ViewHolderForClient>  {
    Context mcontext;
    ArrayList<item_forClient> items;

    public Adapter_Rec_ForClient(Context mcontext, ArrayList<item_forClient> items) {
        this.mcontext = mcontext;
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolderForClient onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mcontext).inflate(R.layout.item_rec_for_donor,null);
        return new ViewHolderForClient(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderForClient viewHolderForClient, final int i) {
        viewHolderForClient.tv_desc.setText(items.get(i).getDescription());
        viewHolderForClient.title.setText(items.get(i).getTitle());
        viewHolderForClient.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Intent intent = new Intent(mcontext,post.class);
                intent.putExtra("title",items.get(i).getTitle());
                intent.putExtra("description",items.get(i).getDescription());
                mcontext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}

package carRent.com;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

class ViewHolderForClient extends RecyclerView.ViewHolder implements View.OnClickListener {
    TextView title,tv_desc;
    ItemClickListener itemClickListener ;
    public ViewHolderForClient(@NonNull View itemView) {
        super(itemView);
        tv_desc = itemView.findViewById(R.id.tv_desc);
        title = itemView.findViewById(R.id.tv_title);
        itemView.setOnClickListener(this);
    }
    public void setItemClickListener(ItemClickListener ic) {
        this.itemClickListener = ic;
    }

    @Override
    public void onClick(View v) {
        this.itemClickListener.onItemClick(v,getLayoutPosition());

    }
}

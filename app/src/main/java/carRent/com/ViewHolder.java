package carRent.com;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    TextView  coastPerDay, seatsNum, carBrand,carCategory, carTransmission;
    ImageView call,carPhoto;
    ItemClickListener itemClickListener;
    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        carBrand=itemView.findViewById(R.id.carBrand);
        carCategory=itemView.findViewById(R.id.category);
        call = itemView.findViewById(R.id.call);
        coastPerDay = itemView.findViewById(R.id.price);
        seatsNum = itemView.findViewById(R.id.seats);
        carTransmission = itemView.findViewById(R.id.transmission);
        carPhoto = itemView.findViewById(R.id.car_photo);
        call.setOnClickListener(this);
    }


    public void setItemClickListener(ItemClickListener ic) {
        this.itemClickListener = ic;
    }

    @Override
    public void onClick(View v) {
        this.itemClickListener.onItemClick(v,getLayoutPosition());
    }
}
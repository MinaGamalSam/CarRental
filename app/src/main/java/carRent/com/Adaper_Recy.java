package carRent.com;
import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Adaper_Recy extends RecyclerView.Adapter<ViewHolder> {

    Context mcontext;
    ArrayList<Client> items ;
    String  phoneNumber;
    public Adaper_Recy(Context mcontext, ArrayList<Client> items) {
        this.mcontext = mcontext;
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(mcontext).inflate(R.layout.item_search,null);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int i) {
        //holder.name.setText(items.get(i).getName());

        holder.carBrand.setText(items.get(i).getcarBrand());
        holder.carCategory.setText(items.get(i).getCarCategory());
        holder.coastPerDay.setText(items.get(i).getCoastPerDay());
        holder.seatsNum.setText(items.get(i).getSeatsNum());


        Picasso.get().load(items.get(i).getcarPhotoUrl()).into(holder.carPhoto);

        if(items.get(i).getcarTransmission().equals("Automatic")){
            holder.carTransmission.setText("A");
        }else {
            holder.carTransmission.setText("M");
        }

        phoneNumber = items.get(i).getPhoneNumber();

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                if (ContextCompat.checkSelfPermission(mcontext, Manifest.permission.CALL_PHONE)== PackageManager.PERMISSION_GRANTED) {
                    call(phoneNumber);
                }else {
                    Toast.makeText(mcontext, "please do permission for call", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
    public void call(String PhoneNumber) {
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:" + PhoneNumber));
        mcontext.startActivity(callIntent);

    }
}

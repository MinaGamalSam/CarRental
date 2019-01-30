package carRent.com;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class post extends AppCompatActivity {

    TextView aboutUs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        aboutUs = findViewById(R.id.aboutUs);
        aboutUs.setText("CarRental facilitates bookings for car rental services. It's not" +
                " own or operate any car rental companies. Your contract for car rental will be between" +
                " you and the car rental supplier. The terms and conditions of the rental agreement between " +
                "you and the car rental supplier are available on this booking engine when you select the car " +
                "rental supplier type and insert the other relevant information."+ "\n" + "\n"

                + " CarRental makes no warranty or" +
                " representation in relation to any rental car rental supplier or any car rented by any car" +
                " rental supplier. It is the car rental supplier’s sole responsibility to provide you with a" +
                " rental car rented through this booking engine" + "\n" + "\n"

                + "It is the responsibility of the car rental supplier to process your reservation correctly." +
                " The accuracy of any quote for renting a car provided by this booking engine and any booking " +
                "made on this booking engine depends on the details you provide on this booking engine." + "\n" + "\n"

                + "While CarRental endeavours to ensure that the booking engine is normally available 24 hours a day," +
                " CarRental shall not be liable if for any reason the booking engine is unavailable at any time " +
                "or for any period. Access to the booking engine may be suspended temporarily and without notice " +
                "in the case of system failure, maintenance or repair or for reasons beyond CarRental’s control." + "\n" + "\n"

                + "CarRental hereby excludes to the fullest extent permitted by law any warranties (whether express or implied)," +
                " as to the quality, completeness, performance or fitness for a particular purpose of (i) any car rental booked through" +
                " this booking engine and (ii) this booking engine and any of its contents, including,"+ "\n" + "\n"
                +
                "but not limited to, " +
                "any information relating to car rental supplier rentals contained within this booking engine and the technology" +
                " supporting and provided on this booking engine. CarRental reserves the right to make alterations to the booking " +
                "engine at any time. The information on this booking engine is updated from time to time. By using this booking engine" +
                " you acknowledge that the rental details and all other information including, but not limited to, information " +
                "relating to travel and holidays published on this booking engine may include inaccuracies or typographical errors.");

    }


    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            startActivity(new Intent(post.this, MainActivity.class));
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(post.this, MainActivity.class));
        finish();

    }
}

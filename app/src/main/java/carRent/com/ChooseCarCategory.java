package carRent.com;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.TextView;

public class ChooseCarCategory extends AppCompatActivity {
    RecyclerView rec_ForChoose;
    TextView privacy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_car_category);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        privacy = findViewById(R.id.privacyText);
        privacy.setText("This legal notice applies to the entire contents of this booking engine. " +
                "Please take some time to read these Terms and Conditions of Use (‘Terms of Use’)" +
                " as by using this booking engine you indicate your acceptance of these Terms of Use " +
                "regardless of whether or not you choose to register with us. If you do not accept these " +
                "terms, do not use this booking engine. By using any part of the booking engine, you shall " +
                "be deemed to have accepted this legal notice in full. Stop using this booking engine " +
                "immediately if you do not accept and agree to be bound by the terms of use." + "\n" + "\n"

                + "This booking engine is powered by CarRental’s technology and allows you to use" +
                " CarRental’s technology to book car rental services from third part car rental " +
                "suppliers. By accepting the Terms of Use and/or using any part of this booking engine," +
                " you agree to conduct your use of this booking engine and the technology supporting it " +
                "and provided on this booking engine in accordance with the Terms of Use and that the Terms of" +
                " Use are an agreement between CarRental and you." + "\n" + "\n"

                + "CarRental may revise this legal notice at any time by updating this posting. You should check" +
                "the booking engine from time to time to review the then current legal notice, because it is binding" +
                " on you. Certain provisions of this legal notice may be superseded by expressly designated legal notices" +
                " or terms located on particular pages at the booking engine." + "\n" + "\n"

                + "All references to booking engine in these Terms of Use are deemed to include reference to all bookings made through" +
                " CarRental’s call centre."+ "\n" + "\n"

                +"By using this booking engine you confirm that you are of sufficient legal age to use this booking engine and create binding " +
                "legal obligations for any liability you may incur as a result of the use of this booking engine. In using this booking engine" +
                " you understand that you are responsible, financially and otherwise, for all uses of this booking engine by you and those using" +
                " your login information. CarRental recommend you protect your login information.");

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            startActivity(new Intent(ChooseCarCategory.this, MainActivity.class));
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(ChooseCarCategory.this, MainActivity.class));
        finish();
    }
}
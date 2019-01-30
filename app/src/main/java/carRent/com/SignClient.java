package carRent.com;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.MimeTypeMap;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import net.rimoto.intlphoneinput.IntlPhoneInput;

import java.util.ArrayList;

import static android.support.constraint.Constraints.TAG;


/**
 * A simple {@link Fragment} subclass.
 */
public class SignClient extends Fragment {
    DatabaseReference myreference;
    StorageReference mStorageRef;
    String name, numOfSeats, number, coastPerDay, carTransition, carBrand, phoneNumber,nameOfCountry, nameOfCities,carCategory ;
    ArrayList<String> numbers;
    EditText et_nameDonor, et_coastPerDay, et_carBrand;
    IntlPhoneInput inputphoneNumber;
    Button btn_sinUp, btn_24h, btn_loadPhoto;
    Spinner spinner_country, spinner_cities, spinner_carCategory, spinner_passengersNum, spinner_carTransition;
    ArrayAdapter adapter_country, adapter_cities, adapter_CarCategory, adapter_seats, adapter_transition;
    String[] country, cities, carCategoryArray, transition, seatsArray;
    public static Uri imageUri;
    public static String carPhotoUrl, s;
    private ImageView car_imageView;
    public Bitmap bitmaps = null;
    private static final int PHOTOREQ = 0;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_sign_donor, container, false);
        numbers = new ArrayList<>();
        findViewById();
        setSpinnerCountry();
        setSpinnerCities();
        setSpinnerCarCategory();
        setSpinnertransition();
        setSpinnerPassengersNum();
        imageUri=null;
        btn_loadPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                takePhotos();
            }
        });
        et_nameDonor.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                getNumbers();
                return false;
            }
        });
        et_nameDonor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getNumbers();
            }
        });
        inputphoneNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getNumbers();
            }
        });
        btn_sinUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sinUpDonor();


            }
        });
        return view;
    }


    public void findViewById() {
        try {
            //SimUp
            car_imageView = view.findViewById(R.id.car_photo);
            btn_loadPhoto = view.findViewById(R.id.carImage);
            btn_sinUp = view.findViewById(R.id.btn_sinUp);
            et_nameDonor = view.findViewById(R.id.et_name);
            et_coastPerDay = view.findViewById(R.id.et_coastPerDay);
            et_carBrand = view.findViewById(R.id.carBrand);
            inputphoneNumber = view.findViewById(R.id.inputphoneNumber);
            spinner_carTransition = view.findViewById(R.id.carTransition);
            spinner_passengersNum = view.findViewById(R.id.passengers);
            spinner_country = view.findViewById(R.id.country);
            cities = getResources().getStringArray(R.array.Egypt);
            spinner_cities = view.findViewById(R.id.city);
            spinner_carCategory = view.findViewById(R.id.bloodType);
        } catch (Exception e) {

        }

    }

    public void setSpinnerCountry() {
        try {
            country = getResources().getStringArray(R.array.country);
            adapter_country = new ArrayAdapter(getActivity(), R.layout.spinner, country);
            spinner_country.setAdapter(adapter_country);
            spinner_country.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    nameOfCountry = country[position];
                    if (nameOfCountry == country[0]) {
                        cities = getResources().getStringArray(R.array.defaultCity);
                        setSpinnerCities();
                    } else if (nameOfCountry == country[1]) {
                        cities = getResources().getStringArray(R.array.Egypt);
                        setSpinnerCities();
                    } else if (nameOfCountry == country[2]) {
                        cities = getResources().getStringArray(R.array.Jordan);
                        setSpinnerCities();
                    } else if (nameOfCountry == country[3]) {
                        cities = getResources().getStringArray(R.array.Emirates);
                        setSpinnerCities();
                    } else if (nameOfCountry == country[4]) {
                        cities = getResources().getStringArray(R.array.Bahrain);
                        setSpinnerCities();
                    } else if (nameOfCountry == country[5]) {
                        cities = getResources().getStringArray(R.array.Algeria);
                        setSpinnerCities();
                    } else if (nameOfCountry == country[6]) {
                        cities = getResources().getStringArray(R.array.SaudiArabia);
                        setSpinnerCities();
                    } else if (nameOfCountry == country[7]) {
                        cities = getResources().getStringArray(R.array.Sudan);
                        setSpinnerCities();
                    } else if (nameOfCountry == country[8]) {
                        cities = getResources().getStringArray(R.array.Somalia);
                        setSpinnerCities();
                    } else if (nameOfCountry == country[9]) {
                        cities = getResources().getStringArray(R.array.Iraq);
                        setSpinnerCities();
                    } else if (nameOfCountry == country[10]) {
                        cities = getResources().getStringArray(R.array.Kuwait);
                        setSpinnerCities();
                    } else if (nameOfCountry == country[11]) {
                        cities = getResources().getStringArray(R.array.Morocco);
                        setSpinnerCities();
                    } else if (nameOfCountry == country[12]) {
                        cities = getResources().getStringArray(R.array.Yemen);
                        setSpinnerCities();
                    } else if (nameOfCountry == country[13]) {
                        cities = getResources().getStringArray(R.array.Turkey);
                        setSpinnerCities();
                    } else if (nameOfCountry == country[14]) {
                        cities = getResources().getStringArray(R.array.Tunisia);
                        setSpinnerCities();
                    } else if (nameOfCountry == country[15]) {
                        cities = getResources().getStringArray(R.array.islands_of_the_moon);
                        setSpinnerCities();
                    } else if (nameOfCountry == country[16]) {
                        cities = getResources().getStringArray(R.array.Comoros);
                        setSpinnerCities();
                    } else if (nameOfCountry == country[17]) {
                        cities = getResources().getStringArray(R.array.Djibouti);
                        setSpinnerCities();
                    } else if (nameOfCountry == country[18]) {
                        cities = getResources().getStringArray(R.array.Syria);
                        setSpinnerCities();
                    } else if (nameOfCountry == country[19]) {
                        cities = getResources().getStringArray(R.array.Oman);
                        setSpinnerCities();
                    } else if (nameOfCountry == country[20]) {
                        cities = getResources().getStringArray(R.array.Palestine);
                        setSpinnerCities();
                    } else if (nameOfCountry == country[21]) {
                        cities = getResources().getStringArray(R.array.Qatar);
                        setSpinnerCities();
                    } else if (nameOfCountry == country[22]) {
                        cities = getResources().getStringArray(R.array.Lebanon);
                        setSpinnerCities();
                    } else if (nameOfCountry == country[23]) {
                        cities = getResources().getStringArray(R.array.Libya);
                        setSpinnerCities();
                    } else if (nameOfCountry == country[24]) {
                        cities = getResources().getStringArray(R.array.Mauritania);
                        setSpinnerCities();
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        } catch (Exception e) {

        }
    }

    public void setSpinnerCities() {
        try {
            adapter_cities = new ArrayAdapter(getActivity(), R.layout.spinner, cities);
            spinner_cities.setAdapter(adapter_cities);
            spinner_cities.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    if (position != 0) {
                        nameOfCities = cities[position];
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        } catch (Exception e) {

        }
    }

    public void setSpinnerCarCategory() {
        try {
            carCategoryArray = getResources().getStringArray(R.array.carCategory);
            adapter_CarCategory = new ArrayAdapter(getActivity(), R.layout.spinner, carCategoryArray);
            spinner_carCategory.setAdapter(adapter_CarCategory);
            spinner_carCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    if (position != 0) {
                        carCategory = carCategoryArray[position];
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        } catch (Exception e) {

        }
    }

    public void setSpinnerPassengersNum() {
        try {
            seatsArray = getResources().getStringArray(R.array.seats);
            adapter_seats = new ArrayAdapter(getActivity(), R.layout.spinner, seatsArray);
            spinner_passengersNum.setAdapter(adapter_seats);
            spinner_passengersNum.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    if (position != 0) {
                        numOfSeats = seatsArray[position];
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        } catch (Exception e) {

        }
    }


    public void setSpinnertransition() {
        try {
            transition = getResources().getStringArray(R.array.carTransition);
            adapter_transition = new ArrayAdapter(getActivity(), R.layout.spinner, transition);
            spinner_carTransition.setAdapter(adapter_transition);
            spinner_carTransition.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    if (position != 0) {
                        carTransition = transition[position];
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        } catch (Exception e) {

        }
    }

    public static final int PICK_IMAGE = 1;


    private String getFileExtension(Uri uri) {
        ContentResolver cR = getActivity().getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(cR.getType(uri));

    }

    public void takePhotos() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PICK_IMAGE && resultCode == Activity.RESULT_OK
                && data != null && data.getData() != null) {

            imageUri = data.getData();

        }
    }


    public void uploadFile() {

        if (imageUri != null) {


            final ProgressDialog progressDialog = new ProgressDialog(getActivity());
            progressDialog.show();
            mStorageRef = FirebaseStorage.getInstance().getReference("car_info").child(nameOfCountry).child(nameOfCities)
                    .child(carCategory);


            mStorageRef.child(System.currentTimeMillis()
                    + "." + getFileExtension(imageUri)).putFile(imageUri)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            carPhotoUrl = taskSnapshot.getDownloadUrl().toString();
                            myreference = FirebaseDatabase.getInstance().getReference("car_info").child(nameOfCountry).child(nameOfCities).child(carCategory);


                            Client client = new Client(name, phoneNumber, coastPerDay, numOfSeats, carBrand, carCategory, carTransition, carPhotoUrl);


                            myreference.push().setValue(client);

                            AlertDialog();

                            progressDialog.dismiss();


                            Toast.makeText(getActivity(), "Upload successful", Toast.LENGTH_LONG).show();

                        }

                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            progressDialog.dismiss();
                            Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                    int progress = (int) ((100.0 * taskSnapshot.getBytesTransferred()) / taskSnapshot.getTotalByteCount());
                    progressDialog.setMessage(progress + "");
                }
            });
            


        } else {
            Toast.makeText(getActivity(), "No file selected", Toast.LENGTH_SHORT).show();
        }


    }


    public void sinUpDonor() {
        try {
            final android.app.AlertDialog alertDialog = new AlertDialog.Builder(getActivity()).create();
            coastPerDay = et_coastPerDay.getText().toString();
            name = et_nameDonor.getText().toString();


            carBrand = et_carBrand.getText().toString();
            if (MainActivity.connected(getActivity())) {
                if (!name.equals("")) {
                    if (spinner_country.getSelectedItemPosition() != 0) {
                        if (spinner_cities.getSelectedItemPosition() != 0) {
                            if (spinner_carCategory.getSelectedItemPosition() != 0) {
                                if (inputphoneNumber.isValid()) {
                                    phoneNumber = inputphoneNumber.getNumber();
                                    if (chickNumberPhone()) {
                                        if (!coastPerDay.equals("")) {
                                            if (!carBrand.equals("")) {
                                            if (imageUri!=null) {

                                                uploadFile();

                                            } else {
                                                alertDialog.setMessage("please select the car photo");
                                                alertDialog.show();
                                            }

                                            } else {
                                                alertDialog.setMessage("please choose the car brand");
                                                alertDialog.show();
                                            }
                                        } else {
                                            alertDialog.setMessage("please enter the coast per day");
                                            alertDialog.show();
                                        }
                                    } else {
                                        alertDialog.setMessage("This number already exists");
                                        alertDialog.show();
                                    }
                                } else {
                                    alertDialog.setMessage("Please check the phone number");
                                    alertDialog.show();
                                }
                            } else {
                                Toast.makeText(getActivity(), "please choose the car category", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(getActivity(), "please choose the city", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(getActivity(), "please choose the country", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    alertDialog.setMessage("Enter Your Name");
                    alertDialog.show();
                }
            } else {
                Toast.makeText(getActivity(), "check your internet connection", Toast.LENGTH_SHORT).show();
            }

        } catch (Exception e) {

        }

    }

    public boolean chickNumberPhone() {
        try {
            getNumbers();
            for (String number : numbers) {
                long num1 = Long.parseLong(number);
                long num2 = Long.parseLong(phoneNumber);
                if (num1 == num2) {
                    return false;
                }

            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private void getNumbers() {
        try {
            if (spinner_country.getSelectedItemPosition() != 0) {
                if (spinner_cities.getSelectedItemPosition() != 0) {
                    if (spinner_carCategory.getSelectedItemPosition() != 0) {
                        myreference = FirebaseDatabase.getInstance().getReference("car_info").child(nameOfCountry).child(nameOfCities).child(carCategory);
                        myreference.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                numbers.clear();
                                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                                    number = snapshot.child("phoneNumber").getValue(String.class);
                                    numbers.add(number);
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                            }
                        });
                    } else {
                    }
                } else {
                }
            } else {
            }
        } catch (Exception e) {
            Log.e(TAG, "getNumbers: ", e);
        }
    }

    private void AlertDialog() {
        AlertDialog alertDialog = new AlertDialog.Builder(getActivity()).create();
        View v = getLayoutInflater().inflate(R.layout.alertdilog_after_signup, null);
        alertDialog.setView(v);
        alertDialog.show();
        ImageView img_1;
        img_1 = v.findViewById(R.id.img_1);
        img_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), ChooseCarCategory.class));
                getActivity().finish();
            }
        });
    }

}

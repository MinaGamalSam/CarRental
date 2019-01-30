package carRent.com;



public class Client {

    private String name ,
            phoneNumber ,coastPerDay,seatsNum,carBrand,carTransmission,carCategory;


    private String carPhotoUrl;

    public Client() {
    }

    public Client(String name, String phoneNumber, String coastPerDay, String seatsNum, String carBrand, String carCategory, String carTransmission, String carPhotoUrl) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.coastPerDay = coastPerDay;
        this.seatsNum = seatsNum;
        this.carBrand = carBrand;
        this.carTransmission = carTransmission;
        this.carPhotoUrl=carPhotoUrl;
        this.carCategory=carCategory;
    }


    public String getCoastPerDay() {
        return coastPerDay;
    }

    public String getCarCategory() {
        return carCategory;
    }

    public String getSeatsNum() {
        return seatsNum;
    }

    public String getcarBrand() {
        return carBrand;
    }

    public String getcarTransmission() {
        return carTransmission;
    }

    public String getcarPhotoUrl() {
        return carPhotoUrl;
    }

    public String getName() {
        return name;
    }



    public String getPhoneNumber() {
        return phoneNumber;
    }


}

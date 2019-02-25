package object.materialLot;

public class OriginPlace {

    private String province;
    private String city;

    public OriginPlace(String province,String city) {

        this.province = province;
        this.city = city;
    }

    public String toString() {
        return "OriginPlace{" +
                "province='" + province + '\'' +
                "city='" + city + '\'' +

                '}';
    }
}

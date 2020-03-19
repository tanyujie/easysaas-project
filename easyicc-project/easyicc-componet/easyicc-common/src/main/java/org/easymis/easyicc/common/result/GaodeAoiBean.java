package org.easymis.easyicc.common.result;

//高德Aoi信息
public class GaodeAoiBean {

    private String poiid;
    private String name;
    private String tel;
    private DituPoint location;

    private String province;
    private String city;
    private String district;
    private String address;
    private String type_big;
    private String type_middle;
    private String type_small;


    private String direction;

    private String businessarea;

    private String shape; //围栏gps信息
    private String area; //面积
    private String pic_cover; //封面图片
    private String description; //描述


    public String getPoiid() {
        return poiid;
    }

    public void setPoiid(String poiid) {
        this.poiid = poiid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public DituPoint getLocation() {
        return location;
    }

    public void setLocation(DituPoint location) {
        this.location = location;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType_big() {
        return type_big;
    }

    public void setType_big(String type_big) {
        this.type_big = type_big;
    }

    public String getType_middle() {
        return type_middle;
    }

    public void setType_middle(String type_middle) {
        this.type_middle = type_middle;
    }

    public String getType_small() {
        return type_small;
    }

    public void setType_small(String type_small) {
        this.type_small = type_small;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getBusinessarea() {
        return businessarea;
    }

    public void setBusinessarea(String businessarea) {
        this.businessarea = businessarea;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getPic_cover() {
        return pic_cover;
    }

    public void setPic_cover(String pic_cover) {
        this.pic_cover = pic_cover;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public class DituPoint {
        private double lat;
        private double lon;

        public double getLat() {
            return lat;
        }

        public void setLat(double lat) {
            this.lat = lat;
        }

        public double getLon() {
            return lon;
        }

        public void setLon(double lon) {
            this.lon = lon;
        }
    }

}

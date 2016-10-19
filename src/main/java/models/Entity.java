
package models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.List;

@Generated("org.jsonschema2pojo")
public class Entity {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("index")
    @Expose
    private int index;
    @SerializedName("guid")
    @Expose
    private String guid;
    @SerializedName("isActive")
    @Expose
    private boolean isActive;
    @SerializedName("balance")
    @Expose
    private String balance;
    @SerializedName("picture")
    @Expose
    private String picture;
    @SerializedName("age")
    @Expose
    private int age;
    @SerializedName("eyeColor")
    @Expose
    private String eyeColor;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("company")
    @Expose
    private String company;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("about")
    @Expose
    private String about;
    @SerializedName("registered")
    @Expose
    private String registered;
    @SerializedName("latitude")
    @Expose
    private double latitude;
    @SerializedName("longitude")
    @Expose
    private double longitude;
    @SerializedName("tags")
    @Expose
    private List<String> tags = new ArrayList<String>();
    @SerializedName("friends")
    @Expose
    private List<Friend> friends = new ArrayList<Friend>();
    @SerializedName("greeting")
    @Expose
    private String greeting;
    @SerializedName("favoriteFruit")
    @Expose
    private String favoriteFruit;

    /**
     * 
     * @return
     *     The id
     */
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The _id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The index
     */
    public int getIndex() {
        return index;
    }

    /**
     * 
     * @param index
     *     The index
     */
    public void setIndex(int index) {
        this.index = index;
    }

    /**
     * 
     * @return
     *     The guid
     */
    public String getGuid() {
        return guid;
    }

    /**
     * 
     * @param guid
     *     The guid
     */
    public void setGuid(String guid) {
        this.guid = guid;
    }

    /**
     * 
     * @return
     *     The isActive
     */
    public boolean isIsActive() {
        return isActive;
    }

    /**
     * 
     * @param isActive
     *     The isActive
     */
    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    /**
     * 
     * @return
     *     The balance
     */
    public String getBalance() {
        return balance;
    }

    /**
     * 
     * @param balance
     *     The balance
     */
    public void setBalance(String balance) {
        this.balance = balance;
    }

    /**
     * 
     * @return
     *     The picture
     */
    public String getPicture() {
        return picture;
    }

    /**
     * 
     * @param picture
     *     The picture
     */
    public void setPicture(String picture) {
        this.picture = picture;
    }

    /**
     * 
     * @return
     *     The age
     */
    public int getAge() {
        return age;
    }

    /**
     * 
     * @param age
     *     The age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * 
     * @return
     *     The eyeColor
     */
    public String getEyeColor() {
        return eyeColor;
    }

    /**
     * 
     * @param eyeColor
     *     The eyeColor
     */
    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    /**
     * 
     * @return
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     *     The gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * 
     * @param gender
     *     The gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * 
     * @return
     *     The company
     */
    public String getCompany() {
        return company;
    }

    /**
     * 
     * @param company
     *     The company
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * 
     * @return
     *     The email
     */
    public String getEmail() {
        return email;
    }

    /**
     * 
     * @param email
     *     The email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 
     * @return
     *     The phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 
     * @param phone
     *     The phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 
     * @return
     *     The address
     */
    public String getAddress() {
        return address;
    }

    /**
     * 
     * @param address
     *     The address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 
     * @return
     *     The about
     */
    public String getAbout() {
        return about;
    }

    /**
     * 
     * @param about
     *     The about
     */
    public void setAbout(String about) {
        this.about = about;
    }

    /**
     * 
     * @return
     *     The registered
     */
    public String getRegistered() {
        return registered;
    }

    /**
     * 
     * @param registered
     *     The registered
     */
    public void setRegistered(String registered) {
        this.registered = registered;
    }

    /**
     * 
     * @return
     *     The latitude
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * 
     * @param latitude
     *     The latitude
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    /**
     * 
     * @return
     *     The longitude
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * 
     * @param longitude
     *     The longitude
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    /**
     * 
     * @return
     *     The tags
     */
    public List<String> getTags() {
        return tags;
    }

    /**
     * 
     * @param tags
     *     The tags
     */
    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    /**
     * 
     * @return
     *     The friends
     */
    public List<Friend> getFriends() {
        return friends;
    }

    /**
     * 
     * @param friends
     *     The friends
     */
    public void setFriends(List<Friend> friends) {
        this.friends = friends;
    }

    /**
     * 
     * @return
     *     The greeting
     */
    public String getGreeting() {
        return greeting;
    }

    /**
     * 
     * @param greeting
     *     The greeting
     */
    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    /**
     * 
     * @return
     *     The favoriteFruit
     */
    public String getFavoriteFruit() {
        return favoriteFruit;
    }

    /**
     * 
     * @param favoriteFruit
     *     The favoriteFruit
     */
    public void setFavoriteFruit(String favoriteFruit) {
        this.favoriteFruit = favoriteFruit;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(index).append(guid).append(isActive).append(balance).append(picture).append(age).append(eyeColor).append(name).append(gender).append(company).append(email).append(phone).append(address).append(about).append(registered).append(latitude).append(longitude).append(tags).append(friends).append(greeting).append(favoriteFruit).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Entity) == false) {
            return false;
        }
        Entity rhs = ((Entity) other);
        return new EqualsBuilder().append(id, rhs.id).append(index, rhs.index).append(guid, rhs.guid).append(isActive, rhs.isActive).append(balance, rhs.balance).append(picture, rhs.picture).append(age, rhs.age).append(eyeColor, rhs.eyeColor).append(name, rhs.name).append(gender, rhs.gender).append(company, rhs.company).append(email, rhs.email).append(phone, rhs.phone).append(address, rhs.address).append(about, rhs.about).append(registered, rhs.registered).append(latitude, rhs.latitude).append(longitude, rhs.longitude).append(tags, rhs.tags).append(friends, rhs.friends).append(greeting, rhs.greeting).append(favoriteFruit, rhs.favoriteFruit).isEquals();
    }

}

package de.codecentric.psd.worblehat.web.formdata;

/**
 * Created by vagrant on 3/13/17.
 */
public class UserBookListData {

    private String email;

    public UserBookListData(String email) {
        this.email = email;
    }

    public UserBookListData() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

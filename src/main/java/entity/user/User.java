package entity.user;

import entity.db.CapstoneDB;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;

public class User {

    private int id;
    private String name;
    private String email;
    private String phone;
    private Timestamp createTime;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public java.lang.String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public User(int id, String name, String email, String phone, Timestamp createTime) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.createTime = createTime;
    }

    public User() {
    }

    public User getUserById(int id) throws SQLException {
        try {
            String sql = "SELECT * FROM user " + "where id=" + id + ";";
            Statement stm = CapstoneDB.getConnection().createStatement();
            try (ResultSet res = stm.executeQuery(sql)) {
                if (res.next()) {
                    return new User(res.getInt("id"), res.getString("name"), res.getString("email"), res.getString("phone"), res.getTimestamp("create_time"));
                }
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

}

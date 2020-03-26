package com.rain.sparrow.system.org.user.entity;

import com.rain.sparrow.common.annotation.check.NotNull;
import org.apache.ibatis.type.Alias;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;



@Entity
@Table(name = "t_s_user")
@Alias(value = "TSUser")
public class TSUser {

    /**主键*/
    private String id;
    /**帐户状态[01正常使用]*/
    private String accountState;
    /**手机号*/
    @NotNull
    private String mobilePhone;
    /**匿名*/
    @NotNull
    private String nickName;
    /**密码*/
    @NotNull
    private String password;
    /**真实姓名*/
    @NotNull
    private String realName;
    /**用户名*/
    @NotNull
    private String userName;
    /**电子邮箱*/
    @NotNull
    private String email;

    @Id
    @GeneratedValue(generator = "paymentableGenerator")
    @GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
    @Column(name ="ID",nullable=false,length=36)
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    @Column(name ="mobile_phone")
    public String getMobilePhone() {
        return mobilePhone;
    }
    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }
    @Column(name ="nick_name")
    public String getNickName() {
    return nickName;
    }
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    @Column(name ="password")
    public String getPassword() {
    return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    @Column(name ="real_name")
    public String getRealName() {
    return realName;
    }
    public void setRealName(String realName) {
        this.realName = realName;
    }
    @Column(name ="user_name")
    public String getUserName() {
    return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    @Column(name ="account_state")
    public String getAccountState() {
        return accountState;
    }
    public void setAccountState(String accountState) {
        this.accountState = accountState;
    }
    @Column(name ="email")
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

}

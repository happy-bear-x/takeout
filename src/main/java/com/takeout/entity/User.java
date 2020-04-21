package com.takeout.entity;

import java.util.Date;

public class User {
    private Integer id;

    private String name;

    private String psw;

    private Date birth;

    private String headpic;

    private Date regtime;

    private Boolean type;

    private Byte sex;

    private String nicname;

    private String average;

    private String tel;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw == null ? null : psw.trim();
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getHeadpic() {
        return headpic;
    }

    public void setHeadpic(String headpic) {
        this.headpic = headpic == null ? null : headpic.trim();
    }

    public Date getRegtime() {
        return regtime;
    }

    public void setRegtime(Date regtime) {
        this.regtime = regtime;
    }

    public Boolean getType() {
        return type;
    }

    public void setType(Boolean type) {
        this.type = type;
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public String getNicname() {
        return nicname;
    }

    public void setNicname(String nicname) {
        this.nicname = nicname == null ? null : nicname.trim();
    }

    public String getAverage() {
        return average;
    }

    public void setAverage(String average) {
        this.average = average == null ? null : average.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return "["+id+","+name+nicname+"]";
    }
}
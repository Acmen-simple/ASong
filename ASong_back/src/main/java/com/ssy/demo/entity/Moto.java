package com.ssy.demo.entity;


import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "moto", schema = "ssy")
public class Moto{
    //主键id
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //车型
    @Basic
    @Column(name = "moto_model")
    private String motoModel;
    //价格
    @Basic
    @Column(name = "moto_price")
    private Double motoPrice;
    //上架时间
    @Basic
//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @Column(name = "moto_sale_time")
    private Date motoSaleTime;
    //排量（单位cc）
    @Basic
    @Column(name = "moto_displacement")
    private Integer motoDisplacement;
    //缸数
    @Basic
    @Column(name = "moto_cylnum")
    private Integer motoCylnum;
    //冷却
    @Basic
    @Column(name = "moto_cool")
    private String motoCool;
    //环标
    @Basic
    @Column(name = "moto_standard")
    private String motoStandard;
    //年份
    @Basic
//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @Column(name = "moto_year")
    private Date motoYear;
    //品牌
    @Basic
    @Column(name = "moto_brand")
    private String motoBrand;
    //库存数量
    @Basic
    @Column(name = "moto_num")
    private Integer motoNum;
    //销量
    @Basic
    @Column(name = "moto_salesvol")
    private Integer motoSalesvol;
    //商品介绍
    @Basic
    @Column(name = "moto_introduce")
    private String motoIntroduce;
    //摩托图片
    @Basic
    @Column(name = "moto_image")
    private String motoImage;
    //摩托车状态（0 有效，1 无效）
    @Basic
    @Column(name = "moto_status")
    private Integer motoStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMotoModel() {
        return motoModel;
    }

    public void setMotoModel(String motoModel) {
        this.motoModel = motoModel;
    }

    public Double getMotoPrice() {
        return motoPrice;
    }

    public void setMotoPrice(Double motoPrice) {
        this.motoPrice = motoPrice;
    }

    public Date getMotoSaleTime() {
        return motoSaleTime;
    }

    public void setMotoSaleTime(Date motoSaleTime) {
        this.motoSaleTime = motoSaleTime;
    }

    public Integer getMotoDisplacement() {
        return motoDisplacement;
    }

    public void setMotoDisplacement(Integer motoDisplacement) {
        this.motoDisplacement = motoDisplacement;
    }

    public Integer getMotoCylnum() {
        return motoCylnum;
    }

    public void setMotoCylnum(Integer motoCylnum) {
        this.motoCylnum = motoCylnum;
    }

    public String getMotoCool() {
        return motoCool;
    }

    public void setMotoCool(String motoCool) {
        this.motoCool = motoCool;
    }

    public String getMotoStandard() {
        return motoStandard;
    }

    public void setMotoStandard(String motoStandard) {
        this.motoStandard = motoStandard;
    }

    public Date getMotoYear() {
        return motoYear;
    }

    public void setMotoYear(Date motoYear) {
        this.motoYear = motoYear;
    }

    public String getMotoBrand() {
        return motoBrand;
    }

    public void setMotoBrand(String motoBrand) {
        this.motoBrand = motoBrand;
    }

    public Integer getMotoNum() {
        return motoNum;
    }

    public void setMotoNum(Integer motoNum) {
        this.motoNum = motoNum;
    }

    public Integer getMotoSalesvol() {
        return motoSalesvol;
    }

    public void setMotoSalesvol(Integer motoSalesvol) {
        this.motoSalesvol = motoSalesvol;
    }

    public String getMotoIntroduce() {
        return motoIntroduce;
    }

    public void setMotoIntroduce(String motoIntroduce) {
        this.motoIntroduce = motoIntroduce;
    }

    public String getMotoImage() {
        return motoImage;
    }

    public void setMotoImage(String motoImage) {
        this.motoImage = motoImage;
    }

    public Integer getMotoStatus() {
        return motoStatus;
    }

    public void setMotoStatus(Integer motoStatus) {
        this.motoStatus = motoStatus;
    }

}

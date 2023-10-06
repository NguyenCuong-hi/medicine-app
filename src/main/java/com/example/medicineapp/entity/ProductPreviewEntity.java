package com.example.medicineapp.entity;

import com.globits.core.domain.BaseObject;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "product_preview")
@Getter
@Setter
public class ProductPreviewEntity extends BaseObject {
    @OneToOne
    private ProductEntity productEntity;

    @Column(name = "title")
    private String title;

    @Column(name = "rating")
    private int rating;

    @Column(name = "publish_at")
    private Date publishAt;

    @Column(name = "published")
    private String published;

    @Column(name = "content")
    private String content;

    @Column(name = "file")
    private String file;

    @Column(name = "cong_dung")
    private String congDung;

    @Column(name = "doi_tuong_su_dung")
    private String doi_tuong_su_dung;

    @Column(name = "thuong_hieu")
    private String thuongHieu;

    @Column(name = "nha_san_xuat")
    private String nhaSanXuat;

    @Column(name = "noi_san_xuat")
    private String noiSanXuat;

    @Column(name = "dang_bao_che")
    private String dangBaoChe;

    @Column(name = "cach_dong_goi")
    private String cachDongGoi;

    @Column(name = "han_dung")
    private String hanDung;

    @Column(name = "kich_thuoc")
    private String kichThuoc;

    @Column(name = "trong_luong")
    private float trongLuong;

    @Column(name = "pham_vi_do")
    private String phamViDo;

    @Column(name = "phu_kien_kem_theo")
    private String phuKienKemTheo;

    @Column(name = "do_chinh_xac")
    private String doChinhXac;

    @Column(name = "khac")
    private String khac;

    @Column(name = "type")
    private String type;
}

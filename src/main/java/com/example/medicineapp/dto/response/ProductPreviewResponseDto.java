package com.example.medicineapp.dto.response;

import com.example.medicineapp.entity.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductPreviewResponseDto {
    private ProductEntity productEntity;

    private String title;

    private int rating;

    private Date publishAt;

    private String published;

    private String content;

    private String file;

    private String congDung;

    private String doi_tuong_su_dung;

    private String thuongHieu;

    private String nhaSanXuat;

    private String noiSanXuat;

    private String dangBaoChe;

    private String cachDongGoi;

    private String hanDung;

    private String kichThuoc;

    private float trongLuong;

    private String phamViDo;

    private String phuKienKemTheo;

    private String doChinhXac;

    private String khac;

    private String type;
}

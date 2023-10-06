package com.example.medicineapp.service.Impl;

import com.example.medicineapp.dto.request.ProductPreviewRequestDto;
import com.example.medicineapp.dto.request.search.ProductPreviewSearchDto;
import com.example.medicineapp.dto.response.ProductPreviewResponseDto;
import com.example.medicineapp.entity.ProductPreviewEntity;
import com.example.medicineapp.repository.ProductPreviewRepository;
import com.example.medicineapp.repository.ProductRepository;
import com.example.medicineapp.service.ProductPreviewService;
import com.example.medicineapp.service.mapper.ProductPreviewMapper;
import com.example.medicineapp.utilities.PageUtil;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductPreviewServiceimpl implements ProductPreviewService {

    private final ProductPreviewRepository previewRepo;
    private final ProductPreviewMapper previewMapper;
    private final ProductRepository productRepo;
    private final EntityManager manager;

    @Override
    public ProductPreviewResponseDto getDtoById(@NonNull UUID id) {
        return previewMapper.entityToResponseDto(previewRepo.findById(id).orElse(null));
    }

    @Override
    public Page<ProductPreviewResponseDto> searchBy(ProductPreviewSearchDto searchDto) {
        StringBuilder sql = new StringBuilder(" SELECT entity FROM ProductPreviewEntity entity WHERE (1=1) ");
        StringBuilder sqlCount = new StringBuilder(" SELECT COUNT(entity) FROM ProductPreviewEntity entity WHERE (1=1) ");
        this.setWhereClause(sql, sqlCount, searchDto);
        sql.append(" ORDER BY createDate ");

        Query query = manager.createQuery(sql.toString());
        Query qCount = manager.createQuery(sqlCount.toString());
        this.setParameter(query, qCount, searchDto);

        List<ProductPreviewEntity> entities = PageUtil.getContent(searchDto, query);
        List<ProductPreviewResponseDto> responseDtos = entities.stream().map(previewMapper::entityToResponseDto).collect(Collectors.toList());

        return PageUtil.getPage(responseDtos, searchDto, qCount);
    }

    private void setWhereClause(StringBuilder sql, StringBuilder sqlCount, ProductPreviewSearchDto searchDto){

    }

    private void setParameter(Query query, Query qCount, ProductPreviewSearchDto searchDto){

    }

    @Override
    public ProductPreviewResponseDto createBy ( @NonNull ProductPreviewRequestDto dto) {
        ProductPreviewEntity entity = new ProductPreviewEntity();
        this.setValue(entity, dto);
        previewRepo.save(entity);
        return previewMapper.entityToResponseDto(entity);
    }

    private void setValue(ProductPreviewEntity entity, ProductPreviewRequestDto dto){
        entity.setProductEntity(dto.getProductEntity());
        entity.setTitle(dto.getTitle());
        entity.setRating(dto.getRating());
        entity.setPublishAt(dto.getPublishAt());
        entity.setRating(dto.getRating());
        entity.setPublished(dto.getPublished());
        entity.setContent(dto.getContent());
        entity.setFile(dto.getFile());
        entity.setCongDung(dto.getCongDung());
        entity.setDoi_tuong_su_dung(dto.getDoi_tuong_su_dung());
        entity.setThuongHieu(dto.getThuongHieu());
        entity.setNhaSanXuat(dto.getNhaSanXuat());
        entity.setNoiSanXuat(dto.getNoiSanXuat());
        entity.setDangBaoChe(dto.getDangBaoChe());
        entity.setCachDongGoi(dto.getCachDongGoi());
        entity.setHanDung(dto.getHanDung());
        entity.setKichThuoc(dto.getKichThuoc());
        entity.setTrongLuong(dto.getTrongLuong());
        entity.setPhamViDo(dto.getPhamViDo());
        entity.setPhuKienKemTheo(dto.getPhuKienKemTheo());
        entity.setDoChinhXac(dto.getDoChinhXac());
        entity.setKhac(dto.getKhac());
        entity.setType(dto.getType());
    }

    @Override
    public ProductPreviewResponseDto updateBy(@NonNull UUID id, @NonNull ProductPreviewRequestDto dto) {

        ProductPreviewEntity entity = previewRepo.getById(id);
        this.setValue(entity, dto);
        return previewMapper.entityToResponseDto(entity);
    }

    @Override
    public Boolean deleteBy(@NonNull UUID id) {

        previewRepo.deleteById(id);
        return true;
    }
}

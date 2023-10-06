package com.example.medicineapp.utilities;

import com.example.medicineapp.dto.request.search.SearchDto;
import org.springframework.data.domain.*;

import javax.persistence.Query;
import java.util.List;

public class PageUtil {
    public PageUtil(){

    }

    public static <T> List<T> getContent(SearchDto searchDto, Query query){
        int pageIndex = searchDto.getPageIndex() - 1;
        int pageSize = searchDto.getPageSize();
        int startPosition = pageIndex * pageSize;
        query.setFirstResult(startPosition);
        query.setMaxResults(pageSize);
        return query.getResultList();
    }

    public static <T> Page<T> getPage(List<T> entities , SearchDto searchDto, Query query){
        long count =(Long) query.getSingleResult();
        Pageable pageable = getPageable(searchDto.getPageIndex(), searchDto.getPageSize());
        return new PageImpl<>(entities, pageable, count);
    }

    public static <T>Page<T> getPage(SearchDto dto, Query query, Query qCount){
        List<T> entities = getContent(dto, query);
        long count = (Long) qCount.getSingleResult();
        Pageable pageable = getPageable(dto.getPageIndex(), dto.getPageSize());
        return new PageImpl<>(entities, pageable, count);
    }

    public static Pageable getPageable(Integer pageIndex, Integer pageSize){
        pageIndex = getPageIndex(pageIndex);
        pageSize = getPageSize(pageSize);
        return PageRequest.of(pageIndex, pageSize);
    }

    public static Pageable getPageable (Integer pageIndex, Integer pageSize, Sort sort){
        pageIndex = getPageIndex(pageIndex);
        pageSize = getPageSize(pageSize);
        return PageRequest.of(pageIndex, pageSize, sort);
    }

    public static int getPageIndex(Integer pageIndex){
        return pageIndex != null && pageIndex > 0 ? pageIndex -1 : 1;
    }

    public static int getPageSize(Integer pageSize){
        return pageSize != null && pageSize > 0 ? pageSize : 10;
    }
}

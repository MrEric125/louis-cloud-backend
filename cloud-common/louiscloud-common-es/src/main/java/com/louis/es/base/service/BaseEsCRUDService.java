package com.louis.es.base.service;

import com.louis.es.base.entity.BaseDocument;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 * @author louis
 * <p>
 * Date: 2019/6/10
 * Description:
 */
@Service
public interface BaseEsCRUDService<E extends BaseDocument, ID extends Serializable> {

    Page<E> searchSimple(String keyword);

    Page<E> search(String keyword);

    Page<E> searchPageable(String keyword, Pageable pageable);


    E add(E e);

    void delete(E e);

    E edit(E e);

    Optional<E> findById(ID id);

    void addBatch(List<E> list);











}

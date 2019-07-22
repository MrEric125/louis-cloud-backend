package com.louis.product.repository;

import com.louis.core.repository.BaseRepository;
import com.louis.product.entity.PmsProduct;
import org.springframework.stereotype.Repository;

/**
 * @author John·Louis
 * @date create in 2019/5/26
 */
@Repository
public interface PmsProductRepository extends BaseRepository<PmsProduct,Long> {
}

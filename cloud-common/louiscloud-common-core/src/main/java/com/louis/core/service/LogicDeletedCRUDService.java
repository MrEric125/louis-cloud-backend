package com.louis.core.service;

import com.louis.core.entity.BaseEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

/**
 * @author John·Louis
 * @date create in 2019/6/1
 * <p>
 * description:
 */
@Transactional
@Slf4j
public class LogicDeletedCRUDService<E extends BaseEntity,ID extends Serializable> extends CRUDService<E, ID>{





}

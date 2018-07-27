package com.dearho.core;

import org.springframework.stereotype.Component;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 继承自己的MyMapper
 *
 * @author liuzh_3nofxnp
 * @since 2015-09-06 21:53
 */
@Component
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {

}

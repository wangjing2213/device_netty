package com.dearho.elasticsearch.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.dearho.elasticsearch.domain.DriverLocation;

/**
 * ES 操作类
 * <p>
 * Created by bysocket on 20/06/2017.
 */
public interface DriverLocationRepository extends ElasticsearchRepository<DriverLocation, Long> {
	 /**
     * AND 语句查询
     *
     * @param description
     * @param score
     * @return
     */
    List<DriverLocation> findByLatitudeAndLongitude(Double Latitude, Double longitude);

    /**
     * OR 语句查询
     *
     * @param description
     * @param score
     * @return
     */
//    List<DriverLocation> findByDescriptionOrScore(String description, Integer score);

    /**
     * 查询城市描述
     *
     * 等同于下面代码
     * @Query("{\"bool\" : {\"must\" : {\"term\" : {\"description\" : \"?0\"}}}}")
     * Page<DriverLocation> findByDescription(String description, Pageable pageable);
     *
     * @param description
     * @param page
     * @return
     */
//    Page<DriverLocation> findByDescription(String description, Pageable page);

    /**
     * NOT 语句查询
     *
     * @param description
     * @param page
     * @return
     */
//    Page<DriverLocation> findByDescriptionNot(String description, Pageable page);

    /**
     * LIKE 语句查询
     *
     * @param description
     * @param page
     * @return
     */

}

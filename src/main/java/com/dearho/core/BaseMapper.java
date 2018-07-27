package com.dearho.core;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.exceptions.PersistenceException;



public interface BaseMapper<M> {
    public int insert(M model) throws PersistenceException;
    public int update(M model) throws PersistenceException;
    public int delete(M model) throws PersistenceException;
    public M get(long id) throws PersistenceException;
    public int count(M model) throws PersistenceException;
    public List<M> select(M model) throws PersistenceException;
}

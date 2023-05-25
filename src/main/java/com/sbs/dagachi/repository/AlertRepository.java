package com.sbs.dagachi.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sbs.dagachi.vo.Alert;

@Mapper
public interface AlertRepository {
    public List<Alert> getAlerts();
}

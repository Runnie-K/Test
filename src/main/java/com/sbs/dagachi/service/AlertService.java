package com.sbs.dagachi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sbs.dagachi.repository.AlertRepository;
import com.sbs.dagachi.vo.Alert;

@Service
public class AlertService {

    private AlertRepository alertRepository;

    public AlertService(AlertRepository alertRepository) {
        this.alertRepository = alertRepository;
    }

    public List<Alert> getAlerts() {
        return alertRepository.getAlerts();
    }
}
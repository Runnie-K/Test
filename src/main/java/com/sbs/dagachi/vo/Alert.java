package com.sbs.dagachi.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Alert {
    private int alert_id;
    private String alert_body;
    private Date alert_date;
    private String alert_receiver;
    private String alert_url;
    private String alert_register;
    private String elapsed_time;
    private boolean Extra__actorCanDelete;
}

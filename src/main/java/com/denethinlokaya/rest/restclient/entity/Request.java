package com.denethinlokaya.rest.restclient.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
public class Request implements Serializable{
    public static final long serialVersionUID = 42L;

    private String topic;
    private int qos;
    private int retain;
    private String payload;

    public Request(String topic,int qos,int retain,String payload){
        this.topic=topic;
        this.qos=qos;
        this.retain=retain;
        this.payload=payload;
    }
}

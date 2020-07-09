package com.example.springchaos.domain;

import lombok.Getter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Getter

@MappedSuperclass
public class DomainImpl implements Domain {

    @Id
    @GeneratedValue
    private Long id;

}

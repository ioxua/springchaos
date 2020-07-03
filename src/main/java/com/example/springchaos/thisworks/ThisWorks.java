package com.example.springchaos.thisworks;

import com.example.springchaos.domain.DomainImpl;
import lombok.Getter;

import javax.persistence.Basic;
import javax.persistence.Entity;

@Getter

@Entity
public class ThisWorks extends DomainImpl {

    @Basic
    private String details;

}

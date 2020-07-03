package com.example.springchaos.generic;

import com.example.springchaos.domain.Domain;

import java.util.List;

public interface GenericRepositoryWithALotOfLogic<T extends Domain> {
    List<T> doStuff();
}

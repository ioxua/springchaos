package com.example.springchaos.thisworks;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ThisWorksRepository extends JpaRepository<ThisWorks, Long>, ThisWorksNotGenericRepoWithALotOfLogic {
}

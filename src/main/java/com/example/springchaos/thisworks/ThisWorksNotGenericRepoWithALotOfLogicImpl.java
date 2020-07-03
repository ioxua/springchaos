package com.example.springchaos.thisworks;

import com.example.springchaos.generic.GenericRepositoryWithALotOfLogicImpl;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

// this class works as a substitution for GenericRepositoryWithALotOfLogicImpl<ThisWorks>, with the difference being:
// in this one, T=ThisWorks.class, for some reason

@Repository
public class ThisWorksNotGenericRepoWithALotOfLogicImpl extends GenericRepositoryWithALotOfLogicImpl<ThisWorks>
        implements ThisWorksNotGenericRepoWithALotOfLogic {
    public ThisWorksNotGenericRepoWithALotOfLogicImpl(EntityManager em) {
        super(em);
    }
}

package net.playground.ipinfoservice.persistence.repository;

import net.playground.ipinfoservice.persistence.entity.IpInfoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IpInfoRepository extends CrudRepository<IpInfoEntity, Integer> {

    List<IpInfoEntity> findByApplicationCode(String applicationCode);
}

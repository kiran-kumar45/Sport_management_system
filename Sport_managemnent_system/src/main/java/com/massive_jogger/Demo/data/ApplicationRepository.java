package com.massive_jogger.Demo.data;

import com.massive_jogger.Demo.models.Application;
import com.massive_jogger.Demo.models.CurrentApplication;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationRepository extends CrudRepository<Application,Long> {
}

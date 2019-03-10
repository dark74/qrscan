package com.gentlelu.repository;

import com.gentlelu.bean.ProxyItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProxyItemRepository extends JpaRepository<ProxyItem, Long> {

    // 查询代理条目
    List<ProxyItem> findById (long id);

    ProxyItem findByCid(String cid);

    ProxyItem findByPhoneId(String phoneId);

    ProxyItem findByMonitorId(String monitorId);

}

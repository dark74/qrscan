package com.gentlelu.bean;

import org.springframework.stereotype.Component;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Component
public class ProxyItem implements Serializable {
    @Id
    @GeneratedValue
    private int id;

    private String cid;
    private int isproxy;
    private String content;
    private String pid;
    private String mid;
    private String hash;

    public ProxyItem() {
    }

    public ProxyItem(String cid, int isProxy, String content, String phoneId, String monitorId, String hashContent) {
        this.cid = cid;
        this.isproxy = isProxy;
        this.content = content;
        this.pid = phoneId;
        this.mid = monitorId;
        this.hash = hashContent;
    }
}

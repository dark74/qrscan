package com.gentlelu.controller;

import com.gentlelu.bean.ProxyItem;
import com.gentlelu.repository.ProxyItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Controller
public class DBTestController {
    final static String TAG = "DBTestController";
    private Logger logger = LoggerFactory.getLogger(DBTestController.class);

    @Autowired
    private ProxyItemRepository proxyItemRepository;

    @RequestMapping("/getItem")
    @ResponseBody
    public ProxyItem getProxyItem(String cid){
        ProxyItem result = proxyItemRepository.findByCid(cid);
        return result;
    }

    @RequestMapping("/insertItem")
    @ResponseBody
    public ProxyItem saveItem(String cid, boolean isProxy, String content, String phoneId, String monitorId) throws NoSuchAlgorithmException {
        int mIsProxy = 0;
        String hashContent = DigestUtils.md5DigestAsHex(content.getBytes());
        mIsProxy =  isProxy ? 1: 0;
        logger.info(TAG, hashContent);
        ProxyItem proxyItem = new ProxyItem(cid, mIsProxy, content, phoneId, monitorId, hashContent);
        ProxyItem save = proxyItemRepository.save(proxyItem);
        return save;
    }
}

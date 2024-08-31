package cn.edu.tyut.service;

import cn.edu.tyut.dao.*;
import cn.edu.tyut.model.Share;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ShareServiceImpl implements ShareService {
    @Autowired
    private ShareMapper shareMapper;

    // 插入分享信息
    @Override
    public int addShare(Share share) {
        int flag = shareMapper.insertShare(share);
        if (flag > 0) {
            return share.getShareId();
        }else {
            return 0;
        }
    }

    // 更新分享信息
    @Override
    public int deleteShare(int id) {
        int flag = shareMapper.deleteShare(id);
        return flag;
    }

    // 查询所有分享信息
    @Override
    public List<Share> getShareList() {
        List<Share> shareList = shareMapper.selectAllShares();
        if (!shareList.isEmpty()) {
            return shareList;
        }else {
            return Collections.emptyList();
        }
    }

    // 根据用户ID查询分享信息
    @Override
    public List<Share> getShareListByUserId(int userId) {
        List<Share> shareList = shareMapper.selectSharesByUserId(userId);
        if (!shareList.isEmpty()) {
            return shareList;
        }else {
            return Collections.emptyList();
        }
    }

    // 根据分享ID查询分享信息
    @Override
    public Share getShareListByShareId(int shareId) {
        Share share = shareMapper.selectShareById(shareId);
        if (share != null) {
            return share;
        }else {
            return new Share();
        }
    }
}

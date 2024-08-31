package cn.edu.tyut.service;

import cn.edu.tyut.model.Share;

import java.util.List;

public interface ShareService {
    public int addShare(Share share);
    public int deleteShare(int id);
    public List<Share> getShareList();
    public List<Share> getShareListByUserId(int userId);
    public Share getShareListByShareId(int shareId);
}

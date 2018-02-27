package com.xyq.service;

import com.xyq.model.Reward;

import java.util.List;

/**
 * Created by asus on 2018/2/27.
 */
public interface RewardService {
    void insertReward(Reward reward);
    List<Reward> getRewardByEid(int eid);
    List<Reward> getRewardByCid(int cid);
}

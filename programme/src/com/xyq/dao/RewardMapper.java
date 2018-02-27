package com.xyq.dao;

import com.xyq.model.Reward;

import java.util.List;

/**
 * Created by asus on 2018/2/27.
 */
public interface RewardMapper {
    void insertReward(Reward reward);
    List<Reward> getRewardByEid(int eid);
    List<Reward> getRewardByCid(int cid);
}

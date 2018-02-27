package com.xyq.service.impl;

import com.xyq.dao.RewardMapper;
import com.xyq.model.Reward;
import com.xyq.service.RewardService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by asus on 2018/2/27.
 */
@Service("rewardService")
public class RewardServiceImpl implements RewardService {
    @Resource
    private RewardMapper rewardMapper;

    @Override
    public void insertReward(Reward reward) {
        rewardMapper.insertReward(reward);
    }

    @Override
    public List<Reward> getRewardByEid(int eid) {
        return rewardMapper.getRewardByEid(eid);
    }

    @Override
    public List<Reward> getRewardByCid(int cid) {
        return rewardMapper.getRewardByCid(cid);
    }
}

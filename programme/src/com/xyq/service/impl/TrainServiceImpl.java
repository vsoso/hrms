package com.xyq.service.impl;

import com.xyq.dao.TrainMapper;
import com.xyq.model.Train;
import com.xyq.service.TrainService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by asus on 2018/2/26.
 */
@Service("trainService")
public class TrainServiceImpl implements TrainService {
    @Resource
    private TrainMapper trainMapper;

    @Override
    public void addTrain(Train train) {
        trainMapper.addTrain(train);
    }

    @Override
    public List<Train> getTrain(int cid) {
        return trainMapper.getTrain(cid);
    }

    @Override
    public void deleteTrain(Train train) {
        trainMapper.deleteTrain(train);
    }

    @Override
    public void updateTrain(Train train) {
        trainMapper.updateTrain(train);
    }

    @Override
    public List<Train> getTrainByDid(int did) {
        return trainMapper.getTrainByDid(did);
    }

}

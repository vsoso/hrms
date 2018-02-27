package com.xyq.dao;

import com.xyq.model.Train;

import java.util.List;

/**
 * Created by asus on 2018/2/26.
 */
public interface TrainMapper {
    void addTrain(Train train);
    List<Train> getTrain(int cid);
    List<Train> getTrainByDid(int did);
    void deleteTrain(Train train);
    void updateTrain(Train train);
}

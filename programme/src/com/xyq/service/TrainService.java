package com.xyq.service;

import com.xyq.model.Train;

import java.util.List;

/**
 * Created by asus on 2018/2/26.
 */
public interface TrainService {
    void addTrain(Train train);
    List<Train> getTrain(int cid);
    void deleteTrain(Train train);
    void updateTrain(Train train);
    List<Train> getTrainByDid(int did);
}

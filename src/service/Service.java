package service;


import space.service.CarServiceSpot;
import space.service.IndependentCarServiceSpot;

import java.util.ArrayList;
import java.util.List;

public class Service {
    List<CarServiceSpot> carServiceSpots = new ArrayList<>();            //lista miejsc serwisowych
    List<IndependentCarServiceSpot> independentCarServiceSpots = new ArrayList<>();   //lista samodzielnych miejsc
}

package com.example.projects.simautomation.repository;

import com.example.projects.simautomation.dto.SimVehicleMapping;
import com.example.projects.simautomation.dto.SimInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SimRepository {

    @Select("Select * from sim_database.sim_vehicle_mapping where vehicle_number = #{vehicleNumber}")
    public SimVehicleMapping findByVehicleNumber(String vehicleNumber);

    public void save(SimInfo simInfo);
}

package com.example.day1028it.service;

import com.example.day1028it.model.JobPosition;

import java.util.List;

public interface JobPositionService {
    // 添加岗位
    void addJobPosition(JobPosition jobPosition);

    // 获取所有岗位
    List<JobPosition> getAllJobPositions();

    // 根据ID获取岗位
    JobPosition getJobPositionById(Integer id);

    // 根据关键词搜索岗位
    List<JobPosition> searchJobPositions(String keyword);
    
    // 多条件查询岗位
    List<JobPosition> searchJobPositionsByConditions(String positionName, String salary, String location);

    // 更新岗位信息
    void updateJobPosition(JobPosition jobPosition);

    // 删除岗位
    void deleteJobPosition(Integer id);
}
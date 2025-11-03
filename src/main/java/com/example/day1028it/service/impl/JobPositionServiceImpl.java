package com.example.day1028it.service.impl;

import com.example.day1028it.mapper.JobPositionMapper;
import com.example.day1028it.model.JobPosition;
import com.example.day1028it.service.JobPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPositionServiceImpl implements JobPositionService {
    
    @Autowired
    private JobPositionMapper jobPositionMapper;

    @Override
    public void addJobPosition(JobPosition jobPosition) {
        jobPositionMapper.insert(jobPosition);
    }

    @Override
    public List<JobPosition> getAllJobPositions() {
        return jobPositionMapper.selectAll();
    }

    @Override
    public JobPosition getJobPositionById(Integer id) {
        return jobPositionMapper.selectById(id);
    }

    @Override
    public List<JobPosition> searchJobPositions(String keyword) {
        return jobPositionMapper.selectByKeyword(keyword);
    }

    @Override
    public List<JobPosition> searchJobPositionsByConditions(String positionName, String salary, String location) {
        return jobPositionMapper.selectByMultipleConditions(positionName, salary, location);
    }

    @Override
    public void updateJobPosition(JobPosition jobPosition) {
        jobPositionMapper.update(jobPosition);
    }

    @Override
    public void deleteJobPosition(Integer id) {
        jobPositionMapper.delete(id);
    }
}
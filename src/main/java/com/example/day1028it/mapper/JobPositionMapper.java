package com.example.day1028it.mapper;

import com.example.day1028it.model.JobPosition;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface JobPositionMapper {
    // 添加岗位
    @Insert("INSERT INTO job_position (company_name, position_name, salary, requirements, location, contact_info, note) VALUES (#{companyName}, #{positionName}, #{salary}, #{requirements}, #{location}, #{contactInfo}, #{note})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(JobPosition jobPosition);

    // 查询所有岗位
    @Select("SELECT * FROM job_position ORDER BY id DESC")
    List<JobPosition> selectAll();

    // 根据ID查询岗位
    @Select("SELECT * FROM job_position WHERE id = #{id}")
    JobPosition selectById(Integer id);

    // 根据条件筛选岗位
    @Select("SELECT * FROM job_position WHERE company_name LIKE CONCAT('%', #{keyword}, '%') OR position_name LIKE CONCAT('%', #{keyword}, '%') OR location LIKE CONCAT('%', #{keyword}, '%') ORDER BY id DESC")
     List<JobPosition> selectByKeyword(String keyword);
    
    // 多条件查询岗位
    @Select("SELECT * FROM job_position WHERE " +
            "(#{positionName} IS NULL OR #{positionName} = '' OR position_name LIKE CONCAT('%', #{positionName}, '%')) AND " +
            "(#{salary} IS NULL OR #{salary} = '' OR salary LIKE CONCAT('%', #{salary}, '%')) AND " +
            "(#{location} IS NULL OR #{location} = '' OR location LIKE CONCAT('%', #{location}, '%')) " +
            "ORDER BY id DESC")
    List<JobPosition> selectByMultipleConditions(@Param("positionName") String positionName, 
                                              @Param("salary") String salary, 
                                              @Param("location") String location);

    // 更新岗位信息
    @Update("UPDATE job_position SET company_name = #{companyName}, position_name = #{positionName}, salary = #{salary}, requirements = #{requirements}, location = #{location}, contact_info = #{contactInfo}, note = #{note} WHERE id = #{id}")
    void update(JobPosition jobPosition);

    // 删除岗位
    @Delete("DELETE FROM job_position WHERE id = #{id}")
    void delete(Integer id);
}
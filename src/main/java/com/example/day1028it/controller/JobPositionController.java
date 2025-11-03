package com.example.day1028it.controller;

import com.example.day1028it.model.JobPosition;
import com.example.day1028it.service.JobPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("/jobs")
public class JobPositionController {

    @Autowired
    private JobPositionService jobPositionService;

    // 显示岗位列表
    @GetMapping
    public String listJobs(
            @RequestParam(value = "keyword", required = false) String keyword,
            @RequestParam(value = "positionName", required = false) String positionName,
            @RequestParam(value = "salary", required = false) String salary,
            @RequestParam(value = "location", required = false) String location,
            Model model) {
        List<JobPosition> jobs;
        
        // 检查是否有任何多条件查询参数（排除空字符串）
        boolean hasConditionParams = (positionName != null && !positionName.trim().isEmpty() && !positionName.equals("")) || 
                                   (salary != null && !salary.trim().isEmpty() && !salary.equals("")) || 
                                   (location != null && !location.trim().isEmpty() && !location.equals(""));
        
        if (hasConditionParams) {
            // 使用多条件查询 - 对于空字符串或null，传递null给服务层
            String positionNameParam = (positionName != null && !positionName.trim().isEmpty() && !positionName.equals("")) ? positionName : null;
            String salaryParam = (salary != null && !salary.trim().isEmpty() && !salary.equals("")) ? salary : null;
            String locationParam = (location != null && !location.trim().isEmpty() && !location.equals("")) ? location : null;
            
            jobs = jobPositionService.searchJobPositionsByConditions(positionNameParam, salaryParam, locationParam);
            System.out.println("多条件查询模式，找到 " + jobs.size() + " 条记录");
            // 添加查询参数到模型中，用于回显
            model.addAttribute("positionName", positionName);
            model.addAttribute("salary", salary);
            model.addAttribute("location", location);
        } else if (keyword != null && !keyword.trim().isEmpty()) {
            // 使用关键词查询
            jobs = jobPositionService.searchJobPositions(keyword.trim());
            System.out.println("搜索模式，关键词: " + keyword + ", 找到 " + jobs.size() + " 条记录");
            model.addAttribute("keyword", keyword);
        } else {
            // 获取所有岗位
            jobs = jobPositionService.getAllJobPositions();
            System.out.println("全量查询模式，找到 " + jobs.size() + " 条记录");
        }

        // 调试输出每条数据
        for (JobPosition job : jobs) {
            System.out.println("数据: ID=" + job.getId() + ", 企业=" + job.getCompanyName() + ", 岗位=" + job.getPositionName());
        }

        model.addAttribute("jobs", jobs);
        model.addAttribute("studentName", "郝一诺");
        model.addAttribute("studentClass", "信2305-3");
        return "list";
    }

    // 添加岗位
    @PostMapping("/add")
    public String addJob(@ModelAttribute JobPosition jobPosition) {
        jobPositionService.addJobPosition(jobPosition);
        return "redirect:/jobs";
    }

    // 更新岗位
    @PostMapping("/edit")
    public String updateJob(@ModelAttribute JobPosition jobPosition) {
        jobPositionService.updateJobPosition(jobPosition);
        return "redirect:/jobs";
    }

    // 删除岗位
    @GetMapping("/delete/{id}")
    public String deleteJob(@PathVariable Integer id) {
        jobPositionService.deleteJobPosition(id);
        return "redirect:/jobs";
    }

    // 获取岗位详情（JSON格式，用于AJAX请求）
    @GetMapping("/view-json/{id}")
    @ResponseBody
    public JobPosition viewJobJson(@PathVariable Integer id) {
        return jobPositionService.getJobPositionById(id);
    }

    // 添加测试方法
    @GetMapping("/test")
    public String testPage(Model model) {
        System.out.println("=== 测试页面被访问 ===");
        return "list";
    }

}
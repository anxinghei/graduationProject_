package com.anxinghei.sys.controller;

import com.anxinghei.sys.entity.Position;
import com.anxinghei.sys.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("position")
public class PositionController {
    @Autowired
    private PositionService positionService;

    @GetMapping("getAll")
    public List<Position> getAllDepts(){
        return positionService.getAllPositions();
    }
}

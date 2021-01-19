package com.anxinghei.sys.service;

import com.anxinghei.sys.entity.Position;
import com.anxinghei.sys.mapper.PositionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionService {
    @Autowired
    private PositionMapper positionMapper;

    public List<Position> getAllPositions(){
        return positionMapper.selectAll();
    }
}

package com.fpoly.duantotnghiep.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fpoly.duantotnghiep.Entity.TaiLieuKhoaHoc;
import com.fpoly.duantotnghiep.Entity.VideoKhoaHoc;
import com.fpoly.duantotnghiep.jparepository.TaiLieuKhoaHocRepository;
import com.fpoly.duantotnghiep.jparepository.VideoKhoaHocRepository;
import com.fpoly.duantotnghiep.service.VideoService;

@Service
public class VideoServiceImpI implements VideoService {
    @Autowired
    VideoKhoaHocRepository videoKhoaHocRepository;

    @Override
    public List<VideoKhoaHoc> findAll() {
        return videoKhoaHocRepository.findAll();
    }

    @Override
    public List<VideoKhoaHoc> findByKhoaHocId(int idKhoaHoc) {
        return videoKhoaHocRepository.findByKhoaHocId(idKhoaHoc);
    }
}

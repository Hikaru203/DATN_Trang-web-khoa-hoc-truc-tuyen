package com.fpoly.duantotnghiep.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.fpoly.duantotnghiep.Entity.KhoaHoc;
import com.fpoly.duantotnghiep.jparepository.KhoaHocRepository;
import com.fpoly.duantotnghiep.service.KhoaHocService;

@Service
public class KhoaHocServiceImpl implements KhoaHocService {
	@Autowired
	KhoaHocRepository khoaHocRepository;

	@Override
	public List<KhoaHoc> findAll() {
		return khoaHocRepository.findAll();
	}
	@Override
	public List<KhoaHoc> findDuyet() {
		return khoaHocRepository.findByDuyet();
	}

	@Override
	public KhoaHoc findByKhoaHocId(Integer id) {
		// TODO Auto-generated method stub
		return khoaHocRepository.findById(id).get();
	}

	@Override
	public KhoaHoc findById(int id) {
		// TODO Auto-generated method stub
		return khoaHocRepository.findById(id);
	}

	@Override
	public List<KhoaHoc> getKhoaHocByLoai(Integer loaiKhoaHoc) {
		return khoaHocRepository.findByLoaiKhoaHocId(loaiKhoaHoc);
	}
    @Override
    public List<String> findAllTenKhoaHoc() {
        return khoaHocRepository.findAllTenKhoaHoc();
    }

	@Override
    public KhoaHoc create(KhoaHoc khoaHoc) {
        return khoaHocRepository.save(khoaHoc);
    }

	@Override
    public void deleteById(Integer id) {
        khoaHocRepository.deleteById(id);
    }


	@Override
    public KhoaHoc update(KhoaHoc khoaHoc) {
        // Kiểm tra xem  có tồn tại trong cơ sở dữ liệu không
        KhoaHoc existingBrand = khoaHocRepository.findById(khoaHoc.getId());
        if (existingBrand != null) {
			existingBrand.setTenKhoaHoc(khoaHoc.getTenKhoaHoc());
			existingBrand.setChiPhi(khoaHoc.getChiPhi());
			existingBrand.setMoTa(khoaHoc.getMoTa());
			if(khoaHoc.getHinhAnh()!=null){
				existingBrand.setHinhAnh(khoaHoc.getHinhAnh());
			}
			if(khoaHoc.isDuyet()!=existingBrand.isDuyet()){
				existingBrand.setDuyet(khoaHoc.isDuyet());
			}
            return khoaHocRepository.save(existingBrand);
        } else {
            // Nếu  không tồn tại, không thực hiện cập nhật và trả về null hoặc thông báo lỗi tùy vào logic ứng dụng của bạn
            return null;
        }
    }

}


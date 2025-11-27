package com.edu.mall.service.impl;

import com.edu.mall.mapper.LitemallAddressMapper;
import com.edu.mall.mapper.LitemallRegionMapper;
import com.edu.mall.pojo.LitemallAddress;
import com.edu.mall.pojo.LitemallRegion;
import com.edu.mall.service.AddressService;
import com.edu.mall.service.AdminGoodService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;


@Service
public class AddressServiceImpl implements AddressService {
    @Resource
    private LitemallAddressMapper litemallAddressMapper;
    @Resource
    private LitemallRegionMapper litemallRegionMapper;
    @Override
    public List<LitemallAddress> queryAll() {
        return litemallAddressMapper.selectAll();
    }

    @Override
    public int addAddress(LitemallAddress litemallAddress, Integer userId) {
        System.out.println(litemallAddress.getProvince());
        litemallAddress.setUserId(userId);
        LitemallRegion litemallRegion = litemallRegionMapper.selectByName(litemallAddress.getCounty());
        litemallAddress.setAreaCode(litemallRegion.getCode()+"");
        if(CollectionUtils.isEmpty(litemallAddressMapper.selectAll())){
            litemallAddress.setIsDefault(true);
        }else {
            System.out.println(litemallAddress.getIsDefault());
            if(litemallAddress.getIsDefault()==true){
                LitemallAddress litemallAddress1 = litemallAddressMapper.selectBydefult(1);
                if (litemallAddress1!=null){
                    litemallAddress1.setIsDefault(false);
                    litemallAddressMapper.updateByPrimaryKeySelective(litemallAddress1);
                }
            }
        }


        return litemallAddressMapper.insertSelective(litemallAddress);
    }


    @Override
    public int updateAddress(LitemallAddress litemallAddress,Integer userId) {

        if(CollectionUtils.isEmpty(litemallAddressMapper.selectAll())){
            litemallAddress.setIsDefault(true);
        }
        System.out.println(litemallAddress.getIsDefault());
        LitemallRegion litemallRegion = litemallRegionMapper.selectByName(litemallAddress.getCounty());
        litemallAddress.setAreaCode(litemallRegion.getCode()+"");
        litemallAddress.setUserId(userId);
        if(litemallAddress.getIsDefault()==true){
            LitemallAddress litemallAddress1 = litemallAddressMapper.selectBydefult(1);
            if (litemallAddress1!=null){
                litemallAddress1.setIsDefault(false);
                litemallAddressMapper.updateByPrimaryKeySelective(litemallAddress1);
            }
        }
        return litemallAddressMapper.updateByPrimaryKeySelective(litemallAddress);
    }

    @Override
    public int delAddress(Integer id, Integer userId) {
        return litemallAddressMapper.deleteByPrimaryKey(id);
    }
}

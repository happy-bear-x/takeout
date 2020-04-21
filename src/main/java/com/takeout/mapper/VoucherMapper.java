package com.takeout.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.takeout.entity.Voucher;
import com.takeout.entity.VoucherExample;

public interface VoucherMapper {
    int countByExample(VoucherExample example);

    int deleteByExample(VoucherExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Voucher record);

    int insertSelective(Voucher record);

    List<Voucher> selectByExample(VoucherExample example);

    Voucher selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Voucher record, @Param("example") VoucherExample example);

    int updateByExample(@Param("record") Voucher record, @Param("example") VoucherExample example);

    int updateByPrimaryKeySelective(Voucher record);

    int updateByPrimaryKey(Voucher record);
}
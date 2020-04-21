package com.takeout.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.takeout.entity.Foods;
import com.takeout.entity.FoodsExample;

public interface FoodsMapper {
    int countByExample(FoodsExample example);

    int deleteByExample(FoodsExample example);

    int deleteByPrimaryKey(Integer foodid);

    int insert(Foods record);

    int insertSelective(Foods record);

    List<Foods> selectByExample(FoodsExample example);

    Foods selectByPrimaryKey(Integer foodid);

    int updateByExampleSelective(@Param("record") Foods record, @Param("example") FoodsExample example);

    int updateByExample(@Param("record") Foods record, @Param("example") FoodsExample example);

    int updateByPrimaryKeySelective(Foods record);

    int updateByPrimaryKey(Foods record);
}
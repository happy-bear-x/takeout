package com.takeout.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.takeout.entity.Judgment;
import com.takeout.entity.JudgmentExample;
import com.takeout.entity.JudgmentKey;

public interface JudgmentMapper {
    int countByExample(JudgmentExample example);

    int deleteByExample(JudgmentExample example);

    int deleteByPrimaryKey(JudgmentKey key);

    int insert(Judgment record);

    int insertSelective(Judgment record);

    List<Judgment> selectByExample(JudgmentExample example);

    Judgment selectByPrimaryKey(JudgmentKey key);

    int updateByExampleSelective(@Param("record") Judgment record, @Param("example") JudgmentExample example);

    int updateByExample(@Param("record") Judgment record, @Param("example") JudgmentExample example);

    int updateByPrimaryKeySelective(Judgment record);

    int updateByPrimaryKey(Judgment record);
}
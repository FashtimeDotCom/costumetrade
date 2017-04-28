package costumetrade.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import costumetrade.domain.SpPColorCustom;
import costumetrade.domain.SpPSizeCustom;
import costumetrade.domain.SpPSizeCustomKey;
@Mapper
public interface SpPSizeCustomMapper {
    int deleteByPrimaryKey(SpPSizeCustomKey key);

    int insert(SpPSizeCustom record);

    int insertSelective(SpPSizeCustom record);

    SpPSizeCustom selectByPrimaryKey(SpPSizeCustomKey key);

    int updateByPrimaryKeySelective(SpPSizeCustom record);

    int updateByPrimaryKey(SpPSizeCustom record);
    
    List<SpPSizeCustom> getSpPSizeCustoms(int corpId);
}
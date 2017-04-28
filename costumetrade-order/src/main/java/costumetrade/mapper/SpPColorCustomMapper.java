package costumetrade.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import costumetrade.domain.SpPCate;
import costumetrade.domain.SpPColorCustom;
import costumetrade.domain.SpPColorCustomKey;
@Mapper
public interface SpPColorCustomMapper {
    int deleteByPrimaryKey(SpPColorCustomKey key);

    int insert(SpPColorCustom record);

    int insertSelective(SpPColorCustom record);

    SpPColorCustom selectByPrimaryKey(SpPColorCustomKey key);

    int updateByPrimaryKeySelective(SpPColorCustom record);

    int updateByPrimaryKey(SpPColorCustom record);
    
    List<SpPColorCustom> getSpPColorCustoms(int corpId);
}
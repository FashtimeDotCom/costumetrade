package costumetrade.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import costumetrade.domain.SpPCate;
import costumetrade.domain.SpPCateKey;
@Mapper
public interface SpPCateMapper {
    int deleteByPrimaryKey(SpPCateKey key);

    int insert(SpPCate record);

    int insertSelective(SpPCate record);

    SpPCate selectByPrimaryKey(SpPCateKey key);

    int updateByPrimaryKeySelective(SpPCate record);

    int updateByPrimaryKey(SpPCate record);
    
    List<SpPCate> getSpPCates(int corpId);
}
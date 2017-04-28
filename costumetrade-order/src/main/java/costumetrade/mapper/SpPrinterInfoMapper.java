package costumetrade.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import costumetrade.domain.SpPrinterInfo;
import costumetrade.domain.SpPrinterInfoKey;
@Mapper
public interface SpPrinterInfoMapper {
    int deleteByPrimaryKey(SpPrinterInfoKey key);

    int insert(SpPrinterInfo record);

    int insertSelective(SpPrinterInfo record);

    SpPrinterInfo selectByPrimaryKey(SpPrinterInfoKey key);

    int updateByPrimaryKeySelective(SpPrinterInfo record);

    int updateByPrimaryKeyWithBLOBs(SpPrinterInfo record);

    int updateByPrimaryKey(SpPrinterInfo record);
    
}
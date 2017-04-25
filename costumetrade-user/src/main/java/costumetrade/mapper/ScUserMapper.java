package costumetrade.mapper;

import costumetrade.domain.ScUser;

public interface ScUserMapper {
    int deleteByPrimaryKey(String id);

    int insert(ScUser record);

    int insertSelective(ScUser record);

    ScUser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ScUser record);

    int updateByPrimaryKey(ScUser record);
}
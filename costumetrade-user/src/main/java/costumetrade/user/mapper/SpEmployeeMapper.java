package costumetrade.user.mapper;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import costumetrade.user.domain.SpEmployee;
import costumetrade.user.domain.SpEmployeeKey;
@Component
@Repository
public interface SpEmployeeMapper {
    int deleteByPrimaryKey(SpEmployeeKey key);

    int insert(SpEmployee record);

    int insertSelective(SpEmployee record);

    SpEmployee selectByPrimaryKey(SpEmployeeKey key);

    int updateByPrimaryKeySelective(SpEmployee record);

    int updateByPrimaryKey(SpEmployee record);
    
    List<SpEmployee>  getAllEmployees();
}
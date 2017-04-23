package costumetrade.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import costumetrade.user.domain.SpMenuEmployee;
@Mapper
public interface SpMenuEmployeeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SpMenuEmployee record);

    int insertSelective(SpMenuEmployee record);

    SpMenuEmployee selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SpMenuEmployee record);

    int updateByPrimaryKey(SpMenuEmployee record);
    
    List<SpMenuEmployee> getAllMenuEmployees(Long employeeId);
    
    int saveSpMenuEmployees(List<SpMenuEmployee> menuEmployees);
    
    int deleteByEmployeeId(Long employeeId);
}
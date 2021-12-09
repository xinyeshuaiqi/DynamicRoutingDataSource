package pers.wmx.db;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

/**
 * @author wangmingxin03
 * Created on 2021-12-08
 */
@Mapper
public interface PersonMapper {
    @Insert("insert into person(name,age) value(#{name},#{age})")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    int insert(Person person);
}

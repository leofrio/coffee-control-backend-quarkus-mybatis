package org.acme.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ProfileMapper {
    @Select("select p.id from profiles p where p.profile_type = #{profileType}")
    public Integer getIdFromProfileType(String profileType);
}

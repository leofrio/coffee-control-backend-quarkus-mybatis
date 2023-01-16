package org.acme.mapper;

import org.acme.dto.SolicitationDto;
import org.acme.dto.UserDetailedDto;
import org.acme.dto.UserDto;
import org.acme.model.User;
import org.apache.ibatis.annotations.*;

import javax.ws.rs.GET;
import javax.ws.rs.QueryParam;
import java.awt.print.Pageable;
import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select\n" +
            "u.id,\n" +
            "u.full_name as name,\n" +
            "u.registration ,\n" +
            "u.pword as password,\n" +
            "p.profile_type as profile_type\n" +
            "from\n" +
            "users u\n" +
            "inner join profiles p on u.profile_id =p.id \n" +
            "limit #{limit} offset #{offset};")
    List<UserDto> getAllUsers(@Param("limit") Integer limit,@Param("offset") Integer offset);


    @Select("select\n" +
            "u.id,\n" +
            "u.full_name as name,\n" +
            "u.registration  as registration,\n" +
            "u.pword as password,\n" +
            "p.profile_type as profile_type,\n" +
            "(\n" +
            "select\n" +
            " count(*)\n" +
            "from\n" +
            " solicitations s\n" +
            "where\n" +
            " s.assigned_user_id = u.id ) as amountSolicitations,\n" +
            "(\n" +
            "select\n" +
            " count(*)\n" +
            "from\n" +
            " contributions c\n" +
            "where\n" +
            " c.user_id = u.id ) as amountContributions \n" +
            "from\n" +
            " users u\n" +
            "inner join profiles p on\n" +
            " u.profile_id = p.id\n" +
            "where\n" +
            " u.id = #{id}\n" +
            "order by \n" +
            " u.id;  ")
    UserDetailedDto getSpecificUser(@Param("id") Integer id);
}

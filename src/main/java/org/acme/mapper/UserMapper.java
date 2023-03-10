package org.acme.mapper;

import org.acme.dto.SolicitationDto;
import org.acme.dto.UserDetailedDto;
import org.acme.dto.UserDto;
import org.acme.form.UserPostForm;
import org.acme.model.User;
import org.apache.ibatis.annotations.*;

import javax.ws.rs.DELETE;
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

    @Insert("insert into users(full_name,registration,pword,profile_id) values (#{user.name},#{user.registration},#{user.password},#{user.profile_id})")
    @SelectKey(statement = {"Select max(id) from users"},keyProperty = "user.id",keyColumn = "id",before = false,resultType = Integer.class)
    void register(@Param("user") User user);


    @Update("update users set full_name= #{user.name},registration=#{user.registration},pword=#{user.password},profile_id=#{user.profile_id} where id=#{user.id}")
    void updateUser(@Param("user") User user);

    @Delete("delete from users where id = #{id}")
    void deleteUser(@Param("id") Integer id);
}

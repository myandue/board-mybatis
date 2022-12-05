package com.example.boardmybatis.mapper;

import com.example.boardmybatis.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;

@Mapper
public interface UserMapper {

    @Insert("INSERT INTO user(name, user_id, password) VALUES(#{user.name}, #{user.userId}, #{user.password})")
    @Options(useGeneratedKeys = true ,keyProperty = "id")
    int insert(@Param("user") User user);

    @Select("SELECT * FROM user WHERE user_id=#{userId}")
    @Results(id="UserMap", value={
            @Result(property = "userId", column = "user_id"),
            @Result(property = "id", column = "id"),
            @Result(property="articleList", column="user_id", many = @Many(select="com.example.boardmybatis.mapper.ArticleMapper.getByUserId"))
    })
    Optional<User> getByUserId(@Param("userId") String userId);

    @Select("SELECT * FROM user WHERE id=#{id}")
    @ResultMap("UserMap")
    Optional<User> getById(@Param("id") int id);

    @Update("UPDATE user SET name=#{user.name}, password=#{user.password} WHERE user_id=#{user.userId}")
    @ResultMap("UserMap")
    int update(@Param("user") User user);

    @Delete("DELETE FROM user WHERE id=#{id}")
    int delete(@Param("id") int id);
}

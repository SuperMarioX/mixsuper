package com.supermario.mixsuper.mapper;

import com.supermario.mixsuper.entity.UserEntity;

import java.util.List;

public interface UserMapper {

    /*@Select("SELECT * from users")
    @Results({
            @Result(property = "userSex", column = "user_sex", javaType = UserSexEnum.class),
            @Result(property = "nickName", column = "nick_name")
    })
    List<UserEntity> getAll();

    @Select("SELECT * FROM users where id = #{id}")
    @Results({
            @Result(property = "userSex", column = "user_sex", javaType = UserSexEnum.class),
            @Result(property = "nickName", column = "nick_name")
    })
    UserEntity getUserById(Long id);

    @Insert("INSERT INTO users(userName,passWord,user_sex) VALUES(#{userName}, #{passWord}, #{userSex})")
    void createUser(UserEntity user);

    @Update("UPDATE users SET userName=#{userName},nick_name=#{nickName} WHERE id =#{id}")
    void updateUserById(UserEntity user);

    @Delete("DELETE FROM users WHERE id =#{id}")
    void deleteUserById(Long id);

    @Delete("delete from users")
    void deleteAll();*/


    List<Object> getAll();
    Object getOne(Long id);
    void insert(UserEntity entity);
    void update(UserEntity entity);
    void delete(Long id);


}

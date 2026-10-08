package com.example.mapper;

import com.example.entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 操作comment相关数据接口
 */
@Mapper
public interface CommentMapper {

    /**
     * 新增
     */
    int insert(Comment comment);

    /**
     * 删除
     */
    int deleteById(Integer id);

    /**
     * 修改
     */
    int updateById(Comment comment);

    /**
     * 根据ID查询
     */
    Comment selectById(Integer id);

    /**
     * 查询所有
     */
    List<Comment> selectAll(Comment comment);

    // userId: 表示当前登录的用户ID
    List<Comment> selectComment(Integer userId);


    @Select("select * from comment where user_id = #{userId}")
    List<Comment> selectUserComment(Integer userId);

    @Select("select * from comment where accept_id = #{userId}")
    List<Comment> selectAcceptComment(Integer userId);
}
package cn.jufangbao.house.shhouse.service.impl;

import cn.jufangbao.house.shhouse.service.CurdService;
import com.github.pagehelper.PageHelper;
import tk.mybatis.mapper.common.Mapper;

import java.io.Serializable;
import java.util.List;

/**
 * CurdServiceImpl.java
 * Created by bzzz (e-mail:zb766767@126.com) on 2017-05-05 19:40:13.
 * Human knowledge belongs to all mankind.
 * Best wishes to little ranran.
 */
public class CurdServiceImpl<T> implements CurdService<T> {

    protected Mapper<T> mapper;

    public int save(T entity){
        return mapper.insert(entity);
    }

    public int delete(T entity){
        return mapper.deleteByPrimaryKey(entity);
    }

    public int update(T entity){
        return mapper.updateByPrimaryKeySelective(entity);
    }

    /**
     * 单表分页查询
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    public List<T> selectPage(int pageNum, int pageSize, T entity){
        PageHelper.startPage(pageNum, pageSize);
        //Spring4支持泛型注入
        return mapper.select(entity);
    }

    public T selectOne(T entity){
        return mapper.selectOne(entity);
    }

    public T selectByPk(Serializable pk){
        return mapper.selectByPrimaryKey(pk);
    }
}

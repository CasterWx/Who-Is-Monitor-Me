package dao;

import domain.Http;

import java.util.ArrayList;

/**
 *  Http对象的CRUD操作
 * */
public interface IHttpDAO {
    /**
     * 保存Http对象
     * @param http
     * */
    void save(Http http);

    /**
     *  查询所有Http对象
     *  @return 所有Http对象
     * */
    ArrayList<Http> list() ;
}

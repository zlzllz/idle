package com.idle.dao;

import java.util.List;

import com.idle.entity.Reply;

/**
 * @author lilingzhi
 * @date 2017年5月05日 下午2:45:47
 */

public interface ReplyDao {

	public List<Reply> getAll();
	
	public int save(Reply reply);
	
	public int update(Reply reply);
	
	public int delete(Reply reply);

	public Reply getById(int id);
	
	public List<Reply> getByN_id(int id);
	
	public List<Reply> getByU_id(int id);

	public Reply getByReplycontent1(String replycontent);
	
	public List<Reply> getByReplycontent(String replycontent);

	public List<Reply> getByDate(String date);
}

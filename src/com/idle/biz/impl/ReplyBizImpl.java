package com.idle.biz.impl;

import java.util.List;

import com.idle.biz.ReplyBiz;
import com.idle.dao.ReplyDao;
import com.idle.dao.impl.ReplyDaoImpl;
import com.idle.entity.Reply;

/**
 * @author lilingzhi
 * @date 2017年5月06日 下午3:24:47
 */

public class ReplyBizImpl implements ReplyBiz {

	ReplyDao rdao = new ReplyDaoImpl();

	@Override
	public List<Reply> getAll() {
		return rdao.getAll();
	}

	@Override
	public int save(Reply reply) {
		return rdao.save(reply);
	}

	@Override
	public int update(Reply reply) {
		return rdao.update(reply);
	}

	@Override
	public int delete(Reply reply) {
		return rdao.delete(reply);
	}

	@Override
	public Reply getById(int id) {
		return rdao.getById(id);
	}

	@Override
	public List<Reply> getByN_id(int id) {
		return rdao.getByN_id(id);
	}

	@Override
	public List<Reply> getByU_id(int id) {
		return rdao.getByU_id(id);
	}

	@Override
	public List<Reply> getByReplycontent(String replycontent) {
		return rdao.getByReplycontent(replycontent);
	}

	@Override
	public List<Reply> getByDate(String date) {
		return rdao.getByDate(date);
	}

	@Override
	public Reply getByReplycontent1(String replycontent) {
		return rdao.getByReplycontent1(replycontent);
	}

}

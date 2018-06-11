package com.idle.biz.impl;

import java.util.List;

import com.idle.biz.NoteBiz;
import com.idle.dao.NoteDao;
import com.idle.dao.impl.NoteDaoImpl;
import com.idle.entity.Note;

/**
 * @author zhangqi
 * @date 2017年5月17日 下午3:51:58
 */

public class NoteBizImpl implements NoteBiz {
	NoteDao ndao = new NoteDaoImpl();

	public List<Note> getAll() {
		return ndao.getAll();
	}

	public int save(Note note) {
		return ndao.save(note);
	}

	public int update(Note note) {
		return ndao.update(note);
	}

	public int delete(Note note) {
		return ndao.delete(note);
	}

	public Note getById(int id) {
		return ndao.getById(id);
	}

	public List<Note> getByU_Id(int id) {
		return ndao.getByU_Id(id);
	}

	public List<Note> getByDate(String notedate) {
		return ndao.getByDate(notedate);
	}

	public List<Note> getByContent(String content) {
		return ndao.getByContent(content);
	}

	@Override
	public List<Note> getByP_Id(int id) {
		return ndao.getByP_Id(id);
	}

	@Override
	public Note getByContent1(String content) {
		return ndao.getByContent1(content);
	}

}

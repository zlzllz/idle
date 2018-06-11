package com.idle.biz;

import java.util.List;

import com.idle.entity.Note;

/**
 * @author zhangqi
 * @date 2017年5月14日 下午4:21:58
 */

public interface NoteBiz {
	public List<Note> getAll();

	public int save(Note note);

	public int update(Note note);

	public int delete(Note note);

	public Note getById(int id);

	public List<Note> getByU_Id(int id);

	public List<Note> getByP_Id(int id);

	public List<Note> getByDate(String notedate);

	public Note getByContent1(String content);

	public List<Note> getByContent(String content);

}

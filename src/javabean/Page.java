package javabean;

import java.util.List;

public class Page {
	private int currentpage;
	private int totalpage;
	private int totalcount;
	private int pagesize;
	List<Book> lists;
	public Page(){
		
	}
	public Page(int currentpage, int totalpage, int totalcount, int pagesize,List<Book> lists) {
		super();
		this.currentpage = currentpage;
		this.totalpage = totalpage;
		this.totalcount = totalcount;
		this.pagesize = pagesize;
		this.lists=lists;
	}
	public int getCurrentpage() {
		return currentpage;
	}
	public void setCurrentpage(int currentpage) {
		this.currentpage = currentpage;
	}
	public int getTotalpage() {
		return totalpage;
	}
	public int getTotalcount() {
		return totalcount;
	}
	public void setTotalcount(int totalcount) {
		this.totalcount = totalcount;
		this.totalpage=(totalcount%pagesize>0?totalcount/pagesize+1:totalcount/pagesize);
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	public void setLists(List<Book> lists){
		this.lists=lists;
	}
	public List getLists(){
		return this.lists;
	}
}

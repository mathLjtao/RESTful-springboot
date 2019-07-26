package com.ljtao.RESTfulspringboot;

import java.util.Date;

public class TvSeriesDto {
	private int id;
	private String name;
	private int seasonCount;
	private Date originRelease;
	public TvSeriesDto(int id, String name, int seasonCount, Date originRelease) {
		super();
		this.id = id;
		this.name = name;
		this.seasonCount = seasonCount;
		this.originRelease = originRelease;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSeasonCount() {
		return seasonCount;
	}
	public void setSeasonCount(int seasonCount) {
		this.seasonCount = seasonCount;
	}
	public Date getOriginRelease() {
		return originRelease;
	}
	public void setOriginRelease(Date originRelease) {
		this.originRelease = originRelease;
	}
}

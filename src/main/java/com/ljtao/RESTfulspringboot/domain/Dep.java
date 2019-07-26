package com.ljtao.RESTfulspringboot.domain;

public class Dep {
	private Integer uuid;
	private String name;
	private String tele;
	@Override
	public String toString() {
		return "Dep [uuid=" + uuid + ", name=" + name + ", tele=" + tele + "]";
	}
	public Integer getUuid() {
		return uuid;
	}
	public void setUuid(Integer uuid) {
		this.uuid = uuid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTele() {
		return tele;
	}
	public void setTele(String tele) {
		this.tele = tele;
	}
}

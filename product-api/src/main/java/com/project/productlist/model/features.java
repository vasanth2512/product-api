package com.project.productlist.model;

public class features {

	public features() {
		super();
		// TODO Auto-generated constructor stub
	}
	public features(String color, String material) {
		super();
		this.color = color;
		this.material = material;
	}
	private String color;
	private String material;
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	@Override
	public String toString() {
		return "features [color=" + color + ", material=" + material + "]";
	}
	
}

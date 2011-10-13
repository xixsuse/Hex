package com.sam.hex;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import sl.shapes.RegularPolygon;

public class RegularPolygonGameObject implements Shape  {
 
 RegularPolygon Hex;
 private byte teamNumber;
 private Color objectColor=Color.white;
 
 
 
	public RegularPolygonGameObject(int x, int y, int r, int vertexCount) {
		Hex =new RegularPolygon(x, y, r, vertexCount);
		
	}
	public RegularPolygonGameObject(int x, int y, int r, int vertexCount, double startAngle) {
		Hex =new RegularPolygon(x, y, r, vertexCount,startAngle);
	}
	
	public void update(int x, int y, int r, int vertexCount, double startAngle){
		Hex =new RegularPolygon(x, y, r, vertexCount,startAngle);
	}
	
	public void setTeam(byte t){
		teamNumber=t;
	}
	public static boolean checkWin(int x, int y){
		return false;
	} 
	public void setColor(Color c){
		objectColor=c;
	}
	public Color getColor(){
		return objectColor;
	}
	@Override
	public boolean contains(Point2D p) {
		
		return Hex.contains(p);
	}
	@Override
	public boolean contains(Rectangle2D r) {
		
		return Hex.contains(r);
	}
	@Override
	public boolean contains(double x, double y) {
		
		return Hex.contains(x,y);
	}
	@Override
	public boolean contains(double x, double y, double w, double h) {
		
		return Hex.contains(x,y,w,h);
	}
	@Override
	public Rectangle getBounds() {
		
		return Hex.getBounds();
	}
	@Override
	public Rectangle2D getBounds2D() {
		
		return Hex.getBounds2D();
	}
	@Override
	public PathIterator getPathIterator(AffineTransform at) {
		
		return Hex.getPathIterator(at);
	}
	@Override
	public PathIterator getPathIterator(AffineTransform at, double flatness) {
		
		return Hex.getPathIterator(at,flatness);
	}
	@Override
	public boolean intersects(Rectangle2D r) {
		
		return Hex.intersects(r);
	}
	@Override
	public boolean intersects(double x, double y, double w, double h) {
		
		return Hex.intersects(x,y,w,h);
	}
}
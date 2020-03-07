package Point;

import java.lang.reflect.Field;

public class Point {
	int x;
	int y;
	Point(){
	
	}
	Point(int x, int y){
		this.x=x;
		this.y=y;
	}
	Field[] getPoint(){
		return this.getClass().getDeclaredFields();
	}
}

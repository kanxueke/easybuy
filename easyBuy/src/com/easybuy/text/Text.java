package com.easybuy.text;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Text {

	public static void main(String[] args) {
		
		try {
			Class cla = Class.forName("com.easybuy.entity.User");
			System.out.println(cla.getName());
			Package package1 = cla.getPackage();
			System.out.println(package1.getName());
			Class class1 = cla.getClass();
			System.out.println(class1.getName()+"\n");
			//
			
			//构造函数的获取
			Constructor constructor = cla.getDeclaredConstructor();
			constructor.setAccessible(true);
			Object newInstance = constructor.newInstance();
			//System.out.println(newInstance);
			//方法的获取
			Method method = cla.getMethod("setSex", Integer.class);
			Object instance = cla.newInstance();
			method.invoke(instance, 1);
			System.out.println(instance);
			
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

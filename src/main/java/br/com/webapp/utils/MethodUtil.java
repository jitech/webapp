package br.com.webapp.utils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import br.com.webapp.annotations.TableTest;
import br.com.webapp.domain_new.AlgorithmTableTest;

public class MethodUtil {

	public static List<Method> listMethodsByAnnotationTableTest(){
		
		try {
				List<Method> methods = new ArrayList<Method>();
				Object obj = new AlgorithmTableTest();
				
				for (final Method method : obj.getClass().getDeclaredMethods()) {
		            if (method.isAnnotationPresent(TableTest.class)) {		            	
		                methods.add(method);
		            }
		        }
				
				return methods;
			
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public static boolean testMethod(Method methodToTest, Object parameter, Object expected){
		
		try {						
				if(methodToTest.invoke(Class.forName(methodToTest.getDeclaringClass().getName()).newInstance(), parameter).equals(expected)) {
					return true;
				}
				
				return false;
			
		}catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
}

package com.qa.crm.TestNGListeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class MyTransformAnnotations implements IAnnotationTransformer{

	public void transform(ITestAnnotation annotation, Class testClass, Constructor testCons, Method testMethod) {

		annotation.setRetryAnalyzer(RetryAnalyzer.class);
		
	}

}

package com.GenericUtilities;

import java.lang.reflect.Method;

import org.testng.annotations.ITestAnnotation;
import org.testng.internal.annotations.IAnnotationTransformer;

public class ITransform implements IAnnotationTransformer
{

	public void transform(ITestAnnotation annotation, Method testMethod,Class<?> occurringClazz)
	{
		annotation.setRetryAnalyzer(com.GenericUtilities.RetryImplementation.class);
	}
	

}

package com.thalasoft.learnintouch.data.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class EnvProdCondition implements Condition {

  private static final String ENV = "prod";

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		return context.getEnvironment().getProperty("env") == null || context.getEnvironment().getProperty("env").equals(ENV);
	}

}
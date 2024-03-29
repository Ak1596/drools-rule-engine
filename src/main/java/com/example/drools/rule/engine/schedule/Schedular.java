package com.example.drools.rule.engine.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.example.drools.rule.engine.delegate.RulesDelegate;
import com.example.drools.rule.engine.util.RulesUtil;

@Configuration
@EnableScheduling
public class Schedular {

	@Autowired
	private RulesUtil util;

	@Autowired
	private RulesDelegate delegate;

	private static final Logger logger = LoggerFactory.getLogger(Schedular.class);

	@Scheduled(fixedDelay = 120000)
	public void pullRequestSchedular() {

		logger.info("Starting scheduled task");
		util.pull();
		delegate.init();
	}

}

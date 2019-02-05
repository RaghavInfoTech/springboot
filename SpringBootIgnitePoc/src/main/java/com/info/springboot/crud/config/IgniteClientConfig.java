/*-
l * UNPUBLISHED SOURCE CODE
 *
 * Copyright � 2017, Brocade Communications Systems, Incorporated.
 * ALL RIGHTS RESERVED.
 *
 * BROCADE HIGHLY CONFIDENTIAL TRADE SECRET INFORMATION
 *
 * Access or possession of this material grants you no right or license,
 * express, implied, statutory or otherwise, under any Brocade patent,
 * copyright, trade secret right or other intellectual property right.
 * Any such license must be contained in a written license agreement
 * signed by an authorized officer of Brocade.  Additionally, access or
 * possession of this material is limited to Brocade employees with a
 * need to know or named employees of Brocade vendors authorized by
 * Brocade in writing to access this material.
 *
 * Restricted Rights: Use, duplication, or disclosure by the U.S.
 * Government is subject to restrictions of FAR 52.227-19 and its
 * successors, or (c)(1)(ii) of the Rights in Technical Data and
 * Computer Software clause at DFAR 252.227-7013 and its successors.
 *
 * Brocade Communications Systems, Inc.,
 * 110 Holger Way, San Jose, CA 95134
 */

package com.info.springboot.crud.config;

import org.apache.ignite.springdata.repository.config.EnableIgniteRepositories;
import org.apache.ignite.transactions.TransactionConcurrency;
import org.apache.ignite.transactions.spring.SpringTransactionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableScheduling
@ComponentScan("com.info.springboot")
@EnableIgniteRepositories(basePackages = { "com.info.springboot" })
@ImportResource("classpath:ignite-client-conf.xml")
@EnableTransactionManagement
public class IgniteClientConfig {

	private static final Logger LOGGER = LoggerFactory.getLogger(IgniteClientConfig.class);

	public IgniteClientConfig() {
	}

	/**
	 * @return
	 */
	@Bean
	@DependsOn("igniteInstance")
	@Primary
	@Lazy
	public PlatformTransactionManager transactionManager() {
		final SpringTransactionManager springTransactionManager = new SpringTransactionManager() {
			@Override
			public void afterPropertiesSet() throws Exception {
				// Do nothing..
			}

			/**
			 * @param event
			 */
			@EventListener
			public void handleContextRefresh(final ContextRefreshedEvent event) throws Exception {
				LOGGER.info("Setting up tx support..");
				super.afterPropertiesSet();
			}
		};
		// Use default grid client instance created..
		springTransactionManager.setTransactionConcurrency(TransactionConcurrency.PESSIMISTIC);
		return springTransactionManager;
	}

}

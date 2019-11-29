package com.kyiminhan.spring.controller;

import com.kyiminhan.spring.constant.PathConstant;
import com.kyiminhan.spring.constant.URLConstant;

/**
 * The Class BaseController.<BR>
 *
 * @author KYIMINHAN <BR>
 * @version 1.0 <BR>
 * @since Nov 28, 2019 <BR>
 *        spring-jpa-demo-002 system <BR>
 *        com.kyiminhan.spring.controller <BR>
 *        BaseController.java <BR>
 */
public abstract class BaseController {

	/**
	 * Gets the path.
	 *
	 * @return the path
	 */
	protected abstract String getPath();

	/**
	 * Forward.
	 *
	 * @param pageName the page name
	 * @return the string
	 */
	protected String forward(final String pageName) {
		return new StringBuilder(getPath()).append(PathConstant.PATH).append(pageName).toString();
	}

	/**
	 * Redirect.
	 *
	 * @param url the url
	 * @return the string
	 */
	protected String redirect(final String url) {
		return new StringBuilder(URLConstant.REDIRECT).append(getPath()).append(url).toString();
	}
}
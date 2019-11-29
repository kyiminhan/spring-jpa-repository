package com.kyiminhan.spring.service.impl;

import java.io.Serializable;

import com.kyiminhan.spring.service.BaseService;

public abstract class BaseServiceImpl<DTO extends Serializable> implements BaseService<DTO> {

	private static final long serialVersionUID = 1L;

}

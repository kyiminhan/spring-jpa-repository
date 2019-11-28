package com.kyiminhan.spring.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kyiminhan.spring.constant.ControllerConstant;
import com.kyiminhan.spring.constant.PathConstant;
import com.kyiminhan.spring.constant.URLConstant;
import com.kyiminhan.spring.entity.Department;
import com.kyiminhan.spring.service.DepartmentService;
import com.kyiminhan.web.dto.DeptDto;

import lombok.Setter;

/**
 * The Class DepartmentController.<BR>
 *
 * @author KYIMINHAN <BR>
 * @version 1.0 <BR>
 * @since Nov 28, 2019 <BR>
 * spring-jpa-demo-002 system <BR>
 * com.kyiminhan.spring.controller <BR>
 * DepartmentController.java <BR>
 */
@Controller
@RequestMapping(path = PathConstant.DEPARTMENT_PATH)
@Setter(onMethod = @__(@Autowired))
public class DepartmentController {

	/** The department service. */
	private DepartmentService departmentService;

	/**
	 * Forward.
	 *
	 * @param pageName the page name
	 * @return the string
	 */
	private String forward(final String pageName) {
		return new StringBuilder(PathConstant.DEPARTMENT_PATH).append(PathConstant.PATH).append(pageName).toString();
	}

	/**
	 * Redirect.
	 *
	 * @param url the url
	 * @return the string
	 */
	private String redirect(final String url) {
		return new StringBuilder(URLConstant.REDIRECT).append(PathConstant.DEPATRMENT_PATH).append(url).toString();
	}

	/**
	 * Creates the.
	 *
	 * @param model the model
	 * @return the string
	 */
	@GetMapping(value = URLConstant.CREATE)
	public String create(final Model model) {
		model.addAttribute(ControllerConstant.DEPATRMENT, Department.builder().build());
		return this.forward(ControllerConstant.CREATE);
	}

	/**
	 * Creates the.
	 *
	 * @param deptDto the dept dto
	 * @param bindingResult the binding result
	 * @param model the model
	 * @return the string
	 */
	@PostMapping(value = URLConstant.CREATE)
	public String create(@ModelAttribute(value = ControllerConstant.DEPATRMENT) final DeptDto deptDto,
			final BindingResult bindingResult, final Model model) {
		this.departmentService.save(deptDto);
		return this.redirect(URLConstant.CREATE);
	}

	/**
	 * Edits the.
	 *
	 * @param id the id
	 * @param model the model
	 * @return the string
	 */
	@GetMapping(value = URLConstant.PARAM_EDIT)
	public String edit(@PathVariable("id") final String id, final Model model) {
		model.addAttribute(ControllerConstant.DEPATRMENT, this.departmentService.findById(Integer.valueOf(id)));
		return this.forward(ControllerConstant.EDIT);
	}

	/**
	 * Edits the.
	 *
	 * @param id the id
	 * @param deptDto the dept dto
	 * @param bindingResult the binding result
	 * @param model the model
	 * @return the string
	 */
	@PostMapping(value = URLConstant.PARAM_EDIT)
	public String edit(@PathVariable("id") final String id, @ModelAttribute final DeptDto deptDto,
			final BindingResult bindingResult, final Model model) {
		this.departmentService.update(deptDto);
		return this.redirect(URLConstant.PARAM_EDIT);
	}

	/**
	 * Detail.
	 *
	 * @param id the id
	 * @param model the model
	 * @return the string
	 */
	@GetMapping(value = URLConstant.PARAM_DETAIL)
	public String detail(@PathVariable("id") final String id, final Model model) {
		model.addAttribute(ControllerConstant.DEPATRMENT, this.departmentService.findById(Integer.valueOf(id)));
		return this.forward(ControllerConstant.DETAIL);
	}

	/**
	 * Delete.
	 *
	 * @param id the id
	 * @param model the model
	 * @return the string
	 */
	@GetMapping(value = URLConstant.PARAM_DELETE)
	public String delete(@PathVariable("id") final String id, final Model model) {
		this.departmentService.delete(Integer.valueOf(id));
		return this.redirect(URLConstant.LIST);
	}

	/**
	 * List.
	 *
	 * @param model the model
	 * @return the string
	 */
	@GetMapping(value = { URLConstant.DEFAULT, URLConstant.LIST })
	public String list(final Model model) {
		final Collection<DeptDto> deptDtos = this.departmentService.findAll();
		model.addAttribute(ControllerConstant.DEPATRMENTS, deptDtos);
		return this.forward(ControllerConstant.LIST);
	}
}
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

import lombok.Setter;

/**
 * The Class DepartmentController.</BR>
 *
 * @author KYIMINHAN </BR>
 * @version 1.0 </BR>
 * @since Mar 17, 2019 </BR>
 *        spring-jpa-demo-001 system </BR>
 *        com.kyiminhan.spring.controller </BR>
 *        DepartmentController.java </BR>
 */
@Controller
@RequestMapping(path = PathConstant.DEPARTMENT_PATH)

/**
 * Sets the department service.
 *
 * @param departmentService the new department service
 */
@Setter(onMethod = @__(@Autowired))
public class DepartmentController {

	/** The department service. */
	private DepartmentService departmentService;

	/**
	 * Forward.
	 *
	 * @param pageName the page name
	 * @return String
	 */
	private String forward(final String pageName) {
		return new StringBuilder(PathConstant.DEPARTMENT_PATH).append(PathConstant.PATH).append(pageName).toString();
	}

	/**
	 * Redirect.
	 *
	 * @param url the url
	 * @return String
	 */
	private String redirect(final String url) {
		return new StringBuilder(URLConstant.REDIRECT).append(PathConstant.DEPATRMENT_PATH).append(url).toString();
	}

	/**
	 * Creates the.
	 *
	 * @param model the model
	 * @return String
	 */
	@GetMapping(value = URLConstant.CREATE)
	public String create(final Model model) {
		model.addAttribute(ControllerConstant.DEPATRMENT, Department.builder().build());
		return this.forward(ControllerConstant.CREATE);
	}

	/**
	 * Creates the.
	 *
	 * @param department    the department
	 * @param bindingResult the binding result
	 * @param model         the model
	 * @return String
	 */
	@PostMapping(value = URLConstant.CREATE)
	public String create(@ModelAttribute(value = ControllerConstant.DEPATRMENT) final Department department,
			final BindingResult bindingResult, final Model model) {
		this.departmentService.save(department);
		return this.redirect(URLConstant.CREATE);
	}

	/**
	 * Edits the.
	 *
	 * @param id    the id
	 * @param model the model
	 * @return String
	 */
	@GetMapping(value = URLConstant.PARAM_EDIT)
	public String edit(@PathVariable("id") final String id, final Model model) {
		model.addAttribute(ControllerConstant.DEPATRMENT, this.departmentService.findById(Integer.valueOf(id)));
		return this.forward(ControllerConstant.EDIT);
	}

	/**
	 * Edits the.
	 *
	 * @param id            the id
	 * @param department    the department
	 * @param bindingResult the binding result
	 * @param model         the model
	 * @return String
	 */
	@PostMapping(value = URLConstant.PARAM_EDIT)
	public String edit(@PathVariable("id") final String id, @ModelAttribute final Department department,
			final BindingResult bindingResult, final Model model) {
		this.departmentService.update(department);
		return this.redirect(URLConstant.PARAM_EDIT);
	}

	/**
	 * Detail.
	 *
	 * @param id    the id
	 * @param model the model
	 * @return String
	 */
	@GetMapping(value = URLConstant.PARAM_DETAIL)
	public String detail(@PathVariable("id") final String id, final Model model) {
		model.addAttribute(ControllerConstant.DEPATRMENT, this.departmentService.findById(Integer.valueOf(id)));
		return this.forward(ControllerConstant.DETAIL);
	}

	/**
	 * Delete.
	 *
	 * @param id    the id
	 * @param model the model
	 * @return String
	 */
	@GetMapping(value = URLConstant.PARAM_DELETE)
	public String delete(@PathVariable("id") final String id, final Model model) {
		this.departmentService.delete(this.departmentService.findById(Integer.valueOf(id)));
		return this.redirect(URLConstant.LIST);
	}

	/**
	 * List.
	 *
	 * @param model the model
	 * @return String
	 */
	@GetMapping(value = { URLConstant.DEFAULT, URLConstant.LIST })
	public String list(final Model model) {
		final Collection<Department> departments = this.departmentService.findAll();
		model.addAttribute(ControllerConstant.DEPATRMENTS, departments);
		return this.forward(ControllerConstant.LIST);
	}
}
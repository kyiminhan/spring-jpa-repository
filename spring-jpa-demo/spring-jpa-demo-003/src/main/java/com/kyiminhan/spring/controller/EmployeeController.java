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
import com.kyiminhan.spring.entity.Employee;
import com.kyiminhan.spring.service.EmployeeService;
import com.kyiminhan.web.dto.EmpDto;

import lombok.Setter;

/**
 * The Class EmployeeController.<BR>
 *
 * @author KYIMINHAN <BR>
 * @version 1.0 <BR>
 * @since Nov 28, 2019 <BR>
 *        spring-jpa-demo-002 system <BR>
 *        com.kyiminhan.spring.controller <BR>
 *        EmployeeController.java <BR>
 */
@Controller
@RequestMapping(path = PathConstant.EMPLOYEE_PATH)

/**
 * Sets the employee service.
 *
 * @param employeeService the new employee service
 */
@Setter(onMethod = @__(@Autowired))
public class EmployeeController extends BaseController {

	/** The employee service. */
	private EmployeeService employeeService;

	/**
	 * Gets the path.
	 *
	 * @return the path
	 */
	@Override
	protected String getPath() {
		return PathConstant.EMPLOYEE_PATH;
	}

	/**
	 * Creates the.
	 *
	 * @param model the model
	 * @return the string
	 */
	@GetMapping(value = URLConstant.CREATE)
	public String create(final Model model) {
		model.addAttribute(ControllerConstant.EMPLOYEE, Employee.builder().build());
		return this.forward(ControllerConstant.CREATE);
	}

	/**
	 * Creates the.
	 *
	 * @param empDto        the emp dto
	 * @param bindingResult the binding result
	 * @param model         the model
	 * @return the string
	 */
	@PostMapping(value = URLConstant.CREATE)
	public String create(@ModelAttribute(value = ControllerConstant.EMPLOYEE) final EmpDto empDto,
			final BindingResult bindingResult, final Model model) {
		this.employeeService.save(empDto);
		return this.redirect(URLConstant.CREATE);
	}

	/**
	 * Edits the.
	 *
	 * @param id    the id
	 * @param model the model
	 * @return the string
	 */
	@GetMapping(value = URLConstant.PARAM_EDIT)
	public String edit(@PathVariable("id") final String id, final Model model) {
		model.addAttribute(ControllerConstant.EMPLOYEE, this.employeeService.findById(Integer.valueOf(id)));
		return this.forward(ControllerConstant.EDIT);
	}

	/**
	 * Edits the.
	 *
	 * @param id            the id
	 * @param employee      the employee
	 * @param bindingResult the binding result
	 * @param model         the model
	 * @return the string
	 */
	@PostMapping(value = URLConstant.PARAM_EDIT)
	public String edit(@PathVariable("id") final String id, @ModelAttribute final EmpDto employee,
			final BindingResult bindingResult, final Model model) {
		this.employeeService.update(employee);
		return this.redirect(URLConstant.PARAM_EDIT);
	}

	/**
	 * Detail.
	 *
	 * @param id    the id
	 * @param model the model
	 * @return the string
	 */
	@GetMapping(value = URLConstant.PARAM_DETAIL)
	public String detail(@PathVariable("id") final String id, final Model model) {
		model.addAttribute(ControllerConstant.EMPLOYEE, this.employeeService.findById(Integer.valueOf(id)));
		return this.forward(ControllerConstant.DETAIL);
	}

	/**
	 * Delete.
	 *
	 * @param id    the id
	 * @param model the model
	 * @return the string
	 */
	@GetMapping(value = URLConstant.PARAM_DELETE)
	public String delete(@PathVariable("id") final String id, final Model model) {
		this.employeeService.delete(Integer.valueOf(id));
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
		final Collection<EmpDto> employees = this.employeeService.findAll();
		model.addAttribute(ControllerConstant.EMPLOYEES, employees);
		return this.forward(ControllerConstant.LIST);
	}
}
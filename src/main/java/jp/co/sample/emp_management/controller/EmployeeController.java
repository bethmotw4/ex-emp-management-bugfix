package jp.co.sample.emp_management.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jp.co.sample.emp_management.domain.Employee;
import jp.co.sample.emp_management.form.InsertEmployeeForm;
import jp.co.sample.emp_management.form.UpdateEmployeeForm;
import jp.co.sample.emp_management.service.EmployeeService;
import net.arnx.jsonic.JSON;

/**
 * 従業員情報を操作するコントローラー.
 * 
 * @author igamasayuki
 *
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	/**
	 * 使用するフォームオブジェクトをリクエストスコープに格納する.
	 * 
	 * @return フォーム
	 */
	@ModelAttribute
	public UpdateEmployeeForm setUpForm() {
		return new UpdateEmployeeForm();
	}
	
	/**
	 * 従業員登録に使用するフォームをインスタンス化する.
	 * 
	 * @return フォーム
	 */
	@ModelAttribute
	public InsertEmployeeForm setUpInsertEmployeeForm() {
		return new InsertEmployeeForm();
	}

	/////////////////////////////////////////////////////
	// ユースケース：従業員一覧を表示する
	/////////////////////////////////////////////////////
	/**
	 * 従業員一覧画面を出力します.
	 * 
	 * @param model モデル
	 * @return 従業員一覧画面
	 */
	@RequestMapping("/showList")
	public String showList(Model model) {
		List<Employee> employeeList = employeeService.showList();
		model.addAttribute("employeeList", employeeList);
		return "employee/list";
	}
	
//	private void convertBase64Image() {
//		List<Employee> employeeList = employeeService.
//	}

	
	/////////////////////////////////////////////////////
	// ユースケース：従業員詳細を表示する
	/////////////////////////////////////////////////////
	/**
	 * 従業員詳細画面を出力します.
	 * 
	 * @param id リクエストパラメータで送られてくる従業員ID
	 * @param model モデル
	 * @return 従業員詳細画面
	 */
	@RequestMapping("/showDetail")
	public String showDetail(String id, Model model) {
		Employee employee = employeeService.showDetail(Integer.parseInt(id));
		model.addAttribute("employee", employee);
		return "employee/detail";
	}
	
	/////////////////////////////////////////////////////
	// ユースケース：従業員詳細を更新する
	/////////////////////////////////////////////////////
	/**
	 * 従業員詳細(ここでは扶養人数のみ)を更新します.
	 * 
	 * @param form
	 *            従業員情報用フォーム
	 * @return 従業員一覧画面へリダクレクト
	 */
	@RequestMapping("/update")
	public String update(@Validated UpdateEmployeeForm form, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return showDetail(form.getId(), model);
		}
		Employee employee = new Employee();
		employee.setId(form.getIntId());
		employee.setDependentsCount(form.getIntDependentsCount());
		employeeService.update(employee);
		return "redirect:/employee/showList";
	}
	
	
	/**
	 * 名前で従業員検索をする.
	 * 
	 * @param searchEmployeeName 従業員名
	 * @param model リクエストスコープ
	 * @return 従業員情報
	 */
	@RequestMapping("/search")
	public String searchEmployee(String searchEmployeeName, Model model) {
		List<Employee> employeeList = employeeService.searchEmployee(searchEmployeeName);
		if (employeeList.size() == 0) {
			model.addAttribute("searchResult", "1件もありませんでした。");
			employeeList = employeeService.showList();
		}
		model.addAttribute("employeeList", employeeList);			
		return "employee/list";
	}
	
	/**
	 * 全従業員の名前をオートコンプリートに渡す.
	 * 
	 * @return 全従業員名
	 */
	@ResponseBody
	@RequestMapping("/getAutoComplete")
	public String getAutoComplete() {
		List<Employee> employeeList = employeeService.showList();
		List<String> nameList = new ArrayList<>();
		employeeList.forEach(employee -> nameList.add(employee.getName()));
		return JSON.encode(nameList);
	}
	
	/**
	 * 従業員登録画面を表示する.
	 * 
	 * @return 従業員登録画面
	 */
	@RequestMapping("/insertShow")
	public String insertShow() {
		return "employee/insert";
	}
	
	
	/**
	 * 従業員を登録する.
	 * 
	 * @param form フォーム
	 * @param result 結果
	 * @return 成功:従業員一覧画面, 失敗:従業員登録画面
	 */
	@RequestMapping("/insert")
	public String insert(@Validated InsertEmployeeForm form, BindingResult result) {
		if (result.hasErrors()) {
			return insertShow();
		}
		Employee employee = new Employee();
		BeanUtils.copyProperties(form, employee);
		employeeService.insert(employee);
		return "redirect:/employee/showList";
	}
	
	
	/**
	 * 500エラーの確認画面
	 * 
	 * @return 意味のない文字列
	 */
	@RequestMapping("/error")
	public String exception() {
		System.out.println(10/ 0);
		return "aa";
	}
}

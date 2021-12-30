package jpabook.jpashop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
	
	@GetMapping("hello")
	public String hell(Model model) { // 모델에 데이터를 시어서 뷰로 넘길수 있다.
		model.addAttribute("data", "hello!!!");
		return "hello"; // 화면이름 /resource/templates/hello.html -> 관례 
	}

}

package com.testSpring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;  // HomeService�� @Autowired �ϱ� ���� ���� Autowired �ۼ��ϸ� �ڵ� ����Ʈ
import org.springframework.stereotype.Controller;		// @Controller �����ϱ� ���� ����Ʈ  @Controller �ۼ��ϸ� �ڵ� ����Ʈ
import org.springframework.ui.Model;				// Model �����ϸ� �ڵ� ����Ʈ
import org.springframework.web.bind.annotation.RequestMapping;  // @RequestMapping �� �� O �ϸ� �ΰ��� �ڵ� ���� ��?
import org.springframework.web.bind.annotation.RequestMethod;

import com.testSpring.model.HomeVo;
import com.testSpring.service.HomeService;
// ctrl + shift + O -> �ڵ����� Ŭ������ import ���ִ� ����Ű [�ſ� �߿�]

@Controller     // @Controller -> ������̼��̶�� �Ѵ�. �ٷ� �Ʒ��ٰ� ����� ������ �۵� �ȵǴϱ� �����ϵ��� ����. �� ������ ��Ʈ�ѷ����� �νĽ����ִ� ������̼�
public class HomeController { //@Controller: ���ϴ� ���� �ּ� ������ ���ִ� ��                      �̰� �ſ� �߿�/�̰� �־�� @RequestMapping �� �������� �� �ִ�.
	@Autowired// �˾Ƽ� Ȩ ��Ʈ�ѷ����� Ȩ ���񽺸� �� �� �ְ� �������ִ� ����
	HomeService homeService;  // ���� homeService�� ������ HomeServiceImpl���� �������� ��ü ������ �׳� homeService�� ���൵ �Ǵµ� �ϴ�. HomeServiceImpl�� �׳� homeService�� ����� ��� �����ϴ� ����
	
	@RequestMapping(value="/test", method = RequestMethod.GET) //RequestMapping �ּҿ� ��� ����� �����Ѵ�. ->  ��ġ�� �� �� �Լ��� ���Բ� ���� // @�� �Ʒ� �ٹ��� ������ �ȵ�
	public String test(Model model) { // ���� ���⼭ ������ �ǵ� -> ȭ��(test1.jsp)���� ���� ����� �ʿ��ϴ�. -> Model ���, ��� ���Ѵ� ->  Model �ʿ� ���� , Model�� ������ �־��ֱ� ���� ����

        System.out.println("eeeeddddd"); // Ȥ�� ������ ���� ��� �� �������� ���Դ��� ������ Ȯ���ϱ� ���ؼ� �ֿܼ� ddddd �� ��� 


        int num = 3 + 20;
        
        List<HomeVo> homeVo = homeService.test();
        //HomeVo homeVo = homeService.test(); //homeService.test(): ���� -> �ٿ� -> Ȩ ���� ������ ���� db���� ������ �޾ƿ�
        
        
        List<HomeVo> homeList = homeService.getElec();

        model.addAttribute("num", num); //addAttribute: ȭ�鿡�� �� ������ �־��ش�. "num" -> ȭ�鿡�� �� ����,  num -> int num = 3 + 20; ���� num
        model.addAttribute("homeVo", homeVo); //������ "homeVo"�� views ���� �� �������̰�, �������� homeVo�� HomeVo homeVo = homeService.test();���� homeVo�̴�.
        model.addAttribute("homeList", homeList);
        
		return "test1"; // test1.jsp �� �̵��ϴ� ����
		//�̵� �Ҷ� �𵨵��� ���� ����.
		
		
	}
	
}

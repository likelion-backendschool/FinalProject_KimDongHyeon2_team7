package com.ll.mutbook.product;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController {

    @GetMapping("/list")
    public String listUp(){
        return "전체 리스트";
    }

    @GetMapping("/create")
    public String addProduct(){
        return "도서 등록";
    }

    @PostMapping("/create")
    public String postAddProduct(){
        return "도서 등록 전송";
    }

    @GetMapping("/{id}/modify")
    public String modifyProduct(){
        return "도서 상품 수정";
    }

    @PostMapping("/{id}/modify")
    public String postModifyProduct(){
        return "도서 상품 수정 전송";
    }

    @PostMapping("/{id}/delete")
    public String deleteProduct(){
        return "도서 상품 삭제";
    }




}

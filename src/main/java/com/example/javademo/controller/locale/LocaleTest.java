package com.example.javademo.controller.locale;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

/**
 * @author: zhaos
 * @date: 2020/12/9
 */
@RestController
@RequestMapping("locale")
public class LocaleTest {

    /**
     * 前端多语言
     * @param locale 多语言
     * @return 多语言类型-
     */
    @GetMapping("language/{locale}")
    public String getLanguage (@PathVariable Locale locale) {
        return locale.toLanguageTag().toLowerCase();
    }

}

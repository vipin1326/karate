/*
 * The MIT License
 *
 * Copyright 2022 Karate Labs Inc.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.intuit.karate.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author pthomas3
 */
@RestController
@RequestMapping("/encoding")
public class EncodingController {

    @RequestMapping("/**")
    public String echoPath(HttpServletRequest httpServletRequest) {
        // running from spring boot + tomcat
        if (httpServletRequest.getPathInfo() == null) {
            return httpServletRequest.getServletPath().replace("/encoding/", "");

        // running from mock spring mvc
        } else {
            return httpServletRequest.getPathInfo().replace("/encoding/", "");
        }
    }
    
    @RequestMapping("/index.php?/api/v2/**")
    public String echoPathWithQuestion(HttpServletRequest httpServletRequest) {
        // running from spring boot + tomcat
        if (httpServletRequest.getPathInfo() == null) {
            return httpServletRequest.getServletPath().replace("/encoding/index.php?/api/v2/", "");

        // running from mock spring mvc
        } else {
            return httpServletRequest.getPathInfo().replace("/encoding/index.php?/api/v2/", "");
        }
    }    

}

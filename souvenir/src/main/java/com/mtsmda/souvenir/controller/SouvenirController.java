package com.mtsmda.souvenir.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.mtsmda.souvenir.controller.constants.SouvenirConstants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import static com.mtsmda.souvenir.controller.constants.SouvenirConstants.*;

@Controller
public class SouvenirController {

    @RequestMapping(value = "/souvenirInsert", method = RequestMethod.POST)
    public String get(HttpServletRequest request, @RequestParam("souvenirPath") MultipartFile file) {
        @SuppressWarnings("rawtypes")
        Map parameterMap = request.getParameterMap();
        System.out.println(parameterMap.size());
        System.out.println(file == null);
        System.out.println();
        return "";
    }

    @RequestMapping(value = GET_SOUVENIR_BY_ID_PIECE_URL, method = RequestMethod.GET)
    public String getSouvenirById(@PathVariable(SOUVENIR_ID_FIELD_NAME) Integer souvenirId) {
        return GET_SOUVENIR_BY_ID_INTERNAL_FILE;
    }

}

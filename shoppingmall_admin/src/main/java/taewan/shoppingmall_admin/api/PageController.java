package taewan.shoppingmall_admin.api;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class PageController {

    @GetMapping
    public String indexPage() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping(path = {"/page/{firstPath}/{pageType}", "/page/{firstPath}/{secondPath}/{pageType}"})
    public String defaultPage(HttpServletRequest request, Model model, @RequestParam Map<String, String> params) {
        String path = request.getRequestURI().replace("/page", "");
        String root = path.substring(0, path.indexOf('/', 1));

        model.addAttribute("json", root);
        model.addAttribute("script", path);
        model.addAttribute("css", path);
        model.addAllAttributes(params);

        return path;
    }

}

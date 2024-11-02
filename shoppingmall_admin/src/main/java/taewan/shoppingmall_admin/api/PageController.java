package taewan.shoppingmall_admin.api;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
    public String defaultPage(HttpServletRequest request, Model model) {
        String path = request.getRequestURI().replace("/page", "");

        model.addAttribute("script", path);
        model.addAttribute("css", path);

        return path;
    }

}

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/admin")
    public String adminDashboard(Model model) {
        model.addAttribute("quizzes", adminService.getAllQuizzes());
        return "admin/dashboard";
    }

    @PostMapping("/admin/addQuiz")
    public String addQuiz(@ModelAttribute Quiz quiz) {
        adminService.addQuiz(quiz);
        return "redirect:/admin";
    }

    @PostMapping("/admin/addQuestion")
    public String addQuestion(@ModelAttribute Question question) {
        adminService.addQuestion(question);
        return "redirect:/admin";
    }

    @PostMapping("/admin/addOption")
    public String addOption(@ModelAttribute Option option) {
        adminService.addOption(option);
        return "redirect:/admin";
    }
}

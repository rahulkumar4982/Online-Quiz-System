import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class QuizController {

    @Autowired
    private QuizService quizService;

    @GetMapping("/quiz/{id}")
    public String startQuiz(@PathVariable Long id, Model model) {
        Quiz quiz = quizService.getQuizById(id);
        if (quiz != null) {
            model.addAttribute("quiz", quiz);
            model.addAttribute("questions", quizService.getRandomizedQuestions(quiz));
        }
        return "quiz";
    }
}

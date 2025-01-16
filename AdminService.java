import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private OptionRepository optionRepository;

    public void addQuiz(Quiz quiz) {
        quizRepository.save(quiz);
    }

    public void addQuestion(Question question) {
        questionRepository.save(question);
    }

    public void addOption(Option option) {
        optionRepository.save(option);
    }
}

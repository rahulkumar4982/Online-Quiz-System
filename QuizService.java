import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class QuizService {

    @Autowired
    private QuizRepository quizRepository;

    public List<Quiz> getAllQuizzes() {
        return quizRepository.findAll();
    }

    public Quiz getQuizById(Long id) {
        return quizRepository.findById(id).orElse(null);
    }

    public List<Question> getRandomizedQuestions(Quiz quiz) {
        List<Question> questions = quiz.getQuestions();
        Random rand = new Random();
        // Randomize question order
        for (int i = 0; i < questions.size(); i++) {
            int randomIndexToSwap = rand.nextInt(questions.size());
            Question temp = questions.get(i);
            questions.set(i, questions.get(randomIndexToSwap));
            questions.set(randomIndexToSwap, temp);
        }
        return questions;
    }
}
